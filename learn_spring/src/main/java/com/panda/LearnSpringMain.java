package com.panda;

import com.panda.circle.depend.A;
import com.panda.circle.depend.B;
import com.panda.circle.depend.C;
import com.panda.circle.depend.D;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class LearnSpringMain {
    public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        A a = context.getBean("a", A.class);
        a.hello();

        B b = context.getBean("b", B.class);
        C c = context.getBean("c", C.class);
        D d = context.getBean("d", D.class);

        System.out.println(a);
        a.hello();

        System.out.println(b);
        b.hello();

        System.out.println(c);

        System.out.println(d);


//        Student student = context.getBean("student", Student.class);
//        System.out.println(student);


/**
        Object myFactoryBean = context.getBean("myFactoryBean");
        System.out.println(myFactoryBean.getClass());
        Object myFactoryBeanFactory = context.getBean("&myFactoryBean");
        System.out.println(myFactoryBeanFactory.getClass());

 **/


    }
}
