package com.backend.bakckend.baekjoon.codingtest.strings.word;

import java.util.Scanner;

public class baekjoon1543 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String word = sc.nextLine();

        //  같은 입력 값 다지우기
        String replaced = str.replace(word, "");
        int length = str.length() - replaced.length();
        int count = length / word.length();
        System.out.println(count);

       /* int index = 0;
        int count = 0;
        while((index = str.indexOf(word, index)) != -1){
            index += word.length();
            count++;
        }
        System.out.println(count);*/

    }
}
