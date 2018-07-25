package com.jcfc.optional.entity;

import java.util.Optional;

public class NewMan {
    private Optional<Women> women = Optional.empty();

    public NewMan() {
    }

    public NewMan(Optional<Women> women) {
        this.women = women;
    }

    public Optional<Women> getWomen() {
        return women;
    }

    public void setWomen(Optional<Women> women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "women=" + women +
                '}';
    }
}
