package com.collectionsutil;

@FunctionalInterface
public interface Calc {

    long exec(long... numbers);
}