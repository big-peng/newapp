package com.hzaihua.jfoenix.entity;

public class UserToMeasure {
    private String userName;
    private String measureCode;

    @Override
    public String toString() {
        return "UserToMeasure{" +
                "userName='" + userName + '\'' +
                ", measureCode='" + measureCode + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = measureCode;
    }

    public UserToMeasure() {
    }

    public UserToMeasure(String userName, String measureCode) {
        this.userName = userName;
        this.measureCode = measureCode;
    }
}
