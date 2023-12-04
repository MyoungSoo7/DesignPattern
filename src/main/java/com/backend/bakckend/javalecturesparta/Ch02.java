package com.backend.bakckend.javalecturesparta;

import java.util.*;

public class Ch02 {

    public static void main(String[] args) {

        // list = arraylist , linkedlist(수정/삭제) , stack (LIFO)
        //

        List<String> recipeList = new ArrayList<String>();
        recipeList.add("물 200ml를 끓인다.\n");
        recipeList.add("순두부소스를 넣는다.\n");
        recipeList.add("양파를 채썰어 넣는다.\n");
        recipeList.add("계란을 풀어서 넣는다.\n");
        recipeList.add("두부를 넣고 5분 정도 끓인다.");

        //System.out.println(recipeList.toString());

        Stack<String> recipeStack = new Stack<String>();
        recipeStack.push("물 200ml를 끓인다.\n");
        recipeStack.push("순두부소스를 넣는다.\n");
        recipeStack.push("양파를 채썰어 넣는다.\n");
        recipeStack.push("계란을 풀어서 넣는다.\n");
        recipeStack.push("두부를 넣고 5분 정도 끓인다.");

       /* System.out.println(recipeStack.toString());
        System.out.println(recipeStack.peek());;
        recipeStack.pop();
        System.out.println(recipeStack.toString());*/

        Queue<String> recipeQueue = new java.util.LinkedList<String>();
        recipeQueue.offer("물 200ml를 끓인다.\n");
        recipeQueue.offer("순두부소스를 넣는다.\n");
        recipeQueue.offer("양파를 채썰어 넣는다.\n");
        recipeQueue.offer("계란을 풀어서 넣는다.\n");
        recipeQueue.offer("두부를 넣고 5분 정도 끓인다.");
        recipeQueue.add("두부를 넣고 5분 정도 끓인다.");

       /* System.out.println(recipeQueue.peek()); ;
        System.out.println(recipeQueue.poll());;
        System.out.println(recipeQueue.toString());
        System.out.println(recipeQueue.size());
*/

        // List와 같으나 중복을 허용하지 않고 순서가 없다.
        Set<String> intSet = new HashSet<String>();

        intSet.add("a");
        intSet.add("b");
        intSet.add("c");

       /* for(String item : intSet){
            System.out.println(item);
        }*/

        System.out.println(intSet.contains("a") );


        Map<String,Integer> intMap = new HashMap<>();
        intMap.put("a",1);
        intMap.put("b",2);
        intMap.put("c",3);

/*
        for(String key : intMap.keySet()){
            System.out.println(key);
        }
        for (Integer value : intMap.values()) {
            System.out.println(value);
        }
*/

    }
}
