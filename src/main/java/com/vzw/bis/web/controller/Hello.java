package com.vzw.bis.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/hello")
public class Hello {


    @RequestMapping(method = GET)
    public String sayHello() {
        return "hello";
    }


}
