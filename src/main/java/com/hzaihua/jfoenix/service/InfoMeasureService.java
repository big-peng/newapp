package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InfoMeasureDao;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class InfoMeasureService {
    @Resource
    private InfoMeasureDao infoMeasureDao;

    /**
     * 查询所有未分配测点信息
     * */
    public ObservableList<InfoMeasure> queryUndistributeMeasure(){
        ObservableList<InfoMeasure> result = FXCollections.observableArrayList();
        result.setAll(infoMeasureDao.queryAllUndisMeasure());
        return result;
    }
}
