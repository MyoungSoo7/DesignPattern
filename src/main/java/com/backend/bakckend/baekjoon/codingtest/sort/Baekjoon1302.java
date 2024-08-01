package com.backend.bakckend.baekjoon.codingtest.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 베스트셀러
public class Baekjoon1302 {


    public static void main(String[] args) {
        // 시간복잡도 : O(L * N2승)
        // 문제 : 판매된 책의 제목들이 주어졌을 때 , 가장 많이 팔린 책은?
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer>map = new HashMap<>();
        for(int i=0; i<N ; i++){
            String title= sc.next();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        String maxTitle ="";
        int maxCount=0;
        for(Map.Entry<String, Integer> title : map.entrySet()){
            String titleName = title.getKey();
            int count = title.getValue();
            if( count > maxCount ||
                    ( count  == maxCount && titleName.compareTo(maxTitle) < 0 )){
                maxTitle = titleName;
                maxCount = count;
            }
        }
        System.out.println(maxTitle);
    }

}
