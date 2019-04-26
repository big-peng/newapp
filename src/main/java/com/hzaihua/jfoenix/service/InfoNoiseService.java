package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InfoNoiseDeviceDao;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InfoNoiseService {
    @Resource
    private InfoNoiseDeviceDao infoNoiseDeviceDao;

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
}
