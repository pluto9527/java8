package com.jcfc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, METHOD, TYPE_PARAMETER})
@Retention(RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
