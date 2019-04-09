package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoUser;

import java.util.List;

public interface InfoMeasureDao {
    /**
     * 查询全部的测点
     * @return 返回值为测点信息对象的集合
     */
    public List<InfoMeasure> queryAll();

    /**
     * 根据测点编号来查询该测点下的设备组类型和ID，调用该接口的Service层得到返回值后会将字符串解析并到对应类型的设备表中查询该测点下的设备的详细信息
     * @param MeasureCode 测点的编号
     * @return 返回值为测点下属的多个设备信息
     */
    public String queryDevicesByMeasureCode(String MeasureCode);

    /**
     * 根据测点编号查询对应的测点信息
     * @param MeasureCode 测点编号
     * @return 返回测点信息的对象
     */
    public InfoMeasure queryByMeasureCode(String MeasureCode);

    /**
     * 根据管理该测点的用户登录名查询该用户所管理的测点
     * @param userName 用户登录名
     * @return 该用户管理的所有测点信息的集合
     */
    public List<InfoMeasure> queryByUserName(String userName);

    /**
     * 根据测点编号来修改该测点下的设备组，Service层的逻辑应该是先查询出来，再继续往后添加或删除，之后再进行修改
     * @param MeasureCode 要修改的测点编号
     * @param deviceTypeAndIDs 修改之后的设备组信息
     * @return 返回是否修改成功
     */
    public boolean updateDevices(String MeasureCode,String deviceTypeAndIDs);

    /**
     * 添加新的测点时调用的接口，其中设备组字段默认为空，也就是添加新的测点之后，该测点下无设备，需要之后从没有测点编号的设备信息中进行选择添加
     * @param infoMeasure 要添加的测点信息
     * @return 返回是否添加成功
     */
    public boolean insertInfoMeasure(InfoMeasure infoMeasure);

    /**
     * 删除测点信息，删除成功之后需要将该测点之下的设备的测点编号字段修改为空，使设备变成未激活状态
     * @param MeasureCode 要删除的测点编号
     * @return 返回是否删除成功
     */
    public boolean deleteInfoMeasure(String MeasureCode);
}
