package com.gxz.test;

import com.gxz.mapper.EmployeeMapper;
import com.gxz.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSession sqlSession;

    @BeforeEach //每次运行Test之前都运行这段代码
    public void init() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ips);
        sqlSession = sessionFactory.openSession(true);
    }

    @Test
    public void test() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = mapper.query(null, 100.0);//两个条件都不生效
        System.out.println("employeeList = " + employeeList);
        employeeList = mapper.query(null, 700.0);//salary条件生效
        System.out.println("employeeList = " + employeeList);
    }

    @AfterEach //每次运行Test之后都运行这段代码
    public void clean(){
        sqlSession.close();
    }

}
