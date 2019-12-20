package ru.phoneStore;

import java.io.IOException;
import java.util.ArrayList;

import static ru.phoneStore.StoreInfo.startupStore;

public class StoreMain {
    static ArrayList<Phone> list = new ArrayList<>();
    static StoreInfo store = new StoreInfo();

    public static void main(String[] args) throws IOException {
        startupStore();
    }
}