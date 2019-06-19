package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.DateStaCode;

import java.util.Date;
import java.util.List;

public interface DateStaCodeDao {
    /**
     * 添加一条天统计数据
     * */
    void insertDateStaCode(DateStaCode dateStaCode);

    /**
     * 根据时间段查询统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<DateStaCode> queryDateStaCodeByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备在某个时间段的统计数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<DateStaCode> queryDateStaCodeByCodeAndTime(String noiseCode,Date startTime,Date endTime);
}
