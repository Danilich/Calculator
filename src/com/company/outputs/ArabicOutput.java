package com.company.outputs;

public class ArabicOutput implements OutputStrategy{
    @Override
    public String output(int exp) {
        return Integer.toString(exp);
    }
}
