package ru.generics;

public class GenTest {
    public static void main(String[] args) {
        Storage<Bolt> storageBolts = new Storage<>(new Bolt(5));
        Storage<Dumbbell> storageDumbbell = new Storage<>(new Dumbbell(8));
        Storage<Bolt> storageBolts2 = new Storage<>(new Bolt(5));

        storageBolts.mass(5);
        storageDumbbell.mass(10);
        storageBolts2.mass(6);
        System.out.println(storageBolts.toString());
        System.out.println(storageBolts2.toString());
        storageBolts.transfer(storageBolts2, 4);
        System.out.println(storageBolts.toString());
        System.out.println(storageBolts2.toString());
        System.out.println(storageDumbbell.toString());
    }
}
