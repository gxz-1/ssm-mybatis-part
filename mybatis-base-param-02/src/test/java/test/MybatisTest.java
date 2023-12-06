package test;

import com.gxz.mapper.EmployeeMapper;
import com.gxz.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3.根据工厂创建sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        //4.根据接口的代理对象调用方法，查找mapper接口的方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);
        //5.提交事务和释放资源
        sqlSession.commit();
        sqlSession.close();

    }
}
