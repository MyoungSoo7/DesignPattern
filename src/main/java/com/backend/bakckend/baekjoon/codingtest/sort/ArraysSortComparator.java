package com.backend.bakckend.baekjoon.codingtest.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortComparator {

    static class Member{
        String name;
        int age;
        Member(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Member[] members ={
           new Member("Carol", 23),
           new Member("Bob", 27),
           new Member("Erin", 31),
           new Member("Alice", 27),
           new Member("Dave", 27),
        };

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age == o2.age){
                    // 나이가 같다면 이름에 대한 사전순
                    return o1.name.compareTo(o2.name);
                }else{
                    // 나이에 에한 오름 차순
                    return o1.age - o2.age;
                }
            }
        });

    }

}
