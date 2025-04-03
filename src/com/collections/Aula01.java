package com.collections;

import java.util.ArrayList;
import java.util.List;

public class Aula01 {

    public static void main(String[] args) {

        int[] codes = {741, 852};

        System.out.println(codes.length);
        List<Integer> codes01 = new ArrayList<>();
        codes01.add(codes[0]);
        codes01.add(codes[1]);
        codes01.forEach(System.out::println);
        codes01.add(74988);
        codes01.forEach(System.out::println);
    }
}