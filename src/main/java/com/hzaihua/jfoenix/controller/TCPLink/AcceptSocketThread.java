package com.hzaihua.jfoenix.controller.TCPLink;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptSocketThread implements Runnable{
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("服务端已启动，等待客户端连接..");
            Socket socket = serverSocket.accept();
            AcceptThread acceptThread = new AcceptThread(socket);
            acceptThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
