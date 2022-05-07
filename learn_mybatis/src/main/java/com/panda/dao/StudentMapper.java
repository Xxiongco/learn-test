package com.panda.dao;

import com.panda.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface StudentMapper {
    List<Student> queryAll();

    Student queryById(@Param("studentId") Long id);

    List<Student> testSelect(Student student);

    List<Student> selectByTwoCondiction(Integer id , String num, Student student);

    List<Student> testStringToLongInMybatis(Student student);

    Integer updateStudent(Student student);
}
