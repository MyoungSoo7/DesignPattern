package com.backend.bakckend.test;

public class BinaryExam {

    public static void main(String[] args) {
        int data  =123;
        String binary = Integer.toBinaryString(data);
        System.out.println(binary);
        String octal = Integer.toOctalString(data);
        System.out.println(octal);
        String hex = Integer.toHexString(data);
        System.out.println(hex);

        int x = 123;
        int y = 0b1111011;
        int z = 0173;
        int w = 0x7b;
        System.out.println(x+ " " + y + " " + z + " " + w);
    }
}
