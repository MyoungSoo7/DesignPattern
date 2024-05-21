package com.backend.bakckend.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Clothes {

    public int solution(String[][] clothes) {
        // 의상 종류별로 의상 개수를 세기 위해 HashMap을 사용합니다.
        Map<String, Integer> clothesCount = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];
            clothesCount.put(type, clothesCount.getOrDefault(type, 0) + 1);
        }

        // 모든 조합의 수를 계산합니다.
        int allCombinations = 1;
        for (int count : clothesCount.values()) {
            allCombinations *= (count + 1);
        }

        // 아무것도 입지 않는 경우를 제외합니다.
        return allCombinations - 1;
    }

    public static void main(String[] args) {
        Clothes sol = new Clothes();

        String[][] clothes = {
                {"얼굴","동그란 안경","검정 선글라스"},
                {"상의", "파란색 티셔츠"},
                {"하의", "청바지"},
                {"겉옷", "긴 코트"}
        };

        System.out.println(sol.solution(clothes));
    }

}
