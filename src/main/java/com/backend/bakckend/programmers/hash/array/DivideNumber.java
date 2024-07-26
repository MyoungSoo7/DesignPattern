package com.backend.bakckend.programmers.hash.array;

import java.util.Arrays;

public class DivideNumber {

   /* public static boolean checkDivisibility(int gcdValue, int[] array){
        for(int num : array){
            if(num % gcdValue != 0){
                return false;
            }
        }
        return true;
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // 배열의 최대공약수
        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);

        System.out.println("gcdA: " + gcdA);
        System.out.println("gcdB: " + gcdB);

        // 최대공약수가 다른 배열의 모든 원소를 나누지 않는지 확인
        int resultA = checkDivisibility(gcdA, arrayB) ? 0 : gcdA;
        int resultB = checkDivisibility(gcdB, arrayA) ? 0 : gcdB;
        System.out.println("resultA: " + resultA);  //0 -> 1은 못나눔?
        System.out.println("resultB: " + resultB);  //1 -> 5는 나눔

        answer = Math.max(resultA, resultB);

        return answer;
    }

    public static void main(String[] args) {
        int[] arrayA ={10, 17}; // 10 20
        int[] arrayB ={5,20};  // 5 17

        int result = solution(arrayA, arrayB);
        System.out.println(result);

    }*/

}
