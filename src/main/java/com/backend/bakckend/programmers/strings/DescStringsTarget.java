package com.backend.bakckend.programmers.strings;

import java.util.Arrays;
import java.util.Collections;

public class DescStringsTarget {

    public String solution(String s) {

        Character[] arr = new Character[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder(arr.length);
        for(char c : arr){
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DescStringsTarget descStringsTarget = new DescStringsTarget();
        String s = "Zbcdefg";
        System.out.println(descStringsTarget.solution(s));
    }
}
