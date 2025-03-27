package com.fundamentosdejava;

import java.time.OffsetDateTime;
import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[]args) {

        Scanner scn = new Scanner(System.in);

        int baseYear = OffsetDateTime.now().getYear();

        System.out.println("Digite o seu nome:");
        String name = scn.next();
        System.out.println("Digite o ano de nascimento:");
        int year = scn.nextInt();

        int age = baseYear - year;

        System.out.printf("Olá %s você tem %d anos \n", name, age);

        scn.close();
    }
}