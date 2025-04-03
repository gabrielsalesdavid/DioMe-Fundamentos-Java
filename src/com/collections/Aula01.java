package com.collections;

import java.util.ArrayList;
import java.util.List;

public class Aula01 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        User user = new User(1, "João");
        users.add(user);
        users.add(new User(2, "Maria"));
        users.add(new User(3, "Leo"));
        System.out.println(users.contains(user));
        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.getFirst());
        System.out.println(users.get(0));
        System.out.println(users.getLast());
        System.out.println(users.size() - 1);
        System.out.println(users.contains(new User(6, "Carlos")));
        System.out.println(new User(4, "Roberto"));
        System.out.println(new User(5, "Izaac"));
        System.out.println(new User(1, "Jão").equals(new User(1, "Jão")));

        System.out.print(user);
        System.out.println(users.remove(new User(10, "Leo")));
        System.out.println(users.remove(0));
        users.clear();
        System.out.println(users);
    }
}