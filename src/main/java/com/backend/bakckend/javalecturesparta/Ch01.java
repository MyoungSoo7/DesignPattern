package com.backend.bakckend.javalecturesparta;

import java.util.Arrays;

public class Ch01 {

    public static void main(String[] args) {

        String rep = """
                물 200ml를 끓인다.
                순두부소스를 넣는다.
                양파를 채썰어 넣는다.
                계란을 풀어서 넣는다.
                두부를 넣고 5분 정도 끓인다.
                """;
        String water= "물 200ml를 끓인다.\n";
        String source = "순두부소스를 넣는다.\n";
        String onion = "양파를 채썰어 넣는다.\n";
        String egg = "계란을 풀어서 넣는다.\n";
        String tofu = "두부를 넣고 5분 정도 끓인다.";

        String recipe = water+ source + onion + egg + tofu;
//        System.out.println(recipe);
//        System.out.println(rep);

        String [] stringArr = {"a","b"};

        int []intArr = {1,2,3,4,5};
        // 얕은 복사
        int []intArr2 = intArr.clone();
        // 깊은 복사
        int []deepCopy = Arrays.copyOf(intArr, intArr.length);


        // 배열 0으로 초기화
        //Arrays.fill(intArr, 0);
        for(int item : intArr2){
            System.out.println(item);
        }
        for(int item : deepCopy){
            System.out.println(item);
        }

        // Array 는 정적배열 , List는 동적배열 ,LinkedList 는  추가/삭제는 빠르나 조회는 느림

    }
}
