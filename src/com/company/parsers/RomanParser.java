package com.company.parsers;

import com.company.utils.DataStorage;
import com.company.operations.*;

import java.util.*;

public class RomanParser implements ParserStrategy {
    final String SPACE = " ";
    DataStorage dataStorage = new DataStorage();
    private final Map<String, ArithmeticOperator> operatorMap = dataStorage.getOperatorMap();

    @Override
    public String infixToPostFix(String expression) {
        char[] tokens = expression.toCharArray();
        StringBuilder output = new StringBuilder();
        Stack<ArithmeticOperator> operatorStack = new Stack<>();

        final Map<Character,
                Integer> romanTable = new HashMap<Character,
                Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
        }};


        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (romanTable.containsKey(tokens[i]) ) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && romanTable.containsKey(tokens[i] )) {
                    sb.append(tokens[i++]);
                }
                for (String token : sb.toString().split(SPACE)) {
                    output.append(romanToInt(token,romanTable)).append(SPACE);
                }
                i--;
            }
            else {
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

    public static int romanToInt(String s,Map<Character,
            Integer> roman) {
        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            StringBuilder sb = new StringBuilder();
            if (i < n-1 && roman.get(s.charAt(i)) <
                    roman.get(s.charAt(i + 1))) {

                sum += roman.get(s.charAt(i + 1)) -
                        roman.get(s.charAt(i));
                sb.append(sum);

                i++;
            } else {
                sum += roman.get(s.charAt(i));
            }
        }

        return sum;
    }
}
