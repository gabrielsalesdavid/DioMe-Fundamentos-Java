package com.fundamentosdejava;

import java.util.Scanner;

public class OperadorAritmetico {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe um numero:");
        int value01 = scn.nextInt();

        System.out.println("Informe o segundo numero:");
        int value02 = scn.nextInt();

        System.out.printf("%d + %d = %d \n", value01, value02, value01 + value02);

        scn.close();
    }
}