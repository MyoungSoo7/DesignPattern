package com.backend.bakckend.baekjoon.codingtest.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacter {

    public static String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to sort characters by frequency in descending order
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Construct the resulting string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char c = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String sortedS = frequencySort(s);
        System.out.println(sortedS);  // 출력: "eert" 또는 "rtee" 등
    }


}
