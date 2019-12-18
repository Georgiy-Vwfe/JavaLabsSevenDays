package ru.generics;

public class Bolt extends Consignment {
    public Bolt(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Bolt{} " + super.toString();
    }
}
