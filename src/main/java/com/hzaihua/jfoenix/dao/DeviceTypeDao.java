package com.hzaihua.jfoenix.dao;

public interface DeviceTypeDao {
    /**
     * 根据类型的编号得到对应的类型设备表名，在进行通过测点查询下属设备时会使用到该接口
     * @param TypeCode 类型的编号
     * @return 返回值为类型的对应的设备表名
     */
    public String queryByTypeCode(String TypeCode);
}
