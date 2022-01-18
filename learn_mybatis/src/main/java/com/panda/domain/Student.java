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

    private Integer count;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count + '\'' + ", "+
                super.toString() +
                '}';
    }
}
