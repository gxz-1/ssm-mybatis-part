package test;

import com.gxz.mapper.EmployeeMapper;
import com.gxz.mapper.TeacherMapper;
import com.gxz.pojo.Employee;
import com.gxz.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


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
        sqlSession.commit();//由于开启了事务，需要提交才会更新数据库
        sqlSession.close();

    }
    @Test
    public void test2() throws IOException{
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ips);
        SqlSession sqlSession = sessionFactory.openSession(true);//autoCommit=true,自动提交事务
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //插入数据,测试主键回显
        Employee e = new Employee();
        e.setEmpName("流弊");
        e.setEmpSalary(666.6);
        System.out.println("插入前："+e.getEmpId());//插入前没有id
        int rows = mapper.insertEmp(e);
        System.out.println("插入后："+e.getEmpId());//插入后回写了id值
        System.out.println("rows = " + rows);
//        List<Employee> employeeList = mapper.queryByNameAndSalary("万物", 666.75);
//        System.out.println("employeeList = " + employeeList);
        sqlSession.close();

    }

    @Test
    public void test3() throws IOException{
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(ips);
        SqlSession sqlSession = sessionFactory.openSession(true);//autoCommit=true,自动提交事务
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);//获取teacher对应的mapper
        ////测试非自增长主键回显
        Teacher t = new Teacher();
        t.settName("流老师");
        System.out.println("插入前："+t.gettId());//插入前没有id
        int rows = mapper.insertTeacher(t);
        System.out.println("插入后："+t.gettId());//插入后回写了id值
        System.out.println("rows = " + rows);

        //resultMap测试
        Teacher teacher = mapper.queryById("ffaca6cd94b411eea953e0e1a913bd29");
        System.out.println("teacher = " + teacher);
        sqlSession.close();

    }

}
