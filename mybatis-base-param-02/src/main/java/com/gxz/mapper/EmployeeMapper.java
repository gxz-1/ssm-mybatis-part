package com.gxz.mapper;

import com.gxz.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
     //根据id查询员工信息
     Employee queryById(Integer id);

      //场景1：根据id删除员工信息
     int deleteById(Integer id);
     //根据工资查询员工信息
     List<Employee> queryBySalary(Double salary);

     //场景2：插入员工数据 【实体对象】
     int insertEmp(Employee employee);//自增长的主键设置

     //场景3：根据员工姓名和工资查询员工信息
     List<Employee> queryByNameAndSalary(@Param("a")String name, @Param("b") Double salary);

     //场景4：插入员工数据，传入的是一个map(name=员工的名字,salary=员工的薪水)
     int insertEmpMap(Map data);




}
