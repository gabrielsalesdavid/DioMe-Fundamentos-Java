package com.fundamentosdejava;

public class OperadorBitwise {

    public static void main(String[] args) {

        int value01 = 6;
        String binary01 = Integer.toBinaryString(value01);
        System.out.printf("Primeiro numero da operação %d (representação binaria %s) \n", value01, binary01);

        int value02 = 5;
        String binary02 = Integer.toBinaryString(value02);
        System.out.printf("Segundo numero da operação %d (representação binaria %s) \n", value02, binary02);

        int result = value01 & value02;
        String binaryResult = Integer.toBinaryString(result);
        System.out.printf(" %d | %d = %d (representação binaria %s) \n", value01, value02, result, binaryResult);
    }
}