package com.backend.bakckend.baekjoon.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 방문 횟수

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);

            if (a == 0) { // 아이를 만난 경우
                if (pq.isEmpty()) {
                    sb.append("-1\n"); // 줄 선물이 없으면 -1
                } else {
                    sb.append(pq.poll()).append("\n"); // 가장 큰 선물을 꺼내서 출력
                }
            } else { // 거점지에서 a개의 선물을 충전
                for (int j = 1; j <= a; j++) {
                    pq.add(Integer.parseInt(input[j])); // 선물을 힙에 추가
                }
            }
        }

        System.out.print(sb.toString());
    }
}
