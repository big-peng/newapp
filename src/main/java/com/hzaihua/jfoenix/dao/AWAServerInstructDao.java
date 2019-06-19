package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.AWAServerInstruct;

import java.util.List;

public interface AWAServerInstructDao {
    /**
     * 添加服务器指令
     * */
    void insertServerInstruct(AWAServerInstruct awaServerInstruct);

    /**
     * 查询服务器指令
     * */
    List<AWAServerInstruct> queryAllServerInstruct();

    /**
     * 查询服务器相关指令
     * */
    List<AWAServerInstruct> queryServerInstructByDeviceType(String deviceType);
}
