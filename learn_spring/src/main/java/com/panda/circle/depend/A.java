package com.panda.circle.depend;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class A {

    @Autowired
    private B b;

    public void hello(){
        System.out.println("AAAAAAAA " + this);
    }
}
