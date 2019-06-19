package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.WeatherLP;

import java.util.Date;
import java.util.List;

public interface WeatherLPDao {

    /**
     * 查询全部气象数据
     * */
    List<WeatherLP> queryAll();
    /**
     * 添加一条瞬时气象数据
     * */
    void insertWeather(WeatherLP weatherLP);

    /**
     * 根据时间段查询瞬时数据记录
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<WeatherLP> queryWeaLPByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备的某个时间段的瞬时数据记录
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<WeatherLP> queryWeaLPByCodeAndTime(String noiseCode,Date startTime,Date endTime);
}
