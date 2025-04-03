package com.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.function.Predicate;

public class Aula02 {

    public static void main(String[] args) {

        Set<User01> users = new HashSet<>();
        users.add(new User01(1, "Jão"));
        users.add(new User01(2, "Maria"));
        users.add(new User01(3, "Juca"));
        users.add(new User01(4, "Leo"));

        System.out.println(new User01(1, "Jão").hashCode());

        System.out.println(users.contains(new User01(1, "Jão")));

        users.forEach(System.out::println);

        Iterator iterator = users.iterator();

        while(iterator.hasNext()) {

            System.out.println(iterator.next());
        }

        users.removeAll(List.of(new User01(1, "Jão"), new User01(2, "Lucas")));
        System.out.println(users);

        users.removeIf(user -> user.getId() == 1);
        users.removeIf(Predicate.not(user -> user.getId() >= 1));
        System.out.println(users);
    }
}