package com.backend.bakckend.programmers.number;

import java.util.Arrays;

public class ArraySplit {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int idx =0;
        for(long i =left; i<=right; i++){
            System.out.println("i/n : " + i/n);
            System.out.println("i%n : " + i%n);
            answer[idx] = (int) Math.max(i/n, i%n) + 1;
            idx++;
        }
        return answer;
    }


    public static void main(String[] args) {
        ArraySplit arraySplit = new ArraySplit();
        int n = 3;
        long left = 2;
        long right = 5;
        int[] result = arraySplit.solution(n, left, right);
        System.out.println(Arrays.toString(result));
    }

}
