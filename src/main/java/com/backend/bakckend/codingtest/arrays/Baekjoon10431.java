package com.backend.bakckend.codingtest.arrays;

import java.util.Scanner;

public class Baekjoon10431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 P

        int P = sc.nextInt();
        System.out.println("P=>"+P);
        // 테스트 케이스반큼 반복
        while(P-- > 0){
            // 테스트 케이스 T 번호
            int T = sc.nextInt();
            System.out.println("T=>"+T);
            // 테스트케시스 T의 학생 생성
            int[] h = new int[7];
            for(int i=0; i<7; i++)
                h[i] = sc.nextInt();
            System.out.println("T=>"+T);
            int cnt =0;
            // 학생 줄세우기
            int[] sorted = new int[7];
            System.out.println("sorted=>"+sorted[6]);
            for(int i=0; i<7;i++){
                //1. 줄 서 있는 학생 중에 자신보다 큰 학생을 찾는다.
                boolean find =false;
                //1-1. 찾지 못햇다면, 줄의 가장 뒤에선다.
                for(int j=0; j<i; j++){
                    if(sorted[j]>h[i]){
                        find = true;
                        //2. 찾았다면, 그 학생의 앞에 선다.
                        //3. 그 학생과 그 뒤의 학생이 모두 한칸씩 물러난다.
                        for(int k =i-1 ; k>= j; k--){
                            sorted[k+1] = sorted[k];
                            cnt++;
                        }
                        sorted[j] = h[i];
                        break;
                    }
                }
                if(!find){
                    sorted[i] = h[i];
                }
            }
            System.out.println(T+" "+cnt);
            /*
7
1 6 2 3 7 5 1 4
            */
        }
    }
}
