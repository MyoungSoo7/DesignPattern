package com.backend.bakckend.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListTest {

    public static void main(String[] args) {



     /* LinkedList 예제

       LinkedList<String > queue = new LinkedList<String >();

        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        String s = queue.poll();

        while(s!= null){
            System.out.println(s);
            s = queue.poll();
        }*/

    /*   arraylist 예제

      List<String > list = new ArrayList<String >();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(1, "one");

        Consumer<String > con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        list.forEach(con1);

        Consumer<String> con2 = s -> System.out.println(s);
        list.forEach(con2);

        list.forEach(s -> System.out.println(s));
*/

        /* list 예제
        List<String > list = new ArrayList<String >();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String > it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/


    }
}
