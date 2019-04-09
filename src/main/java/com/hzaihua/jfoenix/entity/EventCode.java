package com.hzaihua.jfoenix.entity;

import java.util.Date;

public class EventCode {
    private int eventCode;
    private String eventSourceType;//事件来源类型,SYSTEM:平台软件产生的事件；USER：用户产生的事件；DEVICE：设备产生的事件
    private String eventSource;//事件来源类型SYSTEM时为固定的SYSTEM；USER时为用户名UserName；DEVICE时为设备编号ID
    private int eventType;
    private Date eventStartTime;
    private Date eventEndTime;
    private int eventLevel;
    private String eventDescribe;
}
