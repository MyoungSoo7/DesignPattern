package com.backend.bakckend.programmers.hash.array;


import java.util.*;

public class BigNumber {

    public static int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i< n ; i++){
            stack.push(numbers[i]);
        }
        for(int i=0; i< n ; i++){
            queue.add(numbers[i]);
        }
        for(int i=0; i<n ; i++){
            list.add(numbers[i]);
        }
        for(int i=0; i<n ; i++){
            list2.add(numbers[i]);
        }

        System.out.println("numbers : " + Arrays.stream(numbers).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
        System.out.println("stack : " + stack);
        System.out.println("queue : " + queue);
        System.out.println("ArrayList : " + list);
        System.out.println("LinkedList : " + list2);


        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5}; //[3, 5, 5, -1]
        int[] result = solution(numbers);
    }

}
