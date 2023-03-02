package com.backend.bakckend.designpattern.separate;

import java.util.ArrayList;
import java.util.LinkedList;


interface AbstractList<T>{
    void add(T t);
    T remove(int index);
    int insertElement(T t,int index);
    T get(int index);
    int getSize();
}

class List<T>{

    AbstractList<T> list;

    List(AbstractList<T> list){
        this.list = list;
    }

    void add(T t){
        list.add(t);
    }

    T get(int index){
        return list.get(index);
    }

    T remove(int index){
        return list.remove(index);
    }

    int getSize(){
        return list.getSize();
    }

}



class Stack<T> extends List<T>{

    Stack(AbstractList<T> list){
        super(list);
        System.out.println("Stack is created");
    }

    void push(T t){
        list.insertElement(t,0);
    }

    T pop(){
        return remove(0);
    }

}

class Queue<T> extends List<T>{

    Queue(AbstractList<T> list){
        super(list);
        System.out.println("Queue is created");
    }

    void enQueue(T t){
        list.add(t);
    }

    T deQueue(){
        return remove(0);
    }

}

class ArrayImpl<T> implements AbstractList<T>{
    ArrayList<T> array;
    ArrayImpl(){
        array = new ArrayList<T>();
        System.out.println("Array is created");
    }

    @Override
    public void add(T t) {
        array.add(t);
    }

    @Override
    public T remove(int index) {
        return array.remove(index);
    }

    @Override
    public int insertElement(T t, int index) {
        array.add(index, t);
        return index;
    }

    @Override
    public T get(int index) {
        return array.get(index);
    }

    @Override
    public int getSize() {
        return array.size();
    }


}

class LinkedListImpl<T> implements AbstractList<T>{

    LinkedList<T> linkedList;

    LinkedListImpl(){
        linkedList = new LinkedList<T>();
        System.out.println("LinkedList is created");
    }

    @Override
    public void add(T t) {
        linkedList.add(t);
    }

    @Override
    public T remove(int index) {
        return linkedList.remove(index);
    }

    @Override
    public int insertElement(T t, int index) {
        linkedList.add(index, t);
        return index;
    }

    @Override
    public T get(int index) {
        return linkedList.get(index);
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }


}

public class Bridge {

    public static void main(String[] args) {

        // Queue method bridge (ArrayImpl, LinkedListImpl)
        Queue<Integer> queue = new Queue<Integer>(new ArrayImpl<Integer>());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println("=================");


        Queue<Integer> queue2 = new Queue<Integer>(new LinkedListImpl<Integer>());
        queue2.enQueue(1);
        queue2.enQueue(2);
        queue2.enQueue(3);

        System.out.println(queue2.deQueue());
        System.out.println(queue2.deQueue());
        System.out.println(queue2.deQueue());
        System.out.println("=================");

        // Stack method bridge (ArrayImpl, LinkedListImpl)
        Stack<String> arrayStack = new Stack<String>(new ArrayImpl<String>());
        arrayStack.push("aaa");
        arrayStack.push("bbb");
        arrayStack.push("ccc");

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("=========================");

        Stack<String> linkedStack = new Stack<String>(new LinkedListImpl<String>());
        linkedStack.push("aaa");
        linkedStack.push("bbb");
        linkedStack.push("ccc");

        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println("=========================");



    }

}
