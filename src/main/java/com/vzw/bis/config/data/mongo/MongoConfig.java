package com.vzw.bis.config.data.mongo;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

@Configuration
//@Profile("mongodb")
public class MongoConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public MongoDbFactory mongoDbFactory() {
        try {
            return new SimpleMongoDbFactory(new MongoClient(), "database");
        }
        catch(UnknownHostException ex) {
            logger.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }

}

