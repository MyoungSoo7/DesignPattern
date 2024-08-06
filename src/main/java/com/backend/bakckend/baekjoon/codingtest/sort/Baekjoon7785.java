package com.backend.bakckend.baekjoon.codingtest.sort;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 회사에 있는 사람
public class Baekjoon7785 {

    public static void main(String[] args) {
        // 문제 : 회사 출입기록이 주어질 때, 아직 퇴근하지 못한 사람의 목록(사전 역순)
        Scanner sc = new Scanner(System.in);

        // 시간 복잡도 : O(N * LlogN)  L: 사원의 이름 길이
        int N = sc.nextInt();
        Set<String>set = new TreeSet<>();
        for(int i=0; i<N ; i++){
            String name =sc.next();
            String status = sc.next();
            // 2. 각 사원마다 마지막 기록이 enter인지 확인한다.(사전 역순)
            if(status.equals("enter"))
                set.add(name);
            else set.remove(name);
        }

        // 1. 이름 순서에 따라 출입기록을 차례로 정렬한다.
        String[] orderedName =set.toArray(new String[set.size()]);
        for(int i= orderedName.length -1; i>= 0; i--){
            // 2-1. enter이면 아직 회사에 있다는 뜻이므로 출력한다.
            System.out.println(orderedName[i]);
        }
    }
}
