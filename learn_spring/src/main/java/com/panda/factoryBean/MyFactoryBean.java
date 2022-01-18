package com.panda.factoryBean;

import com.panda.domain.Student;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {

    private String name = "MyFactoryBean";

    @Override
    public Object getObject() throws Exception {
        return new Student(100,"xiong","20172109");
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
