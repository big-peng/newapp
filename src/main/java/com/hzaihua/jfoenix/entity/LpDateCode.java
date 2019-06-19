package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class LpDateCode extends RecursiveTreeObject<LpDateCode> {
    private StringProperty noiseCode;
    private Date measureTime;
    private SimpleDoubleProperty LASP;
    private SimpleDoubleProperty LAFP;
    private SimpleDoubleProperty LAIP;
    private SimpleDoubleProperty LCSP;
    private SimpleDoubleProperty LCFP;
    private SimpleDoubleProperty LCIP;
    private SimpleDoubleProperty LZSP;
    private SimpleDoubleProperty LZFP;
    private SimpleDoubleProperty LZIP;
    private StringProperty normal;
    private StringProperty sift;

    @Override
    public String toString() {
        return "LpDateCode{" +
                "noiseCode=" + noiseCode +
                ", measureTime=" + measureTime +
                ", LASP=" + LASP +
                ", LAFP=" + LAFP +
                ", LAIP=" + LAIP +
                ", LCSP=" + LCSP +
                ", LCFP=" + LCFP +
                ", LCIP=" + LCIP +
                ", LZSP=" + LZSP +
                ", LZFP=" + LZFP +
                ", LZIP=" + LZIP +
                ", normal=" + normal +
                ", sift=" + sift +
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

    public double getLASP() {
        return LASP.get();
    }

    public SimpleDoubleProperty LASPProperty() {
        return LASP;
    }

    public void setLASP(double LASP) {
        this.LASP = new SimpleDoubleProperty(LASP);
    }

    public double getLAFP() {
        return LAFP.get();
    }

    public SimpleDoubleProperty LAFPProperty() {
        return LAFP;
    }

    public void setLAFP(double LAFP) {
        this.LAFP = new SimpleDoubleProperty(LAFP);
    }

    public double getLAIP() {
        return LAIP.get();
    }

    public SimpleDoubleProperty LAIPProperty() {
        return LAIP;
    }

    public void setLAIP(double LAIP) {
        this.LAIP = new SimpleDoubleProperty(LAIP);
    }

    public double getLCSP() {
        return LCSP.get();
    }

    public SimpleDoubleProperty LCSPProperty() {
        return LCSP;
    }

    public void setLCSP(double LCSP) {
        this.LCSP = new SimpleDoubleProperty(LCSP);
    }

    public double getLCFP() {
        return LCFP.get();
    }

    public SimpleDoubleProperty LCFPProperty() {
        return LCFP;
    }

    public void setLCFP(double LCFP) {
        this.LCFP = new SimpleDoubleProperty(LCFP);
    }

    public double getLCIP() {
        return LCIP.get();
    }

    public SimpleDoubleProperty LCIPProperty() {
        return LCIP;
    }

    public void setLCIP(double LCIP) {
        this.LCIP = new SimpleDoubleProperty(LCIP);
    }

    public double getLZSP() {
        return LZSP.get();
    }

    public SimpleDoubleProperty LZSPProperty() {
        return LZSP;
    }

    public void setLZSP(double LZSP) {
        this.LZSP = new SimpleDoubleProperty(LZSP);
    }

    public double getLZFP() {
        return LZFP.get();
    }

    public SimpleDoubleProperty LZFPProperty() {
        return LZFP;
    }

    public void setLZFP(double LZFP) {
        this.LZFP = new SimpleDoubleProperty(LZFP);
    }

    public double getLZIP() {
        return LZIP.get();
    }

    public SimpleDoubleProperty LZIPProperty() {
        return LZIP;
    }

    public void setLZIP(double LZIP) {
        this.LZIP = new SimpleDoubleProperty(LZIP);
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

    public String getSift() {
        return sift.get();
    }

    public StringProperty siftProperty() {
        return sift;
    }

    public void setSift(String sift) {
        this.sift = new SimpleStringProperty(sift);
    }

    public LpDateCode(String noiseCode, Date measureTime, double LASP, double LAFP, double LAIP, double LCSP, double LCFP, double LCIP, double LZSP, double LZFP, double LZIP, String normal, String sift) {
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.measureTime = measureTime;
        this.LASP = new SimpleDoubleProperty(LASP);
        this.LAFP = new SimpleDoubleProperty(LAFP);
        this.LAIP = new SimpleDoubleProperty(LAIP);
        this.LCSP = new SimpleDoubleProperty(LCSP);
        this.LCFP = new SimpleDoubleProperty(LCFP);
        this.LCIP = new SimpleDoubleProperty(LCIP);
        this.LZSP = new SimpleDoubleProperty(LZSP);
        this.LZFP = new SimpleDoubleProperty(LZFP);
        this.LZIP = new SimpleDoubleProperty(LZIP);
        this.normal = new SimpleStringProperty(normal);
        this.sift = new SimpleStringProperty(sift);
    }

    public LpDateCode() {
    }
}
