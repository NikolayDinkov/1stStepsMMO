package com.elsys;

public class Mage extends Character {
    private int max_mana;
    private int current_mana;

    Mage() {
        super(60, 10, 5);
        this.max_mana = 80;
        this.current_mana = 80;
    }

    @Override
    protected String getCharacterClass() {
        return "Mage";
    }

    int getMax_mana() {
        return this.max_mana;
    }
    void setMax_mana(int max_mana) { this.max_mana = max_mana; }

    int getCurrent_mana() {
        return this.current_mana;
    }
    void setCurrent_mana(int current_mana) {
        this.current_mana = current_mana;
    }
}
