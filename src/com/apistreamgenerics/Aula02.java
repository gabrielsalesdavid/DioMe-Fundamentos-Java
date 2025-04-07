package com.apistreamgenerics;

import com.apistreamgenerics.Domain.Contact;
import com.apistreamgenerics.Domain.ContactType;
import com.apistreamgenerics.Domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.apistreamgenerics.Domain.ContactType.EMAIL;

public class Aula02 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>(generateUsers());

        var values = users.stream().filter(u -> u.contacts().size() >= 2).toList();
        users.sort(Comparator.comparing(User::age));
        users.forEach(System.out::println);
    }

    private static List<User> generateUsers() {

        var contact = List.of(new Contact("", ContactType.PHONE),
                new Contact("", EMAIL));

        return List.of();
    }
}