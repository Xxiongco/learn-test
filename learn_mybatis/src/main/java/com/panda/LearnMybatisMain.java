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
import java.util.List;
import java.util.Stack;

public class LearnMybatisMain {

    public static String TYPE = "student";

    public static void main(String[] args) throws Exception {
        //learnMybatis();
        testWithInterceptor();
    }

    public static void testWithInterceptor() throws Exception{
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
