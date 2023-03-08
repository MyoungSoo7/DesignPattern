package com.backend.bakckend.test;

public class AsciiTest {

    public static void main(String[] args) {
        //ASCII
        //int A = 65;
        //int a = 97;

         int hanD = '가';
        System.out.println(hanD);
        System.out.println((char)hanD); // 44032
        int hanU = '\uAC00';  // '\uAC00' == '가'
        System.out.println((char)hanU);

        int data = '1' + '2';
        System.out.println("data = " + data);
        System.out.println("data = " + (char)data);

        // '0' = 48
        char i = '1';
        char j = '2';
        int sum = (i-48) + (j-48);
        
        // Q. 1+2 =3 이 나오도록 하시오
        System.out.println("sum = " + sum);
    }
}
