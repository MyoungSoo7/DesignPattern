package com.backend.bakckend.programmers.simulation;

import java.util.HashMap;
import java.util.Map;

public class Sale {
    public int solution(String[] want, int[] number, String[] discount) {
        // 원하는 제품과 수량을 맵에 저장
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int totalDays = 0;
        int n = discount.length;

        // 슬라이딩 윈도우를 사용하여 10일 간의 할인 목록을 확인
        for (int i = 0; i <= n - 10; i++) {
            Map<String, Integer> currentMap = new HashMap<>();

            // 현재 10일 간의 할인 목록을 맵에 저장
            for (int j = i; j < i + 10; j++) {
                currentMap.put(discount[j], currentMap.getOrDefault(discount[j], 0) + 1);
            }

            // 원하는 제품과 수량이 모두 충족되는지 확인
            boolean canRegister = true;
            for (String key : wantMap.keySet()) {
                if (currentMap.getOrDefault(key, 0) < wantMap.get(key)) {
                    canRegister = false;
                    break;
                }
            }

            if (canRegister) {
                totalDays++;
            }
        }

        return totalDays;
    }

    public static void main(String[] args) {
        Sale solution = new Sale();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution.solution(want, number, discount)); // Output: 3
    }
}

