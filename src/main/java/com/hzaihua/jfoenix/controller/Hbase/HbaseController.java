package com.hzaihua.jfoenix.controller.Hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseController {
    public static Configuration conf = null;
    public static void main(String[] args) throws Exception{
        conf=HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","hbasenode47,hbasenode48,hbasenode49");//服务地址
        conf.set("hbase.zookeeper.property.clientPort","2181");//端口号
        //createTable("Leq1s_code");
        //createTable("T_USER");
        //insert("T_USER");
        queryTable("Leq1s_code");
        //queryByRowkey("T_USER","test_1111");
        //deleteByRowkey("T_USER","test_1112");
        //deleteTable("LpData_code");
    }
    /*
     * 建表
     * */
    public static void createTable(String tableName)throws Exception {
        Connection connection=ConnectionFactory.createConnection(conf);
        Admin admin=connection.getAdmin();
        System.out.println(admin);
        TableName tableName1=TableName.valueOf(tableName);
        HTableDescriptor desc=new HTableDescriptor(tableName1);
        HColumnDescriptor family=new HColumnDescriptor("info1");
        desc.addFamily(family);
        HColumnDescriptor family2=new HColumnDescriptor("info2");
        desc.addFamily(family2);
        admin.createTable(desc);

        System.out.println("...............成功...............");
    }
    /*
     *添加数据
     */
    public static void insert(String tableName)throws IOException {
        System.out.println(".............添加数据..........");
        Connection connection=ConnectionFactory.createConnection(conf);
        Table table=connection.getTable(TableName.valueOf(tableName));
        System.out.println(table);
        Put put=new Put(Bytes.toBytes("test_1112"));
        put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("name"),Bytes.toBytes("zhangsan"));
        put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("age"),Bytes.toBytes(22));
        put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("sex"),Bytes.toBytes("男"));
        put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("address"),Bytes.toBytes("北京"));
        table.put(put);
        System.out.println("...............结束...........");
    }
    /*
     * 查询
     * */
    public static void queryTable(String tableName) throws Exception{
        System.out.println("...........查询开始..............");
        Connection connection=ConnectionFactory.createConnection(conf);
        Table table=connection.getTable(TableName.valueOf(tableName));
        System.out.println(table);
        ResultScanner results=table.getScanner(new Scan());
        for (Result result : results) {
           /* byte[] name=result.getValue(Bytes.toBytes("info1"),Bytes.toBytes("name"));
            byte[] age=result.getValue(Bytes.toBytes("info1"),Bytes.toBytes("age"));
            byte[] sex=result.getValue(Bytes.toBytes("info2"),Bytes.toBytes("sex"));
            byte[] address=result.getValue(Bytes.toBytes("info2"),Bytes.toBytes("address"));
            System.out.println("value="+Bytes.toString(name)+","+Bytes.toInt(age)+","
                                +Bytes.toString(sex)+","+Bytes.toString(address));*/
            System.out.println("result="+result);
        }
        System.out.println("........查询结束........");
    }
    /*
     * 根据行键查询
     * */
    public static void queryByRowkey(String tableName,String rowkey)throws IOException{
        System.out.println("..........按行键查询..............");
        Connection connection=ConnectionFactory.createConnection();
        Table table=connection.getTable(TableName.valueOf(tableName));
        System.out.println(table);
        System.out.println(rowkey);
        Get get=new Get(rowkey.getBytes());
        Result result=table.get(get);
        System.out.println(result);
        System.out.println("......按行键查询结束...........");
    }
    /*
     * 清空表
     * */
    public static void truncatetable(String tableName)throws IOException{
        System.out.println("..........清空表..........");
        Connection connection=ConnectionFactory.createConnection();
        Admin admin=connection.getAdmin();
        TableName table=TableName.valueOf(tableName);
        admin.truncateTable(table,true);
        System.out.println("...........结束............");
    }
    /*
     * 删除表
     * */
    public static void deleteTable(String tableName)throws IOException{
        System.out.println("...............删除表................");
        Connection connection=ConnectionFactory.createConnection(conf);
        Admin admin=connection.getAdmin();
        System.out.println(admin);
        admin.disableTable(TableName.valueOf(tableName));
        admin.deleteTable(TableName.valueOf(tableName));
        System.out.println("..........结束.............");
    }
    /*
     * 删除行
     * */
    public static void deleteByRowkey(String tableName,String rowkey)throws IOException{
        System.out.println("......删除行..............");
        Connection connection=ConnectionFactory.createConnection();
        Table table=connection.getTable(TableName.valueOf(tableName));
        System.out.println(table);
        Delete delete=new Delete(Bytes.toBytes(rowkey));
        table.delete(delete);
        System.out.println(".........结束................");
    }
    /*
     * 添加列簇
     * */
    public static void addColumnFamilly(String tableName,String columnFamilly)throws IOException{
        System.out.println(".............添加列簇..........");
        TableName table=TableName.valueOf(tableName);
        Connection connection=ConnectionFactory.createConnection();
        HColumnDescriptor descriptor=new HColumnDescriptor(columnFamilly);
        Admin admin=connection.getAdmin();
        admin.addColumn(table,descriptor);
        System.out.println("...............结束...........");
    }
    /*
     * 删除列簇
     * */
    public static void deleteColumnFamilly(String tableName,String columnFamilly)throws IOException{
        System.out.println(".............删除列簇..........");
        TableName table=TableName.valueOf(tableName);
        Connection connection=ConnectionFactory.createConnection();
        Admin admin=connection.getAdmin();
        admin.deleteColumn(table,columnFamilly.getBytes());
        System.out.println("...............结束...........");
    }
}
