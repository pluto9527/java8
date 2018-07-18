package com.jcfc.lambda.grammer;

//函数式接口
@FunctionalInterface
public interface MyFunction<T> {

    Integer getValue(T t);

}
