package com.collections;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Aula01 {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();

        var arrayStart = OffsetDateTime.now();
        for(int i = 0; i < 100_00_000; i++) {

            arrayList.add(i);
        }

        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        var vectorStart = OffsetDateTime.now();
        List<Integer> vector = new Vector<>();
        for(int i = 0; i < 100_00_000; i++) {

            vector.add(i);
        }

        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        List<Integer> linkedList = new LinkedList<>();

        var linkedStart = OffsetDateTime.now();
        for(int i = 0; i < 100_00_000; i++) {

            arrayList.add(i);
        }

        System.out.println(Duration.between(linkedStart, OffsetDateTime.now()).toMillis());
    }
}