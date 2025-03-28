package com.estruturacontrolejava;

import java.util.Scanner;

public class SwitchCase {

    public static void main(String[]args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe um numero de um(1) ate sets(7):");
        int option = scn.nextInt();

        switch(option) {
            case 1 -> System.out.println("Domingo");
            case 2 -> System.out.println("Segunda");
            case 3 -> System.out.println("Terça");
            case 4 -> System.out.println("Quarta");
            case 5 -> System.out.println("Quinta");
            case 6 -> System.out.println("Sexta");
            case 7 -> System.out.println("Sábado");
            default -> System.out.println("Opção invalida");
        }

        scn.close();
    }
}