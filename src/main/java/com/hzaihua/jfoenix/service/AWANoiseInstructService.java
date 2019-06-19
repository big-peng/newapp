package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.AWANoiseInstructDao;
import com.hzaihua.jfoenix.entity.AWANoiseInstruct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AWANoiseInstructService {

    @Resource
    private AWANoiseInstructDao awaNoiseInstructDao;

    /**
     * 添加设备指令
     * */
    public void saveNoiseInstruct(AWANoiseInstruct awaNoiseInstruct){
        awaNoiseInstructDao.insertNoiseInstruct(awaNoiseInstruct);
    }

    /**
     * 查询设备指令
     **/
    public ObservableList<AWANoiseInstruct> queryAllNoiseInstruct(){
        ObservableList<AWANoiseInstruct> result = FXCollections.observableArrayList();
        result.setAll(awaNoiseInstructDao.queryAllNoiseInstruct());
        return result;
    }

    /**
     * 根据设备编号查询设备指令
     * */
    public ObservableList<AWANoiseInstruct> queryNoiseInstructByNoiseCode(String noiseCode){
        ObservableList<AWANoiseInstruct> result = FXCollections.observableArrayList();
        result.setAll(awaNoiseInstructDao.queryNosieInstructByNoiceCode(noiseCode));
        return result;
    }
}
