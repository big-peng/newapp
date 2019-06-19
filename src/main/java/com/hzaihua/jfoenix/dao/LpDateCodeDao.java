package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.LpDateCode;

import java.util.Date;
import java.util.List;

public interface LpDateCodeDao {

    /**
     * 添加一条根据开关量管理的瞬时数据
     * */
    void insertLpDateCode(LpDateCode lpDateCode);

    /**
     * 根据时间段查询开关量的数据
     * @satrtTime 开始时间
     * @endTime 结束时间
     * */
    List<LpDateCode> queryLpDateByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备的某个时间段开关量数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<LpDateCode> queryLpDateByCodeAndTime(String noiseCode,Date startTime,Date endTime);
}
