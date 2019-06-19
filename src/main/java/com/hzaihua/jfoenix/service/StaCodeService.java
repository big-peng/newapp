package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.StaCodeDao;
import com.hzaihua.jfoenix.entity.StaCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StaCodeService {
    @Resource
    private StaCodeDao staCodeDao;
    /**
     * 添加一条统计数据
     * */
    public void saveStaCode(StaCode staCode){
        staCodeDao.insertStaCode(staCode);
    }

    /**
     * 根据时间段查询统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<StaCode> queryStaByTime(Date startTime,Date endTime){
        ObservableList<StaCode> result = FXCollections.observableArrayList();
        result.setAll(staCodeDao.queryStaByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询时间段数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<StaCode> queryStaByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<StaCode> result = FXCollections.observableArrayList();
        result.setAll(staCodeDao.queryStaByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }
}
