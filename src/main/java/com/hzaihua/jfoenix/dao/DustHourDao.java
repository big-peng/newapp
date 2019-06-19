package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.DustHour;

import java.util.Date;
import java.util.List;

public interface DustHourDao {
    /**
     * 查询全部小时统计粉尘数据
     * */
    List<DustHour> queryAllDustHour();

    /**
     * 添加小时统计粉尘数据
     * @需要传入一个DustHour对象
     * */
    void insertDustHour(DustHour dustHour);

    /**
     * 根据时间段查询该时间时间段所有小时统计粉尘数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<DustHour> queryDustHourByTime(Date startTime,Date endTime);

    /**
     * 根据时间段、设备编号查询该仪器在该时间段的小时统计粉尘数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<DustHour> queryDustHourByTimeAndCode(String noiseCode,Date startTime,Date endTime);
}
