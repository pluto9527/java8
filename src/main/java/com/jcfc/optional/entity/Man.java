package com.jcfc.optional.entity;

public class Man {
    private Women women;

    public Man() {
    }

    public Man(Women women) {
        this.women = women;
    }

    public Women getWomen() {
        return women;
    }

    public void setWomen(Women women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "Man{" +
                "women=" + women +
                '}';
    }
}
