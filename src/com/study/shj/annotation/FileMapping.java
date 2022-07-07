package com.study.shj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(
    name = "file"
)
public @interface FileMapping {

    @AliasFor(
        annotation = RequestMapping.class
    )
    int menuNumber() default 0;

    @AliasFor(
        annotation = RequestMapping.class
    )
    String name() default "";

}
