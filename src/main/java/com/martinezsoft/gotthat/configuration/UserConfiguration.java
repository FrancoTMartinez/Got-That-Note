package com.martinezsoft.gotthat.configuration;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.service.UserApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class UserConfiguration {

    @Bean
    @RequestScope
    public UserApiService userService() throws Exception {return new UserApiService(hibernateSessionFactory());}

    @Bean
    @RequestScope
    public HibernateSessionFactory hibernateSessionFactory(){return new HibernateSessionFactory();}
}
