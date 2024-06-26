package com.backend.bakckend.codingtest.leet;

import java.util.*;

public class FrequentElements {

    public static int[] topKFrequent(int[] nums,  int k) {
        // Step 1: 각 숫자의 빈도수를 계산
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: 빈도수를 기준으로 숫자를 정렬하는 우선순위 큐 생성
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        // 맵의 모든 엔트리를 큐에 추가
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: 큐에서 k개의 요소를 추출하여 결과 리스트에 추가
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }

   /* public int[] topKFrequent(int[] nums, int k) {
        int nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(topKFrequent(nums1, k1)); // 출력: [1, 2]

        int nums2 = {1};
        int k2 = 1;
        System.out.println(topKFrequent(nums2, k2)); // 출력: [1]
    }*/

}
