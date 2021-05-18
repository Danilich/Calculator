package com.company;

import com.company.outputs.ArabicOutput;
import com.company.outputs.RomanOutput;
import com.company.parsers.ArabicParser;
import com.company.parsers.RomanParser;
import com.company.utils.Validator;


public class SimpleCalculator {

    String calculate(String exps){
        String result="";
        CalculatorContext calcContext = new CalculatorContext();

       if(Validator.isDigits(exps)){
           calcContext.setParserStrategy(new ArabicParser());
           calcContext.setOutputStrategy(new ArabicOutput());
            result = calcContext.executeOutput(exps);
        }else if(Validator.isRoman(exps)){
           calcContext.setParserStrategy(new RomanParser());
           calcContext.setOutputStrategy(new RomanOutput());
            result  = calcContext.executeOutput(exps);
        }  else {
            throw new IllegalArgumentException("Неправильный формат");
        }

        return result;
    }









}










