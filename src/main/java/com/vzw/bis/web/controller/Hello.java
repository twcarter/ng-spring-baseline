package com.vzw.bis.web.controller;


import com.vzw.bis.annotations.Log;
import com.vzw.bis.data.HelloBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/hello")
public class Hello {

    private static int id = 0;

    private final Logger logger = LoggerFactory.getLogger(getClass());



    @RequestMapping(method = GET)
    public HelloBean sayHello() {
        return new HelloBean(id++, "hello");
    }


}
