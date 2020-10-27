package com.martinezsoft.gotthat.configuration;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.service.NoteApiServiceImpl;
import com.martinezsoft.gotthat.service.NoteRepository;
import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class GotThatConfiguration {

    @Bean
    @RequestScope
    public UserApiServiceImpl userService() throws Exception {return new UserApiServiceImpl(hibernateSessionFactory());}

    @Bean
    @RequestScope
    public HibernateSessionFactory hibernateSessionFactory(){return new HibernateSessionFactory();}

    /*@Bean
    @RequestScope
    public NoteApiServiceImpl noteApiService() throws Exception{return new NoteApiServiceImpl(NoteRepository)}*/
}
