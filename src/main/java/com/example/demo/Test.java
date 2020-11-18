package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int timeout = 10000;
        timeout -= 100;
        Thread.sleep(100L);
        System.out.println(System.currentTimeMillis()-start);
    }



}


