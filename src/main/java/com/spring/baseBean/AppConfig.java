package com.spring.baseBean;

/**
 * //所有的@Configuration类在启动时，都是通过CGLIB创建一个子类。所以@Configuration 修饰的类不可以是final 的. XML 配置方式bean 可以。
 * 在调用父类的方法并创建一个新的实例之前，子类中的方法首先检查是否缓存过。
 * 该行为也许有些不同，这得根据具体的bean的作用域。这里讨论的是singleton单例作用域。
 */

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "b1")
    public ClientServiceImpl clientService1() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean(name = "b2")
    public ClientServiceImpl clientService2() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)  //如果不声明为prototype 类型， 即使这个方法被前面两个单例bean调用了两次，还是同一个对象。如果不用@Bean 修饰，只是普通的方法就是不同的对象
    public ClientDaoImpl clientDao() {
        return new ClientDaoImpl();
    }
}


class ClientServiceImpl{

    private ClientDaoImpl clientDao;

    public void setClientDao(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;
    }

    public void fun(){
        System.out.println(clientDao);
    }
}


class ClientDaoImpl{
}