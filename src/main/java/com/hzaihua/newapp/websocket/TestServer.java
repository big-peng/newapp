package com.hzaihua.newapp.websocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TestServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6001);
            System.out.println("服务器端已启动，等待客户端连接...");
            Socket socket = ss.accept();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader buf = new BufferedReader(inputStreamReader);
            String temp = null;
            String info = "";
            while ((temp=buf.readLine()) != null){
                info+=temp;
                System.out.println("服务端已接收到客户端连接...");
                System.out.println("服务端接收到客户端信息："+info+",当前客户端ip为："+socket.getInetAddress().getHostAddress());
            }
            OutputStream os = socket.getOutputStream();
            PrintWriter ps = new PrintWriter(os);
            ps.print("已接收到客户端的信息...");
            ps.flush();
            socket.shutdownOutput();

            ps.close();
            os.close();
            buf.close();
            inputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
