package com.company.operations;

import com.company.operations.ArithmeticOperator;

public class Division implements ArithmeticOperator {
    @Override
    public Integer calc(int a, int b) {
        if (b == 0d) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a/b;
    }

    @Override
    public String toString() {
        return "/";
    }
}
