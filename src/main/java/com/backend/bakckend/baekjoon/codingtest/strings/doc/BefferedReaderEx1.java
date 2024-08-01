package com.backend.bakckend.baekjoon.codingtest.strings.doc;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class BefferedReaderEx1 {
    public static String getHtml(String url) throws IOException{
        URL targetUrl = new URL(url);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream()))){
            StringBuffer html = new StringBuffer();
            String tmp;

            while((tmp = reader.readLine()) != null){
                html.append(tmp);
            }
            return html.toString();
        }
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("input.txt"));
              PrintWriter writer = new PrintWriter(new File("output.txt"))){
            while(scanner.hasNext()){
                writer.println(scanner.nextLine());
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
