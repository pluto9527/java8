package com.jcfc.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 *  重复注解与类型注解
 */
public class TestAnnotation {

    //重复注解
    @Test
    public void test() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method method = clazz.getMethod("show");

        MyAnnotation[] annotations = method.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation myAnnotation : annotations) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show() {
    }

    //checker framework
    private /*@NonNull*/ Object obj = null;
    //类型注解
    public void show2(@MyAnnotation("abc") String str) {

    }

}
