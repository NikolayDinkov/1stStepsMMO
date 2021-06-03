package com.elsys;


public class Potion extends Item implements Consumable, Equippable{
    private final int health_restore;
    private final int mana_restore;

    Potion(int health_restore, int mana_restore) {
        super("Potion");
        this.health_restore = health_restore;
        this.mana_restore = mana_restore;
    }

    @Override
    public void consume(Character target) {
        if(target.getCurrent_health() + this.health_restore > target.getMax_health()) {
            target.setCurrent_health(target.getMax_health());
        } else {
            target.setCurrent_health(target.getCurrent_health() + this.health_restore);
        }

        if(target.getCharacterClass().equals("Mage")) {
            if(((Mage) target).getCurrent_mana() + this.mana_restore > ((Mage) target).getMax_mana()) {
                ((Mage) target).setCurrent_mana(((Mage) target).getMax_mana());
            } else {
                ((Mage) target).setCurrent_mana(((Mage) target).getCurrent_mana() + this.mana_restore);
            }
        }
    }
}
