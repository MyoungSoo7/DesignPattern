package com.backend.bakckend.datastructure.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        System.out.println("정렬 전 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(arr);

        System.out.println("정렬 후 배열:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 마지막 i개의 원소는 이미 정렬되어 있으므로 무시
            for (int j = 0; j < n - i - 1; j++) {
                // 인접한 두 원소를 비교하여 필요하면 교환
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
