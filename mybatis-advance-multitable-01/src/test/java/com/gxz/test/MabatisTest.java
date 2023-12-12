package com.gxz.test;

import com.gxz.mapper.CustomerMapper;
import com.gxz.pojo.Order;
import com.gxz.mapper.OrderMapper;
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

public class MabatisTest {
    private SqlSession sqlSession;

    @BeforeEach //每次运行Test之前都运行这段代码
    public void init() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ips);
        sqlSession = sessionFactory.openSession(true);
    }

    @Test
    public void test() throws IOException {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //测试对一的多表查询
        Order order = mapper.queryByOrderId(2);
        System.out.println("order = " + order);
    }

    @Test
    public void test2() throws IOException{
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Order> orderList = mapper.QueryAllOrder();
        System.out.println("orderList = " + orderList);
    }

    @AfterEach //每次运行Test之后都运行这段代码
    public void clean(){
        sqlSession.close();
    }

}
