package com.hzaihua.jfoenix.controller.TCPLink;

import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.controller.measure.AddFixedMeasureController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SendingSocketThread implements Runnable{
    public static int port;
    @Override
    public void run() {

        try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("服务端已启动，等待客户端连接..");

                while (true){
                    Socket socket = serverSocket.accept();
                    SendingThread sendingThread = new SendingThread(socket);
                    sendingThread.start();
                    System.out.println("已接收到客户端连接");
                    System.out.println("输入指令编号:");
                }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
