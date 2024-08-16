package com.backend.bakckend.programmers.simulation;

import java.util.HashMap;
import java.util.Map;

public class Race {
    public static String[] solution(String[] players, String[] callings) {
        // 선수들의 현재 순위를 저장할 맵
        Map<String, Integer> playerPositions = new HashMap<>();

        // 초기 선수들의 순위를 맵에 저장
        for (int i = 0; i < players.length; i++) {
            playerPositions.put(players[i], i);
        }

        // 해설진이 부른 이름에 따라 순위 업데이트
        for (String calling : callings) {
            int currentPosition = playerPositions.get(calling);

            // 만약 부른 선수가 1등이 아니라면
            if (currentPosition > 0) {
                // 앞의 선수와 위치를 바꾼다
                String previousPlayer = players[currentPosition - 1];

                // 선수들의 배열에서 위치 변경
                players[currentPosition - 1] = calling;
                players[currentPosition] = previousPlayer;

                // 맵에서 위치 변경
                playerPositions.put(calling, currentPosition - 1);
                playerPositions.put(previousPlayer, currentPosition);
            }
        }

        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe"};
        String[] callings = {"soe", "soe"};

        String[] result = solution(players, callings);

        for (String player : result) {
            System.out.println(player);
        }
    }
}

