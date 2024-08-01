package com.backend.bakckend.baekjoon.codingtest.sort;

import java.util.Arrays;

public class ArraysSortComparable {

    static class Member implements Comparable<Member>{
        String name;
        int age;

        public Member(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Member o) {
            // 나이가 같다면 이름의 사전순으로 정렬합니다.
            if(this.age == o.age)
                return this.name.compareTo(o.name);
            // 나이가 다르다면 나이 순으로 정렬합니다.
            return this.age - o.age;
        }
    }

    public static void main(String[] args) {
        Member[] members = {
             new Member("Alice", 23),
             new Member("Bob", 21),
             new Member("Erin", 31),
             new Member("Carol", 27),
             new Member("Dave", 19)
        };

        Arrays.sort(members);

        for(Member member : members){
            System.out.println("name: " + member.name + ", age: " + member.age);
        }

    }
}
