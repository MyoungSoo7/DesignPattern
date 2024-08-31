package com.backend.bakckend.programmers.dynamic;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 시작점이 장애물인 경우, 경로는 0개
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 시작점 초기화
        obstacleGrid[0][0] = 1;

        // 첫 번째 열 초기화
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        }

        // 첫 번째 행 초기화
        for (int j = 1; j < n; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1) ? 1 : 0;
        }

        // 나머지 격자 채우기
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[m-1][n-1];
    }

    public static void main(String args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("고유한 경로의 수: " + solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
