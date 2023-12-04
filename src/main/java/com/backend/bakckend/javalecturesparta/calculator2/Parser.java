package com.backend.bakckend.javalecturesparta.calculator2;


import com.backend.bakckend.javalecturesparta.calculator.AddOperation;
import com.backend.bakckend.javalecturesparta.calculator.DivideOperation;
import com.backend.bakckend.javalecturesparta.calculator.MultiplyOperation;
import com.backend.bakckend.javalecturesparta.calculator.SubstractOperation;

import java.util.regex.Pattern;

public class Parser {

    private static final String OPERATION_REG ="[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";
    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws Exception{
        if(!Pattern.matches(NUMBER_REG, firstInput)){
            throw new BadInputException(firstInput);
        }
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }


    public Parser parseSecondNum(String secondInput) throws Exception{
        if(!Pattern.matches(NUMBER_REG, secondInput)){
            throw new BadInputException(secondInput);
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperation(String operationInput) throws Exception{
        if(!Pattern.matches(OPERATION_REG, operationInput)){
            throw new BadInputException("사칙연산의 연산자");
        }

        switch (operationInput){
            case "+":
                this.calculator.setOperation(new AddOperation());
                break;
            case "-":
                this.calculator.setOperation(new SubstractOperation());
                break;
            case "*":
                this.calculator.setOperation(new MultiplyOperation());
                break;
            case "/":
                this.calculator.setOperation(new DivideOperation());
                break;
        }

        return this;
    }

    public double executeCalculation(){
        return calculator.calculate();
    }
}
