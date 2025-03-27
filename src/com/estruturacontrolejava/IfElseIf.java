package com.estruturacontrolejava;

import java.util.Scanner;

public class IfElseIf {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe seu nome:");
        String name = scn.next();
        System.out.println("Informe seu idade:");
        int age = scn.nextInt();

        System.out.println("Você é emancipado? (s/n)");
        var isEmancipated = scn.next().equalsIgnoreCase("s");

        if(age >= 18) {

            System.out.printf("%s, você tem %d anos e pode dirigir \n", name, age);
        } else if(age >= 16 && isEmancipated) {

            System.out.printf("%s, apesar de você ter %d anos, você é emancipada e pode dirigir \n", name, age);
        } else {

            System.out.printf("%s, você não pode dirigir \n", name);
        }

        System.out.println("Fim de execução!");

        scn.close();
    }
}