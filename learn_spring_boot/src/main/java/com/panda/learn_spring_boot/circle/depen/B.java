package com.panda.learn_spring_boot.circle.depen;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Data
@Component
public class B {
    @Autowired
    private A a;
}
