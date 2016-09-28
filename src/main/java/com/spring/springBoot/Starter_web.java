package com.spring.springBoot;

import com.myBatis.spring.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ImportResource(locations={"classpath:myBatis/spring/*.xml"})
@EnableAutoConfiguration
public class Starter_web {

        @RequestMapping("/")
        @ResponseBody
        String home() {
            return "Hello World!";
        }



    @Autowired
    private ServiceImpl serviceImpl;

        @RequestMapping("/getAge")
        @ResponseBody
        public String getAge() {
            serviceImpl.updateAge(false);
            return "index";
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run(Starter_web.class, args);
        }
}
