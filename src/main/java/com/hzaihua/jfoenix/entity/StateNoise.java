package com.hzaihua.jfoenix.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class StateNoise {
    private String deviceCode;//设备编号
    private int linkState;//设备的连接状态
    private int networkState;
    private Date nowDateTime;
    private float lpTime;
    private float LEQZ;
    private float LEQC;
    private float LEQA;
    private float LPFZ;
    private float LPSZ;
    private float LPIZ;
    private float LPFC;
    private float LPSC;
    private float LPIC;
    private float LPFA;
    private float LPSA;
    private float LPIA;
    private float PEAKZ;
    private float PEAKC;
    private float PEAKA;
    private float windSpeed;
    private float outTemperature;
    private float humi_R;
    private float w_Direction;
    private float outHumidity;
    private float ariPressure;
    private float rainfall;
    private int longCarNums;
    private float longCarSpeed;
    private int midCarNums;
    private float midCarSpeed;
    private int shortCarNums;
    private float shortCarSpeed;
    private float PM25;
    private float longitude;
    private float latitude;
    private float speed;
    private float usedRoom;
    private float freeRoom;
    private float batteryVoltage;
    private float workingVoltage;
    private float temperature;
    private float humidity;
    private String stataInfo;
    private int event_01;
    private int event_02;
    private int event_03;
    private int event_04;
    private int event_05;
    private int event_06;
    private int event_07;
    private int event_08;
    private int event_09;
    private int event_10;
    private int event_11;
    private int event_12;
    private int event_13;
    private int hand_Adjust;
    private int auto_Adjust;
    private int adjust_Before;
    private int adjust_After;
    private int event_0211;
    private Date event_01_stime;
    private Date event_02_stime;
    private Date event_03_stime;
    private Date event_04_stime;
    private Date event_05_stime;
    private Date event_06_stime;
    private Date event_07_stime;
    private Date event_08_stime;
    private Date event_09_stime;
    private Date event_10_stime;
    private Date event_11_stime;
    private Date event_12_stime;
    private Date event_13_stime;
    private Date event_0211_stime;
    private Date event_01_etime;
    private Date event_02_etime;
    private Date event_03_etime;
    private Date event_04_etime;
    private Date event_05_etime;
    private Date event_06_etime;
    private Date event_07_etime;
    private Date event_08_etime;
    private Date event_09_etime;
    private Date event_10_etime;
    private Date event_11_etime;
    private Date event_12_etime;
    private Date event_13_etime;
    private Date event_0211_etime;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getLinkState() {
        return linkState;
    }

    public void setLinkState(int linkState) {
        this.linkState = linkState;
    }

    public int getNetworkState() {
        return networkState;
    }

    public void setNetworkState(int networkState) {
        this.networkState = networkState;
    }

    public Date getNowDateTime() {
        return nowDateTime;
    }

    public void setNowDateTime(Date nowDateTime) {
        this.nowDateTime = nowDateTime;
    }

    public float getLpTime() {
        return lpTime;
    }

    public void setLpTime(float lpTime) {
        this.lpTime = lpTime;
    }

    public float getLEQZ() {
        return LEQZ;
    }

    public void setLEQZ(float LEQZ) {
        this.LEQZ = LEQZ;
    }

    public float getLEQC() {
        return LEQC;
    }

    public void setLEQC(float LEQC) {
        this.LEQC = LEQC;
    }

    public float getLEQA() {
        return LEQA;
    }

    public void setLEQA(float LEQA) {
        this.LEQA = LEQA;
    }

    public float getLPFZ() {
        return LPFZ;
    }

    public void setLPFZ(float LPFZ) {
        this.LPFZ = LPFZ;
    }

    public float getLPSZ() {
        return LPSZ;
    }

    public void setLPSZ(float LPSZ) {
        this.LPSZ = LPSZ;
    }

    public float getLPIZ() {
        return LPIZ;
    }

    public void setLPIZ(float LPIZ) {
        this.LPIZ = LPIZ;
    }

    public float getLPFC() {
        return LPFC;
    }

    public void setLPFC(float LPFC) {
        this.LPFC = LPFC;
    }

    public float getLPSC() {
        return LPSC;
    }

    public void setLPSC(float LPSC) {
        this.LPSC = LPSC;
    }

    public float getLPIC() {
        return LPIC;
    }

    public void setLPIC(float LPIC) {
        this.LPIC = LPIC;
    }

    public float getLPFA() {
        return LPFA;
    }

    public void setLPFA(float LPFA) {
        this.LPFA = LPFA;
    }

    public float getLPSA() {
        return LPSA;
    }

    public void setLPSA(float LPSA) {
        this.LPSA = LPSA;
    }

    public float getLPIA() {
        return LPIA;
    }

    public void setLPIA(float LPIA) {
        this.LPIA = LPIA;
    }

    public float getPEAKZ() {
        return PEAKZ;
    }

    public void setPEAKZ(float PEAKZ) {
        this.PEAKZ = PEAKZ;
    }

    public float getPEAKC() {
        return PEAKC;
    }

    public void setPEAKC(float PEAKC) {
        this.PEAKC = PEAKC;
    }

    public float getPEAKA() {
        return PEAKA;
    }

    public void setPEAKA(float PEAKA) {
        this.PEAKA = PEAKA;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getOutTemperature() {
        return outTemperature;
    }

    public void setOutTemperature(float outTemperature) {
        this.outTemperature = outTemperature;
    }

    public float getHumi_R() {
        return humi_R;
    }

    public void setHumi_R(float humi_R) {
        this.humi_R = humi_R;
    }

    public float getW_Direction() {
        return w_Direction;
    }

    public void setW_Direction(float w_Direction) {
        this.w_Direction = w_Direction;
    }

    public float getOutHumidity() {
        return outHumidity;
    }

    public void setOutHumidity(float outHumidity) {
        this.outHumidity = outHumidity;
    }

    public float getAriPressure() {
        return ariPressure;
    }

    public void setAriPressure(float ariPressure) {
        this.ariPressure = ariPressure;
    }

    public float getRainfall() {
        return rainfall;
    }

    public void setRainfall(float rainfall) {
        this.rainfall = rainfall;
    }

    public int getLongCarNums() {
        return longCarNums;
    }

    public void setLongCarNums(int longCarNums) {
        this.longCarNums = longCarNums;
    }

    public float getLongCarSpeed() {
        return longCarSpeed;
    }

    public void setLongCarSpeed(float longCarSpeed) {
        this.longCarSpeed = longCarSpeed;
    }

    public int getMidCarNums() {
        return midCarNums;
    }

    public void setMidCarNums(int midCarNums) {
        this.midCarNums = midCarNums;
    }

    public float getMidCarSpeed() {
        return midCarSpeed;
    }

    public void setMidCarSpeed(float midCarSpeed) {
        this.midCarSpeed = midCarSpeed;
    }

    public int getShortCarNums() {
        return shortCarNums;
    }

    public void setShortCarNums(int shortCarNums) {
        this.shortCarNums = shortCarNums;
    }

    public float getShortCarSpeed() {
        return shortCarSpeed;
    }

    public void setShortCarSpeed(float shortCarSpeed) {
        this.shortCarSpeed = shortCarSpeed;
    }

    public float getPM25() {
        return PM25;
    }

    public void setPM25(float PM25) {
        this.PM25 = PM25;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getUsedRoom() {
        return usedRoom;
    }

    public void setUsedRoom(float usedRoom) {
        this.usedRoom = usedRoom;
    }

    public float getFreeRoom() {
        return freeRoom;
    }

    public void setFreeRoom(float freeRoom) {
        this.freeRoom = freeRoom;
    }

    public float getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(float batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public float getWorkingVoltage() {
        return workingVoltage;
    }

    public void setWorkingVoltage(float workingVoltage) {
        this.workingVoltage = workingVoltage;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public String getStataInfo() {
        return stataInfo;
    }

    public void setStataInfo(String stataInfo) {
        this.stataInfo = stataInfo;
    }

    public int getEvent_01() {
        return event_01;
    }

    public void setEvent_01(int event_01) {
        this.event_01 = event_01;
    }

    public int getEvent_02() {
        return event_02;
    }

    public void setEvent_02(int event_02) {
        this.event_02 = event_02;
    }

    public int getEvent_03() {
        return event_03;
    }

    public void setEvent_03(int event_03) {
        this.event_03 = event_03;
    }

    public int getEvent_04() {
        return event_04;
    }

    public void setEvent_04(int event_04) {
        this.event_04 = event_04;
    }

    public int getEvent_05() {
        return event_05;
    }

    public void setEvent_05(int event_05) {
        this.event_05 = event_05;
    }

    public int getEvent_06() {
        return event_06;
    }

    public void setEvent_06(int event_06) {
        this.event_06 = event_06;
    }

    public int getEvent_07() {
        return event_07;
    }

    public void setEvent_07(int event_07) {
        this.event_07 = event_07;
    }

    public int getEvent_08() {
        return event_08;
    }

    public void setEvent_08(int event_08) {
        this.event_08 = event_08;
    }

    public int getEvent_09() {
        return event_09;
    }

    public void setEvent_09(int event_09) {
        this.event_09 = event_09;
    }

    public int getEvent_10() {
        return event_10;
    }

    public void setEvent_10(int event_10) {
        this.event_10 = event_10;
    }

    public int getEvent_11() {
        return event_11;
    }

    public void setEvent_11(int event_11) {
        this.event_11 = event_11;
    }

    public int getEvent_12() {
        return event_12;
    }

    public void setEvent_12(int event_12) {
        this.event_12 = event_12;
    }

    public int getEvent_13() {
        return event_13;
    }

    public void setEvent_13(int event_13) {
        this.event_13 = event_13;
    }

    public int getHand_Adjust() {
        return hand_Adjust;
    }

    public void setHand_Adjust(int hand_Adjust) {
        this.hand_Adjust = hand_Adjust;
    }

    public int getAuto_Adjust() {
        return auto_Adjust;
    }

    public void setAuto_Adjust(int auto_Adjust) {
        this.auto_Adjust = auto_Adjust;
    }

    public int getAdjust_Before() {
        return adjust_Before;
    }

    public void setAdjust_Before(int adjust_Before) {
        this.adjust_Before = adjust_Before;
    }

    public int getAdjust_After() {
        return adjust_After;
    }

    public void setAdjust_After(int adjust_After) {
        this.adjust_After = adjust_After;
    }

    public int getEvent_0211() {
        return event_0211;
    }

    public void setEvent_0211(int event_0211) {
        this.event_0211 = event_0211;
    }

    public Date getEvent_01_stime() {
        return event_01_stime;
    }

    public void setEvent_01_stime(Date event_01_stime) {
        this.event_01_stime = event_01_stime;
    }

    public Date getEvent_02_stime() {
        return event_02_stime;
    }

    public void setEvent_02_stime(Date event_02_stime) {
        this.event_02_stime = event_02_stime;
    }

    public Date getEvent_03_stime() {
        return event_03_stime;
    }

    public void setEvent_03_stime(Date event_03_stime) {
        this.event_03_stime = event_03_stime;
    }

    public Date getEvent_04_stime() {
        return event_04_stime;
    }

    public void setEvent_04_stime(Date event_04_stime) {
        this.event_04_stime = event_04_stime;
    }

    public Date getEvent_05_stime() {
        return event_05_stime;
    }

    public void setEvent_05_stime(Date event_05_stime) {
        this.event_05_stime = event_05_stime;
    }

    public Date getEvent_06_stime() {
        return event_06_stime;
    }

    public void setEvent_06_stime(Date event_06_stime) {
        this.event_06_stime = event_06_stime;
    }

    public Date getEvent_07_stime() {
        return event_07_stime;
    }

    public void setEvent_07_stime(Date event_07_stime) {
        this.event_07_stime = event_07_stime;
    }

    public Date getEvent_08_stime() {
        return event_08_stime;
    }

    public void setEvent_08_stime(Date event_08_stime) {
        this.event_08_stime = event_08_stime;
    }

    public Date getEvent_09_stime() {
        return event_09_stime;
    }

    public void setEvent_09_stime(Date event_09_stime) {
        this.event_09_stime = event_09_stime;
    }

    public Date getEvent_10_stime() {
        return event_10_stime;
    }

    public void setEvent_10_stime(Date event_10_stime) {
        this.event_10_stime = event_10_stime;
    }

    public Date getEvent_11_stime() {
        return event_11_stime;
    }

    public void setEvent_11_stime(Date event_11_stime) {
        this.event_11_stime = event_11_stime;
    }

    public Date getEvent_12_stime() {
        return event_12_stime;
    }

    public void setEvent_12_stime(Date event_12_stime) {
        this.event_12_stime = event_12_stime;
    }

    public Date getEvent_13_stime() {
        return event_13_stime;
    }

    public void setEvent_13_stime(Date event_13_stime) {
        this.event_13_stime = event_13_stime;
    }

    public Date getEvent_0211_stime() {
        return event_0211_stime;
    }

    public void setEvent_0211_stime(Date event_0211_stime) {
        this.event_0211_stime = event_0211_stime;
    }

    public Date getEvent_01_etime() {
        return event_01_etime;
    }

    public void setEvent_01_etime(Date event_01_etime) {
        this.event_01_etime = event_01_etime;
    }

    public Date getEvent_02_etime() {
        return event_02_etime;
    }

    public void setEvent_02_etime(Date event_02_etime) {
        this.event_02_etime = event_02_etime;
    }

    public Date getEvent_03_etime() {
        return event_03_etime;
    }

    public void setEvent_03_etime(Date event_03_etime) {
        this.event_03_etime = event_03_etime;
    }

    public Date getEvent_04_etime() {
        return event_04_etime;
    }

    public void setEvent_04_etime(Date event_04_etime) {
        this.event_04_etime = event_04_etime;
    }

    public Date getEvent_05_etime() {
        return event_05_etime;
    }

    public void setEvent_05_etime(Date event_05_etime) {
        this.event_05_etime = event_05_etime;
    }

    public Date getEvent_06_etime() {
        return event_06_etime;
    }

    public void setEvent_06_etime(Date event_06_etime) {
        this.event_06_etime = event_06_etime;
    }

    public Date getEvent_07_etime() {
        return event_07_etime;
    }

    public void setEvent_07_etime(Date event_07_etime) {
        this.event_07_etime = event_07_etime;
    }

    public Date getEvent_08_etime() {
        return event_08_etime;
    }

    public void setEvent_08_etime(Date event_08_etime) {
        this.event_08_etime = event_08_etime;
    }

    public Date getEvent_09_etime() {
        return event_09_etime;
    }

    public void setEvent_09_etime(Date event_09_etime) {
        this.event_09_etime = event_09_etime;
    }

    public Date getEvent_10_etime() {
        return event_10_etime;
    }

    public void setEvent_10_etime(Date event_10_etime) {
        this.event_10_etime = event_10_etime;
    }

    public Date getEvent_11_etime() {
        return event_11_etime;
    }

    public void setEvent_11_etime(Date event_11_etime) {
        this.event_11_etime = event_11_etime;
    }

    public Date getEvent_12_etime() {
        return event_12_etime;
    }

    public void setEvent_12_etime(Date event_12_etime) {
        this.event_12_etime = event_12_etime;
    }

    public Date getEvent_13_etime() {
        return event_13_etime;
    }

    public void setEvent_13_etime(Date event_13_etime) {
        this.event_13_etime = event_13_etime;
    }

    public Date getEvent_0211_etime() {
        return event_0211_etime;
    }

    public void setEvent_0211_etime(Date event_0211_etime) {
        this.event_0211_etime = event_0211_etime;
    }

    public StateNoise() {
    }

    public StateNoise(String deviceCode, int linkState) {
        this.deviceCode = deviceCode;
        this.linkState = linkState;
    }

    @Override
    public String toString() {
        return "StateNoise{" +
                "deviceCode=" + deviceCode +
                ", linkState=" + linkState +
                ", networkState=" + networkState +
                ", nowDateTime=" + nowDateTime +
                ", lpTime=" + lpTime +
                ", LEQZ=" + LEQZ +
                ", LEQC=" + LEQC +
                ", LEQA=" + LEQA +
                ", LPFZ=" + LPFZ +
                ", LPSZ=" + LPSZ +
                ", LPIZ=" + LPIZ +
                ", LPFC=" + LPFC +
                ", LPSC=" + LPSC +
                ", LPIC=" + LPIC +
                ", LPFA=" + LPFA +
                ", LPSA=" + LPSA +
                ", LPIA=" + LPIA +
                ", PEAKZ=" + PEAKZ +
                ", PEAKC=" + PEAKC +
                ", PEAKA=" + PEAKA +
                ", windSpeed=" + windSpeed +
                ", outTemperature=" + outTemperature +
                ", humi_R=" + humi_R +
                ", w_Direction=" + w_Direction +
                ", outHumidity=" + outHumidity +
                ", ariPressure=" + ariPressure +
                ", rainfall=" + rainfall +
                ", longCarNums=" + longCarNums +
                ", longCarSpeed=" + longCarSpeed +
                ", midCarNums=" + midCarNums +
                ", midCarSpeed=" + midCarSpeed +
                ", shortCarNums=" + shortCarNums +
                ", shortCarSpeed=" + shortCarSpeed +
                ", PM25=" + PM25 +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", speed=" + speed +
                ", usedRoom=" + usedRoom +
                ", freeRoom=" + freeRoom +
                ", batteryVoltage=" + batteryVoltage +
                ", workingVoltage=" + workingVoltage +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", stataInfo='" + stataInfo + '\'' +
                ", event_01=" + event_01 +
                ", event_02=" + event_02 +
                ", event_03=" + event_03 +
                ", event_04=" + event_04 +
                ", event_05=" + event_05 +
                ", event_06=" + event_06 +
                ", event_07=" + event_07 +
                ", event_08=" + event_08 +
                ", event_09=" + event_09 +
                ", event_10=" + event_10 +
                ", event_11=" + event_11 +
                ", event_12=" + event_12 +
                ", event_13=" + event_13 +
                ", hand_Adjust=" + hand_Adjust +
                ", auto_Adjust=" + auto_Adjust +
                ", adjust_Before=" + adjust_Before +
                ", adjust_After=" + adjust_After +
                ", event_0211=" + event_0211 +
                ", event_01_stime=" + event_01_stime +
                ", event_02_stime=" + event_02_stime +
                ", event_03_stime=" + event_03_stime +
                ", event_04_stime=" + event_04_stime +
                ", event_05_stime=" + event_05_stime +
                ", event_06_stime=" + event_06_stime +
                ", event_07_stime=" + event_07_stime +
                ", event_08_stime=" + event_08_stime +
                ", event_09_stime=" + event_09_stime +
                ", event_10_stime=" + event_10_stime +
                ", event_11_stime=" + event_11_stime +
                ", event_12_stime=" + event_12_stime +
                ", event_13_stime=" + event_13_stime +
                ", event_0211_stime=" + event_0211_stime +
                ", event_01_etime=" + event_01_etime +
                ", event_02_etime=" + event_02_etime +
                ", event_03_etime=" + event_03_etime +
                ", event_04_etime=" + event_04_etime +
                ", event_05_etime=" + event_05_etime +
                ", event_06_etime=" + event_06_etime +
                ", event_07_etime=" + event_07_etime +
                ", event_08_etime=" + event_08_etime +
                ", event_09_etime=" + event_09_etime +
                ", event_10_etime=" + event_10_etime +
                ", event_11_etime=" + event_11_etime +
                ", event_12_etime=" + event_12_etime +
                ", event_13_etime=" + event_13_etime +
                ", event_0211_etime=" + event_0211_etime +
                '}';
    }

    public StateNoise(String deviceCode, int linkState, int networkState, Date nowDateTime, float lpTime, float LEQZ, float LEQC, float LEQA, float LPFZ, float LPSZ, float LPIZ, float LPFC, float LPSC, float LPIC, float LPFA, float LPSA, float LPIA, float PEAKZ, float PEAKC, float PEAKA, float windSpeed, float outTemperature, float humi_R, float w_Direction, float outHumidity, float ariPressure, float rainfall, int longCarNums, float longCarSpeed, int midCarNums, float midCarSpeed, int shortCarNums, float shortCarSpeed, float PM25, float longitude, float latitude, float speed, float usedRoom, float freeRoom, float batteryVoltage, float workingVoltage, float temperature, float humidity, String stataInfo, int event_01, int event_02, int event_03, int event_04, int event_05, int event_06, int event_07, int event_08, int event_09, int event_10, int event_11, int event_12, int event_13, int hand_Adjust, int auto_Adjust, int adjust_Before, int adjust_After, int event_0211, Date event_01_stime, Date event_02_stime, Date event_03_stime, Date event_04_stime, Date event_05_stime, Date event_06_stime, Date event_07_stime, Date event_08_stime, Date event_09_stime, Date event_10_stime, Date event_11_stime, Date event_12_stime, Date event_13_stime, Date event_0211_stime, Date event_01_etime, Date event_02_etime, Date event_03_etime, Date event_04_etime, Date event_05_etime, Date event_06_etime, Date event_07_etime, Date event_08_etime, Date event_09_etime, Date event_10_etime, Date event_11_etime, Date event_12_etime, Date event_13_etime, Date event_0211_etime) {
        this.deviceCode = deviceCode;
        this.linkState = linkState;
        this.networkState = networkState;
        this.nowDateTime = nowDateTime;
        this.lpTime = lpTime;
        this.LEQZ = LEQZ;
        this.LEQC = LEQC;
        this.LEQA = LEQA;
        this.LPFZ = LPFZ;
        this.LPSZ = LPSZ;
        this.LPIZ = LPIZ;
        this.LPFC = LPFC;
        this.LPSC = LPSC;
        this.LPIC = LPIC;
        this.LPFA = LPFA;
        this.LPSA = LPSA;
        this.LPIA = LPIA;
        this.PEAKZ = PEAKZ;
        this.PEAKC = PEAKC;
        this.PEAKA = PEAKA;
        this.windSpeed = windSpeed;
        this.outTemperature = outTemperature;
        this.humi_R = humi_R;
        this.w_Direction = w_Direction;
        this.outHumidity = outHumidity;
        this.ariPressure = ariPressure;
        this.rainfall = rainfall;
        this.longCarNums = longCarNums;
        this.longCarSpeed = longCarSpeed;
        this.midCarNums = midCarNums;
        this.midCarSpeed = midCarSpeed;
        this.shortCarNums = shortCarNums;
        this.shortCarSpeed = shortCarSpeed;
        this.PM25 = PM25;
        this.longitude = longitude;
        this.latitude = latitude;
        this.speed = speed;
        this.usedRoom = usedRoom;
        this.freeRoom = freeRoom;
        this.batteryVoltage = batteryVoltage;
        this.workingVoltage = workingVoltage;
        this.temperature = temperature;
        this.humidity = humidity;
        this.stataInfo = stataInfo;
        this.event_01 = event_01;
        this.event_02 = event_02;
        this.event_03 = event_03;
        this.event_04 = event_04;
        this.event_05 = event_05;
        this.event_06 = event_06;
        this.event_07 = event_07;
        this.event_08 = event_08;
        this.event_09 = event_09;
        this.event_10 = event_10;
        this.event_11 = event_11;
        this.event_12 = event_12;
        this.event_13 = event_13;
        this.hand_Adjust = hand_Adjust;
        this.auto_Adjust = auto_Adjust;
        this.adjust_Before = adjust_Before;
        this.adjust_After = adjust_After;
        this.event_0211 = event_0211;
        this.event_01_stime = event_01_stime;
        this.event_02_stime = event_02_stime;
        this.event_03_stime = event_03_stime;
        this.event_04_stime = event_04_stime;
        this.event_05_stime = event_05_stime;
        this.event_06_stime = event_06_stime;
        this.event_07_stime = event_07_stime;
        this.event_08_stime = event_08_stime;
        this.event_09_stime = event_09_stime;
        this.event_10_stime = event_10_stime;
        this.event_11_stime = event_11_stime;
        this.event_12_stime = event_12_stime;
        this.event_13_stime = event_13_stime;
        this.event_0211_stime = event_0211_stime;
        this.event_01_etime = event_01_etime;
        this.event_02_etime = event_02_etime;
        this.event_03_etime = event_03_etime;
        this.event_04_etime = event_04_etime;
        this.event_05_etime = event_05_etime;
        this.event_06_etime = event_06_etime;
        this.event_07_etime = event_07_etime;
        this.event_08_etime = event_08_etime;
        this.event_09_etime = event_09_etime;
        this.event_10_etime = event_10_etime;
        this.event_11_etime = event_11_etime;
        this.event_12_etime = event_12_etime;
        this.event_13_etime = event_13_etime;
        this.event_0211_etime = event_0211_etime;
    }
}
