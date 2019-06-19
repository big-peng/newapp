package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.WeatherHourDao;
import com.hzaihua.jfoenix.entity.WeatherHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class WeatherHourService {
    @Resource
    private WeatherHourDao weatherHourDao;

    /**
     * 添加一条小时统计气象数据
     * */
    public void saveWeatherHour(WeatherHour weaTherHour){
        weatherHourDao.insertWeatherHour(weaTherHour);
    }

    /**
     * 根据时间段查询小时统计气象数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<WeatherHour> queryWeaHourByTime(Date startTime,Date endTime){
        ObservableList<WeatherHour> result = FXCollections.observableArrayList();
        result.setAll(weatherHourDao.queryWeaHourByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段的小时统计气象数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<WeatherHour> queryWeaHourByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<WeatherHour> result = FXCollections.observableArrayList();
        result.setAll(weatherHourDao.queryWeaHourByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }

    public ObservableList<WeatherHour> queryAllWeaHour() {
        ObservableList<WeatherHour> result = FXCollections.observableArrayList();
        result.setAll(weatherHourDao.queryAllWeaHour());
        return result;
    }
}
