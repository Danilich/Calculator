package com.company.parsers;

import com.company.utils.DataStorage;
import com.company.operations.*;

import java.util.Map;
import java.util.Stack;


//Алгоритм сортировочной станции,упрощенный до операции типа 2+2
public class ArabicParser implements  ParserStrategy{
    final String SPACE = " ";

    DataStorage dataStorage = new DataStorage();
    private final Map<String, ArithmeticOperator> operatorMap = dataStorage.getOperatorMap();

    @Override
    public String infixToPostFix(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<ArithmeticOperator> operatorStack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' &&tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                }
                output.append(sb.toString()).append(SPACE);

                i--;
            } else {

                while (!operatorStack.isEmpty()) {
                    output.append(operatorStack.pop());
                }

                ArithmeticOperator operator = operatorMap.get(Character.toString(tokens[i]));
                operatorStack.push(operator);
            }
        }

        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(SPACE);
        }

        return output.toString();
    }
}
