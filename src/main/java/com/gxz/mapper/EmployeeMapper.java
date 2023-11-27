package com.gxz.mapper;

import com.gxz.pojo.Employee;

public interface EmployeeMapper {
     Employee queryById(Integer id);
     int deleteById(Integer id);
}
