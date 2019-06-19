package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.WeatherDate;

import java.util.Date;
import java.util.List;

public interface WeatherDateDao {
    /**
     * 添加一条天统计气象数据
     * */
    void insertWeatherDate(WeatherDate weatherDate);

    /**
     * 根据时间段查询天统计气象数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<WeatherDate> queryWeatherByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备在某个时间段的天统计气象数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<WeatherDate> queryWeatherByCodeAndTime(String noiseCode,Date startTime,Date endTime);

    WeatherDate queryAllWeaDate();
}
