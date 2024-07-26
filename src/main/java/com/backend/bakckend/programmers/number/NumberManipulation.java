package com.backend.bakckend.programmers.number;


import java.util.Arrays;

public class NumberManipulation {

    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        String reverse = new StringBuilder(str).reverse().toString();
        for(int i=0; i<str.length(); i++){
            answer[i] = Integer.parseInt(String.valueOf(reverse.charAt(i)));
        }
        return answer;
    }

    public static void main(String[] args) {
        NumberManipulation numberManipulation = new NumberManipulation();
        Long nubmer = 12345L;
        int[] result = numberManipulation.solution(nubmer);
        System.out.println(Arrays.toString(result));

    }

}
