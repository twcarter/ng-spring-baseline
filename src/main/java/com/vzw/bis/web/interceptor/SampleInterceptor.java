package com.vzw.bis.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SampleInterceptor extends AbstractInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public SampleInterceptor() {
        System.out.println(getClass().getSimpleName() + ".constructor");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("{}.preHandle: {}", getClass().getName(), request.getRequestURI());
        return true;
    }

}
