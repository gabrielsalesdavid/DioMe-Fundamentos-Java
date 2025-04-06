package com.mapwrappers;

import java.util.HashMap;
import java.util.Map;

public class Aula01 {

    public static void main(String[] args) {

        Map<String, User> user = new HashMap<>();

        user.putAll(user);
        user.put("joao@joao.com", new User("Jão", 22));
        user.put("maria@maria.com", new User("Maria", 32));
        user.put("juca@juca.com", new User("Juca", 18));
        user.put("leo@leo.com", new User("Leo", 40));
        System.out.println(user);
        System.out.println();
        user.keySet().forEach(System.out::println);
        System.out.println();
        user.values().forEach(System.out::println);

        System.out.println();
        System.out.println(user.containsKey("marcos@marcos.com"));

        user.forEach((k, v) -> System.out.printf("Key: %s | value %s \n", k, v));

        System.out.println(user.containsValue(new User("Marcos", 40)));
        System.out.println(user.getOrDefault(" ", new User(" ", -1)));
        user.merge("", new User("", -1),(user1, user2) ->{

            System.out.println(user);
            System.out.println(user2);
            return user2;
        });

        System.out.println(user);

        user.putIfAbsent("", new User("", -1));
        System.out.println(user);
    }
}