package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoMeasure  extends RecursiveTreeObject<InfoMeasure> {
    private StringProperty measureCode = new SimpleStringProperty();//测点的编号，固定测点采用HJ-661编号，非固定点位使用设备编号，级联服务器使用级联服务器编号
    private StringProperty userName = new SimpleStringProperty();//管理该测点的用户登录名，需要与用户信息表主键建立约束
    private SimpleIntegerProperty measureType = new SimpleIntegerProperty();//测点的类型，0为固定点位，1为移动点位，2为级联服务器
    private StringProperty measureName = new SimpleStringProperty();//测点的名称
    private StringProperty deviceTypeAndIDs = new SimpleStringProperty();//测点下属设备的设备类型和编号，测点下属有多个设备，中间用“；”分隔，每个设备由设备类型Type和设备编号ID组成，Type与ID用“，”分隔
    private SimpleIntegerProperty autoConnect =new SimpleIntegerProperty();//是否允许自动连接，0为不允许，1为允许
    private StringProperty measureUserName = new SimpleStringProperty();//测点所属的监测站的名称
    private StringProperty measureAddress = new SimpleStringProperty();//测点的详细地址
    private StringProperty cascadePath = new SimpleStringProperty();//测点的级联路径，本地测点该项无效，远程测点：1级服务器编号>2级服务器编号>3级服务器编号。。。
    private SimpleDoubleProperty latitude  = new SimpleDoubleProperty();//测点的GPS维度
    private SimpleDoubleProperty longitude = new SimpleDoubleProperty();//测点的GPS经度
    private StringProperty measureHead = new SimpleStringProperty();//测点的照片文件路径
    private StringProperty remark = new SimpleStringProperty();//备注信息

    @Override
    public String toString() {
        return "InfoMeasure{" +
                "measureCode=" + measureCode +
                ", UserName=" + userName +
                ", measureType=" + measureType +
                ", measureName=" + measureName +
                ", deviceTypeAndIDs=" + deviceTypeAndIDs +
                ", autoConnect=" + autoConnect +
                ", measureUserName=" + measureUserName +
                ", measureAddress=" + measureAddress +
                ", cascadePath=" + cascadePath +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", measureHead=" + measureHead +
                ", remark=" + remark +
                '}';
    }

    public String getMeasureCode() {
        return measureCode.get();
    }

    public StringProperty measureCodeProperty() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = new SimpleStringProperty(measureCode);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
    }

    public int getMeasureType() {
        return measureType.get();
    }

    public SimpleIntegerProperty measureTypeProperty() {
        return measureType;
    }

    public void setMeasureType(int measureType) {
        this.measureType = new SimpleIntegerProperty(measureType);
    }

    public String getMeasureName() {
        return measureName.get();
    }

    public StringProperty measureNameProperty() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = new SimpleStringProperty(measureName);
    }

    public String getDeviceTypeAndIDs() {
        return deviceTypeAndIDs.get();
    }

    public StringProperty deviceTypeAndIDsProperty() {
        return deviceTypeAndIDs;
    }

    public void setDeviceTypeAndIDs(String deviceTypeAndIDs) {
        this.deviceTypeAndIDs = new SimpleStringProperty(deviceTypeAndIDs);
    }

    public int getAutoConnect() {
        return autoConnect.get();
    }

    public SimpleIntegerProperty autoConnectProperty() {
        return autoConnect;
    }

    public void setAutoConnect(int autoConnect) {
        this.autoConnect = new SimpleIntegerProperty(autoConnect);
    }

    public String getMeasureUserName() {
        return measureUserName.get();
    }

    public StringProperty measureUserNameProperty() {
        return measureUserName;
    }

    public void setMeasureUserName(String measureUserName) {
        this.measureUserName = new SimpleStringProperty(measureUserName);
    }

    public String getMeasureAddress() {
        return measureAddress.get();
    }

    public StringProperty measureAddressProperty() {
        return measureAddress;
    }

    public void setMeasureAddress(String measureAddress) {
        this.measureAddress = new SimpleStringProperty(measureAddress);
    }

    public String getCascadePath() {
        return cascadePath.get();
    }

    public StringProperty cascadePathProperty() {
        return cascadePath;
    }

    public void setCascadePath(String cascadePath) {
        this.cascadePath = new SimpleStringProperty(cascadePath);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public SimpleDoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = new SimpleDoubleProperty(latitude);
    }

    public double getLongitude() {
        return longitude.get();
    }

    public SimpleDoubleProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = new SimpleDoubleProperty(longitude);
    }

    public String getMeasureHead() {
        return measureHead.get();
    }

    public StringProperty measureHeadProperty() {
        return measureHead;
    }

    public void setMeasureHead(String measureHead) {
        this.measureHead = new SimpleStringProperty(measureHead);
    }

    public String getRemark() {
        return remark.get();
    }

    public StringProperty remarkProperty() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = new SimpleStringProperty(remark);
    }

    public InfoMeasure(String measureCode, String userName, Integer measureType, String measureName, String deviceTypeAndIDs, Integer autoConnect, String measureUserName, String measureAddress, String cascadePath, Double latitude, Double longitude, String measureHead, String remark) {
        this.measureCode = new SimpleStringProperty(measureCode);
        this.userName = new SimpleStringProperty(userName);
        this.measureType = new SimpleIntegerProperty(measureType);
        this.measureName = new SimpleStringProperty(measureName);
        this.deviceTypeAndIDs = new SimpleStringProperty(deviceTypeAndIDs);
        this.autoConnect = new SimpleIntegerProperty(autoConnect);
        this.measureUserName = new SimpleStringProperty(measureUserName);
        this.measureAddress = new SimpleStringProperty(measureAddress);
        this.cascadePath = new SimpleStringProperty(cascadePath);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.measureHead = new SimpleStringProperty(measureHead);
        this.remark = new SimpleStringProperty(remark);
    }

    public InfoMeasure() {
    }
}
