package test;

import com.company.SimpleCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private SimpleCalculator calculator;
    private Exception exception;

    @BeforeEach
    public void setUp() {
        calculator = new SimpleCalculator();
    }

    @Test
    public void testOperationsWithDecimals() {
        assertEquals("90", calculator.calculate("9*10"),
                "Should work");

        assertEquals("10", calculator.calculate("3+7"),
                "Should work");

        assertEquals("5", calculator.calculate("10/2"),
                "Should work");
        assertEquals("-1", calculator.calculate("1-2"),
                "Should work");
        assertEquals("0", calculator.calculate("5-5"),
                "Should work");
    }

    @Test
    public void testDivisionByZeroInt() {
         exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.calculate("10/0"));

        assertEquals(exception.getMessage(),"Неправильный формат");
    }

    @Test
    public void testMultiplyByOutOfRangeInt() {
         exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.calculate("2*11"));
        assertEquals(exception.getMessage(),"Неправильный формат");
    }

    @Test
    public void testDifferrentTypesOfNumbers() {
         exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.calculate("X*7"));
        assertEquals(exception.getMessage(),"Неправильный формат");
    }


    @Test
    public void testOperationsWithRoman() {
        assertEquals("XC", calculator.calculate("X*IX"),
                "Should work");
        assertEquals("C", calculator.calculate("X*X"),
                "Should work");

        assertEquals("X", calculator.calculate("III+VII"),
                "Should work");

        assertEquals("II", calculator.calculate("VI / III"),
                "Should work");
        assertEquals("XLV", calculator.calculate("V * IX"),
                "Should work");

    }

    @Test
    public void testNegativeResultRoman() {
         exception = assertThrows(ArithmeticException.class, () ->
            calculator.calculate("I-X"));
        assertEquals(exception.getMessage(),"Значение не существует");
    }

    @Test
    public void testZeroResultRoman() {
        exception = assertThrows(ArithmeticException.class, () ->
            calculator.calculate("X-X"));
        assertEquals(exception.getMessage(),"Значение не существует");
    }

    @Test
    public void testMultiplyByOutOfRangeRoman() {
         exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.calculate("V*XI"));
        assertEquals(exception.getMessage(), "Число больше 10!");
    }
}
