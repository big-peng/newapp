package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.CarFlowHourDao;
import com.hzaihua.jfoenix.entity.CarFlowHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CarFlowHourService {
    @Resource
    private CarFlowHourDao carFlowHourDao;

    /**
     * 添加一条小时统计车流量数据
     * */
    public void saveCarFlowHour(CarFlowHour carFlowHour){
        carFlowHourDao.insertCarFlowHour(carFlowHour);
    }

    /**
     * 根据时间段查询小时统计车流量数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<CarFlowHour> queryCarFlowByTime(Date startTime,Date endTime){
        ObservableList<CarFlowHour> result = FXCollections.observableArrayList();
        result.setAll(carFlowHourDao.queryCarFlowByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询设备在耨个时间段的小时统计车流量数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<CarFlowHour> queryCarFlowHourByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<CarFlowHour> result = FXCollections.observableArrayList();
        result.setAll(carFlowHourDao.queryCarFlowByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }

    public ObservableList<CarFlowHour> queryAllCarHour() {
        ObservableList<CarFlowHour> result = FXCollections.observableArrayList();
        result.setAll(carFlowHourDao.queryAllCarHour());
        return result;
    }
}
