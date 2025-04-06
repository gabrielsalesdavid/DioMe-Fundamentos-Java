package com.bigdecimalenumsoptinal;

import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public enum OperationEnum {

    SUM(Integer::sum, "+"),
    SUBTRACTION((Integer v01, Integer v02) -> v01 - v02, "-"),
    MULTIPLY((Integer v01, Integer v02) -> v01 * v02, "*"),
    DIVISION((Integer v01, Integer v02) -> v01 / v02, "/");

    private final BiFunction<Integer, Integer, Integer> calculator;

    private final String symbol;

    OperationEnum(BiFunction<Integer, Integer, Integer> calculator, String symbol) {

        this.calculator = calculator;
        this.symbol = symbol;
    }
}