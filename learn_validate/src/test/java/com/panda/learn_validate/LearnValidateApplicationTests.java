package com.panda.learn_validate;

import com.panda.learn_validate.domian.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LearnValidateApplicationTests {

    @Test
    void contextLoads() {
        Student student = new Student();
        System.out.println(student);
    }

}
