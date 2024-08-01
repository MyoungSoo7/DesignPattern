package com.backend.bakckend.baekjoon.codingtest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());

        // 1. N을 B로 나눈 몫을 구한다. B로 나누자
        // 2. 이 때 가장 마지막 나머지부터 가장 앞자릿값이 된다.
        String ans= "";
        while(N >0){
            int D = N % B;
            if(D <10) ans+=D;
            else ans += (char)(D - 10+ 'A');
            N = N/B;
        }

        for(int i=ans.length()-1; i>=0; i--)
            System.out.print(ans.charAt(i));
        System.out.println();
    }
}
