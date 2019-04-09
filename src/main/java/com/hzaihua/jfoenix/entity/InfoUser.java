package com.hzaihua.jfoenix.entity;

public class InfoUser {
    private String userName;//用户的登录名，该字段为主键
    private String password;//用户的登录密码，后期需要使用加密Util处理
    private String nickName;//用户设置的昵称
    private int userType;//用户的管理级别，级别不同所拥有的权限也不同
    private String parentUser;//添加该用户的用户登录名
    private String phone;//手机号
    private String occupation;//职业
    private String company;//工作单位
    private String headFileName;//头像文件所在地址
}
