package com.jcfc.defaultinterface;

public interface MyInterface {

    default String getName() {
        return "MyInterface接口默认方法";
    }

    public static String getInfo() {
        return "MyInterface接口静态方法";
    }

}
