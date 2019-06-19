package com.hzaihua.jfoenix.dao;


import com.hzaihua.jfoenix.entity.DustLP;

import java.util.Date;
import java.util.List;

public interface DustLPDao {
    /**
     * 查询所有粉尘瞬时数据，放到一个list集合中
     * @除了当前一秒之外，都是历史数据
     * */
    List<DustLP> queryAllDustLP();

    /**
     * 添加粉尘瞬时数据到数据库中
     * */
    void insertDustLP(DustLP dustLP);

    /**
     * 根据时间段查询瞬时粉尘数据，放到一个list集合中
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<DustLP> queryByTime(Date startTime,Date endTime);
}
