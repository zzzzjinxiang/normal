package com.company;

import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        String x = "cat";
        String x1 = new String("cat");
        System.out.println("x.equals(x1):"+x.equals(x1));
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
