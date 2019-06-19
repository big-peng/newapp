package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class DateStaCode extends RecursiveTreeObject<DateStaCode> {
    private StringProperty noiseCode;
    private Date measureTime;
    private SimpleDoubleProperty leqT;
    private SimpleDoubleProperty LAFmax;
    private SimpleDoubleProperty LAF5;
    private SimpleDoubleProperty LAF10;
    private SimpleDoubleProperty LAF50;
    private SimpleDoubleProperty LAF90;
    private SimpleDoubleProperty LAF95;
    private SimpleDoubleProperty SD;
    private SimpleDoubleProperty LAFmin;
    private StringProperty normal;
    private SimpleDoubleProperty rate;
    private StringProperty sift;
    private SimpleDoubleProperty softRate;
    private SimpleDoubleProperty ld;
    private SimpleDoubleProperty ln;
    private SimpleDoubleProperty ldn;

    @Override
    public String toString() {
        return "DateStaCode{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", leqT=" + leqT +
                ", LAFmax=" + LAFmax +
                ", LAF5=" + LAF5 +
                ", LAF10=" + LAF10 +
                ", LAF50=" + LAF50 +
                ", LAF90=" + LAF90 +
                ", LAF95=" + LAF95 +
                ", SD=" + SD +
                ", LAFmin=" + LAFmin +
                ", normal=" + normal +
                ", rate=" + rate +
                ", sift=" + sift +
                ", softRate=" + softRate +
                ", Ld=" + ld +
                ", Ln=" + ln +
                ", Ldn=" + ldn +
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

    public double getLeqT() {
        return leqT.get();
    }

    public SimpleDoubleProperty leqTProperty() {
        return leqT;
    }

    public void setLeqT(double leqT) {
        this.leqT = new SimpleDoubleProperty(leqT);
    }

    public double getLAFmax() {
        return LAFmax.get();
    }

    public SimpleDoubleProperty LAFmaxProperty() {
        return LAFmax;
    }

    public void setLAFmax(double LAFmax) {
        this.LAFmax = new SimpleDoubleProperty(LAFmax);
    }

    public double getLAF5() {
        return LAF5.get();
    }

    public SimpleDoubleProperty LAF5Property() {
        return LAF5;
    }

    public void setLAF5(double LAF5) {
        this.LAF5 = new SimpleDoubleProperty(LAF5);
    }

    public double getLAF10() {
        return LAF10.get();
    }

    public SimpleDoubleProperty LAF10Property() {
        return LAF10;
    }

    public void setLAF10(double LAF10) {
        this.LAF10 = new SimpleDoubleProperty(LAF10);
    }

    public double getLAF50() {
        return LAF50.get();
    }

    public SimpleDoubleProperty LAF50Property() {
        return LAF50;
    }

    public void setLAF50(double LAF50) {
        this.LAF50 = new SimpleDoubleProperty(LAF50);
    }

    public double getLAF90() {
        return LAF90.get();
    }

    public SimpleDoubleProperty LAF90Property() {
        return LAF90;
    }

    public void setLAF90(double LAF90) {
        this.LAF90 = new SimpleDoubleProperty(LAF90);
    }

    public double getLAF95() {
        return LAF95.get();
    }

    public SimpleDoubleProperty LAF95Property() {
        return LAF95;
    }

    public void setLAF95(double LAF95) {
        this.LAF95 = new SimpleDoubleProperty(LAF95);
    }

    public double getSD() {
        return SD.get();
    }

    public SimpleDoubleProperty SDProperty() {
        return SD;
    }

    public void setSD(double SD) {
        this.SD = new SimpleDoubleProperty(SD);
    }

    public double getLAFmin() {
        return LAFmin.get();
    }

    public SimpleDoubleProperty LAFminProperty() {
        return LAFmin;
    }

    public void setLAFmin(double LAFmin) {
        this.LAFmin = new SimpleDoubleProperty(LAFmin);
    }

    public String getNormal() {
        return normal.get();
    }

    public StringProperty normalProperty() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = new SimpleStringProperty(normal);
    }

    public double getRate() {
        return rate.get();
    }

    public SimpleDoubleProperty rateProperty() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = new SimpleDoubleProperty(rate);
    }

    public String getSift() {
        return sift.get();
    }

    public StringProperty siftProperty() {
        return sift;
    }

    public void setSift(String sift) {
        this.sift = new SimpleStringProperty(sift);
    }

    public double getSoftRate() {
        return softRate.get();
    }

    public SimpleDoubleProperty softRateProperty() {
        return softRate;
    }

    public void setSoftRate(double softRate) {
        this.softRate = new SimpleDoubleProperty(softRate);
    }

    public double getLd() {
        return ld.get();
    }

    public SimpleDoubleProperty ldProperty() {
        return ld;
    }

    public void setLd(double ld) {
        this.ld = new SimpleDoubleProperty(ld);
    }

    public double getLn() {
        return ln.get();
    }

    public SimpleDoubleProperty lnProperty() {
        return ln;
    }

    public void setLn(double ln) {
        this.ln = new SimpleDoubleProperty(ln);
    }

    public double getLdn() {
        return ldn.get();
    }

    public SimpleDoubleProperty ldnProperty() {
        return ldn;
    }

    public void setLdn(double ldn) {
        this.ldn = new SimpleDoubleProperty(ldn);
    }

    public DateStaCode(String noiseCode, Date measureTime, double leqT, double LAFmax, double LAF5, double LAF10, double LAF50, double LAF90, double LAF95, double SD, double LAFmin, String normal, double rate, String sift, double softRate, double ld, double ln, double ldn) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.leqT = new SimpleDoubleProperty(leqT);
        this.LAFmax = new SimpleDoubleProperty(LAFmax);
        this.LAF5 = new SimpleDoubleProperty(LAF5);
        this.LAF10 = new SimpleDoubleProperty(LAF10);
        this.LAF50 = new SimpleDoubleProperty(LAF50);
        this.LAF90 = new SimpleDoubleProperty(LAF90);
        this.LAF95 = new SimpleDoubleProperty(LAF95);
        this.SD = new SimpleDoubleProperty(SD);
        this.LAFmin = new SimpleDoubleProperty(LAFmin);
        this.normal = new SimpleStringProperty(normal);
        this.rate = new SimpleDoubleProperty(rate);
        this.sift = new SimpleStringProperty(sift);
        this.softRate = new SimpleDoubleProperty(softRate);
        this.ld = new SimpleDoubleProperty(ld);
        this.ln = new SimpleDoubleProperty(ln);
        this.ldn = new SimpleDoubleProperty(ldn);
    }

    public DateStaCode() {
    }
}
