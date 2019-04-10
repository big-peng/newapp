package com.hzaihua.jfoenix.entity;

public class InfoNoiseDevice {
    private String deviceCode;//设备编号
    private int deviceType;//设备类型
    private String measureCode;//所属测点编号，为空则表示还没有测点选择该设备，该设备未激活
    private String devicePassword;//设备连接密码
    private int linkType;//连接方式
    private int linkPort;//连接端口号
    private int isAutoLink;//是否自动连接
    private int isAutoAdjust;//是否自动校时
    private int hasCarflow;//是否有车流量
    private int hasWeather;//是否有气象
    private int hasDust;//是否有粉尘
    private int microphoneHeight;//传声器高度
    private String DTUSIM;//DTU电话卡号
    private int isReadSta;//是否读取分钟、小时、天统计统计数据
    private int isReadLp;//是否读取瞬时数据
    private int isReadOct;//是否读取频谱数据
    private int isReadWea;//是否读取气象数据
    private int isReadCar;//是否读取车流量数据
    private int isReadDust;//是否读取粉尘数据
    private int isReadLeq1s;//是否读取瞬时数据

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = measureCode;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }

    public int getLinkPort() {
        return linkPort;
    }

    public void setLinkPort(int linkPort) {
        this.linkPort = linkPort;
    }

    public int getIsAutoLink() {
        return isAutoLink;
    }

    public void setIsAutoLink(int isAutoLink) {
        this.isAutoLink = isAutoLink;
    }

    public int getIsAutoAdjust() {
        return isAutoAdjust;
    }

    public void setIsAutoAdjust(int isAutoAdjust) {
        this.isAutoAdjust = isAutoAdjust;
    }

    public int getHasCarflow() {
        return hasCarflow;
    }

    public void setHasCarflow(int hasCarflow) {
        this.hasCarflow = hasCarflow;
    }

    public int getHasWeather() {
        return hasWeather;
    }

    public void setHasWeather(int hasWeather) {
        this.hasWeather = hasWeather;
    }

    public int getHasDust() {
        return hasDust;
    }

    public void setHasDust(int hasDust) {
        this.hasDust = hasDust;
    }

    public int getMicrophoneHeight() {
        return microphoneHeight;
    }

    public void setMicrophoneHeight(int microphoneHeight) {
        this.microphoneHeight = microphoneHeight;
    }

    public String getDTUSIM() {
        return DTUSIM;
    }

    public void setDTUSIM(String DTUSIM) {
        this.DTUSIM = DTUSIM;
    }

    public int getIsReadSta() {
        return isReadSta;
    }

    public void setIsReadSta(int isReadSta) {
        this.isReadSta = isReadSta;
    }

    public int getIsReadLp() {
        return isReadLp;
    }

    public void setIsReadLp(int isReadLp) {
        this.isReadLp = isReadLp;
    }

    public int getIsReadOct() {
        return isReadOct;
    }

    public void setIsReadOct(int isReadOct) {
        this.isReadOct = isReadOct;
    }

    public int getIsReadWea() {
        return isReadWea;
    }

    public void setIsReadWea(int isReadWea) {
        this.isReadWea = isReadWea;
    }

    public int getIsReadCar() {
        return isReadCar;
    }

    public void setIsReadCar(int isReadCar) {
        this.isReadCar = isReadCar;
    }

    public int getIsReadDust() {
        return isReadDust;
    }

    public void setIsReadDust(int isReadDust) {
        this.isReadDust = isReadDust;
    }

    public int getIsReadLeq1s() {
        return isReadLeq1s;
    }

    public void setIsReadLeq1s(int isReadLeq1s) {
        this.isReadLeq1s = isReadLeq1s;
    }
}
