package com.elsys;

public class Archer extends Character{

    Archer() {
        super(100, 5, 10);
    }

    @Override
    protected String getCharacterClass() {
        return "Archer";
    }
}
