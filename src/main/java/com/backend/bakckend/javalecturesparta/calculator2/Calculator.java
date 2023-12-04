package com.backend.bakckend.javalecturesparta.calculator2;

import com.backend.bakckend.javalecturesparta.calculator.AbstractOperation;

public class Calculator {

    private int firstNumber;
    private int secondNumber;

    private AbstractOperation operation;

    public Calculator(AbstractOperation operation){
        this.operation = operation;
    }

    public Calculator(){

    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }

    public void setFirstNumber(int firstNumber){
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber){
        this.secondNumber = secondNumber;
    }

    public double calculate(){
        return operation.operate(this.firstNumber, this.secondNumber);
    }



}
