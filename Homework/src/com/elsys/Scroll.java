package com.elsys;

public class Scroll extends Item implements Equippable, Usable{
    private int base_damage;

    Scroll(int base_damage) {
        super("Scroll");
        this.base_damage = base_damage;
    }

    @Override
    public void use(Character source, Character target) {
        double coefficient = (double)(source.getIntelligence() - target.getIntelligence()) / 10;
        double damage = this.base_damage + coefficient * this.base_damage;
        if((int)(target.getCurrent_health() - damage) < 0) {
            target.setCurrent_health(0);
        } else if((int)(target.getCurrent_health() - damage) > target.getMax_health()) {
            target.setCurrent_health(target.getMax_health());
        } else {
            target.setCurrent_health((int)(target.getCurrent_health() - damage));
        }
    }
    int getBase_damage() {
        return this.base_damage;
    }

    void setBase_damage(int base_damage) {
        this.base_damage = base_damage;
    }
}
