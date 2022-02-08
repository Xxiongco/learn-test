package com.panda.learn_spring_boot.testImportSelector.domian;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String name;
    private String num;
}