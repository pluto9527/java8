package com.jcfc.defaultinterface;

public class TestDefaultInterface {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());

        System.out.println(MyInterface.getInfo());
    }
}
