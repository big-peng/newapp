package com.hzaihua.jfoenix.entity;

public class InfoMeasure {
    private String measureCode;//测点的编号，固定测点采用HJ-661编号，非固定点位使用设备编号，级联服务器使用级联服务器编号
    private String UserName;//管理该测点的用户登录名，需要与用户信息表主键建立约束
    private int measureType;//测点的类型，0为固定点位，1为移动点位，2为级联服务器
    private String measureName;//测点的名称
    private String deviceTypeAndIDs;//测点下属设备的设备类型和编号，测点下属有多个设备，中间用“；”分隔，每个设备由设备类型Type和设备编号ID组成，Type与ID用“，”分隔
    private int autoConnect;//是否允许自动连接，0为不允许，1为允许
    private String measureUserName;//测点所属的监测站的名称
    private String measureAddress;//测点的详细地址
    private String cascadePath;//测点的级联路径，本地测点该项无效，远程测点：1级服务器编号>2级服务器编号>3级服务器编号。。。
    private double latitude;//测点的GPS维度
    private double longitude;//测点的GPS经度
    private String measureHead;//测点的照片文件路径
    private String remark;//备注信息

    public InfoMeasure() {
    }

    public InfoMeasure(String measureCode, String userName, int measureType, String measureName, String deviceTypeAndIDs, int autoConnect, String measureUserName, String measureAddress, String cascadePath, double latitude, double longitude, String measureHead, String remark) {
        this.measureCode = measureCode;
        UserName = userName;
        this.measureType = measureType;
        this.measureName = measureName;
        this.deviceTypeAndIDs = deviceTypeAndIDs;
        this.autoConnect = autoConnect;
        this.measureUserName = measureUserName;
        this.measureAddress = measureAddress;
        this.cascadePath = cascadePath;
        this.latitude = latitude;
        this.longitude = longitude;
        this.measureHead = measureHead;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "InfoMeasure{" +
                "measureCode='" + measureCode + '\'' +
                ", UserName='" + UserName + '\'' +
                ", measureType=" + measureType +
                ", measureName='" + measureName + '\'' +
                ", deviceTypeAndIDs='" + deviceTypeAndIDs + '\'' +
                ", autoConnect=" + autoConnect +
                ", measureUserName='" + measureUserName + '\'' +
                ", measureAddress='" + measureAddress + '\'' +
                ", cascadePath='" + cascadePath + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", measureHead='" + measureHead + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = measureCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getMeasureType() {
        return measureType;
    }

    public void setMeasureType(int measureType) {
        this.measureType = measureType;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public String getDeviceTypeAndIDs() {
        return deviceTypeAndIDs;
    }

    public void setDeviceTypeAndIDs(String deviceTypeAndIDs) {
        this.deviceTypeAndIDs = deviceTypeAndIDs;
    }

    public int getAutoConnect() {
        return autoConnect;
    }

    public void setAutoConnect(int autoConnect) {
        this.autoConnect = autoConnect;
    }

    public String getMeasureUserName() {
        return measureUserName;
    }

    public void setMeasureUserName(String measureUserName) {
        this.measureUserName = measureUserName;
    }

    public String getMeasureAddress() {
        return measureAddress;
    }

    public void setMeasureAddress(String measureAddress) {
        this.measureAddress = measureAddress;
    }

    public String getCascadePath() {
        return cascadePath;
    }

    public void setCascadePath(String cascadePath) {
        this.cascadePath = cascadePath;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMeasureHead() {
        return measureHead;
    }

    public void setMeasureHead(String measureHead) {
        this.measureHead = measureHead;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
