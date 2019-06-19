package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Instructions extends RecursiveTreeObject<Instructions> {
    private StringProperty instructFlag; //指令身份编码
    private StringProperty instructType; //指令类型
    private StringProperty instructClass; //指令功能代号
    private StringProperty userName; //用户名称
    private StringProperty noiseCode; //测点设备编号
    private StringProperty instructInput; //指令输入内容
    private SimpleIntegerProperty instructRet; //指令返回标记
    private StringProperty instructResult; //指令返回内容
    private Date createTime; //指令创建时间
    private SimpleIntegerProperty outDieTime; //指令销毁间隔

    @Override
    public String toString() {
        return "Instructions{" +
                "instructFlag=" + instructFlag +
                ", instructType=" + instructType +
                ", instructClass=" + instructClass +
                ", userName=" + userName +
                ", noiseCode=" + noiseCode +
                ", instructInput=" + instructInput +
                ", instructRet=" + instructRet +
                ", instructResult=" + instructResult +
                ", createTime=" + createTime +
                ", outDieTime=" + outDieTime +
                '}';
    }

    public String getInstructFlag() {
        return instructFlag.get();
    }

    public StringProperty instructFlagProperty() {
        return instructFlag;
    }

    public void setInstructFlag(String instructFlag) {
        this.instructFlag = new SimpleStringProperty(instructFlag);
    }

    public String getInstructType() {
        return instructType.get();
    }

    public StringProperty instructTypeProperty() {
        return instructType;
    }

    public void setInstructType(String instructType) {
        this.instructType = new SimpleStringProperty(instructType);
    }

    public String getInstructClass() {
        return instructClass.get();
    }

    public StringProperty instructClassProperty() {
        return instructClass;
    }

    public void setInstructClass(String instructClass) {
        this.instructClass = new SimpleStringProperty(instructClass);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
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

    public String getInstructInput() {
        return instructInput.get();
    }

    public StringProperty instructInputProperty() {
        return instructInput;
    }

    public void setInstructInput(String instructInput) {
        this.instructInput = new SimpleStringProperty(instructInput);
    }

    public int getInstructRet() {
        return instructRet.get();
    }

    public SimpleIntegerProperty instructRetProperty() {
        return instructRet;
    }

    public void setInstructRet(int instructRet) {
        this.instructRet = new SimpleIntegerProperty(instructRet);
    }

    public String getInstructResult() {
        return instructResult.get();
    }

    public StringProperty instructResultProperty() {
        return instructResult;
    }

    public void setInstructResult(String instructResult) {
        this.instructResult = new SimpleStringProperty(instructResult);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getOutDieTime() {
        return outDieTime.get();
    }

    public SimpleIntegerProperty outDieTimeProperty() {
        return outDieTime;
    }

    public void setOutDieTime(int outDieTime) {
        this.outDieTime = new SimpleIntegerProperty(outDieTime);
    }

    public Instructions(String instructFlag, String instructType, String instructClass, String userName, String noiseCode, String instructInput, int instructRet, String instructResult, Date createTime, int outDieTime) {
        this.instructFlag = new SimpleStringProperty(instructFlag);
        this.instructType = new SimpleStringProperty(instructType);
        this.instructClass = new SimpleStringProperty(instructClass);
        this.userName = new SimpleStringProperty(userName);
        this.noiseCode = new SimpleStringProperty(noiseCode);
        this.instructInput = new SimpleStringProperty(instructInput);
        this.instructRet = new SimpleIntegerProperty(instructRet);
        this.instructResult = new SimpleStringProperty(instructResult);
        this.createTime = createTime;
        this.outDieTime = new SimpleIntegerProperty(outDieTime);
    }

    public Instructions() {
    }
}
