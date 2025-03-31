package com.herancapolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public sealed abstract class Employee permits Manager, Salesman {

    private String code;
    private String name;
    private String address;
    private int age;
    private double salary;
}