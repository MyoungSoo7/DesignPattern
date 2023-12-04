package com.backend.bakckend.javalecturesparta.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new AddOperation());
        System.out.println(calculator.calculate(1, 2));
        calculator.setOperation(new SubstractOperation());
        System.out.println(calculator.calculate(2, 2));
        calculator.setOperation(new MultiplyOperation());
        System.out.println(calculator.calculate(2, 2));
        calculator.setOperation(new DivideOperation());
        System.out.println(calculator.calculate(2, 2));
    }
}
