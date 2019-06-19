package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.CarFlowLP;

import java.util.Date;
import java.util.List;

public interface CarFlowLPDao {
    /**
     * 添加一条车流量记录
     * */
    void insertCarFlow(CarFlowLP carFlowLP);

    /**
     * 查询全部瞬时车流量数据
     * */
    List<CarFlowLP> queryAllCarFlow();

    /**
     * 根据时间段查询车流量数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<CarFlowLP> queryAllCarFlowByTime(Date startTime,Date endTime);

    /**
     * 根据时间段、设备编号查询该设备在该时间段的车流量信息
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<CarFlowLP> queryCarFlowByTimeAndCode(String noiseCode,Date startTime,Date endTime);
}
