package com.panda;

import com.panda.config.Panda;
import com.panda.domian.Student;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class TestMain {
    /**
     * 测试注解继承性
     */
    @Test
    public void test(){

        Class<Student> studentClass = Student.class;

        Class<? super Student> superclass = studentClass.getSuperclass();

        System.out.println(superclass);

        Annotation[] annotations = superclass.getAnnotations();

        System.out.println(annotations);

        System.out.println(annotations.length);

        for (Annotation annotation : annotations) {

            if (annotation instanceof Panda){
                System.out.println(((Panda)annotation).name());
            }
        }


    }
}
