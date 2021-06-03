package com.elsys;


public class Main {

    public static void main(String[] args) throws Exception {

        Mage mag1 = new Mage();
        Archer arc1 = new Archer();

        Note note1 = new Note("Here is starting your journey!\n");
        Note note2 = new Note("Your journey ends here!\n");

        Potion pot1 = new Potion(15, 20);
        Potion pot2 = new Potion(30, 5);
        Potion pot3 = new Potion(10, 50);

        Scroll scroll1 = new Scroll(10);
        Scroll scroll2 = new Scroll(55);
        Scroll scroll3 = new Scroll(45);

        Book book1 = new Book(2);
        Book book2 = new Book(3);
        Book book3 = new Book(4);

        arc1.pick(note1);
        arc1.pick(note2);
        arc1.pick(pot1);
        arc1.pick(scroll1);
        //arc1.pick(scroll2);
        arc1.pick(book1);

        mag1.pick(pot2);
        //mag1.pick(pot3);
        mag1.pick(scroll3);
        //mag1.pick(book2);
        mag1.pick(book3);

        System.out.println("Mana - " + mag1.getCurrent_mana() + " Health - " + mag1.getCurrent_health());
        //arc1.printInventoryEorN();
        //arc1.printHotbarEorN();
        arc1.useAt(1, mag1);
        //arc1.printInventoryEorN();
        //arc1.printHotbarEorN();
        System.out.println("Mana - " + mag1.getCurrent_mana() + " Health - " + mag1.getCurrent_health());
        //mag1.printHotbarEorN();
        mag1.useAt(0, arc1);
        //mag1.printHotbarEorN();
        System.out.println("Mana - " + mag1.getCurrent_mana() + " Health - " + mag1.getCurrent_health());
        mag1.pick(scroll2);
        arc1.pick(book2);
        //mag1.printHotbarEorN();
        //arc1.printHotbarEorN();
        System.out.println(arc1.toString());
        mag1.useAt(0, arc1);
        System.out.println(arc1.toString());
        //mag1.printHotbarEorN();
        mag1.pick(pot3);
        arc1.useAt(0, mag1);
        System.out.println(arc1.toString());
        //mag1.printHotbarEorN();
        //arc1.printInventoryEorN();
//        mag1.pick(book2);
//        mag1.printHotbarEorN();
//        arc1.useAt(2, mag1);
//        System.out.println("Mana - " + mag1.getCurrent_mana() + " Health - " + mag1.getCurrent_health());
//        arc1.printHotbarEorN();
    }
}
