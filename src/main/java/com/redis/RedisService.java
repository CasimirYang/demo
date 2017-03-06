package com.redis;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yjh on 16/10/1.
 */


@Service
public interface RedisService {

    void testTran(boolean flag);
}
