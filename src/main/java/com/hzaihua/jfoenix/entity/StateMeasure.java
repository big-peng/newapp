package com.hzaihua.jfoenix.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 该实体类是主页面的测点表单显示时使用的
 */
public class StateMeasure {
    private StringProperty measureCode;//测点的编号
    private StringProperty measureName;//测点的名称
    private StringProperty linkState;//测点中的设备连接状态
    private StringProperty dataTime;//数值时间
    private StringProperty data;//数值
    private StringProperty address;//测点的位置信息
    private StringProperty other;//测点的其他参数

    public StateMeasure() {
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

    public String getMeasureName() {
        return measureName.get();
    }

    public StringProperty measureNameProperty() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = new SimpleStringProperty(measureName);
    }

    public String getLinkState() {
        return linkState.get();
    }

    public StringProperty linkStateProperty() {
        return linkState;
    }

    public void setLinkState(String linkState) {
        this.linkState = new SimpleStringProperty(linkState);
    }

    public String getDataTime() {
        return dataTime.get();
    }

    public StringProperty dataTimeProperty() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = new SimpleStringProperty(dataTime);
    }

    public String getData() {
        return data.get();
    }

    public StringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data = new SimpleStringProperty(data);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public String getOther() {
        return other.get();
    }

    public StringProperty otherProperty() {
        return other;
    }

    public void setOther(String other) {
        this.other = new SimpleStringProperty(other);
    }

    public StateMeasure(String measureCode, String measureName, String linkState, String dataTime, String data, String address, String other) {
        this.measureCode = new SimpleStringProperty(measureCode);
        this.measureName = new SimpleStringProperty(measureName);
        this.linkState = new SimpleStringProperty(linkState);
        this.dataTime = new SimpleStringProperty(dataTime);
        this.data = new SimpleStringProperty(data);
        this.address = new SimpleStringProperty(address);
        this.other = new SimpleStringProperty(other);
    }

    @Override
    public String toString() {
        return "StateMeasure{" +
                "measureCode=" + measureCode +
                ", measureName=" + measureName +
                ", linkState=" + linkState +
                ", dataTime=" + dataTime +
                ", data=" + data +
                ", address=" + address +
                ", other=" + other +
                '}';
    }
}
