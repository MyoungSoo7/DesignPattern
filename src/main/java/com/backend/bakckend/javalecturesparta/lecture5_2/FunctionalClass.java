package com.backend.bakckend.javalecturesparta.lecture5_2;

import java.util.Arrays;
import java.util.List;



@FunctionalInterface
interface Calulator{
    int calculator(int x, int y);
}

public class FunctionalClass {


    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        number.stream()
                .filter(x -> x%2 == 0)
                .map(x -> x*x)
                .forEach(x -> System.out.println(x));


        Calulator add = (x,y) -> x+y;
        Calulator sub = (x,y) -> x-y;

        System.out.println(add.calculator(10,20));
        System.out.println(sub.calculator(30,20));

    }

}
