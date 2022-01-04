package com.panda.learn_validate.domian;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Student {
    private Integer id;
    @NotNull
    private String num;
    @NotNull
    private String name;
    private Integer age;
    private String grade;
}
