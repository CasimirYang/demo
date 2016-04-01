package com.spring.lookup_method;

/**
 * 假若你需要单例bean在运行时重复的获取新的原型bean实例。那就不能将原型bean注入给单例bean，因为那样注入只会发生一次，
 * 就是发生在在Srping容器实例化单例bean并解析注入依赖时。如果需要多次获取新的原型bean实例，需要方法注入
 *
 *
 * Srping框架，使用CGLIB (Code Generation Library)类库生成动态子类的字节码技术，覆盖方法
 * 其父类不能是final类,被覆盖的方法也不能是final。
 * 被方法注入的对象不能序列化。
 * 若该方法不是抽象的，动态生成则会重写在源类中的方法。
 *
 */
public abstract class UserManager {
    protected abstract User getUser();

    public void run(){
        User user = getUser();
        System.out.println(user);
    }

  /*  public User getUser() {
        User user =  new User();
        user.setName("ddaa");
        return user;
    }*/
}

class User{
    String name;

    public void init() {
        this.name = "ad";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
