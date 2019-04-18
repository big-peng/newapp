package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoUser extends RecursiveTreeObject<InfoUser> {
    private StringProperty userName;//用户的登录名，该字段为主键
    private StringProperty password;//用户的登录密码，后期需要使用加密Util处理
    private StringProperty nickName;//用户设置的昵称
    private SimpleIntegerProperty userType;//用户的管理级别，级别不同所拥有的权限也不同
    private StringProperty parentUser;//添加该用户的用户登录名
    private StringProperty phone;//手机号
    private StringProperty occupation;//职业
    private StringProperty company;//工作单位
    private SimpleIntegerProperty status;//登录状态
    private StringProperty headFileName;//头像文件所在地址

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public String getNickName() {
        return nickName.get();
    }

    public StringProperty nickNameProperty() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = new SimpleStringProperty(nickName);
    }

    public int getUserType() {
        return userType.get();
    }

    public SimpleIntegerProperty userTypeProperty() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = new SimpleIntegerProperty(userType);
    }

    public String getParentUser() {
        return parentUser.get();
    }

    public StringProperty parentUserProperty() {
        return parentUser;
    }

    public void setParentUser(String parentUser) {
        this.parentUser = new SimpleStringProperty(parentUser);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = new SimpleStringProperty(phone);
    }

    public String getOccupation() {
        return occupation.get();
    }

    public StringProperty occupationProperty() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = new SimpleStringProperty(occupation);
    }

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public void setCompany(String company) {
        this.company = new SimpleStringProperty(company);
    }

    public String getHeadFileName() {
        return headFileName.get();
    }

    public StringProperty headFileNameProperty() {
        return headFileName;
    }

    public void setHeadFileName(String headFileName) {
        this.headFileName = new SimpleStringProperty(headFileName);
    }

    public InfoUser(StringProperty userName, StringProperty password, StringProperty nickName, SimpleIntegerProperty userType, StringProperty parentUser, StringProperty phone, StringProperty occupation, StringProperty company, SimpleIntegerProperty status, StringProperty headFileName) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.userType = userType;
        this.parentUser = parentUser;
        this.phone = phone;
        this.occupation = occupation;
        this.company = company;
        this.status = status;
        this.headFileName = headFileName;
    }

    public int getStatus() {
        return status.get();
    }

    public void setStatus(int status) {
        this.status = new SimpleIntegerProperty(status);
    }

    public SimpleIntegerProperty statusProperty() {
        return status;
    }

    @Override
    public String toString() {
        return "InfoUser{" +
                "userName=" + userName +
                ", password=" + password +
                ", nickName=" + nickName +
                ", userType=" + userType +
                ", parentUser=" + parentUser +
                ", phone=" + phone +
                ", occupation=" + occupation +
                ", company=" + company +
                ", status=" + status +
                ", headFileName=" + headFileName +
                '}';
    }

    public InfoUser() {
    }
}
