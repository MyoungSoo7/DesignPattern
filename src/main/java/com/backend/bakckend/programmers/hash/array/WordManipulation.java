package com.backend.bakckend.programmers.hash.array;

import java.util.HashMap;
import java.util.Map;

public class WordManipulation {
    public static int solution(String s) {
        // 영단어와 숫자를 매핑하는 맵
        Map<String, String> numMap = new HashMap<>();
        numMap.put("zero", "0");
        numMap.put("one", "1");
        numMap.put("two", "2");
        numMap.put("three", "3");
        numMap.put("four", "4");
        numMap.put("five", "5");
        numMap.put("six", "6");
        numMap.put("seven", "7");
        numMap.put("eight", "8");
        numMap.put("nine", "9");

        // 맵을 사용하여 문자열에서 영단어를 숫자로 변환
        for (Map.Entry<String, String> entry : numMap.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue());
        }

        // 변환된 문자열을 정수로 변환하여 반환
        return Integer.parseInt(s);
    }

    public static void main(String args) {
        // 예시 테스트
        System.out.println(solution("one4seveneight"));  // 1478
        System.out.println(solution("23four5six7"));     // 234567
        System.out.println(solution("1zerotwozero3"));   // 10203
    }

}
