package com.vzw.bis.config.root;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
@ComponentScan(
        basePackages = {
                "com.vzw.bis.repo",
                "com.vzw.bis.service",
                "com.vzw.bis.dao",
                "com.vzw.bis.config",
                "com.vzw.bis.util"
        }
//        basePackageClasses = {RedisConfig.class}
)
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
}
