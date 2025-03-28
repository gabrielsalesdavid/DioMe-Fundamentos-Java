package com.exercicos;

import java.util.Scanner;

public class Exercico02 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o numero para verificação");
        int number = scn.nextInt();

        while(true) {

            System.out.println("Informe o numero para verificação");
            int toVerify = scn.nextInt();

            if(toVerify < number) {

                System.out.printf("Informe um numero maior que %d", number);
                continue;
            }

            int result = toVerify % number;

            System.out.printf("%d %d %d = %d \n", toVerify, number, result);
            if(result != 0) break;
        }
    }
}