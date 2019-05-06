package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.EventCodeDao;
import com.hzaihua.jfoenix.entity.EventCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EventCodeService {
    @Resource
    private EventCodeDao eventCodeDao;

    /**
     * 查询全部事件
     * */
    public ObservableList<EventCode> queryllEvent(){
        ObservableList<EventCode> result = FXCollections.observableArrayList();
        result.setAll(eventCodeDao.queryAll());
        return result;
    }

    /**
     * 添加事件
     */
    public void insertEvent(EventCode eventCode){
        eventCodeDao.insertEventCode(eventCode);
    }

    /**
     * 根据事件来源查询事件
     */
    public ObservableList<EventCode> queryByEventSource(String eventSource){
        ObservableList<EventCode> result = FXCollections.observableArrayList();
        result.setAll(eventCodeDao.queryByEventSource(eventSource));
        return result;
    }
}
