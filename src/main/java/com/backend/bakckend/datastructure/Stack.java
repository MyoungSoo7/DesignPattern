package com.backend.bakckend.datastructure;

public class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty");
            return -1; // 또는 예외를 던질 수 있음
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty");
            return -1; // 또는 예외를 던질 수 있음
        }
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        // 스택에 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 스택에서 요소 제거 및 반환
        System.out.println(stack.pop()); // 3

        // 스택의 맨 위 요소 확인
        System.out.println(stack.peek()); // 2

        // 스택이 비어있는지 확인
        System.out.println(stack.isEmpty()); // false

        // 스택의 크기 확인
        System.out.println(stack.size()); // 2
    }



}
