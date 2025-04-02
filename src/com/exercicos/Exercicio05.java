package com.exercicos;

import com.interfacelambda.Circle;
import com.interfacelambda.GeometricForm;
import com.interfacelambda.Rectangle;
import com.interfacelambda.Square;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio05 {

    private final static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int option;
        GeometricForm geometricForm = null;

        while(true) {

            System.out.println("Escolha a forma geometrica para calcular a área");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retangulo");
            System.out.println("3 - Circulo");
            System.out.println("0 - Sair do programa");
            option = scn.nextInt();

            if(option == 1) {

                geometricForm = createSquares();
            } else if(option == 2) {

                geometricForm = createRectangle();
            } else if(option == 3) {

                geometricForm = createCircle();
                continue;
            } else {

                System.out.println("Opção invalida!");
            }

            System.out.println("O resultado do circulo da area foi de " + geometricForm.getArea());
        }
    }

    private static GeometricForm createSquares(){

        System.out.println("Informe o(s) tamanho(s) dos lado(s):");
        double side = scn.nextDouble();
        return new Square(side);
    }

    private static GeometricForm createRectangle(){

        System.out.println("Informe a(s) base(s):");
        double base = scn.nextDouble();
        System.out.println("Informe a(s) altura(s):");
        double height = scn.nextDouble();
        return new Rectangle(height, base);
    }

    private static GeometricForm createCircle(){

        System.out.println("Informe o(s) raio(s):");
        double radius = scn.nextDouble();
        return new Circle(radius);
    }
}