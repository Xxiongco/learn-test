package org.panda.learn_lua.domian;


import lombok.Data;

@Data
public class Student{

    public static Integer NUM = 1;
    public static String PRE_FIX = "2022-00";

    private Integer id;
    private String num;
    private String name;

    public Student(String name) {
        this.id = NUM;
        this.num = PRE_FIX + id;
        this.name = name;
        NUM ++;
    }
}
