package com.martinezsoft.gotthat.configuration;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class UserConfiguration {

    @Bean
    @RequestScope
    public GotThatService gotThatService() throws Exception {return new GotThatService(hibernateSessionFactory());}

    @Bean
    @RequestScope
    public HibernateSessionFactory hibernateSessionFactory(){return new HibernateSessionFactory();}
}
