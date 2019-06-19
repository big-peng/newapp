package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.HourStaCode;

import java.util.Date;
import java.util.List;

public interface HourStaCodeDao {
    /**
     * 添加一条小时统计数据
     * */
    void insertHourStaCode(HourStaCode hourStaCode);

    /**
     * 根据时间段查询小时统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<HourStaCode> queryHourStaCodeByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备的某个时间段的数据
     * @noisecode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<HourStaCode> queryHourStaCodeByCodeAndTime(String noiseCode,Date startTime,Date endTime);
}
