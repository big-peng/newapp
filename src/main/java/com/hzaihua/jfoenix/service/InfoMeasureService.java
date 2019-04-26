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

    /**
     * 添加测点信息
     * */
    public void saveMeasure(InfoMeasure infoMeasure){
        infoMeasureDao.insertInfoMeasure(infoMeasure);
    }

    /**
     * 根据measureCode查询需要修改的测点属性
     * */
    public InfoMeasure queryByMeasureCode(String measureCode){
        return infoMeasureDao.queryByMeasureCode(measureCode);
    }

    /**
     * 修改所属用户名称属性
     * */
    public void updateMeasureUser(InfoMeasure infoMeasure){
        infoMeasureDao.updateMeasureUserName(infoMeasure);
    }
}
