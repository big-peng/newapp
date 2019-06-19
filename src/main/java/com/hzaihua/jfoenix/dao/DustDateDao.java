package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.DustDate;

import java.util.Date;
import java.util.List;

public interface DustDateDao {
    /**
     * 添加一个天统计粉尘数据
     * */
    void insertDustDate(DustDate dustDate);
    /**
     * 查询所有天统计粉尘数据
     * */
    List<DustDate> queryAllDustDate();

    /**
     * 根据时间段查询该时间段内所有天统计粉尘数据
     * @startTime 开始时间
     * @endTime  结束时间
     * */
    List<DustDate> queryDustDateByTime(Date startTime,Date endTime);

    /**
     * 根据时间段、设备编号查询该设备在该时间段内所有的天统计粉尘数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<DustDate> queryDustDateByTimeAndCode(String noiseCode,Date startTime,Date endTime);
}
