package com.redis;

import com.myBatis.spring.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yjh on 16/10/1.
 */

public class RedisServiceImpl implements RedisService {

    private ServiceImpl serviceImpl;

    public void setServiceImpl(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Override
    public void testTran(boolean flag) {
        serviceImpl.getCid(1);
        if(flag){
            throw new RuntimeException("---------000------------");
        }
        serviceImpl.getCid(2);
    }
}
