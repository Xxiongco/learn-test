package com.panda;

import com.panda.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        Student stdent = context.getBean("student", Student.class);
        System.out.println(stdent);
    }
}
