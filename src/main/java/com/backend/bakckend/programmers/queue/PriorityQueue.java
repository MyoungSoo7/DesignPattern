package com.backend.bakckend.programmers.queue;

public class PriorityQueue {
    public int[] solution(String[] operations) {
        System.out.println(operations);
        int[] answer = new int[operations.length];
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // [0, 0]
        int[] result = priorityQueue.solution(operations);
        System.out.println(result);
    }

}
