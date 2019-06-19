package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.OctCodeDao;
import com.hzaihua.jfoenix.entity.OctCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OctCodeService {
    @Resource
    private OctCodeDao octCodeDao;

    /**
     * 添加一条月统计数据
     * */
    public void saveOctCode(OctCode octCode){
        octCodeDao.insertOctCode(octCode);
    }

    /**
     * 根据时间段查询月统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<OctCode> queryOctByTime(Date startTime,Date endTime){
        ObservableList<OctCode> result = FXCollections.observableArrayList();
        result.setAll(octCodeDao.queryOctByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段的月统计数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<OctCode> queryOctByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<OctCode> result = FXCollections.observableArrayList();
        result.setAll(octCodeDao.queryOctByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }

    public ObservableList<OctCode> queryAllOct() {
        ObservableList<OctCode> result = FXCollections.observableArrayList();
        result.setAll(octCodeDao.queryAllOct());
        return result;
    }
}
