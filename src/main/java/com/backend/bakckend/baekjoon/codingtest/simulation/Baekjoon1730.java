package com.backend.bakckend.baekjoon.codingtest.simulation;


import java.util.Scanner;

// 판화
public class Baekjoon1730 {

    public static void main(String[] args) {
        // 문제: 로봇 팔의 명령 순서가 주어졌을 때, 목판 위에 패인 조각도의 흔적
        // 1. 팔을 명령 순서대로 움직인다.
        // 2. 누적된 흔적을 축력한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String command = sc.hasNext() ? sc.next() : "";

        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizontal = new boolean[N][N];
        int curR = 0, curC = 0;

        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            if (cmd == 'D') {
                if (curR == N - 1) continue;
                passVertical[curR][curC] = passVertical[curR + 1][curC] = true;
                curR++;
            } else if (cmd == 'U') {
                if (curR == 0) continue;
                passVertical[curR][curC] = passVertical[curR - 1][curC] = true;
                curR--;
            } else if (cmd == 'L') {
                if (curC == 0) continue;
                passHorizontal[curR][curC] = passHorizontal[curR][curC-1] = true;
                curC--;
            } else {
                if (curC == N - 1) continue;
                passHorizontal[curR][curC] = passHorizontal[curR][curC + 1] = true;
                curC++;
            }

        }
        for (int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if (passVertical[i][j] && passHorizontal[i][j]) ans += "+";
                else if (passVertical[i][j]) ans += "|";
                else if (passHorizontal[i][j]) ans += "-";
                else ans += ".";
            }
            System.out.println(ans);
        }

    }
}
