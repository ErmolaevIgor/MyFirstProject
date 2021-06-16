package org.levelup.bank.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) // в каком месте мы можем использовать аннотацию
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {

    int min();
    int max() default Integer.MAX_VALUE;

}
