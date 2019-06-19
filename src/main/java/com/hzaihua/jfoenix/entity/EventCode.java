package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EventCode extends RecursiveTreeObject<InfoUser> {
    private StringProperty eventCode; //事件编号
    private StringProperty eventSourceType;//事件来源类型,SYSTEM:平台软件产生的事件；USER：用户产生的事件；DEVICE：设备产生的事件
    private StringProperty eventSource;//事件来源类型SYSTEM时为固定的SYSTEM；USER时为用户名UserName；DEVICE时为设备编号ID
    private SimpleIntegerProperty eventType;//事件类型
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventStartTime; //事件开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventEndTime; //事件结束时间
    private SimpleIntegerProperty eventLevel; //事件等级
    private StringProperty eventDescribe; //描述
    private StringProperty startTime; //开始时间字符串
    private StringProperty endTime; // 结束时间字符串

    @Override
    public String toString() {
        return "EventCode{" +
                "eventCode=" + eventCode +
                ", eventSourceType=" + eventSourceType +
                ", eventSource=" + eventSource +
                ", eventType=" + eventType +
                ", eventStartTime=" + eventStartTime +
                ", eventEndTime=" + eventEndTime +
                ", eventLevel=" + eventLevel +
                ", eventDescribe=" + eventDescribe +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public String getStartTime() {
        return startTime.get();
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = new SimpleStringProperty(startTime);
    }

    public String getEndTime() {
        return endTime.get();
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = new SimpleStringProperty(endTime);
    }

    public String getEventCode() {
        return eventCode.get();
    }

    public StringProperty eventCodeProperty() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = new SimpleStringProperty(eventCode);
    }

    public String getEventSourceType() {
        return eventSourceType.get();
    }

    public StringProperty eventSourceTypeProperty() {
        return eventSourceType;
    }

    public void setEventSourceType(String eventSourceType) {
        this.eventSourceType = new SimpleStringProperty(eventSourceType);
    }

    public String getEventSource() {
        return eventSource.get();
    }

    public StringProperty eventSourceProperty() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = new SimpleStringProperty(eventSource);
    }

    public int getEventType() {
        return eventType.get();
    }

    public SimpleIntegerProperty eventTypeProperty() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = new SimpleIntegerProperty(eventType);
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public int getEventLevel() {
        return eventLevel.get();
    }

    public SimpleIntegerProperty eventLevelProperty() {
        return eventLevel;
    }

    public void setEventLevel(int eventLevel) {
        this.eventLevel = new SimpleIntegerProperty(eventLevel);
    }

    public String getEventDescribe() {
        return eventDescribe.get();
    }

    public StringProperty eventDescribeProperty() {
        return eventDescribe;
    }

    public void setEventDescribe(String eventDescribe) {
        this.eventDescribe = new SimpleStringProperty(eventDescribe);
    }

    public EventCode(String eventCode, String eventSourceType, String eventSource, Integer eventType, Date eventStartTime, Date eventEndTime, Integer eventLevel, String eventDescribe) {
        this.eventCode = new SimpleStringProperty(eventCode);
        this.eventSourceType = new SimpleStringProperty(eventSourceType);
        this.eventSource = new SimpleStringProperty(eventSource);
        this.eventType = new SimpleIntegerProperty(eventType);
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventLevel = new SimpleIntegerProperty(eventLevel);
        this.eventDescribe = new SimpleStringProperty(eventDescribe);
    }

    public EventCode() {
    }
}
