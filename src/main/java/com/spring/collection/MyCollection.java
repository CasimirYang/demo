package com.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by casimiryang on 2016/3/30.
 */
public class MyCollection {
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


}
