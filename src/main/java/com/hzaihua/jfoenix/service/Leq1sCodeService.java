package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.Leq1SCodeDao;
import com.hzaihua.jfoenix.entity.Leq1SCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class Leq1sCodeService {
    @Resource
    private Leq1SCodeDao leq1SCodeDao;

    /**
     * 添加瞬时数据
     * */
    public void saveLeq1sCode(Leq1SCode leq1SCode){
        leq1SCodeDao.insertLeq1SCode(leq1SCode);
    }

    /**
     * 根据时间段查询瞬时数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<Leq1SCode> queryLeq1SByTime(Date startTime, Date endTime){
        ObservableList<Leq1SCode> result = FXCollections.observableArrayList();
        result.setAll(leq1SCodeDao.queryLeq1sByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据设备编号查询该设备在某个时间段的数据
     * */
    public ObservableList<Leq1SCode> queryLeq1sCodeByCodeAndTime(String noiseCode,Date startTime,Date endTime){
        ObservableList<Leq1SCode> result = FXCollections.observableArrayList();
        result.setAll(leq1SCodeDao.queryleq1sByCodeAndTime(noiseCode, startTime, endTime));
        return result;
    }
}
