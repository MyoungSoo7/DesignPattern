package com.backend.bakckend.programmers.number;

import java.util.Arrays;
import java.util.Comparator;

public class SortBignumber {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 두 문자열을 이어 붙였을 때 더 큰 값을 만드는 순서로 정렬
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1); // 내림차순 정렬
            }
        });

        StringBuilder result = new StringBuilder();
        for (String str : strNumbers) {
            result.append(str);
        }

        // 모든 숫자가 0인 경우 "0"을 반환
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();


        // 최대 힙을 구현하기 위해 PriorityQueue를 역순으로 설정
        /*PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();

            if (x > 0) {
                maxHeap.add(x);
            } else {
                if (maxHeap.isEmpty()) {
                    output.append(0).append('\n');
                } else {
                    output.append(maxHeap.poll()).append('\n');
                }
            }
        }*/
    }

    public static void main(String[] args) {
        SortBignumber sortBignumber = new SortBignumber();
        int[] numbers = {6, 10, 2};
        String result = sortBignumber.solution(numbers);
        System.out.println(result); // "6210"
    }

}



