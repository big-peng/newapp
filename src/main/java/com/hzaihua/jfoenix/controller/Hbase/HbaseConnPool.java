package com.hzaihua.jfoenix.controller.Hbase;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class HbaseConnPool {
    private static Connection conn = null;
    private static void createConn(){
        String ip = "hbasenode47,hbasenode48,hbasenode49";
        String port = "2181";
        try {
            System.out.println("创建Conn连接开始........");
            long start=System.currentTimeMillis();
            Configuration conf= HBaseConfiguration.create();
            conf.set("hbase.zookeeper.quorum",ip);
            conf.set("hbase.zookeeper.property.clientPort",port);
            conn= ConnectionFactory.createConnection(conf);
            long end=System.currentTimeMillis();
            System.out.println("创建耗时="+(end-start)+"s......");
            System.out.println("创建结束...............");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        if (conn==null){
            synchronized (HbaseConnPool.class){
                System.out.println("没有就开始创建.............");
                createConn();
            }
        }
        System.out.println("conn="+conn);
        return conn;
    }
}
