package com.backend.bakckend.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Grid {

    public int solution(int[][] grid) {
        int answer = 0;
        // Row *Column = table
        // 방문하는 칸에 적힌 숫자의 합 : path -sum
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                queue.add(grid[i][j]);
            }
        }
        System.out.println(queue);

        // 최솟값 19
        return answer;
    }
    public static void main(String[] args) {
        Grid solution = new Grid();
        int[][] grid = {{1, 2}, {3, 4}};
        int result = solution.solution(grid);
        System.out.println(result);

    }
}
