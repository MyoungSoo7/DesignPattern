package com.backend.bakckend.programmers.number;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class OnlyOneNumber {

    public int[] solution(int []arr) {

        return IntStream.range(0,arr.length)
                .filter(i -> i == 0 || arr[i] != arr[i-1])
                .map(i -> arr[i])
                .toArray();
    }

    public static void main(String[] args) {
        OnlyOneNumber onlyOneNumber = new OnlyOneNumber();
        int[] result = onlyOneNumber.solution(new int[]{1,1,3,3,0,1,1});
        System.out.println(Arrays.toString(result));
    }
}
