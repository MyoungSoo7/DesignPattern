package com.backend.bakckend.datastructure.sort;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // i번째 원소를 기준으로 가장 작은 원소의 인덱스를 찾음
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 가장 작은 원소를 i번째 원소와 교환
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args) {
        int arr[] = {64, 25, 12, 22, 11};
        System.out.println("정렬 전 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        selectionSort(arr);

        System.out.println("정렬 후 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
