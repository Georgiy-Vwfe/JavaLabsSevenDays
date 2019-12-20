package ru.phoneStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.phoneStore.StoreMain.*;

public class StoreInfo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private String color;
    private int price;
    private int amount;
    private static int purchaseSum = 0;

    public String getName() {
        return name;
    }

    private String setName() throws IOException {
        System.out.println("Введите название:");
        this.name = reader.readLine();
        return name;
    }

    public String getColor() {
        return color;
    }

    private String setColor() throws IOException {
        System.out.println("Введите цвет:");
        this.color = reader.readLine();
        return color;
    }

    public int getPrice() {
        return price;
    }

    private int setPrice() throws IOException {
        System.out.println("Введите цену:");
        String text = reader.readLine();
        if (isInteger(text)) {
            this.price = Integer.parseInt(text);
            if (price < 1) {
                System.out.println("Цена не может быть меньше 0");
                setPrice();
            }
        } else {
            setPrice();
        }
        return price;
    }

    public int getAmount() {
        return amount;
    }

    private int setAmount() throws IOException {
        System.out.println("Введите кол-во:");
        String text = reader.readLine();
        if (isInteger(text)) {
            this.amount = Integer.parseInt(text);
            if (amount < 1) {
                System.out.println("Цена не может быть меньше 0");
                setAmount();
            }
        } else {
            setAmount();
        }
        return amount;
    }

    private boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Введите число");
            return false;
        }
    }

    private void newProduct(Phone phone) throws IOException {
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

    private void sale() throws IOException {
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

    private void saleReport() throws IOException {
        System.out.println(purchaseSum);
        startupStore();
    }

    private void storage() throws IOException {
        for (Phone phone : list) {
            System.out.println(phone.name + " " + phone.color + " " + phone.price + " " +
                    phone.amount);
        }
        startupStore();
    }

    public static void startupStore() throws IOException {
        try {
            System.out.print("|New product|-|Sale|-|Store|-|Sale Report|-|Quit|-" + '\n' + "Введите запрос: ");
            String method = reader.readLine();
            switch (method) {
                case "New product":
                    store.newProduct(new Phone(store.setName(), store.setColor(), store.setPrice(), store.setAmount()));
                    store.rePurchase();
                    break;
                case "Sale report":
                    store.saleReport();
                    break;
                case "Sale":
                    store.sale();
                    break;
                case "Store":
                    store.storage();
                case "Quit":
                    break;
            }
        } catch (IllegalArgumentException a) {
            a.printStackTrace();
        }
    }

    private void rePurchase() throws IOException {
        System.out.println("Хотите добавить еще? Y/N");
        if (reader.readLine().equalsIgnoreCase("Y")) {
            newProduct(new Phone(store.setName(), store.setColor(), store.setPrice(), store.setAmount()));
        }
    }

}