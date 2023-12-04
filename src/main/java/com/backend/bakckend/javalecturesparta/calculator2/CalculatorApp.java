package com.backend.bakckend.javalecturesparta.calculator2;

import java.util.Scanner;

public class CalculatorApp {


    public static boolean start() throws Exception{
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산기를 실행합니다.");
        System.out.println("첫번째 숫자를 입력해주세요.");
        String firstInput = scanner.nextLine();
        parser.parseFirstNum(firstInput);

        System.out.println("두번째 숫자를 입력해주세요.");
        String secondInput = scanner.nextLine();
        parser.parseSecondNum(secondInput);

        System.out.println("연산자를 입력해주세요.");
        String operationInput = scanner.nextLine();
        parser.parseOperation(operationInput);

        System.out.println("계산 결과는 " + parser.executeCalculation() + "입니다.");
        return true;
    }

}
