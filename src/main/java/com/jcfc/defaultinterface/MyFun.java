package com.jcfc.defaultinterface;

public interface MyFun {

    default String getName() {
        return "MyFun接口默认方法";
    }

}
