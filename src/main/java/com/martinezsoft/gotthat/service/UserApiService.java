package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/services/user")
public class UserApiService implements ApiService {
    private HibernateSessionFactory hibernateSessionFactory;
    private Session userSession;

    public UserApiService(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        userSession = hibernateSessionFactory.buildSession();
    }

    private User userReturnedFromDataBase (String id){
        User userReturned;
        try{
            userSession.beginTransaction();
            Query selectQuery = userSession.createQuery("from Users WHERE USER_ID=:paramId");
            selectQuery.setParameter("paramId", id);
            userReturned = (User) selectQuery.uniqueResult();
            return userReturned;
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<User> lookUp(String id) {

        return ResponseEntity.status(HttpStatus.OK).body(userReturnedFromDataBase(id));
    }

    @Override
    public ResponseEntity<List<User>> search() {
        userSession.beginTransaction();
        List<User> userList = userSession.createQuery("from Users", User.class).list();
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @Override
    public ResponseEntity<User> add(User user) {
        userSession.beginTransaction();
        userSession.save(user);
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @Override
    public ResponseEntity<User> update(String id, User user) {
        User userReturned = userReturnedFromDataBase(id);
        userReturned.setEmail(user.getEmail());
        userReturned.setUserPassword(user.getUserPassword());
        return ResponseEntity.status(HttpStatus.OK).body(userReturned);
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        userSession.delete(userReturnedFromDataBase(id));
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }
}
