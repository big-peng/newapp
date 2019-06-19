package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.CarFlowLPDao;
import com.hzaihua.jfoenix.entity.CarFlowLP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CarFlowLPService {
    @Resource
    private CarFlowLPDao carFlowLPDao;

    /**
     * 查询全部车流量数据
     * */
    public ObservableList<CarFlowLP> queryAllCar(){
        ObservableList<CarFlowLP> result = FXCollections.observableArrayList();
        result.setAll(carFlowLPDao.queryAllCarFlow());
        return result;
    }
    /**
     * 添加一条瞬时车流量数据
     * */
    public void saveCarFlow(CarFlowLP carFlowLP){
        carFlowLPDao.insertCarFlow(carFlowLP);
    }

    /**
     *查询全部车流量数据
     * */
    public ObservableList<CarFlowLP> queryAllCarFlow(){
        ObservableList<CarFlowLP> result = FXCollections.observableArrayList();
        result.setAll(carFlowLPDao.queryAllCarFlow());
        return result;
    }

    /**
     *根据时间段查询车流量数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<CarFlowLP> queryCarFlowByTime(Date startTime,Date endTime){
        ObservableList<CarFlowLP> result = FXCollections.observableArrayList();
        result.setAll(carFlowLPDao.queryAllCarFlowByTime(startTime, endTime));
        return result;
    }

    /**
     * 根据时间段、设备编号查询该设备在该时间段的所有数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    public ObservableList<CarFlowLP> queryCarFlowByTimeAndCode(String noiseCode,Date startTime,Date endTime){
        ObservableList<CarFlowLP> result = FXCollections.observableArrayList();
        result.setAll(carFlowLPDao.queryCarFlowByTimeAndCode(noiseCode, startTime, endTime));
        return result;
    }
}
