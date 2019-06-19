package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.StaCode;

import java.util.Date;
import java.util.List;

public interface StaCodeDao {
    /**
     * 添加一条统计数据
     * */
    void insertStaCode(StaCode staCode);

    /**
     * 根据时间段查询统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<StaCode> queryStaByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备在某个时间段的统计数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<StaCode> queryStaByCodeAndTime(String noiseCode,Date startTime,Date endTime);
}
