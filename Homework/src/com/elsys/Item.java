package com.elsys;

public abstract class Item {
    private final String name;
    private boolean picked;

    Item(String name) {
        this.name = name;
        this.picked = false;
    }

    public String getName() {
        return this.name;
    }

    boolean getPicked() {
        return this.picked;
    }

    void setPicked(boolean picked) {
        this.picked = picked;
    }
}
