package com.jcfc.defaultinterface;

public class SubClass implements MyFun, MyInterface {

    @Override
    public String getName() {
        return MyFun.super.getName();
    }
}
