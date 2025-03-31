package com.herancapolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public non-sealed class Manager extends Employee {

    private String login;
    private String password;
    private double commission;

}