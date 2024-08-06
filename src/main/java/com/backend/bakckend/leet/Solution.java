package com.backend.bakckend.leet;

public class Solution {

    public static int minFlips(String target) {
        int n = target.length();
        char current = '0';
        int flips = 0;

        for (int i = 0; i < n; i++) {
            if (target.charAt(i) != current) {
                flips++;
                current = target.charAt(i);
            }
        }
        return flips;
    }

    public static void main(String[] args) {
        // Example usage:
        String target1 = "10111";
        String target2 = "101";
        String target3 = "00000";

        System.out.println("Minimum flips for target1: " + minFlips(target1)); // Output: 3
        System.out.println("Minimum flips for target2: " + minFlips(target2)); // Output: 3
        System.out.println("Minimum flips for target3: " + minFlips(target3)); // Output: 0
    }
}
