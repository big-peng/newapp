package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.DustDateDao;
import com.hzaihua.jfoenix.entity.DustDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DustDateService {
    @Resource
    private DustDateDao dustDateDao;

    /**
     * 添加天统计粉尘数据
     * */
    public void saveDustDate(DustDate dustDate){
        dustDateDao.insertDustDate(dustDate);
    }

    /**
     * 查询全部天统计粉尘数据
     * */
    public ObservableList<DustDate> queryAllDustDate(){
        ObservableList<DustDate> result = FXCollections.observableArrayList();
        result.setAll(dustDateDao.queryAllDustDate());
        return result;
    }

    /**
     * 根据时间段查询所有天统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<DustDate> queryDustDateByTime(Date startTime,Date endTime){
        ObservableList<DustDate> result = FXCollections.observableArrayList();
        result.setAll(dustDateDao.queryDustDateByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据时间段、设备编号查询该设备在该时间段的所有天统计粉尘数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<DustDate> queryDustDateByTimeAndCode(String noiseCode,Date startTime,Date endTime){
        ObservableList<DustDate> result = FXCollections.observableArrayList();
        result.setAll(dustDateDao.queryDustDateByTimeAndCode(noiseCode, startTime, endTime));
        return result;
    }
}
