package com.backend.bakckend.javalecturesparta.calculator2;

public class BadInputException extends Exception{

    public BadInputException(String message){
        super("잘못된 입력입니다."+  message +"을 입력해주세요!");
    }

}
