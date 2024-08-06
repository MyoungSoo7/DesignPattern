package com.backend.bakckend.baekjoon.codingtest.sort;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 단어 정렬
public class Baekjoon1181{


    public static void main(String[] args) {
        // 문제 : N개의 단어에 대해 중복을 제거하고 아래 조건에 맞게 정렬

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set =new TreeSet<>();
        for(int i=0; i<N ; i++){
            String name = sc.next();
            String status = sc.next();
            if(status.equals("enter"))  // 집합에 추가
                set.add(name);
            else set.remove(name);     //집합에서 제거    System.out.println(name);
        }

        String[] orderedName = set.toArray(new String[set.size()]);
        for(int i=orderedName.length-1; i>=0; i--){
            System.out.println(orderedName[i]);
        }



        // 1. 길이가 짧은 것부터
        // 2. 길이가 같으면 사전 순으로


        // 중복된 단어는 하나만 남기고 제거해야 한다.

    }
}
