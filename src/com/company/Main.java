package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       SimpleCalculator calculator = new SimpleCalculator();
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите выражение:");
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String result = calculator.calculate(string);
            System.out.println(result);
        }
        scanner.close();
        }

}
