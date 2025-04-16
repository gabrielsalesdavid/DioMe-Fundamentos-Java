package com.exercicos;

import java.util.Scanner;

public class Teste02 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        if (n <= 0) {
            return;
        } else if (n == 1) {
            System.out.print("0 ");
            return;
        }

        int a = 0;
        int b = 1;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            int proximo = a + b;
            System.out.print(proximo + " ");
            a = b;
            b = proximo;
        }
        System.out.println();
    }
}