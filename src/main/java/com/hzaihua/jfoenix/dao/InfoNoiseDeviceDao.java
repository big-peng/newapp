package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.InfoNoiseDevice;

import java.util.List;

public interface InfoNoiseDeviceDao {
    /**
     * 查询全部的设备，不区分属于哪一个测点，该接口很少会用到，一般都是以测点为上级进行查询
     * @return 返回全部的设备信息集合
     */
    public List<InfoNoiseDevice> queryAll();

    /**
     * 根据测点编号查询该测点之霞的所有设备
     * @param measureCode 测点编号
     * @return 返回该测点之下的所有设备集合
     */
    public List<InfoNoiseDevice> queryByMeasureCode(String measureCode);

    /**
     * 根据设备ID进行查询，测点下所属设备查询时会调用该接口，之后该接口可能会修改为多个设备信息使用用一个实体类，而且传入的参数也新增一个要查询的设备表名
     * @param deviceCode 设备编号
     * @param deviceTableName 要查询的设备的表名
     * @return 返回该设备编号的设备信息
     */
    public InfoNoiseDevice queryByDeviceCode(String deviceCode,String deviceTableName);

    /**
     * 根据noiseCode查询设备信息，主要是判断设备编号是否已存在
     * */
    public InfoNoiseDevice queryByNoiseDeviceCode(String deviceCode);
    /**
     * 插入一个新的设备信息
     * @param infoNoiseDevice 设备信息对象
     * @return 返回是否插入成功
     */
    public void insertNoiseDevice(InfoNoiseDevice infoNoiseDevice);

    /**
     * 根据设备编号进行修改设备的信息，其中设备编号是固定无法修改的
     * @param infoNoiseDevice 要修改的设备的新信息对象
     * @return 返回是否修改成功
     */
    public boolean updateNoiseDevice(InfoNoiseDevice infoNoiseDevice);

    /**
     * 根据设备编号进行设备所属测点的修改
     * @param deviceCode 设备编号
     * @param measureCode 修改之后的所属测点编号
     * @return 返回是否修改成功
     */
    public boolean updateMeasureCode(String deviceCode,String measureCode);

    /**
     * 删除设备信息，原则上设备信息是不能删除的，但是不排除特殊情况，在删除之前还需要进行设备密码的验证
     * @param deviceCode 要删除的设备编号
     * @return 返回是否删除成功
     */
    public boolean deleteNoiseDevice(String deviceCode,String deviceTableName);
}
