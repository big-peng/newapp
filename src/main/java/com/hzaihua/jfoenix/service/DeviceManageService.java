package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.controller.MoreInfoController;
import com.hzaihua.jfoenix.dao.DeviceTypeDao;
import com.hzaihua.jfoenix.dao.InfoMeasureDao;
import com.hzaihua.jfoenix.dao.InfoNoiseDeviceDao;
import com.hzaihua.jfoenix.dao.StateNoiseDao;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import com.hzaihua.jfoenix.entity.StateNoise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 该接口主要用来进行设备的管理，其中包括新增测点、查询所有测点、查询某测点下设备、查询所有设备、删除测点、修改测点参数等方法
 */
@Service
public class DeviceManageService{
    @Resource
    private InfoMeasureDao infoMeasureDao;
    @Resource
    private DeviceTypeDao deviceTypeDao;
    @Resource
    private StateNoiseDao stateNoiseDao;
    @Resource
    private InfoNoiseDeviceDao infoNoiseDeviceDao;
    /**
     * 该方法实现的是测点的新增功能，新增测点的过程中添加测点信息的时候，需要直接添加下级设备(当然，也可以不添加)，下级设备可以直接新增设备，也可以从没有测点归属的设备中添加，当然，这需要由页面的操作逻辑决定
     * 添加测点的逻辑也可以是软件中没有单独的设备添加，也就是设备添加之后就必须要选定测点，那么在该方法中就需要先向数据库中添加设备信息，在将测点信息添加到数据库中
     * @param infoMeasure 新增的测点信息对象
     * @param noiseDevices 新增的测点要添加的设备信息对象集合
     * @return 返回是否添加成功
     */
    public boolean addMeasure(InfoMeasure infoMeasure, List<InfoNoiseDevice> noiseDevices){
        return false;
    }

    /**
     * 查询所有的测点，该方法是软件的主界面会调用的方法
     * @return 返回所有的测点信息集合
     */
    public List<InfoMeasure> queryAllMeasure(){
        return null;
    }

    /**
     * 根据测点的编号来查询该测点下级设备的参数信息，该方法的实现会比较复杂，首先要根据测点编号查询该条测点信息中多个设备的类型ID和设备ID组，之后根据设备类型ID得到该设备需要去哪张表里查，然后再根据设备编号来查询得出该设备的详细信息
     * @param measureCode 要查询的测点编号
     * @return 返回该测点下的设备的信息对象集合，计划是将所有的设备信息字段都集中到同一个实体类中，根据类中的设备类型来决定显示哪些字段，这样会比较容易实现该方法；或者是通过switch来判断查询哪一个设备数据表
     */
    public ObservableList<MoreInfoController.StateDevice> queryDeviceByMeasureCode(String measureCode){
        ObservableList<MoreInfoController.StateDevice> result = FXCollections.observableArrayList();
        String devicesStr = infoMeasureDao.queryDevicesByMeasureCode(measureCode);
        String[] devices = devicesStr.split(";");
        for(int i=0;i<devices.length;i++){
            String deviceStr = devices[i];
            String typeCode = deviceStr.split(",")[0];
            //得到要查询的表名
            String tableName = deviceTypeDao.queryByTypeCode(typeCode);
            //得到要查询的设备的编号
            String deviceCode = deviceStr.split(",")[1];
            StateNoise stateNoise = stateNoiseDao.queryByDeviceCode(deviceCode,tableName);
            String linkState = "已连接";
            if (stateNoise.getLinkState()==0){
                linkState = "连接断开";
            }else if(stateNoise.getLinkState()==1){
                linkState = "正在连接";
            }
            InfoNoiseDevice infoNoiseDevice = infoNoiseDeviceDao.queryByDeviceCode(deviceCode,tableName);
            String deviceType = infoNoiseDevice.getDeviceType();
            String linkPort = infoNoiseDevice.getLinkPort();
            MoreInfoController.StateDevice stateDevice = new MoreInfoController.StateDevice(deviceCode,deviceType+"",linkState,"","",linkPort+"","");
            result.add(stateDevice);
        }
        return result;
    }

    /**
     * 编辑测点调用的方法，该方法实现的逻辑和新增测点类似，主要就是把新增换成了修改，以及设备可能会新增、修改以及删除，要注意的是测点中的设备编号不可以修改
     * @param infoMeasure 修改之后的测点信息
     * @param noiseDevices 修改之后测点下级的设备的信息，该删除的删除，该修改的修改，该新增的新增
     * @return 返回是否修改成功
     */
    public boolean updateMeasure(InfoMeasure infoMeasure, List<InfoNoiseDevice> noiseDevices){
        return false;
    }

    /**
     * 删除测点时调用的方法，但是原则上测点时不轻易删除的，所以方法中可能需要进行管理员或者其他权限的验证，首先要将该测点下的设备删除，完成之后在进行该测点的删除
     * @param measureCode 要删除的测点编号
     * @return 返回是否删除成功
     */
    public boolean deleteMeasure(String measureCode){
        String devicesStr = infoMeasureDao.queryDevicesByMeasureCode(measureCode);
        String[] devices = devicesStr.split(";");
        for(int i=0;i<devices.length;i++){
            String deviceStr = devices[i];
            String typeCode = deviceStr.split(",")[0];
            //得到要删除的表名
            String tableName = deviceTypeDao.queryByTypeCode(typeCode);
            //得到要删除的设备的编号
            String deviceCode = deviceStr.split(",")[1];
            stateNoiseDao.deleteStateNoise(deviceCode,tableName);
            infoNoiseDeviceDao.deleteNoiseDevice(deviceCode,tableName);
        }
        return infoMeasureDao.deleteInfoMeasure(measureCode);
    }

    public ObservableList<MainController.StateMeasure> getIndexList(){
        ObservableList<MainController.StateMeasure> result = FXCollections.observableArrayList();
        List<InfoMeasure> allMeasure = infoMeasureDao.queryAll();
        for (InfoMeasure infoMeasure:allMeasure) {
            String measureCode = infoMeasure.getMeasureCode();
            if(null != infoMeasure.getCascadePath()&&!"".equals(infoMeasure.getCascadePath())){
                measureCode = "|--" + measureCode;
            }
            String measureName = infoMeasure.getMeasureName();
            String linkState = "已全部连接";
            String devicesStr = infoMeasure.getDeviceTypeAndIDs();
            String[] devices = devicesStr.split(";");
            for(int i=0;i<devices.length;i++){
                String deviceStr = devices[i];
                String typeCode = deviceStr.split(",")[0];
                String tableName = deviceTypeDao.queryByTypeCode(typeCode);
                String deviceCode = deviceStr.split(",")[1];
                StateNoise stateNoise = stateNoiseDao.queryByDeviceCode(deviceCode,tableName);
                if(stateNoise.getLinkState()==0){
                    linkState = "存在断开连接";
                }else if(stateNoise.getLinkState()==1&&"已全部连接".equals(linkState)){
                    linkState = "存在正在连接";
                }
            }
            String address = "经度:" + infoMeasure.getLatitude() + " 纬度:" + infoMeasure.getLongitude();
            String other = "...";
            MainController.StateMeasure stateMeasure = new MainController.StateMeasure(measureCode,measureName,linkState,"","",address,other);
            result.add(stateMeasure);
        }
        System.out.println(result);
        return result;
    }

    /**
     * 添加设备状态
     * */
    public void insertState(StateNoise stateNoise){
        stateNoiseDao.insertStateNoise(stateNoise);
    }
}
