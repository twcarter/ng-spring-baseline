package com.vzw.bis.service;

import org.springframework.stereotype.Service;


@Service
public class HelloService {
    public HelloService() {
        System.out.println(getClass().getSimpleName() + ".constructor");
    }
}
