package com.vzw.bis.data;


public class HelloBean {
    private Integer id;
    private String greeting;

    public HelloBean(Integer id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
