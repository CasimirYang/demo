package com.spring.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



public class PersonServiceBean implements PersonServer{

    @Override
    public void save(String name) {
        System.out.println("call save");
    }

    @Override
    public void update(String name, Integer id) {
        System.out.println("call update");
    }
}