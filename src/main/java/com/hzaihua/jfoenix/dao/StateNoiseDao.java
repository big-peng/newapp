package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.StateNoise;

public interface StateNoiseDao {
    /**
     * 根据设备的编号来查询该设备当前的状态
     * @param deviceCode 设备编号
     * @return 返回设备的当前状态对象
     */
    public StateNoise queryByDeviceCode(String deviceCode);

    /**
     * 修改设备的状态
     * @param stateNoise 要修改的设备状态对象
     * @return 返回是否修改成功
     */
    public boolean updateStateNoise(StateNoise stateNoise);

    /**
     * 插入新设备的时候回调用该接口，创建一条新的该设备的设备状态数据
     * @param stateNoise 设备的状态对象
     * @return 返回是否插入成功
     */
    public boolean insertStateNoise(StateNoise stateNoise);

    /**
     * 删除设备的时候会调用该接口，删除该设备所对应的设备状态数据
     * @param deviceCode 该设备的设备编号
     * @return 返回是否删除成功
     */
    public boolean deleteStateNoise(String deviceCode);
}
