package com.vzw.bis.config.root;

import com.mongodb.MongoClient;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.ResourceUtils;

import java.net.UnknownHostException;


/**
 *
 * Scan service layer packages and provide custom beans.
 *
 */
@Configuration
@ComponentScan(
        basePackages = {
                "com.vzw.bis.repo",
                "com.vzw.bis.service",
                "com.vzw.bis.dao",
                "com.vzw.bis.util"
        }
//        basePackageClasses = {RedisConfig.class}
)
@EnableMongoRepositories(basePackages = "com.vzw.bis.repo")
public class SpringConfig {
    @Bean
    public org.apache.commons.configuration.Configuration configuration() {
        try {

            return new PropertiesConfiguration(
                    ResourceUtils.getURL("classpath:application.properties")
            );

        } catch (Exception ex) {
            return new PropertiesConfiguration();
        }

    }


    public @Bean MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient("localhost");
    }


    public @Bean MongoTemplate mongoTemplate() throws UnknownHostException{
        return new MongoTemplate(mongoClient(), "database");
    }


}
