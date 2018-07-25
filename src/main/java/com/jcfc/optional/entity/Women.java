package com.jcfc.optional.entity;

public class Women {
    private String name;

    public Women() {
    }

    public Women(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Women{" +
                "name='" + name + '\'' +
                '}';
    }
}
