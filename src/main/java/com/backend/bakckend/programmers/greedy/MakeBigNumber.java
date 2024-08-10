package com.backend.bakckend.programmers.greedy;

public class MakeBigNumber {

    public static void main(String[] args) {
        MakeBigNumber sol = new MakeBigNumber();
        System.out.println(sol.solution("1924", 2)); // 94
        System.out.println(sol.solution("1231234", 3)); // 3234
        System.out.println(sol.solution("4177252841", 4)); // 775841
    }

    public String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;

        int idx = 0;

        for(int i=0; i<len ;i++){
            char max = '0';
            for(int j=idx; j<=i+k; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    idx = j+1;
                }
            }
            answer.append(max);
        }


        return answer.toString();
    }
}
