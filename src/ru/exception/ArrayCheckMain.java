package ru.exception;

import java.util.Arrays;

import static ru.exception.ArrayCheck.*;

public class ArrayCheckMain {
    public static void main(String[] args) {
        String[][] arr = {{"1", "22", "4"}, {"1", "2", "3"}, {"1", "2", "3"}};

        try {
            checkArraySize(arr);
        } catch (MyArraySizeException e) {
            System.out.println("Array size incorrect");
            return;
        }

        try {
            sumArrayContain(arr);
        } catch (ArrayDataException a) {
            System.out.println(ArrayDataException.INFO);
            return;
        }
        System.out.println(sum);
    }
}
