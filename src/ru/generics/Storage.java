package ru.generics;

import static ru.generics.util.Util.getValue;

public class Storage<C extends Consignment> {
    C consignment;
    int allMass;

    public Storage(C consignment) {
        this.consignment = consignment;
    }

    public void mass(int quantity) {
        int weight = getValue(consignment, Consignment.class).weight;
        allMass = weight * quantity;
    }

    public void transfer(Storage<C> to, int quantity) {
        allMass += quantity;
        to.allMass -= quantity;
    }

    @Override
    public String toString() {
        return "consignment: " + consignment +
                "\nallMass: " + allMass;
    }
}

