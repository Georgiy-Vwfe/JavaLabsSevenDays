package ru.generics.util;

import ru.generics.Storage;

public class Util {
    public static <T> T getValue(Object obj, Class<T> clazz) {
        return (T) obj;
    }

    public static <T> T getValue(Object obj) {
        return (T) obj;
    }
}