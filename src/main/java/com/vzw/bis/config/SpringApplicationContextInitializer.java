package com.vzw.bis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringApplicationContextInitializer
        implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {


    private static final Logger logger = LoggerFactory.getLogger(SpringApplicationContextInitializer.class);


    @Override
    public void initialize(AnnotationConfigWebApplicationContext applicationContext) {
        logger.debug(getClass().getName() + "initialize");
    }

}
