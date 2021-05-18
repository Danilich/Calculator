package com.company.operations;

import com.company.operations.ArithmeticOperator;

public class Adition implements ArithmeticOperator {

    @Override
    public Integer calc(int a, int b) {
        return a+b;
    }

    @Override
    public String toString() {
        return "+";
    }
}
