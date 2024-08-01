package com.backend.bakckend.baekjoon.codingtest.search;

import java.util.Scanner;

public class Baekjoon3085 {

    // 캔디 바꾸기
    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }


    // 가장 긴 연속 열 (가로)
    public static int findMaxRow(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (int r = 0; r < N; r++) {
            int len = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) len++;
                else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }


    // 가장 긴 연속 행 (세로)
    public static int findMaxColumn(char[][] map) {
        int N = map.length;
        int maxColumn = 0;
        for (int c= 0; c < N; c++) {
            int len = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) len++;
                else {
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }

    public static void main(String[] args) {
        // 색이 다른 사탕이 인접한 두칸을 골라 사탕을 서로 교환할 때,
        // 같은 색으로 이루어진 가장 긴 연속 부분 행/열의 최댓값

        //  1. 가능한 모든 쌍의 사탕을 서로 교환한다.
        //  2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
        //  3. 교환한 사탕을 원복한다.
        // * 교환이 가능한 쌍이 무조건 하나는 있을까?
        // * 교환하지 않은 상태의 답이 더 클 수 있을까?
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][]map = new char[N][N];
        for(int i=0; i<N; i++){
            map[i] = sc.next().toCharArray();
        }
        int ans=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i, j + 1);
                }
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i + 1, j);
                }

            }
        }
        System.out.println(ans);
    }
}
