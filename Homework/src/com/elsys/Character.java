package com.elsys;

import java.util.ArrayList;

public abstract class Character {
    private int current_health;
    private int max_health;
    private int intelligence;
    private int dexterity;

    private final ArrayList<Item> inventory = new ArrayList<>();
    private final int inventory_slots;
    private final ArrayList<Item> hotBar = new ArrayList<>();
    private final int hotBar_slots;

    Character(int max_health, int intelligence, int dexterity) {
        this.current_health = max_health;
        this.max_health = max_health;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.inventory_slots = 10;
        this.hotBar_slots = 3;
    }

    abstract protected String getCharacterClass();

    public String toString() {
        return "Class - " + getCharacterClass() + " Health - " + this.current_health;
    }

    void pick(Item newItem) throws Exception {
        if(newItem.getPicked()) {
            throw new Exception("Item picked");
        }
        int i = 0;
        boolean inventory_added = false;
        boolean hotBar_added = false;

        for(i = 0; i < this.inventory.size(); i++) {
            if(this.inventory.get(i) == null) {
                this.inventory.remove(i);
                this.inventory.add(i, newItem);
                inventory_added = true;
                break;
            }
        }
        if(!inventory_added) {
            if (this.inventory.size() + 1 > this.inventory_slots) {
                throw new Exception("No space in your inventory\n");
            } else {
                this.inventory.add(newItem);
            }
        }

        if(newItem instanceof Equippable) {
            for(i = 0; i < this.hotBar.size(); i++) {
                if(this.hotBar.get(i) == null) {
                    this.hotBar.remove(i);
                    this.hotBar.add(i, newItem);
                    hotBar_added = true;
                    break;
                }
            }
            if(!hotBar_added) {
                if (this.hotBar.size() + 1 > this.hotBar_slots) {
                    throw new Exception("No spaces left in your hotbar\n");
                } else {
                    this.hotBar.add(newItem);
                }
            }
        }
        newItem.setPicked(true);
    }

    void useAt(int index, Character target) throws Exception {
        if(index < 0 || index >= this.hotBar.size() || this.hotBar.get(index) == null) {
            throw new Exception("Hobar error\n");
        }
        if(this.hotBar.get(index) instanceof Consumable) {
            if(this.hotBar.get(index).getName().equals("Potion")) {
                ((Potion) this.hotBar.get(index)).consume(this);
            }
        } else if (this.hotBar.get(index) instanceof Usable) {
            if(this.hotBar.get(index).getName().equals("Scroll")) {
                ((Scroll) this.hotBar.get(index)).use(this, target);
            } else if(this.hotBar.get(index).getName().equals("Book")) {
                ((Book) this.hotBar.get(index)).use(this, target);
            }
        }

        int inv_deleted_index = inventory.indexOf(this.hotBar.get(index));
        this.inventory.remove(this.hotBar.get(index));
        this.inventory.add(inv_deleted_index, null);
        this.hotBar.remove(this.hotBar.get(index));
        this.hotBar.add(index, null);
        //this.inventory.add(index, null);
    }
    public int getCurrent_health() {
        return this.current_health;
    }
    public void setCurrent_health(int current_health) {
        this.current_health = current_health;
    }

    public int getMax_health() {
        return this.max_health;
    }
    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getIntelligence() {
        return this.intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return this.dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void printHotbarEorN() {
        System.out.println("Hotbar: ");
        for(int i = 0; i < this.hotBar.size(); i++) {
            if(this.hotBar.get(i) == null) {
                System.out.println(i + " - null");
            } else {
                System.out.println(i + " - " + this.hotBar.get(i).getName());
            }
        }
    }
    public void printInventoryEorN() {
        System.out.println("Inventory: ");
        for(int i = 0; i < this.inventory.size(); i++) {
            if(this.inventory.get(i) == null) {
                System.out.println(i + " - null");
            } else {
                System.out.println(i + " - " + this.inventory.get(i).getName());
            }
        }
    }

}
