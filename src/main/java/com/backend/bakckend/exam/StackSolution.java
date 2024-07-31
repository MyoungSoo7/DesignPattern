package com.backend.bakckend.exam;

import java.util.Stack;

public class StackSolution {

    public long[] solution(int[][] acts) {
        long[] answer = {};
        // 페이지 이동(curreent idx++ -> idx 앞 stack empty)    => 0
        // 뒤  (current 앞으로가기 스택, 뒤로가기 스택 - 가장 최근에 저장된 페이지)  => -1
        // 앞 ( current 뒤로가기 스택, 앞으로 가기 스택 - 가자 최근에 저장된 페이지) => 1
        int function = 0; // 0, 1, -1
        int current = 0;
        int back = 0;
        int idx =0;
        Stack<Integer> forawrd = new Stack<>();
        Stack<Integer> backward = new Stack<>();
        return answer;
    }
    public static void main(String[] args) {
        StackSolution stackSolution = new StackSolution();
        int[][] acts = {{0, 2}, {-1, 1}, {0, 1}, {1, 1}, {-1, 2}, {1, 1}};  //[2, 1, 3, 3, 0, 1]
        long[] result = stackSolution.solution(acts);
        System.out.println(result);

    }
}
