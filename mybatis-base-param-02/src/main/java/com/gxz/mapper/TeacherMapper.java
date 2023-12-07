package com.gxz.mapper;

import com.gxz.pojo.Teacher;

public interface TeacherMapper {
    int insertTeacher(Teacher teacher);//非自增长主键的回显

    //列名和属性名不一致如何解决 1.sql语句中起别名 2.驼峰式自动映射到resultType 3.使用resultMap自定义映射
    Teacher queryById(String id);
}
