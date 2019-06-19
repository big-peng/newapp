package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.DateStaCodeDao;
import com.hzaihua.jfoenix.entity.DateStaCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DateStaCodeService {
    @Resource
    private DateStaCodeDao dateStaCodeDao;

    /**
     * 添加一条天统计数据
     * */
    public void saveDateStaCode(DateStaCode dateStaCode){
        dateStaCodeDao.insertDateStaCode(dateStaCode);
    }

    /**
     * 根据时间段查询统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<DateStaCode> queryDateStaCodeByTime(Date startTime, Date endTime){
        ObservableList<DateStaCode> result = FXCollections.observableArrayList();
        result.setAll(dateStaCodeDao.queryDateStaCodeByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在牧歌时间段的统计数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<DateStaCode> queryDateStaCodeByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<DateStaCode> result = FXCollections.observableArrayList();
        result.setAll(dateStaCodeDao.queryDateStaCodeByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }
}
