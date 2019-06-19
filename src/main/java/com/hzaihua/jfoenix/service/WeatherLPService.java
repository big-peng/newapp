package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.WeatherLPDao;
import com.hzaihua.jfoenix.entity.WeatherLP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class WeatherLPService {
    @Resource
    private WeatherLPDao weatherLPDao;

    /**
     * 查询所有气象数据
     * */
    public ObservableList<WeatherLP> queryAll(){
        ObservableList<WeatherLP> result = FXCollections.observableArrayList();
        result.setAll(weatherLPDao.queryAll());
        return result;
    }
    /**
     *添加一条瞬时气象数据
     */
    public void saveWeatherLP(WeatherLP weatherLP){
        weatherLPDao.insertWeather(weatherLP);
    }

    /**
     * 根据时间段查询瞬时数据记录
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<WeatherLP> queryWeaLpByTime(Date startTime,Date endTime){
        ObservableList<WeatherLP> result = FXCollections.observableArrayList();
        result.setAll(weatherLPDao.queryWeaLPByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备的某个时间段的瞬时数据记录
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<WeatherLP> queryWeaLpByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<WeatherLP> result = FXCollections.observableArrayList();
        result.setAll(weatherLPDao.queryWeaLPByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }
}
