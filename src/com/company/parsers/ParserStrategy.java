package com.company.parsers;


//Паттерн:Cтратегия
public interface ParserStrategy {
   String infixToPostFix(String expression);
}
