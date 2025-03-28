package com.estruturacontrolejava;

import java.util.Scanner;

public class SwitchCase {

    public static void main(String[]args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe um numero de um(1) ate sets(7):");
        int option = scn.nextInt();

        switch(option) {
            case 1:

                System.out.println("Domingo");
                break;

            case 2:

                System.out.println("Segunda");
                break;

            case 3:

                System.out.println("Terça");
                break;

            case 4:

                System.out.println("Quarta");
                break;

            case 5:

                System.out.println("Quinta");
                break;

            case 6:

                System.out.println("Sexta");
                break;

            case 7:

                System.out.println("Sábado");
                break;

            default:
                System.out.println("Opção invalida");
        }

        scn.close();
    }
}