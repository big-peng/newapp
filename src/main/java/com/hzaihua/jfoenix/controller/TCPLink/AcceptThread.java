package com.hzaihua.jfoenix.controller.TCPLink;

import java.io.*;
import java.net.Socket;

public class AcceptThread extends Thread {
    private Socket socket;

    public AcceptThread(Socket socket) {
        this.socket = socket;
    }


    /*public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            char[] c = new char[1024];

            while ( bufferedReader.read(c,0,1024) > 0) {
                String s = new String(c);
                    String flag = getCode(s,"Flag");
                    System.out.println("服务端接收到客户端信息：" + flag + ",当前客户端ip为："
                            + socket.getInetAddress().getHostAddress());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getCode(String pack,String node){
        String temp = ("<"+node+">");
        int beginPos = pack.indexOf(temp,0);
        String endTemp = "</"+node+">";
        int endPos = pack.indexOf(endTemp,0);
        if(beginPos != -1 && endPos != -1){
            return pack.substring(beginPos+temp.length()+1,endPos-1);
        }
        return null;
    }*/

    /*private String getRtn(String pack,String rtn){
        String temp = ("<"+rtn+">");
        int beginPos = pack.indexOf(temp,0);
        String endTemp = ("</"+rtn+">");
        int endPos = pack.indexOf(endTemp,0);
        if(beginPos != -1 && endPos != -1){
            return pack.substring(beginPos+temp.length()+1,endPos-1);
        }
        return null;
    }*/
}
