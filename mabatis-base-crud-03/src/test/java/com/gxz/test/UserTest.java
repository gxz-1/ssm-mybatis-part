package com.gxz.test;

import com.gxz.mapper.UserMapper;
import com.gxz.pojo.User;
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

public class UserTest {
    private SqlSession sqlSession;

    @BeforeEach //每次运行Test之前都运行这段代码
    public void init() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ips);
        sqlSession = sessionFactory.openSession(true);
    }

    @Test
    public void test() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试添加
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        mapper.insert(user);
        System.out.println(user);
        List<User> userList = mapper.selectAll();//查询所有
        System.out.println("userList = " + userList);
        //测试更新
        user.setId(1);
        user.setUsername("newadmin");
        user.setPassword("25879");
        int update = mapper.update(user);
        System.out.println("update = " + update);
        //测试查询
        User user1 = mapper.selectById(1);
        System.out.println("user1 = " + user1);
        //测试删除
        int delete = mapper.delete(1);
        System.out.println("delete = " + delete);
    }

    @AfterEach //每次运行Test之后都运行这段代码
    public void clean(){
        sqlSession.close();
    }
}
