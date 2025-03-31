package com.exercicos;

import java.util.Locale;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scn = new Scanner(System.in);

        double nota = scn.nextDouble();

            if(nota < 5.0) {
                System.out.println("Reprovado");
            } else if(nota > 5.0 && nota <= 6.9) {
                System.out.println("Recuperacao");
            } else {
                System.out.println("Aprovado");
            }


        scn.close();
    }
}