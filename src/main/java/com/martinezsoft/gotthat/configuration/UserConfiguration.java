package com.martinezsoft.gotthat.configuration;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.service.UserApiService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class UserConfiguration {

    @Bean
    @RequestScope
    public UserApiService userService() throws Exception {return new UserApiService(hibernateSessionFactory());}

    @Bean
    @RequestScope
    public HibernateSessionFactory hibernateSessionFactory(){return new HibernateSessionFactory();}

    /*public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "noteDB");
    }
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }*/
}
