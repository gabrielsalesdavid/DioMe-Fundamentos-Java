package com.estruturacontrolejava;

import java.util.Scanner;

public class EstruturaRepeticao {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        for(int i = 1;i < 100; i++) {

            if (i == 100) break;

            System.out.println(i);
        }

        scn.close();
    }
}