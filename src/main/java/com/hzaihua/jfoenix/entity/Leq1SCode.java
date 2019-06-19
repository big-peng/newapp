package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Leq1SCode extends RecursiveTreeObject<Leq1SCode>{
    private StringProperty noiseCode;
    private Date measureTime;
    private SimpleDoubleProperty LEQA;
    private SimpleDoubleProperty LEQC;
    private SimpleDoubleProperty LEQZ;

    @Override
    public String toString() {
        return "Leq1SCode{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", LEQA=" + LEQA +
                ", LEQC=" + LEQC +
                ", LEQZ=" + LEQZ +
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

    public double getLEQA() {
        return LEQA.get();
    }

    public SimpleDoubleProperty LEQAProperty() {
        return LEQA;
    }

    public void setLEQA(double LEQA) {
        this.LEQA = new SimpleDoubleProperty(LEQA);
    }

    public double getLEQC() {
        return LEQC.get();
    }

    public SimpleDoubleProperty LEQCProperty() {
        return LEQC;
    }

    public void setLEQC(double LEQC) {
        this.LEQC = new SimpleDoubleProperty(LEQC);
    }

    public double getLEQZ() {
        return LEQZ.get();
    }

    public SimpleDoubleProperty LEQZProperty() {
        return LEQZ;
    }

    public void setLEQZ(double LEQZ) {
        this.LEQZ = new SimpleDoubleProperty(LEQZ);
    }

    public Leq1SCode(String noiseCode, Date measureTime, double LEQA, double LEQC, double LEQZ) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.LEQA = new SimpleDoubleProperty(LEQA);
        this.LEQC = new SimpleDoubleProperty(LEQC);
        this.LEQZ = new SimpleDoubleProperty(LEQZ);
    }

    public Leq1SCode() {
    }
}
