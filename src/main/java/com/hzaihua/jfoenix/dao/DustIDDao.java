package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.DustID;

import java.util.List;

public interface DustIDDao {
    /**
     * 该接口可以根据时间范围来查询某个设备在这一个时间范围内的数据变化
     * 在实现的时候可以通过调用该接口的Service层通过时间范围进行推算需要去哪几张表中查询，并将结果合并到一个集合中
     * @param tableName 查询的月份所在的表，该表名可以通过获取表名的工具类得到
     * @param startTime 范围开始的时间，可以使用字符串，也可以使用Date对象，也可以是时间戳
     * @param endTime 范围结束的时间
     * @return 返回值为测量时间在这一个范围内的List数据集合，返回到前端可以使用ECharts进行可视化处理
     */
    public List<DustID> queryByUnitTime(String tableName,String startTime,String endTime);

    /**
     * 创建表的接口，如果通过调用查询表名接口发现当前数据库没有当前要插入数据的接口，就通过该接口新建一个数据表
     * @param tableName 以月份为单位的表名，格式为Dust_ID_201902，通过获取表名的工具类得到
     * @return 返回是否创建成功
     */
    public boolean createYearMonthTable(String tableName);

    /**
     * 插入新数据的接口，根据传入的表名进行数据的插入
     * @param tableName 以月份为单位的表名，格式为Dust_ID_201902，通过获取表名的工具类得到
     * @param dustID 要插入的数据对象，主键为时间
     * @return 返回是否插入成功
     */
    public boolean insertDataByTableName(String tableName,DustID dustID);

    /**
     * 使用该接口查询数据库中是否含有该数据表
     * @param tableName 要查询的表名
     * @return 没有该表返回null，有则返回该表名
     */
    public String queryTableName(String tableName);
}
