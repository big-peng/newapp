package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.Leq1SCode;

import java.util.Date;
import java.util.List;

public interface Leq1SCodeDao {
    /**
     * 添加leq1s的数据
     * */
    void insertLeq1SCode(Leq1SCode leq1SCode);

    /**
     * 根据时间段查询leq1s数据
     * @startTime 开始时间
     * @结束时间 结束时间
     * */
    List<Leq1SCode> queryLeq1sByTime(Date startTime,Date endTime);

    /**
     * 根据设备编号查询leq1s某个时间段的数据
     * @noiseCode 设备编号
     * @startTime 开始时间
     * @startTime 结束时间
     * */
    List<Leq1SCode> queryleq1sByCodeAndTime(String noiseCode,Date startTime,Date endTime);
}
