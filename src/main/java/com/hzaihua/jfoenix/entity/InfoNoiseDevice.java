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
}
