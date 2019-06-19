package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class WeatherLP extends RecursiveTreeObject<WeatherLP> {
    private StringProperty noiseCode; //设备编号
    private Date measureTime; //测量时间
    private SimpleIntegerProperty unitTime; //时间间隔
    private SimpleDoubleProperty w_Speed; //风速
    private SimpleDoubleProperty w_Direction; //风向
    private SimpleDoubleProperty a_Temp; //温度
    private SimpleDoubleProperty humi_R; //湿度
    private SimpleDoubleProperty ari_p; //气压
    private SimpleDoubleProperty PRF; //雨量

    @Override
    public String toString() {
        return "WeatherLP{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", unitTime=" + unitTime +
                ", w_Speed=" + w_Speed +
                ", w_Direction=" + w_Direction +
                ", a_Temp=" + a_Temp +
                ", humi_R=" + humi_R +
                ", ari_p=" + ari_p +
                ", PRF=" + PRF +
                '}';
    }

    public String getNoiseCode() {
        return noiseCode.get();
    }

    public StringProperty noiseCodeProperty() {
        return noiseCode;
    }

    public void setNoiseCode(String noiseCode) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
    }

    public Date getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(Date measureTime) {
        this.measureTime = measureTime;
    }

    public int getUnitTime() {
        return unitTime.get();
    }

    public SimpleIntegerProperty unitTimeProperty() {
        return unitTime;
    }

    public void setUnitTime(int unitTime) {
        this.unitTime = new SimpleIntegerProperty(unitTime);
    }

    public double getW_Speed() {
        return w_Speed.get();
    }

    public SimpleDoubleProperty w_SpeedProperty() {
        return w_Speed;
    }

    public void setW_Speed(double w_Speed) {
        this.w_Speed = new SimpleDoubleProperty(w_Speed);
    }

    public double getW_Direction() {
        return w_Direction.get();
    }

    public SimpleDoubleProperty w_DirectionProperty() {
        return w_Direction;
    }

    public void setW_Direction(double w_Direction) {
        this.w_Direction = new SimpleDoubleProperty(w_Direction);
    }

    public double getA_Temp() {
        return a_Temp.get();
    }

    public SimpleDoubleProperty a_TempProperty() {
        return a_Temp;
    }

    public void setA_Temp(double a_Temp) {
        this.a_Temp = new SimpleDoubleProperty(a_Temp);
    }

    public double getHumi_R() {
        return humi_R.get();
    }

    public SimpleDoubleProperty humi_RProperty() {
        return humi_R;
    }

    public void setHumi_R(double humi_R) {
        this.humi_R = new SimpleDoubleProperty(humi_R);
    }

    public double getAri_p() {
        return ari_p.get();
    }

    public SimpleDoubleProperty ari_pProperty() {
        return ari_p;
    }

    public void setAri_p(double ari_p) {
        this.ari_p = new SimpleDoubleProperty(ari_p);
    }

    public double getPRF() {
        return PRF.get();
    }

    public SimpleDoubleProperty PRFProperty() {
        return PRF;
    }

    public void setPRF(double PRF) {
        this.PRF = new SimpleDoubleProperty(PRF);
    }

    public WeatherLP(String noiseCode, Date measureTime, int unitTime, double w_Speed, double w_Direction, double a_Temp, double humi_R, double ari_p, double PRF) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.unitTime = new SimpleIntegerProperty(unitTime);
        this.w_Speed = new SimpleDoubleProperty(w_Speed);
        this.w_Direction = new SimpleDoubleProperty(w_Direction);
        this.a_Temp = new SimpleDoubleProperty(a_Temp);
        this.humi_R = new SimpleDoubleProperty(humi_R);
        this.ari_p = new SimpleDoubleProperty(ari_p);
        this.PRF = new SimpleDoubleProperty(PRF);
    }

    public WeatherLP() {
    }
}
