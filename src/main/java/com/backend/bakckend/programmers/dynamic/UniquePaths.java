package com.backend.bakckend.programmers.dynamic;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 첫 번째 행은 모두 1로 초기화
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 첫 번째 열도 모두 1로 초기화
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 나머지 셀을 채우기
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String args) {
        UniquePaths solution = new UniquePaths();
        int m = 3; // 예시 입력
        int n = 7; // 예시 입력
        System.out.println("고유 경로의 수: " + solution.uniquePaths(m, n));
    }
}
