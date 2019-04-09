package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class DownUser extends RecursiveTreeObject<DownUser> {
    private String username;
    private String name;
    private String status;
    private String type;
    private String phone;

    public DownUser(String username, String name, String status, String type, String phone) {
        this.username = username;
        this.name = name;
        this.status = status;
        this.type = type;
        this.phone = phone;
    }

    public DownUser() {
    }

    @Override
    public String toString() {
        return "DownUser{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
