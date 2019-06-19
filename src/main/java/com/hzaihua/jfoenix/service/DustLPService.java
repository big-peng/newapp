package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.DustLPDao;
import com.hzaihua.jfoenix.entity.DustLP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DustLPService {
    @Resource
    private DustLPDao dustLPDao;

    /**
     * 添加粉尘数据实现方法
     */
    public void saveDustLp(DustLP dustLP){
        dustLPDao.insertDustLP(dustLP);
    }

    /**
     * 查询所有粉尘数据，放到一个list集合中
     * */
    public ObservableList<DustLP> queryAllDustLP(){
        ObservableList<DustLP> result = FXCollections.observableArrayList();
        result.setAll(dustLPDao.queryAllDustLP());
        return result;
    }

    /**
     *根据时间段查询粉尘数据，放入list集合中
     * */
    public ObservableList<DustLP> queryByTime(Date startTime,Date endTime){
        ObservableList<DustLP> result = FXCollections.observableArrayList();
        result.setAll(dustLPDao.queryByTime(startTime,endTime));
        return result;
    }
}
