package com.backend.bakckend.util;

import java.io.IOException;

public class FourArithmetic {

    public static void main(String[] args) throws IOException {
        /*Yaml yaml = new Yaml();
        Map<String, Object> data = (Map<String, Object>) yaml.load(new FileInputStream("src/main/resources/application.yml"));*/


        char cInput =0;
        int i =0;
        System.out.println("Input a character : ");
        cInput = (char)System.in.read();
        System.out.println(cInput);
        i = System.in.read();
        System.out.println(i);
        i = System.in.read();
        System.out.println(i);
        System.out.println(System.in.available());

    }
}
