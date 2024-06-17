package com.backend.bakckend.javaversion.version8;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Arrays;

public class StreamTest {


    public static void main(String[] args) throws Exception {
        // 파일/버퍼 스트림
        //fileInputStream();
        // byte 배열 스트림
        byteArrayInputStream();
    }

    private static void byteArrayInputStream() {
        byte[] inSrc = {1, 2, 3, 4, 5};
        byte[] outSrc = null;

        ByteArrayInputStream input =null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        int data =0;

        while( (data = input.read()) != -1){
            output.write(data);
        }

        outSrc = output.toByteArray();

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }


    private static void fileInputStream() throws Exception {
        FileInputStream fis = new FileInputStream("src/main/java/com/backend/bakckend/javaversion/version8/test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        System.out.println(bis.read());
        //bis.read();
    }



}
