package com.backend.bakckend.programmers.hash.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubjecStackQueu {

    public String[] solution(String[][] plans) {
        String[] answer = {};
        // 과제를 끝낸 순서를 저장할 리스트
        List<String> completedTasks = new ArrayList<>();
        // 멈춘 과제를 저장할 스택
        Stack<String[]> pausedTasks = new Stack<>();
        // 현재 진행 중인 과제
        String[] currentTask = null;
        int currentTime = 0;

        // plans 배열을 시작 시간 기준으로 정렬
        Arrays.sort(plans, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

        for (String[] plan : plans) {
            String taskName = plan[0];
            int startTime = Integer.parseInt(plan[1]);
            int duration = Integer.parseInt(plan[2]);

            // 새로운 과제를 시작할 시각이 되었을 때
            while (currentTask != null && currentTime + Integer.parseInt(currentTask[2]) <= startTime) {
                // 현재 과제를 끝냄
                currentTime += Integer.parseInt(currentTask[2]);
                completedTasks.add(currentTask[0]);

                // 멈춘 과제가 있다면 이어서 진행
                if (!pausedTasks.isEmpty()) {
                    currentTask = pausedTasks.pop();
                } else {
                    //currentTask = "";
                }
            }

            // 현재 과제가 진행 중이라면 멈춤
            if (currentTask !=null) {
                currentTask[2] = String.valueOf(Integer.parseInt(currentTask[2]) - (startTime - currentTime));
                pausedTasks.push(currentTask);
            }

            // 새로운 과제를 시작
            currentTask = new String[]{taskName, String.valueOf(startTime), String.valueOf(duration)};
            currentTime = startTime;
        }

        // 남아 있는 과제를 모두 끝냄
        while (currentTask !=null) {
            currentTime += Integer.parseInt(currentTask[2]);
            completedTasks.add(currentTask[0]);

            if (!pausedTasks.isEmpty()) {
                currentTask = pausedTasks.pop();
            } else {
                currentTask =null;
            }
        }
        answer = completedTasks.toArray(new String[0]);
        // 결과를 배열로 변환하여 반환
        return answer;
    }

    public static void main(String[] args) {
        SubjecStackQueu subjecStackQueu = new SubjecStackQueu();
        // name 은 과제 이름, start는 시작 시각, playtime은 소요 시간
        // name은 2~10자리 알파벳 소문자 ,중복물가
        // start hh:mm 형식으로 00:00 ~ 23:59 사이의 시각 중 하나 (과제시간 중복없음)
        // playtime은 1~100 사이의 정수

        String[][] plans = {
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };   // ["korean", "english", "math"]
        String[] result = subjecStackQueu.solution(plans);

    }

}
