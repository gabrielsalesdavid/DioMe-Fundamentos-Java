package com.herancapolimorfismo;

public class IntroducaoHerPol {

    public static void main(String[] args) {

        Manager mang = new Manager();

        mang.setName("João");
        mang.setLogin("joao");
        mang.setPassword("123456");

        System.out.println(mang.getName());
        System.out.println(mang.getLogin());
        System.out.println(mang.getPassword());
    }
}