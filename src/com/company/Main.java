package com.company;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        int m = Integer.MIN_VALUE;
        System.out.println(m+1);
        String keys = "ABCDEFG";
        for (int i = 1; i <= keys.length(); i++) {
            map.put(String.valueOf(keys.charAt(i - 1)), i);
        }
        map.forEach(2,
                (k, v) -> System.out.println("key-" + k + ":value-" + v + ". by thread->" + Thread.currentThread().getName()));
    }
}
