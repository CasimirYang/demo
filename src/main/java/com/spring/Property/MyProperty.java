package com.spring.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by yjh on 16/9/29.
 */
@Component
@PropertySource(value = "classpath:com/spring/property/quartz.properties")
public class MyProperty{

//为了支持spring el 表达式
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
