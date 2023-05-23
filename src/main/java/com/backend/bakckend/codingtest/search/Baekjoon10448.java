package com.backend.bakckend.codingtest.search;

import java.util.Scanner;

public class Baekjoon10448 {

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess(){
        // 1. K보다 작은 삼각수를 모두 구한다.
        int[]triangleNumbers = new int[50];
        int triangleNumberCount =0;
        for(int i=1;  ; i++){
            // 삼각수 공식(가우스의 자연수)
            int triangleNumber = i * (i+1)/2;
            // 1000까지 계산
            if(triangleNumber >= 1000) break;
            // 삼각수를 모두 담는다.
            triangleNumbers[triangleNumberCount++] +=triangleNumber;
        }
        // 2. 구해진 삼각수 세개의 합으로 K를 나타낸 수 있느지 확인하다.
        boolean[] isSumOfTriangleNumber= new boolean[1001];
        for(int i =0; i<triangleNumberCount; i++)
            for(int j=0; j<triangleNumberCount; j++) {
                // 삼각수 두개를 더해서 1000보다 작은 수를 구한다.
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) isSumOfTriangleNumber[sum] = true;
            }

        for(int i=1; i<1000; i++) {
            // 1000보다 작은 수 중 삼각수 두개의 합으로 나타낼 수 있는 수를 구한다.
            if (!isSumOfTriangleNumber[i]) continue;
            for (int j = 0; j < triangleNumberCount; j++) {
                // 1000보다 작은 수 중 삼각수 두개의 합으로 나타낼 수 있는 수에
                // 삼각수 하나를 더해서 1000보다 작은 수를 구한다.
                int sum = i + triangleNumbers[j];
                // 1000보다 작은 수 중 삼각수 세개의 합으로 나타낼 수 있는 수를 구한다.
                if (sum <= 1000) isEurekaNumber[sum] = true;
            }
        }
    }


    public static void main(String[] args) {
        //1. 삼각수를 구한다.
        preprocess();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int K = sc.nextInt();
            System.out.println(isEurekaNumber[K] ? 1 : 0);
        }
    }
}
