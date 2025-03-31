package com.classesencapsulamento;

public class Aula01 {

    public static void main(String[] args) {

        Person male = new Person();

        male.setName("João");
        male.setAge(12);

        Person female = new Person();

        female.setName("Maria");
        female.setAge(10);

        System.out.println("Male name: " + male.getName() + " age: " + male.getAge());
        System.out.println("female name: " + female.getName() + " age: " + female.getAge());
    }
}