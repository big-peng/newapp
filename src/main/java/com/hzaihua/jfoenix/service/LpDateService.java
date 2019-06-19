package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.LpDateCodeDao;
import com.hzaihua.jfoenix.entity.LpDateCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LpDateService {
    @Resource
    private LpDateCodeDao lpDateCodeDao;

    /**
     * 添加开关量存储的数据,平均每秒存一次
     * */
    public void saveLpDateCode(LpDateCode lpDateCode){
        lpDateCodeDao.insertLpDateCode(lpDateCode);
    }

    /**
     * 根据时间段查询开关量数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<LpDateCode> queryLpDateByTime(Date startTime,Date endTime){
        ObservableList<LpDateCode> result = FXCollections.observableArrayList();
        result.setAll(lpDateCodeDao.queryLpDateByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段的开关量数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<LpDateCode> queryLpDateByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<LpDateCode> result = FXCollections.observableArrayList();
        result.setAll(lpDateCodeDao.queryLpDateByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }
}
