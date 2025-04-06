package com.bigdecimalenumsoptinal;

import jdk.dynalink.Operation;

import java.util.Scanner;

public class Aula02 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int option = -1;
        while(option != 5) {

            System.out.println("Escolha uma opção");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Sair");
            option = scn.nextInt();

            if(option >= 5 || option < 1) {

                System.out.println("Selecione uma opção valida");
                continue;
            }

            if(option == 5) {

                break;
            }

            OperationEnum selectedOption = OperationEnum.values()[option - 1];

            System.out.println("Informe o primeiro valor");
            int value01 = scn.nextInt();
            System.out.println("Informe o segundo valor");
            int value02 = scn.nextInt();

            int result = selectedOption.getCalculator().apply(value01, value02);

            System.out.printf("%d %d %d = %d \n \n", value01, selectedOption.getSymbol(), value02, result);
        }
    }
}