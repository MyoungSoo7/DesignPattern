package com.backend.bakckend.programmers.hash.array;

import java.util.Arrays;
import java.util.Stack;

public class BigNumber {

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int n= numbers.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< n-1; i++){
            stack.push(i);
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i+1]){
                answer[stack.pop()] = numbers[i+1];
            }
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        answer[n-1] = -1;
        return answer;

    }

    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2}; //[3, 5, 5, -1]
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

}
