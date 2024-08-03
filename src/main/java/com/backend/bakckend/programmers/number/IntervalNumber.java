package com.backend.bakckend.programmers.number;

public class IntervalNumber {

    public long[] solution(int x, int n) {
        // 정수 x, 자연수 n
        // x 부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴
        // x = 2, n = 5 -> [2,4,6,8,10]
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        IntervalNumber intervalNumber = new IntervalNumber();
        int x = 2;
        int n = 5;
        long[] result = intervalNumber.solution(x, n);  //[2,4,6,8,10]
        for (long l : result) {
            System.out.println(l);
        }
    }
}
