package com.backend.bakckend.exam;

import java.util.Arrays;

public class Solution2 {

    public int[] solution(int[][] scores) {
        // 총점, 응시자평균 낮은거, ID번호가 빠른 응시자
        int[] answer = new int[scores.length];
        int[] totalCount = new int[scores.length];

        for(int i=0; i<scores.length; i++){
            for(int j=0; j<2 ; j++){
                totalCount[i] = scores[i][j] + scores[i][j];
            }
        }
        System.out.println(Arrays.toString(totalCount));

        Arrays.sort(totalCount);
        System.out.println(Arrays.toString(totalCount));


        /*180
        134
        174
        174
        162
        178
        200
        188*/


        int lowAvg = 0;
        int id = 0;


        /*{85, 90},
        {65, 67},
        {88, 87},
        {88, 87},
        {73, 81},
        {65, 89},
        {99, 100},
        {80, 94}*/

        //   1번응시자의 순위부터 차례 배열

        return answer;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] scores = {{85, 90}, {65, 67}, {88, 87}, {88, 87}, {73, 81}, {65, 89}, {99, 100}, {80, 94}};  //[4, 8, 2, 3, 6, 7, 1, 5]
        int[] result = solution.solution(scores);
        //System.out.println(result);

    }
}
