package com.martinezsoft.gotthat.configuration;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
public class MongoDbSessionFactory {
    private final MongoDatabaseFactory mongo;

    public MongoDbSessionFactory(MongoDatabaseFactory mongo) {
        this.mongo = mongo;
    }
}
