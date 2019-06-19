package com.hzaihua.jfoenix.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class StateNoise {
    private StringProperty deviceCode;//设备编号
    private SimpleIntegerProperty linkState;//设备的连接状态
    private SimpleIntegerProperty networkState;
    private Date nowDateTime;
    private SimpleDoubleProperty lpTime;
    private SimpleDoubleProperty LEQZ;
    private SimpleDoubleProperty LEQC;
    private SimpleDoubleProperty LEQA;
    private SimpleDoubleProperty LPFZ;
    private SimpleDoubleProperty LPSZ;
    private SimpleDoubleProperty LPIZ;
    private SimpleDoubleProperty LPFC;
    private SimpleDoubleProperty LPSC;
    private SimpleDoubleProperty LPIC;
    private SimpleDoubleProperty LPFA;
    private SimpleDoubleProperty LPSA;
    private SimpleDoubleProperty LPIA;
    private SimpleDoubleProperty PEAKZ;
    private SimpleDoubleProperty PEAKC;
    private SimpleDoubleProperty PEAKA;
    private SimpleDoubleProperty windSpeed;
    private SimpleDoubleProperty outTemperature;
    private SimpleDoubleProperty humi_R;
    private SimpleDoubleProperty w_Direction;
    private SimpleDoubleProperty outHumidity;
    private SimpleDoubleProperty ariPressure;
    private SimpleDoubleProperty rainfall;
    private SimpleIntegerProperty longCarNums;
    private SimpleDoubleProperty longCarSpeed;
    private SimpleIntegerProperty midCarNums;
    private SimpleDoubleProperty midCarSpeed;
    private SimpleIntegerProperty shortCarNums;
    private SimpleDoubleProperty shortCarSpeed;
    private SimpleDoubleProperty PM25;
    private SimpleDoubleProperty PM10;
    private SimpleDoubleProperty longitude;
    private SimpleDoubleProperty latitude;
    private SimpleDoubleProperty speed;
    private SimpleDoubleProperty usedRoom;
    private SimpleDoubleProperty freeRoom;
    private SimpleDoubleProperty batteryVoltage;
    private SimpleDoubleProperty workingVoltage;
    private StringProperty SIMICCID;
    private StringProperty SIMIMSI;
    private SimpleDoubleProperty perFlux;
    private SimpleDoubleProperty avgSpeed;
    private SimpleDoubleProperty temperature;
    private SimpleDoubleProperty humidity;
    private StringProperty stataInfo;
    private SimpleIntegerProperty event_01;
    private SimpleIntegerProperty event_02;
    private SimpleIntegerProperty event_03;
    private SimpleIntegerProperty event_04;
    private SimpleIntegerProperty event_05;
    private SimpleIntegerProperty event_06;
    private SimpleIntegerProperty event_07;
    private SimpleIntegerProperty event_08;
    private SimpleIntegerProperty event_09;
    private SimpleIntegerProperty event_10;
    private SimpleIntegerProperty event_11;
    private SimpleIntegerProperty event_12;
    private SimpleIntegerProperty event_13;
    private SimpleIntegerProperty hand_Adjust;
    private SimpleIntegerProperty auto_Adjust;
    private SimpleIntegerProperty adjust_Before;
    private SimpleIntegerProperty adjust_After;
    private SimpleIntegerProperty event_0211;
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
                ", SIMICCID=" + SIMICCID +
                ", SIMIMSI=" + SIMIMSI +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", stataInfo=" + stataInfo +
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
        if(linkState == null){
            return 0;
        }
        return linkState.get();
    }

    public SimpleIntegerProperty linkStateProperty() {
        return linkState;
    }

    public void setLinkState(int linkState) {
        this.linkState = new SimpleIntegerProperty(linkState);
    }

    public int getNetworkState() {
        if(networkState == null){
            return 0;
        }
        return networkState.get();
    }

    public SimpleIntegerProperty networkStateProperty() {
        return networkState;
    }

    public void setNetworkState(int networkState) {
        this.networkState = new SimpleIntegerProperty(networkState);
    }

    public Date getNowDateTime() {
        if(nowDateTime == null){
            return new Date();
        }
        return nowDateTime;
    }

    public void setNowDateTime(Date nowDateTime) {
        this.nowDateTime = nowDateTime;
    }

    public double getLpTime() {
        if(lpTime == null){
            return 0;
        }
        return lpTime.get();
    }

    public SimpleDoubleProperty lpTimeProperty() {
        return lpTime;
    }

    public void setLpTime(double lpTime) {
        this.lpTime = new SimpleDoubleProperty(lpTime);
    }

    public double getLEQZ() {
        if(LEQZ == null){
            return 0;
        }
        return LEQZ.get();
    }

    public SimpleDoubleProperty LEQZProperty() {
        return LEQZ;
    }

    public void setLEQZ(double LEQZ) {
        this.LEQZ = new SimpleDoubleProperty(LEQZ);
    }

    public double getLEQC() {
        if(LEQC == null){
            return 0;
        }
        return LEQC.get();
    }

    public SimpleDoubleProperty LEQCProperty() {
        return LEQC;
    }

    public void setLEQC(double LEQC) {
        this.LEQC = new SimpleDoubleProperty(LEQC);
    }

    public double getLEQA() {
        if(LEQA == null){
            return 0;
        }
        return LEQA.get();
    }

    public SimpleDoubleProperty LEQAProperty() {
        return LEQA;
    }

    public void setLEQA(double LEQA) {
        this.LEQA = new SimpleDoubleProperty(LEQA);
    }

    public double getLPFZ() {
        if(LPFZ == null){
            return 0;
        }
        return LPFZ.get();
    }

    public SimpleDoubleProperty LPFZProperty() {
        return LPFZ;
    }

    public void setLPFZ(double LPFZ) {
        this.LPFZ = new SimpleDoubleProperty(LPFZ);
    }

    public double getLPSZ() {
        if(LPSZ == null){
            return 0;
        }
        return LPSZ.get();
    }

    public SimpleDoubleProperty LPSZProperty() {
        return LPSZ;
    }

    public void setLPSZ(double LPSZ) {
        this.LPSZ = new SimpleDoubleProperty(LPSZ);
    }

    public double getLPIZ() {
        if(LPIZ == null){
            return 0;
        }
        return LPIZ.get();
    }

    public SimpleDoubleProperty LPIZProperty() {
        return LPIZ;
    }

    public void setLPIZ(double LPIZ) {
        this.LPIZ = new SimpleDoubleProperty(LPIZ);
    }

    public double getLPFC() {
        if(LPFC == null){
            return 0;
        }
        return LPFC.get();
    }

    public SimpleDoubleProperty LPFCProperty() {
        return LPFC;
    }

    public void setLPFC(double LPFC) {
        this.LPFC = new SimpleDoubleProperty(LPFC);
    }

    public double getLPSC() {
        if(LPSC == null){
            return 0;
        }
        return LPSC.get();
    }

    public SimpleDoubleProperty LPSCProperty() {
        return LPSC;
    }

    public void setLPSC(double LPSC) {
        this.LPSC = new SimpleDoubleProperty(LPSC);
    }

    public double getLPIC() {
        if(LPIC == null){
            return 0;
        }
        return LPIC.get();
    }

    public SimpleDoubleProperty LPICProperty() {
        return LPIC;
    }

    public void setLPIC(double LPIC) {
        this.LPIC = new SimpleDoubleProperty(LPIC);
    }

    public double getLPFA() {
        if(LPFA == null){
            return 0;
        }
        return LPFA.get();
    }

    public SimpleDoubleProperty LPFAProperty() {
        return LPFA;
    }

    public void setLPFA(double LPFA) {
        this.LPFA = new SimpleDoubleProperty(LPFA);
    }

    public double getLPSA() {
        if(LPSA == null){
            return 0;
        }
        return LPSA.get();
    }

    public SimpleDoubleProperty LPSAProperty() {
        return LPSA;
    }

    public void setLPSA(double LPSA) {
        this.LPSA = new SimpleDoubleProperty(LPSA);
    }

    public double getLPIA() {
        if(LPIA == null){
            return 0;
        }
        return LPIA.get();
    }

    public SimpleDoubleProperty LPIAProperty() {
        return LPIA;
    }

    public void setLPIA(double LPIA) {
        this.LPIA = new SimpleDoubleProperty(LPIA);
    }

    public double getPEAKZ() {
        if(PEAKZ == null){
            return 0;
        }
        return PEAKZ.get();
    }

    public SimpleDoubleProperty PEAKZProperty() {
        return PEAKZ;
    }

    public void setPEAKZ(double PEAKZ) {
        this.PEAKZ = new SimpleDoubleProperty(PEAKZ);
    }

    public double getPEAKC() {
        if(PEAKC == null){
            return 0;
        }
        return PEAKC.get();
    }

    public SimpleDoubleProperty PEAKCProperty() {
        return PEAKC;
    }

    public void setPEAKC(double PEAKC) {
        this.PEAKC = new SimpleDoubleProperty(PEAKC);
    }

    public double getPEAKA() {
        if(PEAKA == null){
            return 0;
        }
        return PEAKA.get();
    }

    public SimpleDoubleProperty PEAKAProperty() {
        return PEAKA;
    }

    public void setPEAKA(double PEAKA) {
        this.PEAKA = new SimpleDoubleProperty(PEAKA);
    }

    public double getWindSpeed() {
        if(windSpeed == null){
            return 0;
        }
        return windSpeed.get();
    }

    public SimpleDoubleProperty windSpeedProperty() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = new SimpleDoubleProperty(windSpeed);
    }

    public double getOutTemperature() {
        if(outTemperature == null){
            return 0;
        }
        return outTemperature.get();
    }

    public SimpleDoubleProperty outTemperatureProperty() {
        return outTemperature;
    }

    public void setOutTemperature(double outTemperature) {
        this.outTemperature = new SimpleDoubleProperty(outTemperature);
    }

    public double getHumi_R() {
        if(humi_R == null){
            return 0;
        }
        return humi_R.get();
    }

    public SimpleDoubleProperty humi_RProperty() {
        return humi_R;
    }

    public void setHumi_R(double humi_R) {
        this.humi_R = new SimpleDoubleProperty(humi_R);
    }

    public double getW_Direction() {
        if(w_Direction == null){
            return 0;
        }
        return w_Direction.get();
    }

    public SimpleDoubleProperty w_DirectionProperty() {
        return w_Direction;
    }

    public void setW_Direction(double w_Direction) {
        this.w_Direction = new SimpleDoubleProperty(w_Direction);
    }

    public double getOutHumidity() {
        if(outHumidity == null){
            return 0;
        }
        return outHumidity.get();
    }

    public SimpleDoubleProperty outHumidityProperty() {
        return outHumidity;
    }

    public void setOutHumidity(double outHumidity) {
        this.outHumidity = new SimpleDoubleProperty(outHumidity);
    }

    public double getAriPressure() {
        if(ariPressure == null){
            return 0;
        }
        return ariPressure.get();
    }

    public SimpleDoubleProperty ariPressureProperty() {
        return ariPressure;
    }

    public void setAriPressure(double ariPressure) {
        this.ariPressure = new SimpleDoubleProperty(ariPressure);
    }

    public double getRainfall() {
        if(rainfall == null){
            return 0;
        }
        return rainfall.get();
    }

    public SimpleDoubleProperty rainfallProperty() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = new SimpleDoubleProperty(rainfall);
    }

    public int getLongCarNums() {
        if(longCarNums == null){
            return 0;
        }
        return longCarNums.get();
    }

    public SimpleIntegerProperty longCarNumsProperty() {
        return longCarNums;
    }

    public void setLongCarNums(int longCarNums) {
        this.longCarNums = new SimpleIntegerProperty(longCarNums);
    }

    public double getLongCarSpeed() {
        if(longCarSpeed == null){
            return 0;
        }
        return longCarSpeed.get();
    }

    public SimpleDoubleProperty longCarSpeedProperty() {
        return longCarSpeed;
    }

    public void setLongCarSpeed(double longCarSpeed) {
        this.longCarSpeed = new SimpleDoubleProperty(longCarSpeed);
    }

    public int getMidCarNums() {
        if(midCarNums == null){
            return 0;
        }
        return midCarNums.get();
    }

    public SimpleIntegerProperty midCarNumsProperty() {
        return midCarNums;
    }

    public void setMidCarNums(int midCarNums) {
        this.midCarNums = new SimpleIntegerProperty(midCarNums);
    }

    public double getMidCarSpeed() {
        if(midCarSpeed == null){
            return 0;
        }
        return midCarSpeed.get();
    }

    public SimpleDoubleProperty midCarSpeedProperty() {
        return midCarSpeed;
    }

    public void setMidCarSpeed(double midCarSpeed) {
        this.midCarSpeed = new SimpleDoubleProperty(midCarSpeed);
    }

    public int getShortCarNums() {
        if(shortCarNums == null){
            return 0;
        }
        return shortCarNums.get();
    }

    public SimpleIntegerProperty shortCarNumsProperty() {
        return shortCarNums;
    }

    public void setShortCarNums(int shortCarNums) {
        this.shortCarNums = new SimpleIntegerProperty(shortCarNums);
    }

    public double getShortCarSpeed() {
        if(shortCarSpeed == null){
            return 0;
        }
        return shortCarSpeed.get();
    }

    public SimpleDoubleProperty shortCarSpeedProperty() {
        return shortCarSpeed;
    }

    public void setShortCarSpeed(double shortCarSpeed) {
        this.shortCarSpeed = new SimpleDoubleProperty(shortCarSpeed);
    }

    public double getPM25() {
        if(PM25 == null){
            return 0;
        }
        return PM25.get();
    }

    public SimpleDoubleProperty PM25Property() {
        return PM25;
    }

    public void setPM25(double PM25) {
        this.PM25 = new SimpleDoubleProperty(PM25);
    }

    public double getPM10() {
        if(PM10 == null){
            return 0;
        }
        return PM10.get();
    }

    public SimpleDoubleProperty PM10Property() {
        return PM10;
    }

    public void setPM10(double PM10) {
        this.PM10 = new SimpleDoubleProperty(PM10);
    }

    public double getPerFlux() {
        if(perFlux == null){
            return 0;
        }
        return perFlux.get();
    }

    public SimpleDoubleProperty perFluxProperty() {
        return perFlux;
    }

    public void setPerFlux(double perFlux) {
        this.perFlux = new SimpleDoubleProperty(perFlux);
    }

    public double getAvgSpeed() {
        if(avgSpeed == null){
            return 0;
        }
        return avgSpeed.get();
    }

    public SimpleDoubleProperty avgSpeedProperty() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = new SimpleDoubleProperty(avgSpeed);
    }

    public double getLongitude() {
        if(longitude == null){
            return 0;
        }
        return longitude.get();
    }

    public SimpleDoubleProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = new SimpleDoubleProperty(longitude);
    }

    public double getLatitude() {
        if(latitude == null){
            return 0;
        }
        return latitude.get();
    }

    public SimpleDoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = new SimpleDoubleProperty(latitude);
    }

    public double getSpeed() {
        if(speed == null){
            return 0;
        }
        return speed.get();
    }

    public SimpleDoubleProperty speedProperty() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = new SimpleDoubleProperty(speed);
    }

    public double getUsedRoom() {
        if(usedRoom == null){
            return 0;
        }
        return usedRoom.get();
    }

    public SimpleDoubleProperty usedRoomProperty() {
        return usedRoom;
    }

    public void setUsedRoom(double usedRoom) {
        this.usedRoom = new SimpleDoubleProperty(usedRoom);
    }

    public double getFreeRoom() {
        if(freeRoom == null){
            return 0;
        }
        return freeRoom.get();
    }

    public SimpleDoubleProperty freeRoomProperty() {
        return freeRoom;
    }

    public void setFreeRoom(double freeRoom) {
        this.freeRoom = new SimpleDoubleProperty(freeRoom);
    }

    public double getBatteryVoltage() {
        if(batteryVoltage == null){
            return 0;
        }
        return batteryVoltage.get();
    }

    public SimpleDoubleProperty batteryVoltageProperty() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(double batteryVoltage) {
        this.batteryVoltage = new SimpleDoubleProperty(batteryVoltage);
    }

    public double getWorkingVoltage() {
        if(workingVoltage == null){
            return 0;
        }
        return workingVoltage.get();
    }

    public SimpleDoubleProperty workingVoltageProperty() {
        return workingVoltage;
    }

    public void setWorkingVoltage(double workingVoltage) {
        this.workingVoltage = new SimpleDoubleProperty(workingVoltage);
    }
    public String getSIMICCID() {
        if(SIMIMSI == null){
            return "";
        }
        return SIMICCID.get();
    }

    public StringProperty SIMICCIDProperty() {
        return SIMICCID;
    }

    public void setSIMICCID(String SIMICCID) {
        this.SIMICCID = new SimpleStringProperty(SIMICCID);
    }

    public String getSIMIMSI() {
        if(SIMIMSI == null){
            return "";
        }
        return SIMIMSI.get();
    }

    public StringProperty SIMIMSIProperty() {
        return SIMIMSI;
    }

    public void setSIMIMSI(String SIMIMSI) {
        this.SIMIMSI = new SimpleStringProperty(SIMIMSI);
    }

    public double getTemperature() {
        if (temperature == null){
            return 0;
        }
        return temperature.get();
    }

    public SimpleDoubleProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = new SimpleDoubleProperty(temperature);
    }

    public double getHumidity() {
        if(humidity == null){
            return 0;
        }
        return humidity.get();
    }

    public SimpleDoubleProperty humidityProperty() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = new SimpleDoubleProperty(humidity);
    }

    public String getStataInfo() {
        if(stataInfo == null){
            return "";
        }
        return stataInfo.get();
    }

    public StringProperty stataInfoProperty() {
        return stataInfo;
    }

    public void setStataInfo(String stataInfo) {
        this.stataInfo = new SimpleStringProperty(stataInfo);
    }

    public int getEvent_01() {
        if(event_01 == null){
            return 0;
        }
        return event_01.get();
    }

    public SimpleIntegerProperty event_01Property() {
        return event_01;
    }

    public void setEvent_01(int event_01) {
        this.event_01 = new SimpleIntegerProperty(event_01);
    }

    public int getEvent_02() {
        if(event_02 == null){
            return 0;
        }
        return event_02.get();
    }

    public SimpleIntegerProperty event_02Property() {
        return event_02;
    }

    public void setEvent_02(int event_02) {
        this.event_02 = new SimpleIntegerProperty(event_02);
    }

    public int getEvent_03() {
        if(event_03 == null){
            return 0;
        }
        return event_03.get();
    }

    public SimpleIntegerProperty event_03Property() {
        return event_03;
    }

    public void setEvent_03(int event_03) {
        this.event_03 = new SimpleIntegerProperty(event_03);
    }

    public int getEvent_04() {
        if(event_04 == null){
            return 0;
        }
        return event_04.get();
    }

    public SimpleIntegerProperty event_04Property() {
        return event_04;
    }

    public void setEvent_04(int event_04) {
        this.event_04 = new SimpleIntegerProperty(event_04);
    }

    public int getEvent_05() {
        if(event_05 == null){
            return 0;
        }
        return event_05.get();
    }

    public SimpleIntegerProperty event_05Property() {
        return event_05;
    }

    public void setEvent_05(int event_05) {
        this.event_05 = new SimpleIntegerProperty(event_05);
    }

    public int getEvent_06() {
        if(event_06 == null){
            return 0;
        }
        return event_06.get();
    }

    public SimpleIntegerProperty event_06Property() {
        return event_06;
    }

    public void setEvent_06(int event_06) {
        this.event_06 = new SimpleIntegerProperty(event_06);
    }

    public int getEvent_07() {
        if(event_07 == null){
            return 0;
        }
        return event_07.get();
    }

    public SimpleIntegerProperty event_07Property() {
        return event_07;
    }

    public void setEvent_07(int event_07) {
        this.event_07 = new SimpleIntegerProperty(event_07);
    }

    public int getEvent_08() {
        if(event_08 == null){
            return 0;
        }
        return event_08.get();
    }

    public SimpleIntegerProperty event_08Property() {
        return event_08;
    }

    public void setEvent_08(int event_08) {
        this.event_08 = new SimpleIntegerProperty(event_08);
    }

    public int getEvent_09() {
        if(event_09 == null){
            return 0;
        }
        return event_09.get();
    }

    public SimpleIntegerProperty event_09Property() {
        return event_09;
    }

    public void setEvent_09(int event_09) {
        this.event_09 = new SimpleIntegerProperty(event_09);
    }

    public int getEvent_10() {
        if(event_10 == null){
            return 0;
        }
        return event_10.get();
    }

    public SimpleIntegerProperty event_10Property() {
        return event_10;
    }

    public void setEvent_10(int event_10) {
        this.event_10 = new SimpleIntegerProperty(event_10);
    }

    public int getEvent_11() {
        if(event_11 == null){
            return 0;
        }
        return event_11.get();
    }

    public SimpleIntegerProperty event_11Property() {
        return event_11;
    }

    public void setEvent_11(int event_11) {
        this.event_11 = new SimpleIntegerProperty(event_11);
    }

    public int getEvent_12() {
        if(event_12 == null){
            return 0;
        }
        return event_12.get();
    }

    public SimpleIntegerProperty event_12Property() {
        return event_12;
    }

    public void setEvent_12(int event_12) {
        this.event_12 = new SimpleIntegerProperty(event_12);
    }

    public int getEvent_13() {
        if(event_13 == null){
            return 0;
        }
        return event_13.get();
    }

    public SimpleIntegerProperty event_13Property() {
        return event_13;
    }

    public void setEvent_13(int event_13) {
        this.event_13 = new SimpleIntegerProperty(event_13);
    }

    public int getHand_Adjust() {
        if(hand_Adjust == null){
            return 0;
        }
        return hand_Adjust.get();
    }

    public SimpleIntegerProperty hand_AdjustProperty() {
        return hand_Adjust;
    }

    public void setHand_Adjust(int hand_Adjust) {
        this.hand_Adjust = new SimpleIntegerProperty(hand_Adjust);
    }

    public int getAuto_Adjust() {
        if(auto_Adjust == null){
            return 0;
        }
        return auto_Adjust.get();
    }

    public SimpleIntegerProperty auto_AdjustProperty() {
        return auto_Adjust;
    }

    public void setAuto_Adjust(int auto_Adjust) {
        this.auto_Adjust = new SimpleIntegerProperty(auto_Adjust);
    }

    public int getAdjust_Before() {
        if(adjust_Before == null){
            return 0;
        }
        return adjust_Before.get();
    }

    public SimpleIntegerProperty adjust_BeforeProperty() {
        return adjust_Before;
    }

    public void setAdjust_Before(int adjust_Before) {
        this.adjust_Before = new SimpleIntegerProperty(adjust_Before);
    }

    public int getAdjust_After() {
        if(adjust_After == null){
            return 0;
        }
        return adjust_After.get();
    }

    public SimpleIntegerProperty adjust_AfterProperty() {
        return adjust_After;
    }

    public void setAdjust_After(int adjust_After) {
        this.adjust_After = new SimpleIntegerProperty(adjust_After);
    }

    public int getEvent_0211() {
        if(event_0211 == null){
            return 0;
        }
        return event_0211.get();
    }

    public SimpleIntegerProperty event_0211Property() {
        return event_0211;
    }

    public void setEvent_0211(int event_0211) {
        this.event_0211 = new SimpleIntegerProperty(event_0211);
    }

    public Date getEvent_01_stime() {
        if(event_01_stime == null) return null;
        return event_01_stime;
    }

    public void setEvent_01_stime(Date event_01_stime) {
        this.event_01_stime = event_01_stime;
    }

    public Date getEvent_02_stime() {
        if(event_02_stime == null) return null;
        return event_02_stime;
    }

    public void setEvent_02_stime(Date event_02_stime) {
        this.event_02_stime = event_02_stime;
    }

    public Date getEvent_03_stime() {
        if(event_03_stime == null) return null;
        return event_03_stime;
    }

    public void setEvent_03_stime(Date event_03_stime) {
        this.event_03_stime = event_03_stime;
    }

    public Date getEvent_04_stime() {
        if(event_04_stime == null) return null;
        return event_04_stime;
    }

    public void setEvent_04_stime(Date event_04_stime) {
        this.event_04_stime = event_04_stime;
    }

    public Date getEvent_05_stime() {
        if(event_05_stime == null) return null;
        return event_05_stime;
    }

    public void setEvent_05_stime(Date event_05_stime) {
        this.event_05_stime = event_05_stime;
    }

    public Date getEvent_06_stime() {
        if(event_06_stime == null) return null;
        return event_06_stime;
    }

    public void setEvent_06_stime(Date event_06_stime) {
        this.event_06_stime = event_06_stime;
    }

    public Date getEvent_07_stime() {
        if(event_07_stime == null) return null;
        return event_07_stime;
    }

    public void setEvent_07_stime(Date event_07_stime) {
        this.event_07_stime = event_07_stime;
    }

    public Date getEvent_08_stime() {
        if(event_08_stime == null) return null;
        return event_08_stime;
    }

    public void setEvent_08_stime(Date event_08_stime) {
        this.event_08_stime = event_08_stime;
    }

    public Date getEvent_09_stime() {
        if(event_09_stime == null) return null;
        return event_09_stime;
    }

    public void setEvent_09_stime(Date event_09_stime) {
        this.event_09_stime = event_09_stime;
    }

    public Date getEvent_10_stime() {
        if(event_10_stime == null) return null;
        return event_10_stime;
    }

    public void setEvent_10_stime(Date event_10_stime) {
        this.event_10_stime = event_10_stime;
    }

    public Date getEvent_11_stime() {
        if(event_11_stime == null) return null;
        return event_11_stime;
    }

    public void setEvent_11_stime(Date event_11_stime) {
        this.event_11_stime = event_11_stime;
    }

    public Date getEvent_12_stime() {
        if(event_12_stime == null) return null;
        return event_12_stime;
    }

    public void setEvent_12_stime(Date event_12_stime) {
        this.event_12_stime = event_12_stime;
    }

    public Date getEvent_13_stime() {
        if(event_13_stime == null) return null;
        return event_13_stime;
    }

    public void setEvent_13_stime(Date event_13_stime) {
        this.event_13_stime = event_13_stime;
    }

    public Date getEvent_0211_stime() {
        if(event_0211_stime == null) return null;
        return event_0211_stime;
    }

    public void setEvent_0211_stime(Date event_0211_stime) {
        this.event_0211_stime = event_0211_stime;
    }

    public Date getEvent_01_etime() {
        if(event_01_etime == null) return null;
        return event_01_etime;
    }

    public void setEvent_01_etime(Date event_01_etime) {
        this.event_01_etime = event_01_etime;
    }

    public Date getEvent_02_etime() {
        if(event_02_etime == null) return null;
        return event_02_etime;
    }

    public void setEvent_02_etime(Date event_02_etime) {
        this.event_02_etime = event_02_etime;
    }

    public Date getEvent_03_etime() {
        if(event_03_etime == null) return null;
        return event_03_etime;
    }

    public void setEvent_03_etime(Date event_03_etime) {
        this.event_03_etime = event_03_etime;
    }

    public Date getEvent_04_etime() {
        if(event_04_etime == null) return null;
        return event_04_etime;
    }

    public void setEvent_04_etime(Date event_04_etime) {
        this.event_04_etime = event_04_etime;
    }

    public Date getEvent_05_etime() {
        if(event_05_etime == null) return null;
        return event_05_etime;
    }

    public void setEvent_05_etime(Date event_05_etime) {
        this.event_05_etime = event_05_etime;
    }

    public Date getEvent_06_etime() {
        if(event_06_etime == null) return null;
        return event_06_etime;
    }

    public void setEvent_06_etime(Date event_06_etime) {
        this.event_06_etime = event_06_etime;
    }

    public Date getEvent_07_etime() {
        if(event_07_etime == null) return null;
        return event_07_etime;
    }

    public void setEvent_07_etime(Date event_07_etime) {
        this.event_07_etime = event_07_etime;
    }

    public Date getEvent_08_etime() {
        if(event_08_etime == null) return null;
        return event_08_etime;
    }

    public void setEvent_08_etime(Date event_08_etime) {
        this.event_08_etime = event_08_etime;
    }

    public Date getEvent_09_etime() {
        if(event_09_etime == null) return null;
        return event_09_etime;
    }

    public void setEvent_09_etime(Date event_09_etime) {
        this.event_09_etime = event_09_etime;
    }

    public Date getEvent_10_etime() {
        if(event_10_etime == null) return null;
        return event_10_etime;
    }

    public void setEvent_10_etime(Date event_10_etime) {
        this.event_10_etime = event_10_etime;
    }

    public Date getEvent_11_etime() {
        if(event_11_etime == null) return null;
        return event_11_etime;
    }

    public void setEvent_11_etime(Date event_11_etime) {
        this.event_11_etime = event_11_etime;
    }

    public Date getEvent_12_etime() {
        if(event_12_etime == null) return null;
        return event_12_etime;
    }

    public void setEvent_12_etime(Date event_12_etime) {
        this.event_12_etime = event_12_etime;
    }

    public Date getEvent_13_etime() {
        if(event_13_etime == null) return null;
        return event_13_etime;
    }

    public void setEvent_13_etime(Date event_13_etime) {
        this.event_13_etime = event_13_etime;
    }

    public Date getEvent_0211_etime() {
        if(event_0211_etime == null) return null;
        return event_0211_etime;
    }

    public void setEvent_0211_etime(Date event_0211_etime) {
        this.event_0211_etime = event_0211_etime;
    }

    public StateNoise(String deviceCode, int linkState, int networkState, Date nowDateTime, double lpTime, double LEQZ, double LEQC, double LEQA, double LPFZ, double LPSZ, double LPIZ, double LPFC, double LPSC, double LPIC, double LPFA, double LPSA, double LPIA, double PEAKZ, double PEAKC, double PEAKA, double windSpeed, double outTemperature, double humi_R, double w_Direction, double outHumidity, double ariPressure, double rainfall, int longCarNums, double longCarSpeed, int midCarNums, double midCarSpeed, int shortCarNums, double shortCarSpeed, double PM25,double PM10, double perFlux, double avgSpeed, double longitude, double latitude, double speed, double usedRoom, double freeRoom, double batteryVoltage, double workingVoltage,String SIMICCID, String SIMIMSI,  double temperature, double humidity, String stataInfo, int event_01, int event_02, int event_03, int event_04, int event_05, int event_06, int event_07, int event_08, int event_09, int event_10, int event_11, int event_12, int event_13, int hand_Adjust, int auto_Adjust, int adjust_Before, int adjust_After, int event_0211, Date event_01_stime, Date event_02_stime, Date event_03_stime, Date event_04_stime, Date event_05_stime, Date event_06_stime, Date event_07_stime, Date event_08_stime, Date event_09_stime, Date event_10_stime, Date event_11_stime, Date event_12_stime, Date event_13_stime, Date event_0211_stime, Date event_01_etime, Date event_02_etime, Date event_03_etime, Date event_04_etime, Date event_05_etime, Date event_06_etime, Date event_07_etime, Date event_08_etime, Date event_09_etime, Date event_10_etime, Date event_11_etime, Date event_12_etime, Date event_13_etime, Date event_0211_etime) {
        this.deviceCode = new SimpleStringProperty(deviceCode);
        this.linkState = new SimpleIntegerProperty(linkState);
        this.networkState = new SimpleIntegerProperty(networkState);
        this.nowDateTime = nowDateTime;
        this.lpTime = new SimpleDoubleProperty(lpTime);
        this.LEQZ = new SimpleDoubleProperty(LEQZ);
        this.LEQC = new SimpleDoubleProperty(LEQC);
        this.LEQA = new SimpleDoubleProperty(LEQA);
        this.LPFZ = new SimpleDoubleProperty(LPFZ);
        this.LPSZ = new SimpleDoubleProperty(LPSZ);
        this.LPIZ = new SimpleDoubleProperty(LPIZ);
        this.LPFC = new SimpleDoubleProperty(LPFC);
        this.LPSC = new SimpleDoubleProperty(LPSC);
        this.LPIC = new SimpleDoubleProperty(LPIC);
        this.LPFA = new SimpleDoubleProperty(LPFA);
        this.LPSA = new SimpleDoubleProperty(LPSA);
        this.LPIA = new SimpleDoubleProperty(LPIA);
        this.PEAKZ = new SimpleDoubleProperty(PEAKZ);
        this.PEAKC = new SimpleDoubleProperty(PEAKC);
        this.PEAKA = new SimpleDoubleProperty(PEAKA);
        this.windSpeed = new SimpleDoubleProperty(windSpeed);
        this.outTemperature = new SimpleDoubleProperty(outTemperature);
        this.humi_R = new SimpleDoubleProperty(humi_R);
        this.w_Direction = new SimpleDoubleProperty(w_Direction);
        this.outHumidity = new SimpleDoubleProperty(outHumidity);
        this.ariPressure = new SimpleDoubleProperty(ariPressure);
        this.rainfall = new SimpleDoubleProperty(rainfall);
        this.longCarNums = new SimpleIntegerProperty(longCarNums);
        this.longCarSpeed = new SimpleDoubleProperty(longCarSpeed);
        this.midCarNums = new SimpleIntegerProperty(midCarNums);
        this.midCarSpeed = new SimpleDoubleProperty(midCarSpeed);
        this.shortCarNums = new SimpleIntegerProperty(shortCarNums);
        this.shortCarSpeed = new SimpleDoubleProperty(shortCarSpeed);
        this.PM25 = new SimpleDoubleProperty(PM25);
        this.PM10 = new SimpleDoubleProperty(PM10);
        this.perFlux = new SimpleDoubleProperty(perFlux);
        this.avgSpeed = new SimpleDoubleProperty(avgSpeed);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.latitude = new SimpleDoubleProperty(latitude);
        this.speed = new SimpleDoubleProperty(speed);
        this.usedRoom = new SimpleDoubleProperty(usedRoom);
        this.freeRoom = new SimpleDoubleProperty(freeRoom);
        this.batteryVoltage = new SimpleDoubleProperty(batteryVoltage);
        this.workingVoltage = new SimpleDoubleProperty(workingVoltage);
        this.SIMICCID = new SimpleStringProperty(SIMICCID);
        this.SIMIMSI = new SimpleStringProperty(SIMIMSI);
        this.temperature = new SimpleDoubleProperty(temperature);
        this.humidity = new SimpleDoubleProperty(humidity);
        this.stataInfo = new SimpleStringProperty(stataInfo);
        this.event_01 = new SimpleIntegerProperty(event_01);
        this.event_02 = new SimpleIntegerProperty(event_02);
        this.event_03 = new SimpleIntegerProperty(event_03);
        this.event_04 = new SimpleIntegerProperty(event_04);
        this.event_05 = new SimpleIntegerProperty(event_05);
        this.event_06 = new SimpleIntegerProperty(event_06);
        this.event_07 = new SimpleIntegerProperty(event_07);
        this.event_08 = new SimpleIntegerProperty(event_08);
        this.event_09 = new SimpleIntegerProperty(event_09);
        this.event_10 = new SimpleIntegerProperty(event_10);
        this.event_11 = new SimpleIntegerProperty(event_11);
        this.event_12 = new SimpleIntegerProperty(event_12);
        this.event_13 = new SimpleIntegerProperty(event_13);
        this.hand_Adjust = new SimpleIntegerProperty(hand_Adjust);
        this.auto_Adjust = new SimpleIntegerProperty(auto_Adjust);
        this.adjust_Before = new SimpleIntegerProperty(adjust_Before);
        this.adjust_After = new SimpleIntegerProperty(adjust_After);
        this.event_0211 = new SimpleIntegerProperty(event_0211);
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

    public StateNoise() {
    }
}
