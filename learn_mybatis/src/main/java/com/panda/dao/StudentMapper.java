package com.panda.dao;

import com.panda.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> queryAll();

    Student queryById(@Param("studentId") Long id);

    List<Student> testSelect(Student student);
}
