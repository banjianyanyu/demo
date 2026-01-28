package com.bjyy.ch14_springboot_developingtips.demo01ifswitchreconstruction.operation;

import java.util.function.BiFunction;

public enum Operation {
    ADD((a, b) -> a + b),
    SUB((a, b) -> a - b),
    MUL((a, b) -> a * b),
    DIV((a, b) -> a / b);

    private final BiFunction<Integer, Integer, Integer> function;

    Operation(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    public int apply(int a, int b) {
        return function.apply(a, b);
    }
}