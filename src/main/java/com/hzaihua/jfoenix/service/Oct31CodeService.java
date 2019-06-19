package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.Oct31CodeDao;
import com.hzaihua.jfoenix.entity.Oct31Code;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class Oct31CodeService {
    @Resource
    private Oct31CodeDao oct31CodeDao;

    /**
     * 添加一条天统计数据
     * */
    public void saveOct31Code(Oct31Code oct31Code){
        oct31CodeDao.insertOct31Code(oct31Code);
    }

    /**
     * 根据时间段查询数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<Oct31Code> queryOct31CodeByTime(Date startTime,Date endTime){
        ObservableList<Oct31Code> result = FXCollections.observableArrayList();
        result.setAll(oct31CodeDao.queryOct31CodeByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段中的数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<Oct31Code> queryOct31CodeByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<Oct31Code> result = FXCollections.observableArrayList();
        result.setAll(oct31CodeDao.queryOct31CodeByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }

    /**
     * 查询全部oct数据
     * */
    public ObservableList<Oct31Code> queryAllOct31Code() {
        ObservableList<Oct31Code> result = FXCollections.observableArrayList();
        result.setAll(oct31CodeDao.queryOct31Code());
        return result;
    }
}
