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
    String selectBlog(int id);

    Map selectMap(int id);

    UserModel selectUser(int id);

    List selectUsers();

    UserModel selectUser2(@Param("name") String name,@Param("id") int id);

    void updateUser(@Param("id") int id);

    void updateUser2(@Param("id") int id);
}
