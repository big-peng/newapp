package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class OctCode extends RecursiveTreeObject<OctCode> {
    private StringProperty noiseCode;
    private Date measureTime;
    private SimpleIntegerProperty millisecond;
    private SimpleDoubleProperty HZ16;
    private SimpleDoubleProperty HZ31P5;
    private SimpleDoubleProperty HZ63;
    private SimpleDoubleProperty HZ125;
    private SimpleDoubleProperty HZ250;
    private SimpleDoubleProperty HZ500;
    private SimpleDoubleProperty HZ1000;
    private SimpleDoubleProperty HZ2000;
    private SimpleDoubleProperty HZ4000;
    private SimpleDoubleProperty HZ8000;
    private SimpleDoubleProperty HZ16000;

    @Override
    public String toString() {
        return "OctCode{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", millisecond=" + millisecond +
                ", HZ16=" + HZ16 +
                ", HZ31P5=" + HZ31P5 +
                ", HZ63=" + HZ63 +
                ", HZ125=" + HZ125 +
                ", HZ250=" + HZ250 +
                ", HZ500=" + HZ500 +
                ", HZ1000=" + HZ1000 +
                ", HZ2000=" + HZ2000 +
                ", HZ4000=" + HZ4000 +
                ", HZ8000=" + HZ8000 +
                ", HZ16000=" + HZ16000 +
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

    public int getMillisecond() {
        return millisecond.get();
    }

    public SimpleIntegerProperty millisecondProperty() {
        return millisecond;
    }

    public void setMillisecond(int millisecond) {
        this.millisecond = new SimpleIntegerProperty(millisecond);
    }

    public double getHZ16() {
        return HZ16.get();
    }

    public SimpleDoubleProperty HZ16Property() {
        return HZ16;
    }

    public void setHZ16(double HZ16) {
        this.HZ16 = new SimpleDoubleProperty(HZ16);
    }

    public double getHZ31P5() {
        return HZ31P5.get();
    }

    public SimpleDoubleProperty HZ31P5Property() {
        return HZ31P5;
    }

    public void setHZ31P5(double HZ31P5) {
        this.HZ31P5 = new SimpleDoubleProperty(HZ31P5);
    }

    public double getHZ63() {
        return HZ63.get();
    }

    public SimpleDoubleProperty HZ63Property() {
        return HZ63;
    }

    public void setHZ63(double HZ63) {
        this.HZ63 = new SimpleDoubleProperty(HZ63);
    }

    public double getHZ125() {
        return HZ125.get();
    }

    public SimpleDoubleProperty HZ125Property() {
        return HZ125;
    }

    public void setHZ125(double HZ125) {
        this.HZ125 = new SimpleDoubleProperty(HZ125);
    }

    public double getHZ250() {
        return HZ250.get();
    }

    public SimpleDoubleProperty HZ250Property() {
        return HZ250;
    }

    public void setHZ250(double HZ250) {
        this.HZ250 = new SimpleDoubleProperty(HZ250);
    }

    public double getHZ500() {
        return HZ500.get();
    }

    public SimpleDoubleProperty HZ500Property() {
        return HZ500;
    }

    public void setHZ500(double HZ500) {
        this.HZ500 = new SimpleDoubleProperty(HZ500);
    }

    public double getHZ1000() {
        return HZ1000.get();
    }

    public SimpleDoubleProperty HZ1000Property() {
        return HZ1000;
    }

    public void setHZ1000(double HZ1000) {
        this.HZ1000 = new SimpleDoubleProperty(HZ1000);
    }

    public double getHZ2000() {
        return HZ2000.get();
    }

    public SimpleDoubleProperty HZ2000Property() {
        return HZ2000;
    }

    public void setHZ2000(double HZ2000) {
        this.HZ2000 = new SimpleDoubleProperty(HZ2000);
    }

    public double getHZ4000() {
        return HZ4000.get();
    }

    public SimpleDoubleProperty HZ4000Property() {
        return HZ4000;
    }

    public void setHZ4000(double HZ4000) {
        this.HZ4000 = new SimpleDoubleProperty(HZ4000);
    }

    public double getHZ8000() {
        return HZ8000.get();
    }

    public SimpleDoubleProperty HZ8000Property() {
        return HZ8000;
    }

    public void setHZ8000(double HZ8000) {
        this.HZ8000 = new SimpleDoubleProperty(HZ8000);
    }

    public double getHZ16000() {
        return HZ16000.get();
    }

    public SimpleDoubleProperty HZ16000Property() {
        return HZ16000;
    }

    public void setHZ16000(double HZ16000) {
        this.HZ16000 = new SimpleDoubleProperty(HZ16000);
    }

    public OctCode(String noiseCode, Date measureTime, int millisecond, double HZ16, double HZ31P5, double HZ63, double HZ125, double HZ250, double HZ500, double HZ1000, double HZ2000, double HZ4000, double HZ8000, double HZ16000) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.millisecond = new SimpleIntegerProperty(millisecond);
        this.HZ16 = new SimpleDoubleProperty(HZ16);
        this.HZ31P5 = new SimpleDoubleProperty(HZ31P5);
        this.HZ63 = new SimpleDoubleProperty(HZ63);
        this.HZ125 = new SimpleDoubleProperty(HZ125);
        this.HZ250 = new SimpleDoubleProperty(HZ250);
        this.HZ500 = new SimpleDoubleProperty(HZ500);
        this.HZ1000 = new SimpleDoubleProperty(HZ1000);
        this.HZ2000 = new SimpleDoubleProperty(HZ2000);
        this.HZ4000 = new SimpleDoubleProperty(HZ4000);
        this.HZ8000 = new SimpleDoubleProperty(HZ8000);
        this.HZ16000 = new SimpleDoubleProperty(HZ16000);
    }

    public OctCode() {
    }
}
