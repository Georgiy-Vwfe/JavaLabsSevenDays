package ru.phoneStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Store {
    static ArrayList<Phone> list = new ArrayList<>();
    static StoreInfo store = new StoreInfo();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int purchaseSum = 0;

    public static void main(String[] args) throws IOException {
        startupStore();
    }

    public static void newProduct(Phone phone) throws IOException {
        if (list.size() == 0) {
            list.add(phone);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).name.equals(phone.name) && list.get(i).color.equals(phone.color)) {
                    list.get(i).amount += store.getAmount();
                } else {
                    list.add(phone);
                    break;
                }
            }
        }
        startupStore();
    }

    public static void sale() throws IOException {
        boolean hasPhone = false;
        int index = 0;

        String currName = store.setName();
        String currColor = store.setColor();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(currName) && list.get(i).color.equals(currColor)) {
                hasPhone = true;
                index = i;
                purchaseSum += list.get(i).amount * list.get(i).price;
                break;
            }
        }
        if (hasPhone) {
            list.get(index).amount -= store.setAmount();
            if (list.get(index).amount <= 0) {
                list.remove(index);
            }
        } else {
            System.out.println("Такого телефона нет,введите заново");
            sale();
        }
        startupStore();
    }

    public static void saleReport() throws IOException {
        System.out.println(purchaseSum);
        startupStore();
    }

    public static void storage() throws IOException {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name + " " + list.get(i).color + " " + list.get(i).price + " " +
                    list.get(i).amount);
        }

        startupStore();
    }

    public static void startupStore() throws IOException {
        try {
            System.out.print("|New product|-|Sale|-|Store|-|Sale Report|-|Quit|-" + '\n' + "Введите запрос: ");
            String method = reader.readLine();
            switch (method) {
                case "New product":
                    newProduct(new Phone(store.setName(), store.setColor(), store.setPrice(), store.setAmount()));
                    store.newPhone();
                    break;
                case "Sale report":
                    saleReport();
                    break;
                case "Sale":
                    sale();
                    break;
                case "Store":
                    storage();
                case "Quit":
                    break;
            }
        } catch (IllegalArgumentException a) {
            a.printStackTrace();
        }
    }
}