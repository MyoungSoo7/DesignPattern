package com.backend.bakckend.baekjoon.codingtest.simulation;


import java.util.Scanner;

// ACM호텔
public class Baekjoon10250 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        // 한번에 계산해보자
        // 한방씩 배치하지 않아도 10명마다 엘리베이터와 한칸씩 멀어진다.
        int T= sc.nextInt();
        // N번째 손님의 호수 :  H로 나눈 몫
        // N번째 손님의 층수 H로나눈 나머지
        // 시간복잡도 0(1)

        while(T-- > 0){
            int H=sc.nextInt();
            int N=sc.nextInt();
            int W=sc.nextInt();
            int distance = (N-1)/ H+1 ; // 엘리베이터와의 거리
            int floor =(N-1)%H +1 ;   // 배정받을 방의 층수
            System.out.printf("%d%02d\n", floor, distance);

        }

    }
}
