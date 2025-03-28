package com.estruturacontrolejava;

import java.util.Scanner;

import static java.lang.String.format;

public class SwitchCase {

    public static void main(String[]args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe um numero de um(1) ate sets(7):");
        int option = scn.nextInt();

        String message = switch(option) {

            case 1, 7 -> {

                String day = option == 1 ? "Domingo" : "Sabado";
                yield String.format("Hoje e %s, fim de semana uhuull \\o/", day);
            }
            //case 1 -> System.out.println("Domingo");
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexta";
            //case 7 -> System.out.println("Sábado");
            default -> "Opção invalida";
        };

        scn.close();
    }
}