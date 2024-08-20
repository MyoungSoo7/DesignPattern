package com.backend.bakckend.programmers.BinarySearch;

import java.util.Arrays;

public class RightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        int[][] startIntervals = new int[n][2];

        // 각 구간의 시작점과 인덱스를 저장
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }

        // 시작점을 기준으로 정렬
        Arrays.sort(startIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 각 구간에 대해 오른쪽 구간 찾기
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int left = 0, right = n - 1;
            int index = -1;

            // 이진 탐색을 통해 오른쪽 구간 찾기
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (startIntervals[mid][0] >= end) {
                    index = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = index;
        }

        return result;
    }

    public static void main(String[] args) {
        RightInterval solution = new RightInterval();
        int[][] intervals = {{1, 2}};
        int[] result = solution.findRightInterval(intervals);
        System.out.println(Arrays.toString(result)); // 출력: [-1]
    }
}
