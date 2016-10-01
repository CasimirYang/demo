package com.myBatis;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yjh on 16/9/27.
 */
public class ClassModel extends JdkSerializationRedisSerializer implements Serializable{
    private int cid;
    private String cname;
    private List<UserModel> userModel;

}

