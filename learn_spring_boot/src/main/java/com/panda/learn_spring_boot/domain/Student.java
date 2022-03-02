package com.panda.learn_spring_boot.domain;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Student {
    private Integer id;
    @NotNull
    private String num;
    @NotBlank
    private String name;

    private Integer age;
    private String grade;
}
