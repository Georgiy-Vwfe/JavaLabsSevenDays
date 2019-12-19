package ru.exception;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayCheck {
    static int sum;

    public static void checkArraySize(String[][] arr) throws MyArraySizeException {
        int arrSize = 3;
        if (arr.length != arrSize) {
            throw new MyArraySizeException("Overcrowded");
        }
        for (String[] strings : arr) {
            if (strings.length != arrSize) {
                throw new MyArraySizeException("incorrect");
            }
        }
    }


    public static void sumArrayContain(String[][] arr) throws ArrayDataException {
        String[] arr2 = new String[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isInteger(arr[i][j])) {
                    System.out.print(arr[i][j] + " ");
                    arr2[index++] = arr[i][j];
                } else {
                    throw new ArrayDataException("Not a number", arr[i][j]);
                }
            }
        }
        String str = String.join(" ", arr2);
        System.out.println("\n" + str);
        int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        sum = IntStream.of(numArr).sum();
    }

    static boolean isInteger(String arr) {
        try {
            Integer.parseInt(arr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
