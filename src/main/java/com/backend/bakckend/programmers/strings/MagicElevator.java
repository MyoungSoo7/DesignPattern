package com.backend.bakckend.programmers.strings;

import java.util.LinkedList;
import java.util.Queue;

public class MagicElevator {
    public static int solution(int storey) {
        // BFS를 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        // 시작점 (현재 층, 버튼 누름 횟수)
        queue.add(new int[]{storey, 0});

        // 방문한 층을 기록하기 위한 배열
        boolean[] visited = new boolean[storey + 1];
        visited[storey] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentFloor = current[0];
            int currentSteps = current[1];

            // 0층에 도달하면 버튼 누름 횟수 반환
            if (currentFloor == 0) {
                return currentSteps;
            }

            // 가능한 버튼 누름을 시도  // 100,000,000
            for (int move : new int[]{-1, 1, -10, 10, -100, 100, -1000, 1000, -10000, 10000, -100000, 100000, -1000000, 1000000
                    , -10000000, 10000000, -100000000, 100000000  }  ) {
                int nextFloor = currentFloor + move;

                // 다음 층이 0 이상이고 방문하지 않은 층일 경우
                if (nextFloor >= 0 && nextFloor <= storey && !visited[nextFloor]) {
                    visited[nextFloor] = true;
                    queue.add(new int[]{nextFloor, currentSteps + 1});
                }
            }
        }

        // 이론상 여기에 도달하지 않음
        return -1;
    }

    public static void main(String[] args) {
        int storey = 2554;
        System.out.println("최소 마법의 돌 개수: " + solution(storey));
    }
}

