package com.backend.bakckend.programmers.dynamic;

public class Fibonacci {

    public int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int mod = 1234567;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % mod;
        }

        return fib[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.solution(3);
        System.out.println(result);

    }

}
