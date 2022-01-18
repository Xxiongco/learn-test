package com.panda;

import com.panda.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

//        Student student = context.getBean("student", Student.class);
//        System.out.println(student);

        Object myFactoryBean = context.getBean("myFactoryBean");
        System.out.println(myFactoryBean.getClass());
        Object myFactoryBeanFactory = context.getBean("&myFactoryBean");
        System.out.println(myFactoryBeanFactory.getClass());

    }
}
