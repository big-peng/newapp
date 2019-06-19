package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.WeatherHour;

import java.util.Date;
import java.util.List;

public interface WeatherHourDao {
    /**
     * 添加一条小时统计气象数据
     * */
    void insertWeatherHour(WeatherHour weaTherHour);

    /**
     * 根据时间段查询小时统计气象数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<WeatherHour> queryWeaHourByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备在某个时间段的小时统计气象数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<WeatherHour> queryWeaHourByCodeAndTime(String noiseCode,Date startTime,Date endTime);

    WeatherHour queryAllWeaHour();
}
