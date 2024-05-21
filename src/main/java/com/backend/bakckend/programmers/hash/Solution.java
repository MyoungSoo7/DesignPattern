package com.backend.bakckend.programmers.hash;

import java.util.Arrays;

class PhoneBook {

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
        PhoneBook phone_book = new PhoneBook();
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(phone_book.solution(phoneBook));
    }

}