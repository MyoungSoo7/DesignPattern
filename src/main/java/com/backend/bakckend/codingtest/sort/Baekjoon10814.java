package com.backend.bakckend.codingtest.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 나이순 정렬
public class Baekjoon10814 {

    public static void main(String[] args) throws IOException {
        // 문제 : N명의 회원의 나이와 이름이 가입한 순서대로 주어질 때, 아래 조건에 맞게 정렬
        Scanner sc = new Scanner(System.in);

        int N= sc.nextInt();
        Member[] members = new Member[N];
        for(int i=0; i<N; i++){
            members[i] = new Member(sc.nextInt(), sc.next(), i);
        }

        // 1. 나이가 작은 회원 먼저
        // 2. 나이가 같으면 먼저 가입한 사람 먼저
        Arrays.sort(members);

        for(Member member : members){
            System.out.println(member.age + " " + member.name);
        }

    }

    static class Member implements Comparable<Member>{
        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx){
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        // 1. 나이가 작은 회원 먼저
        // 2. 나이가 같으면 먼저 가입한 사람 먼저
        @Override
        public int compareTo(Member o) {
            if(age != o.age) {
                return age - o.age;
            }
            return idx - o.idx;
        }

    }
}
