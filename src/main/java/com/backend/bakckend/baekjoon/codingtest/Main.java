package com.backend.bakckend.baekjoon.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
/*
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
    }*/

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // 입력 받기
            int N = sc.nextInt(); // 손님의 수
            int M = sc.nextInt(); // 초밥의 수

            long startTime = System.nanoTime();

            // 손님의 선호 초밥 정보 저장
            List<Set<Integer>> preferences = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int k = sc.nextInt(); // 각 손님의 초밥 선호 개수
                Set<Integer> prefSet = new HashSet<>();
                for (int j = 0; j < k; j++) {
                    prefSet.add(sc.nextInt());
                }
                preferences.add(prefSet);
            }

            // 요리사가 만든 초밥 순서
            int[] sushis = new int[M];
            for (int i = 0; i < M; i++) {
                sushis[i] = sc.nextInt();
            }

            // 결과를 저장할 배열
            int[] result = new int[N];
            List<Set<Integer>> eaten = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                eaten.add(new HashSet<>()); // 각 손님이 이미 먹은 초밥을 기록
            }

            // 초밥 처리
            for (int sushi : sushis) {
                for (int i = 0; i < N; i++) {
                    if (preferences.get(i).contains(sushi) && !eaten.get(i).contains(sushi)) {
                        eaten.get(i).add(sushi); // 초밥을 먹었다고 표시
                        result[i]++;            // 먹은 초밥 개수 증가
                        break;                  // 해당 초밥은 다음 손님에게 전달되지 않음
                    }
                }
            }

            // 결과 출력
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }


            long endTime = System.nanoTime();

            System.out.println();
            System.out.println("Execution Time : + "+ (endTime - startTime) / 1_000_000.0 + " ms nano seconds");




        }


}
