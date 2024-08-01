package com.backend.bakckend.baekjoon.codingtest.arrays;

import java.util.Scanner;

public class Baekjoon3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 수 P
        int N= sc.nextInt();
        // 테스트  케이스 P 배열
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        // 번호
        int X = sc.nextInt();

        //
        boolean[] check = new boolean[1000001];
        for(int i=0; i<N; i++){
            check[arr[i]]=true;
        }

        int cnt =0;
        for(int i=0; i<= (X-1) /2; i++){
            if(i <= 1000000 && X-i <=100000   ){
                cnt += (check[i] && check[X-i]) ? 1: 0;
            }
        }
        System.out.println(cnt);

    }
}
