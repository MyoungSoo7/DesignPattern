package com.backend.bakckend.codingtest.strings.word;

import java.util.Scanner;

public class baekjoon13223 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String[] current = sc.nextLine().split(":");
        String[] target = sc.nextLine().split(":");

        int currentHour = Integer.parseInt(current[0]);
        int currentMinute = Integer.parseInt(current[1]);
        int currentSecond = Integer.parseInt(current[2]);

        int targetHour = Integer.parseInt(target[0]);
        int targetMinute = Integer.parseInt(target[1]);
        int targetSecond = Integer.parseInt(target[2]);

        int currentTotalSecond = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int targetTotalSecond = targetHour * 3600 + targetMinute * 60 + targetSecond;
        
        int NeedSecondAmount = targetTotalSecond - currentTotalSecond;
        // 24시간 기본
        if(NeedSecondAmount <=0) NeedSecondAmount += 24 * 3600;
        
        int NeedHour = NeedSecondAmount / 3600;
        int NeedMinute = (NeedSecondAmount % 3600) / 60;
        int NeedSecond = NeedSecondAmount  % 60;

        System.out.println(String.format("%02d:%02d:%02d", NeedHour, NeedMinute, NeedSecond));
        
        

    }
}
