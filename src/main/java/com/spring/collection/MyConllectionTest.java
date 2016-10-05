package com.spring.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by casimiryang on 2016/3/30.
 */

@ContextConfiguration(locations= {"/spring/collection.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyConllectionTest {

    @Autowired(required = false)
    @Qualifier("collection")
    private MyCollection myCollection;

    @Test
    public void testMyCollection(){
        assert myCollection.getList() instanceof ArrayList;
        System.out.println(myCollection.getList().getClass());
        System.out.println(myCollection.getList().size());
    }
}
