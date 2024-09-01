package com.backend.bakckend.programmers.dynamic;

public class RoomVisit {

    public int firstDayAllRoomsVisited(int[] nextVisit) {
        int n = nextVisit.length;
        long[] f = new long[n];
        final int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; ++i) {
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + mod) % mod;
        }
        return (int) f[n - 1];
    }

    public static void main(String[]args) {
        RoomVisit solution = new RoomVisit();

        // 예제 1
        int[] nextVisit1 = {0, 0};
        System.out.println("Example 1 Output: " + solution.firstDayAllRoomsVisited(nextVisit1)); // 출력: 2

        // 예제 2
        int[] nextVisit2 = {0, 0, 2};
        System.out.println("Example 2 Output: " + solution.firstDayAllRoomsVisited(nextVisit2)); // 출력: 6

        // 예제 3
        int[] nextVisit3 = {0, 1, 2, 0};
        System.out.println("Example 3 Output: " + solution.firstDayAllRoomsVisited(nextVisit3)); // 출력: 6
    }
}
