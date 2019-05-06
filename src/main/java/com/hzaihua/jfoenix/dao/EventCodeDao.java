package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.EventCode;

import java.util.List;

public interface EventCodeDao {
    /**
     * 查询全部的事件
     * @return 返回系统中全部的事件信息集合
     */
    public List<EventCode> queryAll();

    /**
     * 根据事件的来源查询该来源所有的事件
     * @param eventSource 可以是SYSTEM,也可以是某一个用户，也可以是某一个测点
     * @return 得到一个事件信息的集合
     */
    public List<EventCode> queryByEventSource(String eventSource);

    /**
     * 新增一个事件
     * @param eventCode 事件对象
     * @return 返回是否插入成功
     */
    public boolean insertEventCode(EventCode eventCode);

}
