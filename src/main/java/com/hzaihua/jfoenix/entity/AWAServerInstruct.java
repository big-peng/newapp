package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AWAServerInstruct extends RecursiveTreeObject<AWAServerInstruct> {
    private StringProperty instructId; //服务器指令编号
    private StringProperty measureName; //测点名称
    private StringProperty subTree; //测点编码信息
    private StringProperty deviceType;  //测点设备的型号
    private SimpleDoubleProperty longitude; //测点经度
    private SimpleDoubleProperty latitude; //测点纬度
    private SimpleDoubleProperty userLongitude; //用户指定测点经度
    private SimpleDoubleProperty userLatitude; //用户指定测点纬度
    private StringProperty functionCode; //功能区代码
    private StringProperty measureAddress; //测点地址
    private StringProperty deviceAWAID; //测点设备的机号或编号
    private SimpleIntegerProperty isAutoAdjust; //自动校准时钟
    private SimpleIntegerProperty isReadMin; //分钟历史数据
    private SimpleIntegerProperty isReadHour;  //小时历史数据
    private SimpleIntegerProperty isReadDay; //天历史数据
    private SimpleIntegerProperty isReadLp; //Lp的历史数据
    private SimpleIntegerProperty isReadLeq1s; //Leq1S的历史数据
    private SimpleIntegerProperty isReadOct; //频谱历史数据
    private SimpleIntegerProperty isReadWea; //气象历史数据
    private SimpleIntegerProperty isReadCar; //交通历史数据
    private SimpleIntegerProperty isReadDust; //空气历史数据
    private SimpleIntegerProperty isReadEvent; //时间上传
    private SimpleIntegerProperty isOpenVoice; //实时语音

    @Override
    public String toString() {
        return "AWAServerInstruct{" +
                "instructId=" + instructId +
                ", measureName=" + measureName +
                ", subTree=" + subTree +
                ", deviceType=" + deviceType +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", userLongitude=" + userLongitude +
                ", userLatitude=" + userLatitude +
                ", functionCode=" + functionCode +
                ", measureAddress=" + measureAddress +
                ", deviceAWAID=" + deviceAWAID +
                ", isAutoAdjust=" + isAutoAdjust +
                ", isReadMin=" + isReadMin +
                ", isReadHour=" + isReadHour +
                ", isReadDay=" + isReadDay +
                ", isReadLp=" + isReadLp +
                ", isReadLeq1s=" + isReadLeq1s +
                ", isReadOct=" + isReadOct +
                ", isReadWea=" + isReadWea +
                ", isReadCar=" + isReadCar +
                ", isReadDust=" + isReadDust +
                ", isReadEvent=" + isReadEvent +
                ", isOpenVoice=" + isOpenVoice +
                '}';
    }

    public String getInstructId() {
        return instructId.get();
    }

    public StringProperty instructIdProperty() {
        return instructId;
    }

    public void setInstructId(String instructId) {
        this.instructId = new SimpleStringProperty(instructId);
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

    public String getSubTree() {
        return subTree.get();
    }

    public StringProperty subTreeProperty() {
        return subTree;
    }

    public void setSubTree(String subTree) {
        this.subTree = new SimpleStringProperty(subTree);
    }

    public String getDeviceType() {
        return deviceType.get();
    }

    public StringProperty deviceTypeProperty() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = new SimpleStringProperty(deviceType);
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

    public double getLatitude() {
        return latitude.get();
    }

    public SimpleDoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = new SimpleDoubleProperty(latitude);
    }

    public double getUserLongitude() {
        return userLongitude.get();
    }

    public SimpleDoubleProperty userLongitudeProperty() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = new SimpleDoubleProperty(userLongitude);
    }

    public double getUserLatitude() {
        return userLatitude.get();
    }

    public SimpleDoubleProperty userLatitudeProperty() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = new SimpleDoubleProperty(userLatitude);
    }

    public String getFunctionCode() {
        return functionCode.get();
    }

    public StringProperty functionCodeProperty() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = new SimpleStringProperty(functionCode);
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

    public String getDeviceAWAID() {
        return deviceAWAID.get();
    }

    public StringProperty deviceAWAIDProperty() {
        return deviceAWAID;
    }

    public void setDeviceAWAID(String deviceAWAID) {
        this.deviceAWAID = new SimpleStringProperty(deviceAWAID);
    }

    public int getIsAutoAdjust() {
        return isAutoAdjust.get();
    }

    public SimpleIntegerProperty isAutoAdjustProperty() {
        return isAutoAdjust;
    }

    public void setIsAutoAdjust(int isAutoAdjust) {
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
    }

    public int getIsReadMin() {
        return isReadMin.get();
    }

    public SimpleIntegerProperty isReadMinProperty() {
        return isReadMin;
    }

    public void setIsReadMin(int isReadMin) {
        this.isReadMin = new SimpleIntegerProperty(isReadMin);
    }

    public int getIsReadHour() {
        return isReadHour.get();
    }

    public SimpleIntegerProperty isReadHourProperty() {
        return isReadHour;
    }

    public void setIsReadHour(int isReadHour) {
        this.isReadHour = new SimpleIntegerProperty(isReadHour);
    }

    public int getIsReadDay() {
        return isReadDay.get();
    }

    public SimpleIntegerProperty isReadDayProperty() {
        return isReadDay;
    }

    public void setIsReadDay(int isReadDay) {
        this.isReadDay = new SimpleIntegerProperty(isReadDay);
    }

    public int getIsReadLp() {
        return isReadLp.get();
    }

    public SimpleIntegerProperty isReadLpProperty() {
        return isReadLp;
    }

    public void setIsReadLp(int isReadLp) {
        this.isReadLp = new SimpleIntegerProperty(isReadLp);
    }

    public int getIsReadLeq1s() {
        return isReadLeq1s.get();
    }

    public SimpleIntegerProperty isReadLeq1sProperty() {
        return isReadLeq1s;
    }

    public void setIsReadLeq1s(int isReadLeq1s) {
        this.isReadLeq1s = new SimpleIntegerProperty(isReadLeq1s);
    }

    public int getIsReadOct() {
        return isReadOct.get();
    }

    public SimpleIntegerProperty isReadOctProperty() {
        return isReadOct;
    }

    public void setIsReadOct(int isReadOct) {
        this.isReadOct = new SimpleIntegerProperty(isReadOct);
    }

    public int getIsReadWea() {
        return isReadWea.get();
    }

    public SimpleIntegerProperty isReadWeaProperty() {
        return isReadWea;
    }

    public void setIsReadWea(int isReadWea) {
        this.isReadWea = new SimpleIntegerProperty(isReadWea);
    }

    public int getIsReadCar() {
        return isReadCar.get();
    }

    public SimpleIntegerProperty isReadCarProperty() {
        return isReadCar;
    }

    public void setIsReadCar(int isReadCar) {
        this.isReadCar = new SimpleIntegerProperty(isReadCar);
    }

    public int getIsReadDust() {
        return isReadDust.get();
    }

    public SimpleIntegerProperty isReadDustProperty() {
        return isReadDust;
    }

    public void setIsReadDust(int isReadDust) {
        this.isReadDust = new SimpleIntegerProperty(isReadDust);
    }

    public int getIsReadEvent() {
        return isReadEvent.get();
    }

    public SimpleIntegerProperty isReadEventProperty() {
        return isReadEvent;
    }

    public void setIsReadEvent(int isReadEvent) {
        this.isReadEvent = new SimpleIntegerProperty(isReadEvent);
    }

    public int getIsOpenVoice() {
        return isOpenVoice.get();
    }

    public SimpleIntegerProperty isOpenVoiceProperty() {
        return isOpenVoice;
    }

    public void setIsOpenVoice(int isOpenVoice) {
        this.isOpenVoice = new SimpleIntegerProperty(isOpenVoice);
    }

    public AWAServerInstruct(String instructId, String measureName, String subTree, String deviceType, double longitude, double latitude, double userLongitude, double userLatitude, String functionCode, String measureAddress, String deviceAWAID, int isAutoAdjust, int isReadMin, int isReadHour, int isReadDay, int isReadLp, int isReadLeq1s, int isReadOct, int isReadWea, int isReadCar, int isReadDust, int isReadEvent, int isOpenVoice) {
        this.instructId = new SimpleStringProperty(instructId);
        this.measureName = new SimpleStringProperty(measureName);
        this.subTree = new SimpleStringProperty(subTree);
        this.deviceType = new SimpleStringProperty(deviceType);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.userLongitude = new SimpleDoubleProperty(userLongitude);
        this.userLatitude = new SimpleDoubleProperty(userLatitude);
        this.functionCode = new SimpleStringProperty(functionCode);
        this.measureAddress = new SimpleStringProperty(measureAddress);
        this.deviceAWAID = new SimpleStringProperty(deviceAWAID);
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
        this.isReadMin = new SimpleIntegerProperty(isReadMin);
        this.isReadHour = new SimpleIntegerProperty(isReadHour);
        this.isReadDay = new SimpleIntegerProperty(isReadDay);
        this.isReadLp = new SimpleIntegerProperty(isReadLp);
        this.isReadLeq1s = new SimpleIntegerProperty(isReadLeq1s);
        this.isReadOct = new SimpleIntegerProperty(isReadOct);
        this.isReadWea = new SimpleIntegerProperty(isReadWea);
        this.isReadCar = new SimpleIntegerProperty(isReadCar);
        this.isReadDust = new SimpleIntegerProperty(isReadDust);
        this.isReadEvent = new SimpleIntegerProperty(isReadEvent);
        this.isOpenVoice = new SimpleIntegerProperty(isOpenVoice);
    }

    public AWAServerInstruct() {
    }
}
