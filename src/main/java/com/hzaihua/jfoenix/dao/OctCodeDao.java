package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.OctCode;

import java.util.Date;
import java.util.List;

public interface OctCodeDao {
    /**
     * 添加一条月统计数据
     * */
    void insertOctCode(OctCode octCode);

    /**
     * 根据时间段查询月统计数据
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<OctCode> queryOctByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询该设备在时间段的月统计数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @endTime 结束时间
     * */
    List<OctCode> queryOctByCodeAndTime(String noiseCode,Date startTime,Date endTime);

    OctCode queryAllOct();
}
