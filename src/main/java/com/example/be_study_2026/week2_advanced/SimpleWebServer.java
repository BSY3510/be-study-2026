package com.example.be_study_2026.week2_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 대기 중...");

        while (true) {
            try (Socket client = serverSocket.accept()) {
                System.out.println("----- 클라이언트 접속 -----");
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String line;
                while ((line = inputStream.readLine()) != null) {
                    if (line.isEmpty()) {
                        break;
                    }
                    System.out.println(line);
                }

                BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                outputStream.write("HTTP/1.1 200 OK\r\n");
                outputStream.write("Content-Type: text/html; charset=utf-8\r\n");
                outputStream.write("\r\n");
                outputStream.write("<html>Hello World! BE 학습 중입니다.</html>\r\n");
                outputStream.flush();
                System.out.println("----- 응답 전송 완료 및 연결 종료 -----");
            }
        }
    }

}
