package com.exercicos;

import java.util.Scanner;

public class Teste01 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int sum = 0;
        int count = scn.nextInt();
        while(!(count < 0)) {

            sum += count;
            count = scn.nextInt();
        }

        System.out.println(sum);
    }
}