package com.spring.baseIOC.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by casimiryang on 2016/3/29.
 */

@ContextConfiguration(locations= {"/baseConfig.xml","/field_DI.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SomeBeanTests {

        @Autowired
        @Qualifier("innerBean")
        private SomeBean someBean;  //这里混合使用了注解和annotation的方式 someBean里面的field 用的是XML 方式


     @Test
    public void testSimpleProperties() throws Exception {
        System.out.println(someBean.getSomeBean());
    }
}
