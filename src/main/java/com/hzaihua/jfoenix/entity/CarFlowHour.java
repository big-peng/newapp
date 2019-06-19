package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class CarFlowHour extends RecursiveTreeObject<CarFlowHour> {
    private StringProperty noiseCode;
    private Date measureTime;
    private StringProperty radarID;
    private SimpleIntegerProperty unitTime;
    private SimpleIntegerProperty roadWayNum;
    private SimpleDoubleProperty totalFlux;
    private SimpleDoubleProperty occupyRation;
    private SimpleDoubleProperty longRation;
    private SimpleDoubleProperty midRation;
    private SimpleDoubleProperty shortRation;
    private SimpleDoubleProperty avgSpeed;
    private SimpleDoubleProperty longSpeed;
    private SimpleDoubleProperty midSpeed;
    private SimpleDoubleProperty shortSpeed;
    private SimpleDoubleProperty preFlux;
    private SimpleDoubleProperty longCarNums;
    private SimpleDoubleProperty midCarNums;
    private SimpleDoubleProperty shortCarNums;

    @Override
    public String toString() {
        return "CarFlowHour{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", radarID=" + radarID +
                ", unitTime=" + unitTime +
                ", roadWayNum=" + roadWayNum +
                ", totalFlux=" + totalFlux +
                ", occupyRation=" + occupyRation +
                ", longRation=" + longRation +
                ", midRation=" + midRation +
                ", shortRation=" + shortRation +
                ", avgSpeed=" + avgSpeed +
                ", longSpeed=" + longSpeed +
                ", midSpeed=" + midSpeed +
                ", shortSpeed=" + shortSpeed +
                ", preFlux=" + preFlux +
                ", longCarNums=" + longCarNums +
                ", midCarNums=" + midCarNums +
                ", shortCarNums=" + shortCarNums +
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

    public String getRadarID() {
        return radarID.get();
    }

    public StringProperty radarIDProperty() {
        return radarID;
    }

    public void setRadarID(String radarID) {
        this.radarID = new SimpleStringProperty(radarID);
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

    public int getRoadWayNum() {
        return roadWayNum.get();
    }

    public SimpleIntegerProperty roadWayNumProperty() {
        return roadWayNum;
    }

    public void setRoadWayNum(int roadWayNum) {
        this.roadWayNum = new SimpleIntegerProperty(roadWayNum);
    }

    public double getTotalFlux() {
        return totalFlux.get();
    }

    public SimpleDoubleProperty totalFluxProperty() {
        return totalFlux;
    }

    public void setTotalFlux(double totalFlux) {
        this.totalFlux = new SimpleDoubleProperty(totalFlux);
    }

    public double getOccupyRation() {
        return occupyRation.get();
    }

    public SimpleDoubleProperty occupyRationProperty() {
        return occupyRation;
    }

    public void setOccupyRation(double occupyRation) {
        this.occupyRation = new SimpleDoubleProperty(occupyRation);
    }

    public double getLongRation() {
        return longRation.get();
    }

    public SimpleDoubleProperty longRationProperty() {
        return longRation;
    }

    public void setLongRation(double longRation) {
        this.longRation = new SimpleDoubleProperty(longRation);
    }

    public double getMidRation() {
        return midRation.get();
    }

    public SimpleDoubleProperty midRationProperty() {
        return midRation;
    }

    public void setMidRation(double midRation) {
        this.midRation = new SimpleDoubleProperty(midRation);
    }

    public double getShortRation() {
        return shortRation.get();
    }

    public SimpleDoubleProperty shortRationProperty() {
        return shortRation;
    }

    public void setShortRation(double shortRation) {
        this.shortRation = new SimpleDoubleProperty(shortRation);
    }

    public double getAvgSpeed() {
        return avgSpeed.get();
    }

    public SimpleDoubleProperty avgSpeedProperty() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = new SimpleDoubleProperty(avgSpeed);
    }

    public double getLongSpeed() {
        return longSpeed.get();
    }

    public SimpleDoubleProperty longSpeedProperty() {
        return longSpeed;
    }

    public void setLongSpeed(double longSpeed) {
        this.longSpeed = new SimpleDoubleProperty(longSpeed);
    }

    public double getMidSpeed() {
        return midSpeed.get();
    }

    public SimpleDoubleProperty midSpeedProperty() {
        return midSpeed;
    }

    public void setMidSpeed(double midSpeed) {
        this.midSpeed = new SimpleDoubleProperty(midSpeed);
    }

    public double getShortSpeed() {
        return shortSpeed.get();
    }

    public SimpleDoubleProperty shortSpeedProperty() {
        return shortSpeed;
    }

    public void setShortSpeed(double shortSpeed) {
        this.shortSpeed = new SimpleDoubleProperty(shortSpeed);
    }

    public double getPreFlux() {
        return preFlux.get();
    }

    public SimpleDoubleProperty preFluxProperty() {
        return preFlux;
    }

    public void setPreFlux(double preFlux) {
        this.preFlux = new SimpleDoubleProperty(preFlux);
    }

    public double getLongCarNums() {
        return longCarNums.get();
    }

    public SimpleDoubleProperty longCarNumsProperty() {
        return longCarNums;
    }

    public void setLongCarNums(double longCarNums) {
        this.longCarNums = new SimpleDoubleProperty(longCarNums);
    }

    public double getMidCarNums() {
        return midCarNums.get();
    }

    public SimpleDoubleProperty midCarNumsProperty() {
        return midCarNums;
    }

    public void setMidCarNums(double midCarNums) {
        this.midCarNums = new SimpleDoubleProperty(midCarNums);
    }

    public double getShortCarNums() {
        return shortCarNums.get();
    }

    public SimpleDoubleProperty shortCarNumsProperty() {
        return shortCarNums;
    }

    public void setShortCarNums(double shortCarNums) {
        this.shortCarNums = new SimpleDoubleProperty(shortCarNums);
    }

    public CarFlowHour(String noiseCode, Date measureTime, String radarID, int unitTime, int roadWayNum, double totalFlux, double occupyRation, double longRation, double midRation, double shortRation, double avgSpeed, double longSpeed, double midSpeed, double shortSpeed, double preFlux, double longCarNums, double midCarNums, double shortCarNums) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.radarID = new SimpleStringProperty(radarID);
        this.unitTime = new SimpleIntegerProperty(unitTime);
        this.roadWayNum = new SimpleIntegerProperty(roadWayNum);
        this.totalFlux = new SimpleDoubleProperty(totalFlux);
        this.occupyRation = new SimpleDoubleProperty(occupyRation);
        this.longRation = new SimpleDoubleProperty(longRation);
        this.midRation = new SimpleDoubleProperty(midRation);
        this.shortRation = new SimpleDoubleProperty(shortRation);
        this.avgSpeed = new SimpleDoubleProperty(avgSpeed);
        this.longSpeed = new SimpleDoubleProperty(longSpeed);
        this.midSpeed = new SimpleDoubleProperty(midSpeed);
        this.shortSpeed = new SimpleDoubleProperty(shortSpeed);
        this.preFlux = new SimpleDoubleProperty(preFlux);
        this.longCarNums = new SimpleDoubleProperty(longCarNums);
        this.midCarNums = new SimpleDoubleProperty(midCarNums);
        this.shortCarNums = new SimpleDoubleProperty(shortCarNums);
    }

    public CarFlowHour() {
    }
}
