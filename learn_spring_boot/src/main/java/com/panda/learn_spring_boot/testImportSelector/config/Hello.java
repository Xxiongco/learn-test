package com.panda.learn_spring_boot.testImportSelector.config;

import com.panda.learn_spring_boot.testImportSelector.domian.User;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@EnableHelloConfiguration(name = "test",className = {User.class})
public @interface Hello {
}
