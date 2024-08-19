package com.backend.bakckend.programmers.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
/*
        int dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == length) {
                length++;
            }
        }

        return length;*/
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Example 1: " + lengthOfLIS(nums1)); // Output: 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Example 2: " + lengthOfLIS(nums2)); // Output: 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Example 3: " + lengthOfLIS(nums3)); // Output: 1
    }
}
