package com.exercicos;

import java.util.Scanner;

public class Exercico03 {

    private final static PetMachine petMachine = new PetMachine();

    private final static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int option = -1;

        do {

            System.out.println("===Escolha uma das opções===");
            System.out.println("1 - Dar banho no Pet");
            System.out.println("2 - Abastecer a maquina com agua");
            System.out.println("3 - Abastecer a maquina com shampoo");
            System.out.println("4 - Verificar agua da maquina");
            System.out.println("5 - Verificar shampoo da maquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet no maquina");
            System.out.println("8 - Retirar pet da maquina");
            System.out.println("9 - Limpar a maquina");
            System.out.println("0 - Sair");

            option = scn.nextInt();

            switch(option) {
                case 1 -> petMachine.takeShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> chekIfHasPetInMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção invalida");
            }
        } while(true);

    }

    private static void setWater() {

        System.out.println("Tentando colocar agua na maquina");
        petMachine.addWater();
    }

    private static void setShampoo() {

        System.out.println("Tentando colocar shampoo na maquina");
        petMachine.addShampoo();
    }

    private static void verifyWater() {

        int amount = petMachine.getShampoo();
        System.out.println("A maquina esta no maximo com " + amount + " litro(s) de water");
    }

    private static void verifyShampoo() {

        int amount = petMachine.getShampoo();
        System.out.println("A maquina esta no maximo com " + amount + " litro(s) de shampoo");
    }

    private static void chekIfHasPetInMachine() {

        boolean hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na maquina" : "Não tem pet na maquina");
    }

    public static void setPetInPetMachine() {

        String name = "";
        while(name == null || name.isEmpty()) {

            System.out.println("Informe o nome do pet");
            name = scn.nextLine();
        }

        Pet pe = new Pet(name);
        petMachine.setPet(pe);
    }
}