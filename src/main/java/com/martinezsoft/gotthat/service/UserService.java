package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import org.hibernate.Session;

public class UserService implements Service{
    private HibernateSessionFactory hibernateSessionFactory;
    private Session userSession;

    public UserService(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        userSession = hibernateSessionFactory.buildSession();
    }

    @Override
    public void get() {

    }

    @Override
    public void search() {

    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
