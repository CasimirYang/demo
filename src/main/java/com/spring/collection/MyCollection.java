package com.spring.collection;

import org.springframework.context.LifecycleProcessor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by casimiryang on 2016/3/30.
 */

@Repository
public class MyCollection  implements LifecycleProcessor {
    List<Integer> list;
    Properties properties;
    Map<String,String> map;
    Set<Long> set;


    public MyCollection() {
    }

    public MyCollection(List<Integer> list, Properties properties, Map<String, String> map, Set<Long> set) {
        this.list = list;
        this.properties = properties;
        this.map = map;
        this.set = set;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<Long> getSet() {
        return set;
    }

    public void setSet(Set<Long> set) {
        this.set = set;
    }

    @Override
    public void start() {
        System.out.println("--------------start");
    }

    @Override
    public void stop() {
        System.out.println("--------------stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("-------------------isRunning");
        return false;
    }

    @Override
    public void onRefresh() {
        System.out.println("-------------------onRefresh");
    }

    @Override
    public void onClose() {
        System.out.println("-------------------onClose");
    }

    public void init(){
    System.out.println("call init method");
}

}
