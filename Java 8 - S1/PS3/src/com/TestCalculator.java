package com;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Lambda expressions for addition, subtraction, multiplication, and division
        IntegerMath addition = (a, b) -> {
            System.out.println("Addition is: " + (a + b));
            return a + b;
        };

        IntegerMath subtraction = (a, b) -> {
            System.out.println("Subtraction is: " + (a - b));
            return a - b;
        };

        IntegerMath multiplication = (a, b) -> {
            System.out.println("Multiplication is: " + (a * b));
            return a * b;
        };

        IntegerMath division = (a, b) -> {
            System.out.println("Division is: " + (a / b));
            return a / b;
        };

        // Perform operations
        calculator.operatingBinary(20, 10, addition);
        calculator.operatingBinary(20, 10, subtraction);
        calculator.operatingBinary(20, 10, multiplication);
        calculator.operatingBinary(20, 10, division);
    }
}
