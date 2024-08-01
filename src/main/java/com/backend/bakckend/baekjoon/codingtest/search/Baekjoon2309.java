package com.backend.bakckend.baekjoon.codingtest.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] h = new int[9];
        int sum =0;
        for(int i=0; i<9;i++){
            h[i] = Integer.parseInt(br.readLine());
            sum += h[i];
        }
        int[] ans = new int[7];
        boolean found= false;
        for(int i =0; i<9; i++){
            for(int j=i+1; j< 9; j++){
                if(sum - h[i]- h[j] == 100){
                    int ansIndex =0;
                    for(int k=0; k<9; k++){
                        if(k!=i && k!=j){
                            ans[ansIndex++] = h[k];
                        }
                    }
                    found=true;
                    break;
                }
            }
            if(found) break;
        }

        insertionSort(ans);
        for(int i=0; i<7; i++)
            System.out.println(ans[i]);

    }
    
    public static void insertionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i ; j++){
                if(arr[j] > arr[i]){
                    int cur = arr[i];
                    for(int k=i; k >j; k--){
                        arr[k] = arr[k-1];
                    }
                    arr[j] = cur;
                    break;
                }
            }
        }
    }

}
