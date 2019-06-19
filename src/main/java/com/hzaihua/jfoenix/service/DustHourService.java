package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.DustHourDao;
import com.hzaihua.jfoenix.entity.DustHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DustHourService {
    @Resource
    private DustHourDao dustHourDao;

    /**
     * 添加天统计粉尘数据
     * @DustHour 传入一个dustHour对象
     * */
    public void saveDustHour(DustHour dustHour){
        dustHourDao.insertDustHour(dustHour);
    }

    /**
     * 查询全部小时统计粉尘数据
     * */
    public ObservableList<DustHour> queryAllDustHour(){
        ObservableList<DustHour> result = FXCollections.observableArrayList();
        result.setAll(dustHourDao.queryAllDustHour());
        return result;
    }

    /**
     * 根据时间段查询所有小时统计粉尘数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<DustHour> queryDustHourByTime(Date startTime,Date endTime){
        ObservableList<DustHour> result = FXCollections.observableArrayList();
        result.setAll(dustHourDao.queryDustHourByTime(startTime,endTime));
        return result;
    }

    /**
     * 根据时间段、设备编号查询该设备在改时间段的小时统计粉尘数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<DustHour> querydustHourByTimeAndCode(String noiseCode,Date startTime,Date endTime){
        ObservableList<DustHour> result = FXCollections.observableArrayList();
        result.setAll(dustHourDao.queryDustHourByTimeAndCode(noiseCode, startTime, endTime));
        return  result;
    }
}
