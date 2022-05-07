package com.panda.learn_spring_stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * matchIfMissing
 * 如果没有配置也匹配，默认是false,也就是说，如果配置文件没有，那么这个bean不生效，true时生效。
 */

@Order(1)
@Component
@ConditionalOnProperty(name="app.initialize.dictionary")
public class DictionaryInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("1243");
    }
}