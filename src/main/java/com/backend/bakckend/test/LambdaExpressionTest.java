package com.backend.bakckend.test;

interface  MyInterface1 {
    void method1(int a, int b);
}
interface  MyInterface2 {
    void method2(int a);
}

public class LambdaExpressionTest {

    public static void main(String[] args) {

        MyInterface1 f1, f2, f3;
        MyInterface2 f4;
        MyInterface2 f5;
        MyInterface2 f6;

        f1 = (a, b) -> System.out.println(a + b);
        f1.method1(3,4);
        f2= (a, b) -> System.out.println(a - b);
        f2.method1(5,6);
        f3= (a, b) -> System.out.println(a * b);
        f3.method1(7,8);

        f4= (int a)-> System.out.println(a);
        f4.method2(9);
        f5= a-> System.out.println(a);
        f5.method2(10);


   /*     Addable ad1 = new Addable() {
            @Override
            public int add(int a, int b) {
                return (a + b);
            }
        };

        System.out.println(ad1.add(100,200));

        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(ad2.add(10,20));

        Addable ad3 = (a, b) -> a + b;
        System.out.println(ad3.add(1,2));
*/

        //Addable addable = (a, b) -> a + b;


    }

}
