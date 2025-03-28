package com.estruturacontrolejava;

import java.util.Scanner;

public class WhileDoWhile {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String name = "exit";

        do {

            System.out.println("Informe um nome");
            name = scn.next();

            System.out.println(name);

        } while(!name.equalsIgnoreCase("exit"));

        scn.close();
    }
}