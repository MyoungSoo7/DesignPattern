package com.backend.bakckend.programmers.dynamic;

public class Run {

    public int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // 점화식을 이용하여 방법의 수 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        // n칸에 도달하는 방법의 수 반환
        return dp[n];
    }

    public static void main(String[] args) {
        Run run = new Run();
        int result = run.solution(3);
        System.out.println(result);
    }
}
