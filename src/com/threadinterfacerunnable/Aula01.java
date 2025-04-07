package com.threadinterfacerunnable;

import java.util.ArrayList;
import java.util.List;

public class Aula01 {

    private final static List<Integer> number = new ArrayList<>();
    private synchronized static void inc(int numbers) {

            number.add(numbers);
    }

    private synchronized static void show() {

            System.out.println(number);
    }

    public static void main(String[] args) {

        Runnable inc = () ->{
            for(int i = 0; i < 100_00; i++) {

                number.add(i);
            }
        };

        Runnable dec = () ->{
            for(int i = 0; i < 100_00; i--) {

                number.add(i);
            }
        };

        Runnable show = () ->{
            for(int i = 0; i < 250_00; i++) {

                show();
            }
        };

        new Thread(inc).start();
        new Thread(dec).start();
        new Thread(show).start();
    }
}