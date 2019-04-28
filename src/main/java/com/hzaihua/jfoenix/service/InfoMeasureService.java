package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InfoMeasureDao;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.UserToMeasure;
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
    public ObservableList<InfoMeasure> queryAllMeasure(){
        ObservableList<InfoMeasure> result = FXCollections.observableArrayList();
        result.setAll(infoMeasureDao.queryAll());
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
     * 根据measureCode查询需要修改的测点属性
     * */
    public ObservableList<InfoMeasure> queryByUserName(String userName){
        ObservableList<InfoMeasure> result = FXCollections.observableArrayList();
        result.setAll(infoMeasureDao.queryByUserName(userName));
        return result;
    }


}
