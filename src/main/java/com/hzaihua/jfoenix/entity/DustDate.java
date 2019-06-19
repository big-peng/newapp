package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class DustDate extends RecursiveTreeObject<DustDate> {
    private StringProperty noiseCode;
    private Date measureTime;
    private SimpleIntegerProperty unitTime;
    private SimpleDoubleProperty TSP;
    private SimpleDoubleProperty PM10;
    private SimpleDoubleProperty PM2_5;
    private SimpleDoubleProperty SOx;
    private SimpleDoubleProperty NOx;
    private SimpleDoubleProperty anion;
    private SimpleDoubleProperty maxTSP;
    private SimpleDoubleProperty minTSP;
    private SimpleDoubleProperty maxPM10;
    private SimpleDoubleProperty minPM10;
    private SimpleDoubleProperty maxPM25;
    private SimpleDoubleProperty minPM25;
    private SimpleDoubleProperty maxSOx;
    private SimpleDoubleProperty minSOx;
    private SimpleDoubleProperty maxNOx;
    private SimpleDoubleProperty minNOx;
    private SimpleDoubleProperty maxAnion;
    private SimpleDoubleProperty minAnion;

    @Override
    public String toString() {
        return "DustDate{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", unitTime=" + unitTime +
                ", TSP=" + TSP +
                ", PM10=" + PM10 +
                ", PM2_5=" + PM2_5 +
                ", SOx=" + SOx +
                ", NOx=" + NOx +
                ", anion=" + anion +
                ", maxTSP=" + maxTSP +
                ", minTSP=" + minTSP +
                ", maxPM10=" + maxPM10 +
                ", minPM10=" + minPM10 +
                ", maxPM25=" + maxPM25 +
                ", minPM25=" + minPM25 +
                ", maxSOx=" + maxSOx +
                ", minSOx=" + minSOx +
                ", maxNOx=" + maxNOx +
                ", minNOx=" + minNOx +
                ", maxAnion=" + maxAnion +
                ", minAnion=" + minAnion +
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

    public double getMaxTSP() {
        return maxTSP.get();
    }

    public SimpleDoubleProperty maxTSPProperty() {
        return maxTSP;
    }

    public void setMaxTSP(double maxTSP) {
        this.maxTSP = new SimpleDoubleProperty(maxTSP);
    }

    public double getMinTSP() {
        return minTSP.get();
    }

    public SimpleDoubleProperty minTSPProperty() {
        return minTSP;
    }

    public void setMinTSP(double minTSP) {
        this.minTSP = new SimpleDoubleProperty(minTSP);
    }

    public double getMaxPM10() {
        return maxPM10.get();
    }

    public SimpleDoubleProperty maxPM10Property() {
        return maxPM10;
    }

    public void setMaxPM10(double maxPM10) {
        this.maxPM10 = new SimpleDoubleProperty(maxPM10);
    }

    public double getMinPM10() {
        return minPM10.get();
    }

    public SimpleDoubleProperty minPM10Property() {
        return minPM10;
    }

    public void setMinPM10(double minPM10) {
        this.minPM10 = new SimpleDoubleProperty(minPM10);
    }

    public double getMaxPM25() {
        return maxPM25.get();
    }

    public SimpleDoubleProperty maxPM25Property() {
        return maxPM25;
    }

    public void setMaxPM25(double maxPM25) {
        this.maxPM25 = new SimpleDoubleProperty(maxPM25);
    }

    public double getMinPM25() {
        return minPM25.get();
    }

    public SimpleDoubleProperty minPM25Property() {
        return minPM25;
    }

    public void setMinPM25(double minPM25) {
        this.minPM25 = new SimpleDoubleProperty(minPM25);
    }

    public double getMaxSOx() {
        return maxSOx.get();
    }

    public SimpleDoubleProperty maxSOxProperty() {
        return maxSOx;
    }

    public void setMaxSOx(double maxSOx) {
        this.maxSOx = new SimpleDoubleProperty(maxSOx);
    }

    public double getMinSOx() {
        return minSOx.get();
    }

    public SimpleDoubleProperty minSOxProperty() {
        return minSOx;
    }

    public void setMinSOx(double minSOx) {
        this.minSOx = new SimpleDoubleProperty(minSOx);
    }

    public double getMaxNOx() {
        return maxNOx.get();
    }

    public SimpleDoubleProperty maxNOxProperty() {
        return maxNOx;
    }

    public void setMaxNOx(double maxNOx) {
        this.maxNOx = new SimpleDoubleProperty(maxNOx);
    }

    public double getMinNOx() {
        return minNOx.get();
    }

    public SimpleDoubleProperty minNOxProperty() {
        return minNOx;
    }

    public void setMinNOx(double minNOx) {
        this.minNOx = new SimpleDoubleProperty(minNOx);
    }

    public double getMaxAnion() {
        return maxAnion.get();
    }

    public SimpleDoubleProperty maxAnionProperty() {
        return maxAnion;
    }

    public void setMaxAnion(double maxAnion) {
        this.maxAnion = new SimpleDoubleProperty(maxAnion);
    }

    public double getMinAnion() {
        return minAnion.get();
    }

    public SimpleDoubleProperty minAnionProperty() {
        return minAnion;
    }

    public void setMinAnion(double minAnion) {
        this.minAnion = new SimpleDoubleProperty(minAnion);
    }

    public DustDate(String noiseCode, Date measureTime, int unitTime, double TSP, double PM10, double PM2_5, double SOx, double NOx, double anion, double maxTSP, double minTSP, double maxPM10, double minPM10, double maxPM25, double minPM25, double maxSOx, double minSOx, double maxNOx, double minNOx, double maxAnion, double minAnion) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.unitTime = new SimpleIntegerProperty(unitTime);
        this.TSP = new SimpleDoubleProperty(TSP);
        this.PM10 = new SimpleDoubleProperty(PM10);
        this.PM2_5 = new SimpleDoubleProperty(PM2_5);
        this.SOx = new SimpleDoubleProperty(SOx);
        this.NOx = new SimpleDoubleProperty(NOx);
        this.anion = new SimpleDoubleProperty(anion);
        this.maxTSP = new SimpleDoubleProperty(maxTSP);
        this.minTSP = new SimpleDoubleProperty(minTSP);
        this.maxPM10 = new SimpleDoubleProperty(maxPM10);
        this.minPM10 = new SimpleDoubleProperty(minPM10);
        this.maxPM25 = new SimpleDoubleProperty(maxPM25);
        this.minPM25 = new SimpleDoubleProperty(minPM25);
        this.maxSOx = new SimpleDoubleProperty(maxSOx);
        this.minSOx = new SimpleDoubleProperty(minSOx);
        this.maxNOx = new SimpleDoubleProperty(maxNOx);
        this.minNOx = new SimpleDoubleProperty(minNOx);
        this.maxAnion = new SimpleDoubleProperty(maxAnion);
        this.minAnion = new SimpleDoubleProperty(minAnion);
    }

    public DustDate() {
    }
}
