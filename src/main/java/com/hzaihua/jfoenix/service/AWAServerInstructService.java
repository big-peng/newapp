package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.AWAServerInstructDao;
import com.hzaihua.jfoenix.entity.AWAServerInstruct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AWAServerInstructService {

    @Resource
    private AWAServerInstructDao awaServerInstructDao;

    /**
     * 添加服务器指令
     * */
    public void saveServerInstruct(AWAServerInstruct awaServerInstruct){
        awaServerInstructDao.insertServerInstruct(awaServerInstruct);
    }

    /**
     * 查询所有服务器指令
     * */
    public ObservableList<AWAServerInstruct> queryAllServiceInstruct(){
        ObservableList<AWAServerInstruct> result = FXCollections.observableArrayList();
        result.setAll(awaServerInstructDao.queryAllServerInstruct());
        return result;
    }

    /**
     * 根据设备类型查询服务器指令
     * */
    public ObservableList<AWAServerInstruct> queryServerInstructByDeiceType(String deviceType){
        ObservableList<AWAServerInstruct> result = FXCollections.observableArrayList();
        result.setAll(awaServerInstructDao.queryServerInstructByDeviceType(deviceType));
        return result;
    }
}
