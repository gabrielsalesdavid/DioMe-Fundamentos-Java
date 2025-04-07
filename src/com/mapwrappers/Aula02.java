package com.mapwrappers;

public class Aula02 {

    public static void main(String[] args) {

        Users user = new Users("Jão", 20);
        printValue(user);
        System.out.println("'" + user + "'");
    }

    private static void printValue(Users user1) {

        user1.setName("Maria");
        user1.setAge(33);
        User user01 = new User("Maria", 33);
        System.out.println(user1);
    }
}