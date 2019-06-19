package com.hzaihua.jfoenix.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoNoiseDevice {
    private StringProperty deviceCode;//设备编号
    private StringProperty deviceType;//设备类型
    private StringProperty measureCode;//所属测点编号，为空则表示还没有测点选择该设备，该设备未激活
    private StringProperty devicePassword;//设备连接密码
    private SimpleIntegerProperty linkType;//连接方式
    private SimpleIntegerProperty linkPort;//连接端口号
    private SimpleIntegerProperty isAutoLink;//是否自动连接
    private SimpleIntegerProperty isAutoAdjust;//是否自动校时
    private StringProperty microphoneHeight;//传声器高度
    private StringProperty DTUSIM;//DTU电话卡号
    private SimpleIntegerProperty isReadMin;//是否读取分钟统计数据
    private SimpleIntegerProperty isReadHour;//是否读取小时统计数据
    private SimpleIntegerProperty isReadDay;//是否读取天统计数据
    private SimpleIntegerProperty isReadLp;//是否读取瞬时数据
    private SimpleIntegerProperty isReadOct;//是否读取频谱数据
    private SimpleIntegerProperty isReadWea;//是否读取气象数据
    private SimpleIntegerProperty isReadCar;//是否读取车流量数据
    private SimpleIntegerProperty isReadDust;//是否读取粉尘数据
    private SimpleIntegerProperty isReadLeq1s;//是否读取瞬时数据
    private SimpleIntegerProperty isReadEvent;//是否读取事件数据
    private SimpleIntegerProperty isOpenVoice;//是否开启实时语音服务
    private StringProperty funCode;//功能区
    private SimpleIntegerProperty stateType;

    public int getStateType() {
        return stateType.get();
    }

    public SimpleIntegerProperty stateTypeProperty() {
        return stateType;
    }

    public void setStateType(int stateType) {
        this.stateType = new SimpleIntegerProperty(stateType);
    }

    public String getDeviceCode() {
        return deviceCode.get();
    }

    public StringProperty deviceCodeProperty() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = new SimpleStringProperty(deviceCode);
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

    public String getMeasureCode() {
        return measureCode.get();
    }

    public StringProperty measureCodeProperty() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = new SimpleStringProperty(measureCode);
    }

    public String getDevicePassword() {
        return devicePassword.get();
    }

    public StringProperty devicePasswordProperty() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = new SimpleStringProperty(devicePassword);
    }

    public int getLinkType() {
        return linkType.get();
    }

    public SimpleIntegerProperty linkTypeProperty() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = new SimpleIntegerProperty(linkType);
    }

    public int getLinkPort() {
        return linkPort.get();
    }

    public SimpleIntegerProperty linkPortProperty() {
        return linkPort;
    }

    public void setLinkPort(int linkPort) {
        this.linkPort = new SimpleIntegerProperty(linkPort);
    }

    public int getIsAutoLink() {
        return isAutoLink.get();
    }

    public SimpleIntegerProperty isAutoLinkProperty() {
        return isAutoLink;
    }

    public void setIsAutoLink(int isAutoLink) {
        this.isAutoLink = new SimpleIntegerProperty(isAutoLink);
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


    public String getMicrophoneHeight() {
        return microphoneHeight.get();
    }

    public StringProperty microphoneHeightProperty() {
        return microphoneHeight;
    }

    public void setMicrophoneHeight(String microphoneHeight) {
        this.microphoneHeight = new SimpleStringProperty(microphoneHeight);
    }

    public String getDTUSIM() {
        return DTUSIM.get();
    }

    public StringProperty DTUSIMProperty() {
        return DTUSIM;
    }

    public void setDTUSIM(String DTUSIM) {
        this.DTUSIM = new SimpleStringProperty(DTUSIM);
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

    public int getIsReadLeq1s() {
        return isReadLeq1s.get();
    }

    public SimpleIntegerProperty isReadLeq1sProperty() {
        return isReadLeq1s;
    }

    public void setIsReadLeq1s(int isReadLeq1s) {
        this.isReadLeq1s = new SimpleIntegerProperty(isReadLeq1s);
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

    public String getFunCode() {
        return funCode.get();
    }

    public StringProperty funCodeProperty() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = new SimpleStringProperty(funCode);
    }

    @Override
    public String toString() {
        return "InfoNoiseDevice{" +
                "deviceCode=" + deviceCode +
                ", deviceType=" + deviceType +
                ", measureCode=" + measureCode +
                ", devicePassword=" + devicePassword +
                ", linkType=" + linkType +
                ", linkPort=" + linkPort +
                ", isAutoLink=" + isAutoLink +
                ", isAutoAdjust=" + isAutoAdjust +
                ", microphoneHeight=" + microphoneHeight +
                ", DTUSIM=" + DTUSIM +
                ", isReadMin=" + isReadMin +
                ", isReadHour=" + isReadHour +
                ", isReadDay=" + isReadDay +
                ", isReadLp=" + isReadLp +
                ", isReadOct=" + isReadOct +
                ", isReadWea=" + isReadWea +
                ", isReadCar=" + isReadCar +
                ", isReadDust=" + isReadDust +
                ", isReadLeq1s=" + isReadLeq1s +
                ", isReadEvent=" + isReadEvent +
                ", isOpenVoice=" + isOpenVoice +
                ", funCode=" + funCode +
                '}';
    }

    public InfoNoiseDevice(String deviceCode, String deviceType, String measureCode, String devicePassword, Integer linkType, Integer linkPort, Integer isAutoLink, Integer isAutoAdjust, String microphoneHeight, String DTUSIM, Integer isReadMin, Integer isReadHour, Integer isReadDay, Integer isReadLp, Integer isReadOct, Integer isReadWea, Integer isReadCar, Integer isReadDust, Integer isReadLeq1s, Integer isReadEvent, Integer isOpenVoice,String funCode) {
        this.deviceCode = new SimpleStringProperty(deviceCode);
        this.deviceType = new SimpleStringProperty(deviceType);
        this.measureCode = new SimpleStringProperty(measureCode);
        this.devicePassword = new SimpleStringProperty(devicePassword);
        this.linkType = new SimpleIntegerProperty(linkType);
        this.linkPort = new SimpleIntegerProperty(linkPort);
        this.isAutoLink = new SimpleIntegerProperty(isAutoLink);
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
        this.microphoneHeight = new SimpleStringProperty(microphoneHeight);
        this.DTUSIM = new SimpleStringProperty(DTUSIM);
        this.isReadMin = new SimpleIntegerProperty(isReadMin);
        this.isReadHour = new SimpleIntegerProperty(isReadHour);
        this.isReadDay = new SimpleIntegerProperty(isReadDay);
        this.isReadLp = new SimpleIntegerProperty(isReadLp);
        this.isReadOct = new SimpleIntegerProperty(isReadOct);
        this.isReadWea = new SimpleIntegerProperty(isReadWea);
        this.isReadCar = new SimpleIntegerProperty(isReadCar);
        this.isReadDust = new SimpleIntegerProperty(isReadDust);
        this.isReadLeq1s = new SimpleIntegerProperty(isReadLeq1s);
        this.isReadEvent = new SimpleIntegerProperty(isReadEvent);
        this.isOpenVoice = new SimpleIntegerProperty(isOpenVoice);
        this.funCode = new SimpleStringProperty(funCode);
    }

    public InfoNoiseDevice() {
    }
}
