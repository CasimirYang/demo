package com.myBatis;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yjh on 16/9/28.
 */
public interface ClassMapper {


    List<ClassModel> selectClass();

    List<ClassModel> selectClass2();
}
