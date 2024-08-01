package com.backend.bakckend.baekjoon.codingtest.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = n;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            boolean[] check = new boolean[26];
            // 첫 번째 문자를 통해 그룹 단어인지 확인
            for(int j=1; j<s.length(); j++){
                // 이전 문자와 현재 문자가 같지 않은 경우
                if(s.charAt(j-1) != s.charAt(j)){
                    if(check[s.charAt(j)-97] == true){
                        count--;
                        break;
                    }
                    check[s.charAt(j-1)-97] = true;
                }
            }
        }
        System.out.println(count);

    }
}
