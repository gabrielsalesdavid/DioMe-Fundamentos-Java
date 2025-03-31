package com.herancapolimorfismo;

public class ExploHerPol {

    public static void main(String[] args) {

        printEmployee(new Manager());
        printEmployee(new Salesman());
    }

    public static void printEmployee(Employee emp) {

        System.out.printf("========%s========\n", emp.getClass().getCanonicalName());

        switch(emp) {
            case Manager mang -> {
                mang.setCode("123");
                mang.setName("João");
                mang.setSalary(5000);
                mang.setLogin("joao");
                mang.setPassword("123456");
                mang.setCommission(1200);

                System.out.println(mang.getCode());
                System.out.println(mang.getSalary());
                System.out.println(mang.getName());
                System.out.println(mang.getLogin());
                System.out.println(mang.getPassword());
                System.out.println(mang.getCommission());
            }
            case Salesman sale -> {
                sale.setCode("456");
                sale.setName("Lucas");
                sale.setSalary(2800);
                sale.setPercentPerSold(10);
                sale.getSoldAmount(1000);

                System.out.println(sale.getCode());
                System.out.println(sale.getSalary());
                System.out.println(sale.getName());
                System.out.println(sale.getPercentPerSold());
            }
        }

        System.out.println("================");
    }
}