package ru.exception;

public class ArrayDataException extends Exception{
    String str;
    public static final String INFO = "Array have symbols";

    public ArrayDataException(String message, String str) {
        super(message);
        this.str = str;
    }
}
