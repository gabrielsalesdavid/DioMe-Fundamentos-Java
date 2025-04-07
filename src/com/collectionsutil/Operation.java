package com.collectionsutil;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.LongStream;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Operation {

    SUM(n -> LongStream.of(n).reduce(0, Long::sum)),
    SUBTRACTION(n -> LongStream.of(n).reduce(0, (n01, n02) -> n01 - n02));

    private Calc operationCallback;
}