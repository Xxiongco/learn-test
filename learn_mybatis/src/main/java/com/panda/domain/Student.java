package com.panda.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Student {
    private Integer id;
    private String name;
    private String num;
}
