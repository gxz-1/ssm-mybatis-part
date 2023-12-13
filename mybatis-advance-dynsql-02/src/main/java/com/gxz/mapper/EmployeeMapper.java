package com.gxz.mapper;

import org.apache.ibatis.annotations.Param;
import com.gxz.pojo.Employee;

import java.util.List;

//学习动态sql语句
public interface EmployeeMapper {
    List<Employee> query(@Param("name") String name,@Param("salary") Double salary);
}
