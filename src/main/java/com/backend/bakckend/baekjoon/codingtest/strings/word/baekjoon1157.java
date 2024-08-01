package com.backend.bakckend.baekjoon.codingtest.strings.word;

import java.util.Scanner;

public class baekjoon1157 {

    public static int getAlphabetCount(String str , char alp){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(alp == str.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        // 가장 많이 사용된 알파벳의 갯수
        int max = 0;
        // 가장 많이 사용된 알파벳의 갯수가 여러개인 경우
        char maxAlphabet = '?';
        for(char alp='A'; alp<='Z'; alp++){
            int count = getAlphabetCount(str,alp);
            if(count > max){
                max = count;
                maxAlphabet = alp;
            }else if(count == max){
                maxAlphabet = '?';
            }
        }
        System.out.println(maxAlphabet);
    }
}
