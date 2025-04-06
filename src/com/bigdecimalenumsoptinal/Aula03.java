package com.bigdecimalenumsoptinal;

import com.bigdecimalenumsoptinal.Domain.User01;
import com.fundamentosdejava.Main;

import java.util.Optional;

import static com.bigdecimalenumsoptinal.Domain.SexEnum.FEMALE;
import static com.bigdecimalenumsoptinal.Domain.SexEnum.MALE;

public class Aula03 {

    public static void main(String[] args) {

        Optional<User01> optional = Optional.of(new User01("João", 18, MALE));
        //Optional<User01> optional = Optional.empty();

        optional.ifPresentOrElse(user -> {
            System.out.printf("Usuario: %s \n", user);
            user = new User01("João", 22, MALE);
            System.out.printf("Usuario: %s \n", user);
        }, () -> System.out.println("Sem usuario"));

        System.out.println(optional.orElse(new User01("Maria", 22, FEMALE)));
        System.out.println(optional.orElseThrow(() -> new RuntimeException("")));

        User02 newUser = optional.map(user -> new User02(user.name(), user.age(), user.sex())).orElseThrow();

        System.out.println(optional.orElse(defaultUser()));
        System.out.println(newUser);
    }

    public static User01 defaultUser() {

        System.out.println("Buscando o valor default");
        return new User01("Maria", 22, FEMALE);
    }
}