package com.backend.bakckend.javalecturesparta.calculator2;

public class Main {

    public static void main(String[] args) {
        boolean calculatorOn = false;

        while(!calculatorOn){
            try{
                calculatorOn =  CalculatorApp.start();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
