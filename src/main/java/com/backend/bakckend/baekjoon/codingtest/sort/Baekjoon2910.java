package com.backend.bakckend.baekjoon.codingtest.sort;


import java.io.IOException;
import java.util.*;

// 빈도정렬
public class Baekjoon2910 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i =0; i< N ; i++){
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


       /* int[] frequencies = map.keySet().toArray(new Integer[map.size()]);
            Arrays.sort(frequencies, new Comparator<Integer>(){

        });*/

        // 1. 더 많이 등장한 숫자 먼저


        // 2. 등장 횟수가 같다면 입력으로 먼저 들어온 것이 먼저

            
    }
}
