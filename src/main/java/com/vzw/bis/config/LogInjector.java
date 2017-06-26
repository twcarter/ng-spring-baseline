package com.vzw.bis.config;

import com.vzw.bis.annotations.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 *  Springframework BeanPostProcessor that will inject a slf4j Logger
 *
 *  Usage:
 *  <pre>
 *  {@link Logger @Log} Logger logger;
 *  </pre>
 *
 */
@Component
public class LogInjector implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger( LogInjector.class );

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        logger.debug("bean -> " + beanName);
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {

            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(Log.class) != null) {
                    Logger log = LoggerFactory.getLogger(bean.getClass());
                    field.set(bean, log);
                }

            }

        });
        return bean;
    }
}