package com.backend.bakckend.leet;

import java.util.*;

public class BFSSearch {


    public static void main(String[] args) {
        System.out.println("BFS Search");
        Scanner sc = new Scanner(System.in);

        // 전체 사람의 수 n
        int n = sc.nextInt();
        // 촌수를 계산해야 하는 두 사람의 번호
        int person1 = sc.nextInt();
        int person2 = sc.nextInt();
        // 부모 자식간의 관계의 개수 m
        int m = sc.nextInt();

        // 인접 리스트를 사용하여 그래프 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 부모 자식 관계 입력
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        // BFS를 사용하여 촌수 계산
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(person1);
        distance[person1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // 결과 출력
        System.out.println(distance[person2]);
    }
}
