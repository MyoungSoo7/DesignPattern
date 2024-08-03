package com.backend.bakckend.programmers.number;

import java.util.Arrays;

public class Thesis {
    public static void main(String[] args) {
        Thesis thesis = new Thesis();
        int[] citations = {3, 0, 6, 1, 5};
        int result = thesis.solution(citations);
        System.out.println(result);
    }

    public int solution(int[] citations) {
        // 인용 횟수를 오름차순으로 정렬합니다.
        Arrays.sort(citations);

        int n = citations.length;

        // h의 최댓값을 찾기 위해 반복문을 사용합니다.
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문이 h번 이상 인용된 논문의 수
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
