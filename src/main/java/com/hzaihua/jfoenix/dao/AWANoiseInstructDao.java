package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.AWANoiseInstruct;
import java.util.List;

public interface AWANoiseInstructDao {
    /**
     * 添加设备指令
     */
    void insertNoiseInstruct(AWANoiseInstruct awaNoiseInstruct);

    /**
     * 查询所有设备指令
     * */
    List<AWANoiseInstruct> queryAllNoiseInstruct();

    /**
     * 查询设备相关指令
     * */
    List<AWANoiseInstruct> queryNosieInstructByNoiceCode(String noiseCode);
}