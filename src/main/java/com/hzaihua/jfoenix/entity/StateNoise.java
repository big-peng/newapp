package com.hzaihua.jfoenix.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StateNoise {
    private StringProperty deviceCode;//设备编号
    private int linkState;//设备的连接状态

    public String getDeviceCode() {
        return deviceCode.get();
    }

    public StringProperty deviceCodeProperty() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = new SimpleStringProperty(deviceCode);
    }

    public int getLinkState() {
        return linkState;
    }

    public void setLinkState(int linkState) {
        this.linkState = linkState;
    }
}
