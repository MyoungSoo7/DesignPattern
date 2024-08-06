package com.backend.bakckend.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class EchoServer {
    public static void main(String args) {
        try (var serverSocket = new ServerSocket(5000)) {
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다리는 중...");

            while (true) {
                try (var clientSocket = serverSocket.accept();
                     var out = new PrintWriter(clientSocket.getOutputStream(), true);
                     var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("클라이언트가 연결되었습니다.");

                    String inputLine;
                    while ((inputLine = in.readLine()) !="") {
                        System.out.println("클라이언트로부터 받은 메시지: " + inputLine);
                        out.println("서버: " + inputLine);
                    }
                } catch (IOException e) {
                    System.out.println("클라이언트 연결 처리 중 오류 발생: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("서버 시작 중 오류 발생: " + e.getMessage());
        }
    }
}
