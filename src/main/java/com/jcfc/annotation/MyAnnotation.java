package com.jcfc.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(MyAnnotations.class)//重复注解：必须放在容器中,并加上@Repeatable
@Target({TYPE, FIELD, METHOD, PARAMETER, TYPE_PARAMETER})
@Retention(RUNTIME)
public @interface MyAnnotation {
    String value() default "jcfc";
}
