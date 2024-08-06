package com.backend.bakckend.programmers.strings;

import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[operations.length]; // 연산의 결과를 저장할 배열

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소값을 빼는 큐
        for(String operation : operations){

        }

        if(pq.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{pq.poll(), pq.poll()};

    }

    public static void main(String[] args) {
        DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
        int[] result = doublePriorityQueue.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        System.out.println(result);

    }


}
