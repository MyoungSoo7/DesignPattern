package com.backend.bakckend.codingtest.intervalSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws IOException    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            float f = 5.5F;
           // System.out.println(1/0);
            br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}
