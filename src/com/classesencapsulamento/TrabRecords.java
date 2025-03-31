package com.classesencapsulamento;

public class TrabRecords {

    public static void mian(String[] args) {

        Person01 pes = new Person01("João", 12);
        System.out.println(pes);
        System.out.println(pes.name());

        Person newPes = new Person(pes.name(), 13);
    }
}