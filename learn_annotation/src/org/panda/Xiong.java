package org.panda;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Hong
public @interface Xiong {
    String name() default "xiong";
    String age() default "20";
}
