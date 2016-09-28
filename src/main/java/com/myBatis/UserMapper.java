package com.myBatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 映射器类必须是一个接口,而不是具体的实现类
 *
 */

public interface UserMapper {

    Map selectMap(int id);

    Object selectUser(int id);

    List selectUsers();

    UserModel selectUser2(@Param("name") String name,@Param("id") int id);

    void updateUser(@Param("id") int id);

    void updateAge(@Param("age") int age, @Param("id") int id);

    int selectAge(@Param("id") int id);


}
