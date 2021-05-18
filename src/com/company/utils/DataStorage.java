package com.company.utils;

import com.company.operations.*;

import java.util.Map;

public class DataStorage {
    private final Map<String, ArithmeticOperator> operatorMap = Map.of(
            "/", new Division(),
            "*", new Multiplication(),
            "+", new Adition(),
            "-", new Subract()
    );

    public Map<String, ArithmeticOperator> getOperatorMap() {
        return operatorMap;
    }
}
