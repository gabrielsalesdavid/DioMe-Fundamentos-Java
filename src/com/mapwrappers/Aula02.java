package com.mapwrappers;

public class Aula02 {

    public static void main(String[] args) {

        User user = new User("Jão", 20);
        printValue(user);
        System.out.println("'" + user + "'");
    }

    private static void printValue(final User user) {

        user.setName("Maria");
        user.setAge(33);
        user = new User("Maria", 33);
        System.out.println(user);
    }
}