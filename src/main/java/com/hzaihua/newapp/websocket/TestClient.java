package com.hzaihua.newapp.websocket;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class TestClient{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.0.159", 6001);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("服务端你好，我是客户1...");
            printWriter.flush();
            socket.shutdownOutput();
            while (true) {
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String temp = null;
                String info = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    info += new String(temp);
                    System.out.println("客户端接收服务端发送信息：" + info);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
