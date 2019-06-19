package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.Oct31Code;

import java.util.Date;
import java.util.List;

public interface Oct31CodeDao {
    /**
     * 添加一条天统计的中心频率数据
     * */
    void insertOct31Code(Oct31Code oct31Code);

    /**
     * 根据时间段查询数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<Oct31Code> queryOct31CodeByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询时间段数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<Oct31Code> queryOct31CodeByCodeAndTime(String noiseCode,Date startTime,Date endTime);

    /**
     * 查询全部OCT31Code数据
     * */
    Oct31Code queryOct31Code();
}
