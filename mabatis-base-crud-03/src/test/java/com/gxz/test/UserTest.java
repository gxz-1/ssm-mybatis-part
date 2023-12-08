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
        //测试更新
//        User user = new User();
        user.setId(0);
        user.setUsername("简分担");
        user.setPassword("25879");
        int update = mapper.update(user);
        System.out.println("update = " + update);
        //测试删除

    }

    @AfterEach
    public void clean(){
        sqlSession.close();
    }
}
