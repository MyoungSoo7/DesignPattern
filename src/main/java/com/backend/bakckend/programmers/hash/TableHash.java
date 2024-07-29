package com.backend.bakckend.programmers.hash;

import java.util.Arrays;

public class TableHash {

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        // 1. 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col-1] == b[col-1]) {
                return a[0] - b[0];
            } else {
                return a[col-1] - b[col-1];
            }
        });

        // 2. S_i 계산 및 XOR 연산
        int hashValue = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int S_i = 0;
            for (int value : data[i]) {
                S_i += value % (i + 1);
            }
            hashValue ^= S_i;
        }

        return hashValue;

    }

    public static void main(String[] args) {
        TableHash tableHash = new TableHash();
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int result = tableHash.solution(data, col, row_begin, row_end);
        System.out.println(result);


    }
}
