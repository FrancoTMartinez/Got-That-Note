package com.martinezsoft.gotthat.configuration;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;

import com.martinezsoft.gotthat.service.NoteApiServiceImpl;
import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class GotThatConfiguration {

    @Bean
    @RequestScope
    public UserApiServiceImpl userApiServiceImpl() throws Exception {return new UserApiServiceImpl(hibernateSessionFactory());}

    @Bean
    @RequestScope
    public NoteApiServiceImpl noteApiServiceImpl() throws Exception {return new NoteApiServiceImpl(hibernateSessionFactory());}

    @Bean
    public HibernateSessionFactory hibernateSessionFactory(){return new HibernateSessionFactory();}


}
