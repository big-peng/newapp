package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.WeatherDateDao;
import com.hzaihua.jfoenix.entity.WeatherDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class WeatherDateService {
    @Resource
    private WeatherDateDao weatherDateDao;

    /**
     * 添加一个天统计气象数据
     * */
    public void saveWeatherDate(WeatherDate weatherDate){
        weatherDateDao.insertWeatherDate(weatherDate);
    }

    /**
     * 根据时间段查询天统计气象数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<WeatherDate> queryWeaByTime(Date startTime,Date endTime){
        ObservableList<WeatherDate> result = FXCollections.observableArrayList();
        result.setAll(weatherDateDao.queryWeatherByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段的天统计气象数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<WeatherDate> queryWeaByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<WeatherDate> result = FXCollections.observableArrayList();
        result.setAll(weatherDateDao.queryWeatherByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }

    public ObservableList<WeatherDate> queryAllWeaDate() {
        ObservableList<WeatherDate> result = FXCollections.observableArrayList();
        result.setAll(weatherDateDao.queryAllWeaDate());
        return result;
    }
}
