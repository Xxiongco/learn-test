package com.panda;

import com.panda.dao.StudentMapper;
import com.panda.domain.Student;
import com.panda.interceptor.MybatisInterceptor;
import com.panda.interceptor.MybatisInterceptor2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LearnMybatisMain {

    public static String TYPE = "student";

    public static void main(String[] args) throws Exception {
        //learnMybatis();
        // 为mybatis添加拦截器的测试
        //testWithInterceptor();

        //testMultipleParam();
        testStringToLongInMybatis();


    }

    public static void testStringToLongInMybatis(){

        Student student = new Student();

        HashSet<String> ids = new HashSet<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");

        student.setIds(ids);
        //student.setName("panda");

        SqlSession sqlSession = getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.testStringToLongInMybatis(student);

        for (Student s : students) {
            System.out.println(s);
        }


    }

    public static SqlSession getSqlSession(){



        String resource = "mybatisConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        return session;

    }

    /**
     * idea修改相关的参数即可
     * @throws Exception
     */
    public static void testMultipleParam() throws Exception {
        String resource = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(2);
        student.setNum("20172110");
        List<Student> students = mapper.selectByTwoCondiction(1, "20172109", student);

        System.out.println(students);

    }


    public static void testWithInterceptor() throws Exception {
        String resource = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addInterceptor(new MybatisInterceptor());
        sqlSessionFactory.getConfiguration().addInterceptor(new MybatisInterceptor2());
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setType("student");
        List<Student> students = mapper.testSelect(student);
        students.forEach(item -> {
            System.out.println(item.getNum() == null);
            System.out.println(item);
        });
    }

    public static void learnMybatis() throws IOException {
        String resource = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.queryById(1L);
            System.out.println(student);
            List<Student> students = mapper.queryAll();
            students.forEach(item -> System.out.println(item));
        } finally {
            session.close();
        }
    }
}
