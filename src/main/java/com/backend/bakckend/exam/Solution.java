package com.backend.bakckend.exam;

import java.util.Arrays;

public class Solution {

    public int[][] solution(int[][] square, int k) {
        int[][] answer =square;
        // 기본 배열 갯수
        int squareUpLength = square.length *2;
        // 1번 확장 갯수
        int[][] scaleUp = new int[squareUpLength][squareUpLength];
        for(int i=0; i< squareUpLength; i++){
            for(int j=0; j< squareUpLength; j++){
                if(i < square.length && j < square.length){
                    scaleUp[i][j] = square[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(scaleUp))   ;

        // square 배열을 k 번확장한결과 배열 [square(1~10) , k(1~10)]
        //   [1, 0, 0, 0, 0, 1]
        // , [0, 1, 1, 1, 1, 0]
        // , [1, 0, 1, 1, 0, 1]
        // , [1, 0, 1, 1, 0, 1]
        // , [0, 1, 1, 1, 1, 0]
        // , [1, 0, 0, 0, 0, 1]

        return answer;
    }

    public static void main(String[] args) {

        int[][] square= {{1, 0, 0}
                       , {0, 1, 1}
                       , {1, 0, 1}};
        int k = 1;
        Solution solution = new Solution();
        int[][] result = solution.solution(square, k);
        System.out.println(Arrays.deepToString(result));
    }

}
