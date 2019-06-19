package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.CarFlowDate;

import java.util.Date;
import java.util.List;

public interface CarFlowDateDao {
    /**
     * 添加一条天统计车流量数据
     * */
    void insertCarFlowDate(CarFlowDate carFlowDate);

    /**
     * 根据时间段查询数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<CarFlowDate> queryAllByTime(Date startTime,Date endTime);

    /**
     * 根据时间段查询某个设备在某个时间段的数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<CarFlowDate> queryByCodeAndTime(String noiseCode,Date startTime,Date endTime);

    CarFlowDate queryAllCarDate();
}
