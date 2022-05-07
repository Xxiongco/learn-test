package com.panda.learn_spring_boot.base.domain;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class Student {
    private Integer id;
    @NotNull
    private String num;
    @NotBlank
    private String name;

    private Integer age;
    private String grade;
}
