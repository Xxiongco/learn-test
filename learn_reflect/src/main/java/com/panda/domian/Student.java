package com.panda.domian;

import com.panda.config.Panda;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Student extends Person implements Study{
    private Integer id;
    @NotNull
    private String num;
    @NotNull
    private String name;
    private Integer age;
    private String grade;

    @Override
    public void learn(String subject) {
        System.out.println("i will learn " + subject);
    }
}
