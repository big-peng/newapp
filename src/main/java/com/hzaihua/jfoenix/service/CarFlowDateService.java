package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.CarFlowDateDao;
import com.hzaihua.jfoenix.entity.CarFlowDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CarFlowDateService {
    @Resource
    private CarFlowDateDao carFlowDateDao;

    /**
     * 添加一条天统计车流量数据
     * */
    public void saveCarFlowDate(CarFlowDate carFlowDate){
        carFlowDateDao.insertCarFlowDate(carFlowDate);
    }

    /**
     * 根据时间段查询车流量数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<CarFlowDate> queryByTime(Date startTime,Date endTime){
        ObservableList<CarFlowDate> result = FXCollections.observableArrayList();
        result.setAll(carFlowDateDao.queryAllByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备某个时间段的数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */

    public ObservableList<CarFlowDate> queryByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<CarFlowDate> result = FXCollections.observableArrayList();
        result.setAll(carFlowDateDao.queryByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }

    public ObservableList<CarFlowDate> queryAllCarDate() {
        ObservableList<CarFlowDate> result = FXCollections.observableArrayList();
        result.setAll(carFlowDateDao.queryAllCarDate());
        return result;
    }
}
