package com.herancapolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public non-sealed class Salesman extends Employee {

    private double percentPerSold;
}