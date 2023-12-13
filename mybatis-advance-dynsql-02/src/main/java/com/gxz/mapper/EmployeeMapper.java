package com.gxz.mapper;

import org.apache.ibatis.annotations.Param;
import com.gxz.pojo.Employee;

import java.util.List;

//学习动态sql语句
public interface EmployeeMapper {
    //学习where标签
    List<Employee> query(@Param("name") String name,@Param("salary") Double salary);
    //学习set标签
    int updateById(Employee employee);
    //学习choose标签
    List<Employee> queryChoose(@Param("name") String name,@Param("salary") Double salary);

    // 根据id批量的进行增删改查
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);
    int deleteBatch(@Param("ids") List<Integer> ids);
    int insertBatch(@Param("list")List<Employee> employeeList);
    int updateBatch(@Param("list") List<Employee> employeeList);
}
