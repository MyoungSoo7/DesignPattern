package com.backend.bakckend.test;

import java.io.IOException;


class CharInput{
    int aInput =0;
    public char getInput() throws IOException {
        aInput = System.in.read();
        return (char) aInput;
    }
}

public class ExceptionTest {

    public static void main(String[] args) {

         /*   int b =0;
        try{
            b= System.in.read();
        }catch (IOException ex){
            System.out.println(ex);
        }
        System.out.println((char) b);*/

       /* CharInput charInput = new CharInput();
        try{
            System.out.println(charInput.getInput());
        }catch (IOException ex){
            System.out.println(ex);
        }*/



    }
}



