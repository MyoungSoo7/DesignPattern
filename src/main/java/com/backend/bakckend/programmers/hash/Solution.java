package com.backend.bakckend.programmers.hash;

import java.util.Arrays;

class Solution {

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {

            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(sol.solution(phoneBook));
    }

}