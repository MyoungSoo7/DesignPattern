package com.backend.bakckend.baekjoon.codingtest.algorithm.ch03;

import java.util.Scanner;

public class P11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sNum = sc.next();
        System.out.println(sNum);
        char[] cNum = sNum.toCharArray();
        System.out.println(cNum);
        int sum =0;
        for(int i=0; i<cNum.length; i++){
            sum += cNum[i]-'0';
        }
        System.out.println(sum);

    }

}
