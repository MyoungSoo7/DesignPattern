package com.backend.bakckend.programmers.dictionary;

public class Dictionary {

    public int solution(String word) {

        int[] weights = {781, 156, 31, 6, 1}; // 각 자리의 가중치
        char[] dic = {'A', 'E', 'I', 'O', 'U'};
        int result = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < dic.length; j++) {
                if (c == dic[j]) {
                    result += j * weights[i] + 1;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.solution("A")); // 1
        System.out.println(dictionary.solution("AA")); // 2
        System.out.println(dictionary.solution("EIO")); // 1189
    }

}
