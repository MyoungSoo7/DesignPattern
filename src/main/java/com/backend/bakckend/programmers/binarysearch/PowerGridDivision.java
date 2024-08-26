package com.backend.bakckend.programmers.binarysearch;

import java.util.*;

public class PowerGridDivision {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<List<Integer>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 생성
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // 각 간선을 제거하고 두 서브트리의 노드 개수 차이를 계산
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 간선 제거
            graph.get(v1).remove((Integer) v2);
            graph.get(v2).remove((Integer) v1);

            // BFS 또는 DFS를 사용하여 서브트리의 노드 개수 계산
            int subtreeSize = bfs(graph, n, v1);
            int difference = Math.abs((n - subtreeSize) - subtreeSize);
            answer = Math.min(answer, difference);

            // 간선 복구
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return answer;
    }

    private int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PowerGridDivision solution = new PowerGridDivision();
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution.solution(n, wires)); // 결과: 3
    }
}

