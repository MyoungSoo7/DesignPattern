package com.backend.bakckend.baekjoon.codingtest.strings.word;

import java.util.Scanner;

public class bj1919 {

    // 각 알파벳 26개 갯수를 각각의 배열에 담음
    public static int[] getAlphabetCount(String str){
        //  알파벳 26
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        return arr;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  a= sc.next();
        String  b= sc.next();

        // 입력한 알파벳 비교
        int[] arr1 = getAlphabetCount(a);
        int[] arr2 = getAlphabetCount(b);

        // 알파벳 개수 비교(같은 갯수 알파벳이면 0)
        int ans = 0;
        for(int i=0; i<26; i++)
            ans += Math.abs(arr1[i] - arr2[i]);
        System.out.println(ans);

    }

}
