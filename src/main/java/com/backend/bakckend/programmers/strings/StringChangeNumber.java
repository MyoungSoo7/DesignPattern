package com.backend.bakckend.programmers.strings;

public class StringChangeNumber {

    public int solution(String s) {
        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        StringChangeNumber stringChangeNumber = new StringChangeNumber();
        String s = "1234"; //1478
        int number = stringChangeNumber.solution(s);
        System.out.println(number);

    }

}
