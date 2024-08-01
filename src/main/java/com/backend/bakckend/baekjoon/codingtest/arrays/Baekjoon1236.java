package com.backend.bakckend.baekjoon.codingtest.arrays;

import java.util.Scanner;

public class Baekjoon1236 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt(); // 세로
        int M= sc.nextInt(); // 가로

        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i]= sc.next().toCharArray();
        }

        boolean[] existRow = new boolean[N];
        boolean[] existCol = new boolean[M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='X'){
                    existRow[i]=true;
                    existCol[j]=true;
                }
            }
        }

        int needRowCount= N;
        int needColCount= M;
        for(int i=0; i<N; i++){
            if(existRow[i]) needRowCount--;
        }
        for(int i=0; i<M; i++){
            if(existCol[i]) needColCount--;
        }

        System.out.println(Math.max(needRowCount, needColCount));

     /*   Scanner sc = new Scanner(System.in);
        int N= sc.nextInt(); // 세로
        int M= sc.nextInt(); // 가로
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i]= sc.next().toCharArray();
        }

        //1. 각 행/열에 대해 경비원이 있는지 확인한다.
        boolean[] existRow = new boolean[N];
        boolean[] existCol = new boolean[M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='X'){
                    existRow[i]=true;
                    existCol[j]=true;
                }
            }
        }

        //2. 보호받지 못하는 행/열의 갯수를 구한다.
        int needRowCount= N;
        int needColCount= M;
        for(int i=0; i<N; i++){
            if(existRow[i]) needRowCount--;
        }
        for(int i=0; i<M; i++){
            if(existCol[i]) needColCount--;
        }

        //3. 둘 중 큰 값을 출력한다.
        System.out.println(Math.max(needRowCount, needColCount));*/

    }

}
