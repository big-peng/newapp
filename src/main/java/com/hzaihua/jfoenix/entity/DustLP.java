package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

/**
 * 瞬时粉尘数据实体类
 * */
public class DustLP extends RecursiveTreeObject<DustLP> {
    private StringProperty noiseCode;
    private Date measureTime;
    private SimpleIntegerProperty unitTime;
    private SimpleDoubleProperty TSP;
    private SimpleDoubleProperty PM10;
    private SimpleDoubleProperty PM2_5;
    private SimpleDoubleProperty SOx;
    private SimpleDoubleProperty NOx;
    private SimpleDoubleProperty anion;

    @Override
    public String toString() {
        return "DustLP{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", unitTime=" + unitTime +
                ", TSP=" + TSP +
                ", PM10=" + PM10 +
                ", PM2_5=" + PM2_5 +
                ", SOx=" + SOx +
                ", NOx=" + NOx +
                ", anion=" + anion +
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

    public double getTSP() {
        return TSP.get();
    }

    public SimpleDoubleProperty TSPProperty() {
        return TSP;
    }

    public void setTSP(double TSP) {
        this.TSP = new SimpleDoubleProperty(TSP);
    }

    public double getPM10() {
        return PM10.get();
    }

    public SimpleDoubleProperty PM10Property() {
        return PM10;
    }

    public void setPM10(double PM10) {
        this.PM10 = new SimpleDoubleProperty(PM10);
    }

    public double getPM2_5() {
        return PM2_5.get();
    }

    public SimpleDoubleProperty PM2_5Property() {
        return PM2_5;
    }

    public void setPM2_5(double PM2_5) {
        this.PM2_5 = new SimpleDoubleProperty(PM2_5);
    }

    public double getSOx() {
        return SOx.get();
    }

    public SimpleDoubleProperty SOxProperty() {
        return SOx;
    }

    public void setSOx(double SOx) {
        this.SOx = new SimpleDoubleProperty(SOx);
    }

    public double getNOx() {
        return NOx.get();
    }

    public SimpleDoubleProperty NOxProperty() {
        return NOx;
    }

    public void setNOx(double NOx) {
        this.NOx = new SimpleDoubleProperty(NOx);
    }

    public double getAnion() {
        return anion.get();
    }

    public SimpleDoubleProperty anionProperty() {
        return anion;
    }

    public void setAnion(double anion) {
        this.anion = new SimpleDoubleProperty(anion);
    }

    public DustLP(String noiseCode, Date measureTime, int unitTime, double TSP, double PM10, double PM2_5, double SOx, double NOx, double anion) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.unitTime = new SimpleIntegerProperty(unitTime);
        this.TSP = new SimpleDoubleProperty(TSP);
        this.PM10 = new SimpleDoubleProperty(PM10);
        this.PM2_5 = new SimpleDoubleProperty(PM2_5);
        this.SOx = new SimpleDoubleProperty(SOx);
        this.NOx = new SimpleDoubleProperty(NOx);
        this.anion = new SimpleDoubleProperty(anion);
    }

    public DustLP() {
    }
}
