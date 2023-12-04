package com.backend.bakckend.javalecturesparta.calculator;

public class Calculator {
    private AbstractOperation operation;
    public Calculator(AbstractOperation operation){
        this.operation = operation;
    }
    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }

//    public void setFirstNumber(int a){
//        this.operation.setFirstNumber(a);
//    }

    public double calculate(int a, int b){

        return operation.operate(a,b);
    }
}
