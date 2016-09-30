package com.spring.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yjh on 16/9/29.
 */
@ContextConfiguration(classes = {MyProperty.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyTest {

    @Autowired
    private Environment env;

    @Test
    public void test(){
        System.out.print(env);
    }
}
