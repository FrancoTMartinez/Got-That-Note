package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.model.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class UserApiServiceImpl implements UserService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session userSession;

    public UserApiServiceImpl(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        userSession = hibernateSessionFactory.buildSession();
    }

    private Users userReturnedFromDataBase (Integer id){
        Users usersReturned;
        try{
            userSession.beginTransaction();
            Query selectQuery = userSession.createQuery("from Users WHERE Id=:paramId");
            selectQuery.setParameter("paramId", id);
            usersReturned = (Users) selectQuery.uniqueResult();
            return usersReturned;
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }


    @Override
    public ResponseEntity<Users> lookUp(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userReturnedFromDataBase(id));
    }

    @Override
    public ResponseEntity<List<Users>> search() {
        userSession.beginTransaction();
        List<Users> usersList = userSession.createQuery("from Users", Users.class).list();
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @Override
    public ResponseEntity<Users> add(Users users) {
        userSession.beginTransaction();
        userSession.save(users);
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
    }

    @Override
    public ResponseEntity<Users> update(Integer id, Users users) {
        Users usersReturned = userReturnedFromDataBase(id);
        usersReturned.setEmail(users.getEmail());
        usersReturned.setUserPassword(users.getUserPassword());
        userSession.update(users);
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(usersReturned);
    }

    @Override
    public ResponseEntity<String> delete(Integer id) {
        userSession.delete(userReturnedFromDataBase(id));
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }


}
