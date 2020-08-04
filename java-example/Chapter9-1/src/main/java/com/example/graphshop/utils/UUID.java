package com.example.graphshop.utils;

public class UUID {
    private static int id = 0;

    public static String getId() {
        return String.valueOf(id++);
    }
}
