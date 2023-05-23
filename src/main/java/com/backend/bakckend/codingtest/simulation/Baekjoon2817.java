package com.backend.bakckend.codingtest.simulation;

import java.util.Scanner;

// ALPS식 투표
public class Baekjoon2817 {

    static class Score{
        Score(int staffIndex,double scr){
            this.staffIndex= staffIndex;
            this.scr = scr;
        }
        int staffIndex;
        double scr;
    }

    public static void sortScoresDescendingOrder(Score[] arr){
       for(int i=0; i<arr.length;i++){
           for(int j =0; j<i ;j++){
                if(arr[i].scr > arr[j].scr){
                     Score temp = arr[i];
                     for(int k =i ; k>j ; k--){
                         arr[k] = arr[k-1];
                     }
                     arr[j] = temp;
                }
           }
       }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 참가자들의 수
        int X = sc.nextInt();
        // 스태프의 수
        int N = sc.nextInt();

        // 1. 전체 득표수의 5프로 미만의 스태프를 후보에서 제외한다.
        double validCut = X* 0.05;
        boolean[] validCandidate = new boolean[26];
        int[] staffVote = new int[26];
        int candidateCount =0;
        for(int i=0; i<N; i++){
            // 스태프 이름
            String name =sc.next();
            // 스태프가 받은 칩의 개수
            int vote = sc.nextInt();
            if(vote >= validCut){
                //  A~Z : 65~90
                //  A~Z - 'A' : 0~25
                int index = name.charAt(0) -'A';
                validCandidate[index] = true;
                staffVote[index]= vote;
                candidateCount++;
            }
        }

        // 2. 남은 스태프마다 받은 득표수를 1~14로 나눈 점수를 구한다.
        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex =0;
        for(int i=0; i< 26; i++){
            if(validCandidate[i]) {
                for(int j=1; j<=14; j++){
                    scores[scoreIndex++] = new Score(i, (double)staffVote[i]/j);
                }
            }
        }

        // 3. 전체 점수 집합에서 점수가 큰 1~14번째 스태프에게 칩을 1개씩 지급한다.
        sortScoresDescendingOrder(scores);

        int[] ans = new int[26];
        for(int i=0; i< 14;i++){
            ans[scores[i].staffIndex]++;
        }

        // 4. 스태프 이름에 대해 사전순으로 후보 스태프와 받은 칩의 수를 출력한다.
        for(int i=0;i<26;i++){
            if(validCandidate[i]){
                System.out.println((char)(i+'A') + " " + ans[i]);
            }
        }

    }
}
