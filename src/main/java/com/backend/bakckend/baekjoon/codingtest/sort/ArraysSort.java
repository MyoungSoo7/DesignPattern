package com.backend.bakckend.baekjoon.codingtest.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bwr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bwr.readLine());
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(bwr.readLine());
        }

        // Tim Sort 최악의 경우에도( NlogN)
        Arrays.sort(arr);

        BufferedWriter bww = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bww.write(arr[i]+"\n");
        }
        bww.flush();

        int [] primitiveArray = new int[]{1,2,3,4,5};
        Arrays.sort(primitiveArray);
        for(int i=primitiveArray.length-1 ; i>=0; i--){
            System.out.println(primitiveArray[i]);
        }

        Integer[] objectArray = new Integer[]{1,2,3,4,5};
        Arrays.sort(objectArray, Collections.reverseOrder());
        for(Integer x : objectArray){
            System.out.println(x);
        }

        Arrays.sort(objectArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // return o1 -o2; // 오름차순
                return o2 -o1; // 내림차순
            }
        });
        Arrays.sort(objectArray, (o1, o2) -> o2 -o1); // 람다식 (내림차순)

        for(Integer x : objectArray){
            System.out.println(x);
        }

    }
}
