package com.panda;

import com.panda.dao.StudentMapper;
import com.panda.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LearnMybatisMain {
    public static void main(String[] args) throws IOException {
        String resource = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> students = mapper.queryAll();
            students.forEach(student -> System.out.println(student));
        } finally {
            session.close();
        }
    }
}
