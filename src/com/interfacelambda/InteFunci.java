package com.interfacelambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class InteFunci {

    public static void main(String[] args) {

        List<User> usList = List.of(new User("Maria", 21),
                new User("Eduardo", 40),
                new User("Jão", 32),
                new User("Ana", 19));

        printStringValue(Record::toString, usList);
    }

    private static void printStringValue(Function<User, String> callback, List<User> us) {

        us.forEach(u -> System.out.println(callback.apply(u)));
    }
}