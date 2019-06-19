package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.HourStaCodeDao;
import com.hzaihua.jfoenix.entity.HourStaCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class HourStaCodeService {
    @Resource
    private HourStaCodeDao hourStaCodeDao;

    /**
     * 添加一条小时统计数据
     * */
    public void saveHourStaCode(HourStaCode hourStaCode){
        hourStaCodeDao.insertHourStaCode(hourStaCode);
    }

    /**
     * 根据时间段查询小时统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<HourStaCode> queryHourStaCodeByTime(Date startTime,Date endTime){
        ObservableList<HourStaCode> result = FXCollections.observableArrayList();
        result.setAll(hourStaCodeDao.queryHourStaCodeByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段的小时统计数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<HourStaCode> queryHourStaCodeByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<HourStaCode> result = FXCollections.observableArrayList();
        result.setAll(hourStaCodeDao.queryHourStaCodeByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }
}
