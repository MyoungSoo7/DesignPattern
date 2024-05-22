package com.backend.bakckend.programmers.hash.stackqueue;


import java.util.*;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 작업이 완료되는 일수를 계산
        Queue<Integer> daysQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int days = (remainingWork + speeds[i] - 1) / speeds[i];
            daysQueue.offer(days);
        }

        // 배포 횟수를 계산
        List<Integer> deployments = new ArrayList<>();
        int currentDeploy = daysQueue.poll();
        int count = 1;

        while (!daysQueue.isEmpty()) {
            int day = daysQueue.poll();
            if (day <= currentDeploy) {
                count++;
            } else {
                deployments.add(count);
                currentDeploy = day;
                count = 1;
            }
        }

        // 마지막 배포 건수를 추가
        deployments.add(count);

        // List를 배열로 변환하여 반환
        int[] result = new int[deployments.size()];
        for (int i = 0; i < deployments.size(); i++) {
            result[i] = deployments.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        FunctionDevelopment sol = new FunctionDevelopment();
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        System.out.println(Arrays.toString(sol.solution(progresses1, speeds1))); // [2, 1]

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(sol.solution(progresses2, speeds2))); // [1, 3, 2]
    }
}


