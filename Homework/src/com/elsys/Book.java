// Класа се казва Book, защото в началото исках да бъде книга за енчантване на оръжието но няма как да стане
// и не съм сменял иментата
package com.elsys;

public class Book extends Item implements Equippable, Usable{
    private final int dizziness;

    Book(int dizziness) {
        super("Book");
        this.dizziness = dizziness;
    }
    @Override
    public void use(Character source, Character target) {
        if(target.getIntelligence() - (this.dizziness * 3) < 0) {
            target.setIntelligence(0);
        } else {
            target.setIntelligence(target.getIntelligence() - (this.dizziness * 3));
        }
        if(target.getDexterity() - (this.dizziness * 2) < 0) {
            target.setDexterity(0);
        } else {
            target.setDexterity(target.getDexterity() - (this.dizziness * 2));
        }
        if(target.getCharacterClass().equals("Mage")) {
            if(((Mage) target).getCurrent_mana() + (this.dizziness * 4) > ((Mage) target).getMax_mana()) {
                ((Mage) target).setCurrent_mana(((Mage) target).getMax_mana());
            } else {
                ((Mage) target).setCurrent_mana(((Mage) target).getCurrent_mana() + (this.dizziness * 4));
            }
        }
    }
}
