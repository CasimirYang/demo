package com.spring.springmvc;

import com.myBatis.spring.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by yjh on 16/10/13.
 */
public class CacheServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebApplicationContext ct = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        ServiceImpl service = (ServiceImpl) ct.getBean("myService");
        service.getCid(1);

        RedisCacheManager cacheManager = (RedisCacheManager) ct.getBean("cacheManager");
        JedisConnectionFactory factory = (JedisConnectionFactory) ct.getBean("jedisConnFactory");

        factory.getConnection().flushDb();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
