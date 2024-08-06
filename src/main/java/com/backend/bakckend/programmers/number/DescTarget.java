package com.backend.bakckend.programmers.number;

import java.util.Arrays;

public class DescTarget {

    public long solution(long n) {
        String str = Long.toString(n);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr)).reverse();
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {

        DescTarget descTarget = new DescTarget();
        long n = 118372;
        System.out.println(descTarget.solution(n));

    }
}
