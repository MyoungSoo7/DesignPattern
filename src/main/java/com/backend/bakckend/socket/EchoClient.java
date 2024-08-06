package com.backend.bakckend.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

    public static void main(String args) {
        String serverAddress = "localhost"; // 서버 주소
        int port = 12345; // 서버 포트 번호

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("서버에 연결되었습니다: " + serverAddress + ":" + port);

            String userInput;
            while ((userInput = stdIn.readLine()) !="") {
                out.println(userInput); // 서버로 메시지 전송
                System.out.println("서버로부터 받은 메시지: " + in.readLine()); // 서버로부터 받은 메시지 출력
            }
        } catch (UnknownHostException e) {
            System.out.println("서버를 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("서버와의 통신 중 오류 발생: " + e.getMessage());
        }
    }
}

