package com.backend.bakckend.programmers.hash.stackqueue;

public class RightBracket {

    public boolean solution(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        RightBracket sol = new RightBracket();
        System.out.println(sol.solution("()()")); // true
        System.out.println(sol.solution("(())()")); // true
        System.out.println(sol.solution(")()(")); // false
        System.out.println(sol.solution("(()(")); // false
    }

}
