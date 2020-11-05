package com.martinezsoft.gotthat.configuration;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;

import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class GotThatConfiguration {

    @Bean
    @RequestScope
    public UserApiServiceImpl userApiServiceImpl() throws Exception {return new UserApiServiceImpl(hibernateSessionFactory());}

    @Bean
    public HibernateSessionFactory hibernateSessionFactory(){return new HibernateSessionFactory();}

    /*@Bean
    @RequestScope
    public NoteApiServiceImpl noteApiService() throws Exception{return new NoteApiServiceImpl(simpleMongoRepository());}

    @Bean
    @RequestScope
    public SimpleMongoRepository simpleMongoRepository(){return new SimpleMongoRepository();}*/


}
