package com.company;

import com.company.operations.*;
import com.company.outputs.OutputStrategy;
import com.company.parsers.ParserStrategy;
import com.company.utils.DataStorage;

import java.util.Map;
import java.util.Stack;

public class CalculatorContext {

    DataStorage dataStorage = new DataStorage();
    private final Map<String, ArithmeticOperator> operatorMap = dataStorage.getOperatorMap();

        private ParserStrategy parserStrategy;
        private OutputStrategy outputStrategy;

        public void setParserStrategy(ParserStrategy parserStrategy) {
            this.parserStrategy = parserStrategy;
        }

        public void setOutputStrategy(OutputStrategy outputStrategy) {
            this.outputStrategy = outputStrategy;
        }

        private String executeStrategy(String output){
           return parserStrategy.infixToPostFix(output);
        }

        public String executeOutput(String output) {
            return outputStrategy.output(evaluate(executeStrategy(output)));
        }

        private int evaluate(String output) {
            Stack<Integer> operands = new Stack<>();
            for (String token : output.split(" ")) {
                if (token.chars().allMatch(Character::isDigit)) {
                    operands.push(Integer.parseInt(token));
                } else {
                    int val1 = operands.pop();
                    int val2 = operands.pop();
                    operands.push(operatorMap.get(token).calc(val2, val1));
                }
            }


            return operands.pop();
        }

    }

