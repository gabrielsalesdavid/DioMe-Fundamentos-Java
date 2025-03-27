package com.fundamentosdejava;

import java.util.Scanner;

public class OperadorLogico {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Quantos anos você tem?");

        int age = scn.nextInt();

        System.out.println("Você é emancipado?");
        boolean isEmancipated = scn.nextBoolean();

        boolean canDrive = age >= 18 || isEmancipated && age >= 16;

        System.out.printf("Você pode dirigir? (%b) \n", canDrive);

        scn.close();
    }
}