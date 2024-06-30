package com.backend.bakckend.datastructure;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.peek();
        stack.isEmpty();
        stack.size();
    }
}
