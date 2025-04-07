package com.apistreamgenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aula01 {

    public static void main(String[] args) {

        List<String> debugValues = new ArrayList<>();

        Stream value01 = Arrays.stream(Stream.generate(() -> new Random()
                        .nextInt())
                        .limit(5)
                        .toArray(Integer[]::new));

        for (var v : value01.toList()) {
            System.out.println(v);
        }

        int[] value = IntStream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray();

        Stream.of("Maria", "João", "Marcio", "Luana", "Leandro", "Marcia")
                .peek(System.out::println)
                .filter(name -> name.endsWith("o"))
                .toList();

        System.out.println(value);
        System.out.println(debugValues);
    }
}