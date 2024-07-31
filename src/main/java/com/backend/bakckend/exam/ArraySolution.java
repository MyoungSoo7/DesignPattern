package com.backend.bakckend.exam;

import java.util.Arrays;

public class ArraySolution {

    public int[] solution(int[][] arrs) {
        int[] basic = {1,2,3,4,5,6};
        int[] answer = {};
        int cnt =  arrs.length;

        int sameCount =0;
        for(int i=0; i<cnt ; i++){
            if(basic[i] == arrs[0][i]){
                sameCount++;
            }
        }
        if(sameCount == 6){
            answer[0] = 0;
        }
        System.out.println(sameCount);
        System.out.println(Arrays.toString(answer));

        // 6 인 배열 3개씩 두개로 나눔
        // 순서 유지하고 몇번 섞어야 arrs 에 담긴 배열과 같은 상태
        // arrs ( 5~10, 각 행은 6, 원소 1~6 중복x)
        return answer;
    }
    public static void main(String[] args) {
        ArraySolution arraySolution = new ArraySolution();
        int [][] arrs = {{1, 2, 3, 4, 5, 6}, {3, 4, 2, 6, 5, 1}, {4, 5, 6, 1, 2, 3}, {4, 1, 5, 2, 3, 6}, {5, 3, 1, 4, 2, 6}, {6, 2, 3, 4, 5, 1}};
        int[] result = arraySolution.solution(arrs); //[0, 3, 1, 1, 2, 2]

    }
}
