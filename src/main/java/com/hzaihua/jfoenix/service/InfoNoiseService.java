package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InfoNoiseDeviceDao;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoNoiseService {
    @Resource
    private InfoNoiseDeviceDao infoNoiseDeviceDao;

    /**
     * 查询全部设备
     * */
    public ObservableList<InfoNoiseDevice> queryAllNoise(){
        ObservableList<InfoNoiseDevice> result = FXCollections.observableArrayList();
        result.setAll(infoNoiseDeviceDao.queryAll());
        return result;
    }

    /**
     * 添加设备接口
     * */
    public void saveInfoNoiseDevice(InfoNoiseDevice infoNoiseDevice){
        infoNoiseDeviceDao.insertNoiseDevice(infoNoiseDevice);
    }

    /**
     * 根据deviceCode查询，判断设备编号是否已存在
     * */
    public InfoNoiseDevice queryByNoiseCode(String deviceCode){
        return infoNoiseDeviceDao.queryByNoiseDeviceCode(deviceCode);
    }

    /**
     *  根据测点编号查询该测点下的所有设备
     * */
    public ObservableList<InfoNoiseDevice> queryByMeasureCode(String measureCode){
        ObservableList<InfoNoiseDevice> result = FXCollections.observableArrayList();
        result.setAll(infoNoiseDeviceDao.queryByMeasureCode(measureCode));
        return result;
    }
}
