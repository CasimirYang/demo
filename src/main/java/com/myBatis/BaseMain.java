package com.myBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

/**
 * MyBatis 包含一个名叫 Resources 的工具类，
 * 它包含一些实用方法，可使从 classpath 或其他位置加载资源文件更加容易
 *
 * SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的范围是请求或方法范围。
 *
 * 每次收到的 HTTP 请求，就可以打开一个 SqlSession，响应后确保关闭它。
 *
 * 一级缓存:单个session的内缓存
 * 二级缓存:不同session的相互缓存;需要在SQL 映射文件中添加一行: <cache/>
 */
public class BaseMain {

    public static void main(String[] args) throws Exception {
        String resource = "myBatis/base/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            //UserModel userModel = mapper.selectUser2("cas",1);
            //System.out.println("------:"+userModel);
            mapper.updateUser(1);
            session.commit();
        } finally {
            session.close();
        }
    }
}
