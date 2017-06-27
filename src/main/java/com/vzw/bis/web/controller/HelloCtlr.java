package com.vzw.bis.web.controller;


import com.vzw.bis.data.HelloBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/hello")
public class HelloCtlr {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private int id = 0;

    public HelloCtlr() {
        System.out.println(getClass().getSimpleName() + ".constructor");
    }

    @RequestMapping(method = GET)
    public HelloBean sayHello() {
        logger.debug("saying hello");
        return new HelloBean(id++, "hello, dude");
    }

}
