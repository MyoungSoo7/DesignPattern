package com.backend.bakckend.baekjoon.codingtest.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2840 {

    public static void main(String[] args) {
        // 바퀴를 시계방향으로 S칸 돌릴때마다 화살표가 가리키는 글자가 주어질때 바퀴의 각칸에 적어놓은 알파벳을 알아내자
        // 바퀴에 적힌 글자가 모두 다른지 확인한다.
        // 바퀴에 출력된 글자를 마지막으로 도착한 글자부터 출력한다.
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int curIndex= 0;
        while(K-- > 0){
            int step = sc.nextInt();
            char nextAlphabet =sc.next().charAt(0);
            int nextIndex = ((curIndex - step) % N + N ) %N;
            if(wheel[nextIndex] == '?' ) wheel[nextIndex] = nextAlphabet;
            else if(wheel[nextIndex] != nextAlphabet) {
                System.out.println("!");
                return ;
            }
            curIndex = nextIndex;
        }

        boolean[] used = new boolean[26];
        for(int i=0; i<N;i++){
            if(wheel[i] == '?') continue;
            if(used[wheel[i]- 'A' ]){
                System.out.println("!");
                return ;
            }
            used[wheel[i]- 'A' ] = true;
        }

        for(int i=0; i<N ; i++){
            System.out.print(wheel[(curIndex + i) % N]);
        }
        System.out.println();
    }
}
