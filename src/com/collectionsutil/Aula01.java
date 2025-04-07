package com.collectionsutil;

import java.util.Arrays;
import java.util.Scanner;

public class Aula01 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe a operação que deseja ser realizado:");
        int operation = scn.nextInt();

        while(operation > 2 || operation < 1) {

            System.out.println("Escolha uma opção valida(1 - Sum, 2 - Subtraction)");
            operation = scn.nextInt();
        }

        Operation selected = Operation.values()[operation - 1];
        System.out.println("Informes os numeros que serão usados separados por virgula");
        String numbers = scn.next();
        long[] arrayNumber = Arrays.stream(numbers.split(",")).mapToLong(Long::parseLong).toArray();

        long result = selected.getOperationCallback().exec(arrayNumber);
        System.out.printf("O resultado da operação é %d \n", result);
    }
}