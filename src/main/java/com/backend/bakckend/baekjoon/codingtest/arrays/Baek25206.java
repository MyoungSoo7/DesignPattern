package com.backend.bakckend.baekjoon.codingtest.arrays;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 너의 평점은
public class Baek25206 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        double sumnumscore = 0;
        double sumnum = 0;

        for(int i=0; i< 20; i++){
            st = new StringTokenizer(br.readLine());
            String Object = st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String alphabet = st.nextToken();
            double score = 0;

            if(!(alphabet.equals("P"))){
                switch (alphabet){
                    case "A+":
                        score = 4.5;
                        break;
                    case "A0":
                        score = 4.0;
                        break;
                    case "A-":
                        score = 3.7;
                        break;
                    case "B+":
                        score = 3.5;
                        break;
                    case "B0":
                        score = 3.0;
                        break;
                    case "B-":
                        score = 2.7;
                        break;
                    case "C+":
                        score = 2.5;
                        break;
                    case "C0":
                        score = 2.0;
                        break;
                    case "C-":
                        score = 1.7;
                        break;
                    case "D+":
                        score = 1.5;
                        break;
                    case "D0":
                        score = 1.0;
                        break;
                    case "D-":
                        score = 0.7;
                        break;
                    case "F":
                        score = 0.0;
                        break;
                }
                sumnumscore += num*score;
                sumnum += num;
            }
        }
        System.out.println(String.format("%.6f",sumnumscore/sumnum));
        br.close();

    }


}
