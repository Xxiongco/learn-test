package com.panda.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Student extends Person{
    private Integer id;
    private String num;
    private String type;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", num='" + num + '\'' + super.toString() +
                '}';
    }
}
