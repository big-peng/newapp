package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.CarFlowHour;

import java.util.Date;
import java.util.List;

public interface CarFlowHourDao {
    /**
     * 添加一条小时统计车流量数据
     * */
    void insertCarFlowHour(CarFlowHour carFlowHour);

    /**
     *根据时间段查询小时统计车流量数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<CarFlowHour> queryCarFlowByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备某个时间段的小时统计车流量数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<CarFlowHour> queryCarFlowByCodeAndTime(String noiseCode,Date startTime,Date endTime);

    CarFlowHour queryAllCarHour();
}
