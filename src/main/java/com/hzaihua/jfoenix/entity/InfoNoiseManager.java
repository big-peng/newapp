package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class InfoNoiseManager extends RecursiveTreeObject<InfoUser> {
    private StringProperty noiseManagerId; //设备编号
    private SimpleDoubleProperty sample; //瞬时采样间隔
    private SimpleIntegerProperty upSpace; //瞬时上传间隔
    private SimpleDoubleProperty dayOverValue; //噪声白天超标值
    private SimpleDoubleProperty nightOverValue; //噪声晚上超标值
    private SimpleIntegerProperty overDlay; //噪声超标延时
    private SimpleIntegerProperty isExceed; //是否超标报警
    private SimpleDoubleProperty dayOctValue; //频谱白天超标限值
    private SimpleDoubleProperty nightOctValue; //频谱晚上超标限值
    private SimpleIntegerProperty octDlay; //频谱超标延时
    private SimpleIntegerProperty isOct; //是否超标频谱分析
    private SimpleDoubleProperty dayRecordValue; //录音白天超标
    private SimpleDoubleProperty nightRecordValue; //录音晚上超标
    private SimpleIntegerProperty recordDlay; //录音超标延时
    private SimpleIntegerProperty isRecord; //是否录音
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordStartTime; //上传开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordEndTime; //上传结束时间
    private SimpleIntegerProperty recordModel; //上传模式
    private StringProperty freWight; //频率计权
    private StringProperty timeWight; //时间计权
    private SimpleIntegerProperty initime;// 积分统计时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adjustTime; //校准时间
    private SimpleIntegerProperty adjustSpace; //校准间隔
    private SimpleIntegerProperty isAutoAdjust; //是否自动电校准
    private SimpleIntegerProperty weaAutoUp; //气象自动上传
    private SimpleIntegerProperty weaAutoSave; //气象自动保存
    private SimpleIntegerProperty weaUpSpace; //气象采集间隔
    private SimpleIntegerProperty carAutoUp; //车流量自动上传
    private SimpleIntegerProperty carAutoSave; //车流量自动保存
    private SimpleIntegerProperty carUpSpace; //车流量采集间隔
    private SimpleIntegerProperty dustAutoUp; //粉尘自动上传
    private SimpleIntegerProperty dustAutoSave; //粉尘自动保存
    private SimpleIntegerProperty dustUpSpace; //粉尘采集间隔
    private SimpleIntegerProperty event_01; //手动控制电校准
    private SimpleIntegerProperty event_02; //自动电校准
    private SimpleIntegerProperty event_03; //加热
    private SimpleIntegerProperty event_04; //噪声超标
    private SimpleIntegerProperty event_05; //仪器启动
    private SimpleIntegerProperty event_06; //仪器正常关机
    private SimpleIntegerProperty event_07; //停电
    private SimpleIntegerProperty event_08; //机箱门被打开
    private SimpleIntegerProperty event_09; //读声级计出错
    private SimpleIntegerProperty event_10; //存储器出错
    private SimpleIntegerProperty event_11; //USB口出错
    private SimpleIntegerProperty event_12; //电池电压不足
    private SimpleIntegerProperty event_13; //声校准
    private SimpleIntegerProperty ON_OFF_LEQZ; //每秒的Z计权等效上传0：关； 1：开
    private SimpleIntegerProperty ON_OFF_LEQC; //每秒的C计权等效上传
    private SimpleIntegerProperty ON_OFF_LEQA; //每秒的A计权等效上传
    private SimpleIntegerProperty ON_OFF_LPFZ; //时间F计权、频率Z计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPSZ; //时间S计权、频率Z计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPIZ; //时间I计权、频率Z计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPFC; //时间F计权、频率C计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPSC; //时间S计权、频率C计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPIC; //时间I计权、频率C计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPFA; //时间F计权、频率A计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPSA; //时间S计权、频率A计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_LPIA; //时间I计权、频率A计权瞬时值上传
    private SimpleIntegerProperty ON_OFF_PEAKZ; //Z计权峰值上传
    private SimpleIntegerProperty ON_OFF_PEAKC; //C计权峰值上传
    private SimpleIntegerProperty ON_OFF_PEAKA; //A计权峰值上传
    private SimpleIntegerProperty ON_OFF_HOUR; //小时统计数据自动上传
    private SimpleIntegerProperty ON_OFF_DAY; //天统计数据自动上传
    private SimpleIntegerProperty ON_OFF_UDT; //自定义分钟时间统计数据自动上传
    private SimpleIntegerProperty ON_OFF_13OCT; //1/3频谱数据按照采样间隔参数的间隔自动上传
    private SimpleIntegerProperty ON_OFF_11OCT; //1/1频谱数据按照采样间隔参数的间隔自动上传
    private SimpleIntegerProperty ON_OFF_RADF; //仪器出错时复位
    private SimpleIntegerProperty ON_OFF_FAMF; //存储器加载失败时格式化存储器
    private SimpleIntegerProperty ON_OFF_PDWIV; //低电压数据保护
    private SimpleIntegerProperty ON_OFF_LEQ1S; //保存每秒的Leq，包括A、C、Z 3个计权
    private SimpleIntegerProperty hasOct; //是否有频谱授权
    private SimpleIntegerProperty hasAll; //是否有积分授权
    private SimpleIntegerProperty hasRecord; //是否有记录功能
    private SimpleIntegerProperty hasSoundtrans; //实时语音授权
    private SimpleIntegerProperty record_On_Off; //录音启动终止
    private StringProperty version_Hardware; //硬件版本
    private StringProperty version_Linux; //内核版本
    private StringProperty version_N_VIEW; //界面版本
    private StringProperty version_NoiseMonitor; //采集版本
    private StringProperty version_normal; //协议版本

    @Override
    public String toString() {
        return "InfoNoiseManager{" +
                "noiseManagerId=" + noiseManagerId +
                ", sample=" + sample +
                ", upSpace=" + upSpace +
                ", dayOverValue=" + dayOverValue +
                ", nightOverValue=" + nightOverValue +
                ", overDlay=" + overDlay +
                ", isExceed=" + isExceed +
                ", dayOctValue=" + dayOctValue +
                ", nightOctValue=" + nightOctValue +
                ", octDlay=" + octDlay +
                ", isOct=" + isOct +
                ", dayRecordValue=" + dayRecordValue +
                ", nightRecordValue=" + nightRecordValue +
                ", recordDlay=" + recordDlay +
                ", isRecord=" + isRecord +
                ", recordStartTime=" + recordStartTime +
                ", recordEndTime=" + recordEndTime +
                ", recordModel=" + recordModel +
                ", freWight=" + freWight +
                ", timeWight=" + timeWight +
                ", initime=" + initime +
                ", adjustTime=" + adjustTime +
                ", adjustSpace=" + adjustSpace +
                ", isAutoAdjust=" + isAutoAdjust +
                ", weaAutoUp=" + weaAutoUp +
                ", weaAutoSave=" + weaAutoSave +
                ", weaUpSpace=" + weaUpSpace +
                ", carAutoUp=" + carAutoUp +
                ", carAutoSave=" + carAutoSave +
                ", carUpSpace=" + carUpSpace +
                ", dustAutoUp=" + dustAutoUp +
                ", dustAutoSave=" + dustAutoSave +
                ", dustUpSpace=" + dustUpSpace +
                ", event_01=" + event_01 +
                ", event_02=" + event_02 +
                ", event_03=" + event_03 +
                ", event_04=" + event_04 +
                ", event_05=" + event_05 +
                ", event_06=" + event_06 +
                ", event_07=" + event_07 +
                ", event_08=" + event_08 +
                ", event_09=" + event_09 +
                ", event_10=" + event_10 +
                ", event_11=" + event_11 +
                ", event_12=" + event_12 +
                ", event_13=" + event_13 +
                ", ON_OFF_LEQZ=" + ON_OFF_LEQZ +
                ", ON_OFF_LEQC=" + ON_OFF_LEQC +
                ", ON_OFF_LEQA=" + ON_OFF_LEQA +
                ", ON_OFF_LPFZ=" + ON_OFF_LPFZ +
                ", ON_OFF_LPSZ=" + ON_OFF_LPSZ +
                ", ON_OFF_LPIZ=" + ON_OFF_LPIZ +
                ", ON_OFF_LPFC=" + ON_OFF_LPFC +
                ", ON_OFF_LPSC=" + ON_OFF_LPSC +
                ", ON_OFF_LPIC=" + ON_OFF_LPIC +
                ", ON_OFF_LPFA=" + ON_OFF_LPFA +
                ", ON_OFF_LPSA=" + ON_OFF_LPSA +
                ", ON_OFF_LPIA=" + ON_OFF_LPIA +
                ", ON_OFF_PEAKZ=" + ON_OFF_PEAKZ +
                ", ON_OFF_PEAKC=" + ON_OFF_PEAKC +
                ", ON_OFF_PEAKA=" + ON_OFF_PEAKA +
                ", ON_OFF_HOUR=" + ON_OFF_HOUR +
                ", ON_OFF_DAY=" + ON_OFF_DAY +
                ", ON_OFF_UDT=" + ON_OFF_UDT +
                ", ON_OFF_13OCT=" + ON_OFF_13OCT +
                ", ON_OFF_11OCT=" + ON_OFF_11OCT +
                ", ON_OFF_RADF=" + ON_OFF_RADF +
                ", ON_OFF_FAMF=" + ON_OFF_FAMF +
                ", ON_OFF_PDWIV=" + ON_OFF_PDWIV +
                ", ON_OFF_LEQ1S=" + ON_OFF_LEQ1S +
                ", hasOct=" + hasOct +
                ", hasAll=" + hasAll +
                ", hasRecord=" + hasRecord +
                ", hasSoundtrans=" + hasSoundtrans +
                ", record_On_Off=" + record_On_Off +
                ", version_Hardware=" + version_Hardware +
                ", version_Linux=" + version_Linux +
                ", version_N_VIEW=" + version_N_VIEW +
                ", version_NoiseMonitor=" + version_NoiseMonitor +
                ", version_normal=" + version_normal +
                '}';
    }

    public String getNoiseManagerId() {
        return noiseManagerId.get();
    }

    public StringProperty noiseManagerIdProperty() {
        return noiseManagerId;
    }

    public void setNoiseManagerId(String noiseManagerId) {
        this.noiseManagerId = new SimpleStringProperty(noiseManagerId);
    }

    public double getSample() {
        if(sample == null){
            return 0;
        }
        return sample.get();
    }

    public SimpleDoubleProperty sampleProperty() {
        return sample;
    }

    public void setSample(double sample) {
        this.sample = new SimpleDoubleProperty(sample);
    }

    public int getUpSpace() {
        if(upSpace == null){
            return 0;
        }
        return upSpace.get();
    }

    public SimpleIntegerProperty upSpaceProperty() {
        return upSpace;
    }

    public void setUpSpace(int upSpace) {
        this.upSpace = new SimpleIntegerProperty(upSpace);
    }

    public double getDayOverValue() {
        if(dayOverValue == null){
            return 0;
        }
        return dayOverValue.get();
    }

    public SimpleDoubleProperty dayOverValueProperty() {
        return dayOverValue;
    }

    public void setDayOverValue(double dayOverValue) {
        this.dayOverValue = new SimpleDoubleProperty(dayOverValue);
    }

    public double getNightOverValue() {
        if(nightOverValue == null){
            return 0;
        }
        return nightOverValue.get();
    }

    public SimpleDoubleProperty nightOverValueProperty() {
        return nightOverValue;
    }

    public void setNightOverValue(double nightOverValue) {
        this.nightOverValue = new SimpleDoubleProperty(nightOverValue);
    }

    public int getOverDlay() {
        if(overDlay == null){
            return 0;
        }
        return overDlay.get();
    }

    public SimpleIntegerProperty overDlayProperty() {
        return overDlay;
    }

    public void setOverDlay(int overDlay) {
        this.overDlay = new SimpleIntegerProperty(overDlay);
    }

    public int getIsExceed() {
        if(isExceed == null){
            return 0;
        }
        return isExceed.get();
    }

    public SimpleIntegerProperty isExceedProperty() {
        return isExceed;
    }

    public void setIsExceed(int isExceed) {
        this.isExceed = new SimpleIntegerProperty(isExceed);
    }

    public double getDayOctValue() {
        if(dayOctValue == null){
            return 0;
        }
        return dayOctValue.get();
    }

    public SimpleDoubleProperty dayOctValueProperty() {
        return dayOctValue;
    }

    public void setDayOctValue(double dayOctValue) {
        this.dayOctValue = new SimpleDoubleProperty(dayOctValue);
    }

    public double getNightOctValue() {
        if(nightOverValue == null){
            return 0;
        }
        return nightOctValue.get();
    }

    public SimpleDoubleProperty nightOctValueProperty() {
        return nightOctValue;
    }

    public void setNightOctValue(double nightOctValue) {
        this.nightOctValue = new SimpleDoubleProperty(nightOctValue);
    }

    public int getOctDlay() {
        if(octDlay == null){
            return 0;
        }
        return octDlay.get();
    }

    public SimpleIntegerProperty octDlayProperty() {
        return octDlay;
    }

    public void setOctDlay(int octDlay) {
        this.octDlay = new SimpleIntegerProperty(octDlay);
    }

    public int getIsOct() {
        if(isOct == null){
            return 0;
        }
        return isOct.get();
    }

    public SimpleIntegerProperty isOctProperty() {
        return isOct;
    }

    public void setIsOct(int isOct) {
        this.isOct = new SimpleIntegerProperty(isOct);
    }

    public double getDayRecordValue() {
        if(dayRecordValue == null){
            return 0;
        }
        return dayRecordValue.get();
    }

    public SimpleDoubleProperty dayRecordValueProperty() {
        return dayRecordValue;
    }

    public void setDayRecordValue(double dayRecordValue) {
        this.dayRecordValue = new SimpleDoubleProperty(dayRecordValue);
    }

    public double getNightRecordValue() {
        if(nightRecordValue == null){
            return 0;
        }
        return nightRecordValue.get();
    }

    public SimpleDoubleProperty nightRecordValueProperty() {
        return nightRecordValue;
    }

    public void setNightRecordValue(double nightRecordValue) {
        this.nightRecordValue = new SimpleDoubleProperty(nightRecordValue);
    }

    public int getRecordDlay() {
        if(recordDlay == null){
            return 0;
        }
        return recordDlay.get();
    }

    public SimpleIntegerProperty recordDlayProperty() {
        return recordDlay;
    }

    public void setRecordDlay(int recordDlay) {
        this.recordDlay = new SimpleIntegerProperty(recordDlay);
    }

    public int getIsRecord() {
        if(isRecord == null){
            return 0;
        }
        return isRecord.get();
    }

    public SimpleIntegerProperty isRecordProperty() {
        return isRecord;
    }

    public void setIsRecord(int isRecord) {
        this.isRecord = new SimpleIntegerProperty(isRecord);
    }

    public Date getRecordStartTime() {
        return recordStartTime;
    }

    public void setRecordStartTime(Date recordStartTime) {
        this.recordStartTime = recordStartTime;
    }

    public Date getRecordEndTime() {
        return recordEndTime;
    }

    public void setRecordEndTime(Date recordEndTime) {
        this.recordEndTime = recordEndTime;
    }

    public int getRecordModel() {
        if(recordModel == null){
            return 0;
        }
        return recordModel.get();
    }

    public SimpleIntegerProperty recordModelProperty() {
        return recordModel;
    }

    public void setRecordModel(int recordModel) {
        this.recordModel = new SimpleIntegerProperty(recordModel);
    }

    public String getFreWight() {
        if(freWight == null){
            return "请选择频率计权";
        }
        return freWight.get();
    }

    public StringProperty freWightProperty() {
        return freWight;
    }

    public void setFreWight(String freWight) {
        this.freWight = new SimpleStringProperty(freWight);
    }

    public String getTimeWight() {
        if(timeWight == null){
            return "请选择时间计权";
        }
        return timeWight.get();
    }

    public StringProperty timeWightProperty() {
        return timeWight;
    }

    public void setTimeWight(String timeWight) {
        this.timeWight = new SimpleStringProperty(timeWight);
    }

    public int getInitime() {
        if(initime == null){
            return 0;
        }
        return initime.get();
    }

    public SimpleIntegerProperty initimeProperty() {
        return initime;
    }

    public void setInitime(int initime) {
        this.initime = new SimpleIntegerProperty(initime);
    }

    public Date getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Date adjustTime) {
        this.adjustTime = adjustTime;
    }

    public int getAdjustSpace() {
        if(adjustSpace == null){
            return 0;
        }
        return adjustSpace.get();
    }

    public SimpleIntegerProperty adjustSpaceProperty() {
        return adjustSpace;
    }

    public void setAdjustSpace(int adjustSpace) {
        this.adjustSpace = new SimpleIntegerProperty(adjustSpace);
    }

    public int getIsAutoAdjust() {
        if(isAutoAdjust == null){
            return 0;
        }
        return isAutoAdjust.get();
    }

    public SimpleIntegerProperty isAutoAdjustProperty() {
        return isAutoAdjust;
    }

    public void setIsAutoAdjust(int isAutoAdjust) {
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
    }

    public int getWeaAutoUp() {
        if(weaAutoUp == null){
            return 0;
        }
        return weaAutoUp.get();
    }

    public SimpleIntegerProperty weaAutoUpProperty() {
        return weaAutoUp;
    }

    public void setWeaAutoUp(int weaAutoUp) {
        this.weaAutoUp = new SimpleIntegerProperty(weaAutoUp);
    }

    public int getWeaAutoSave() {
        if(weaAutoSave == null){
            return 0;
        }
        return weaAutoSave.get();
    }

    public SimpleIntegerProperty weaAutoSaveProperty() {
        return weaAutoSave;
    }

    public void setWeaAutoSave(int weaAutoSave) {
        this.weaAutoSave = new SimpleIntegerProperty(weaAutoSave);
    }

    public int getWeaUpSpace() {
        if(weaUpSpace == null){
            return 0;
        }
        return weaUpSpace.get();
    }

    public SimpleIntegerProperty weaUpSpaceProperty() {
        return weaUpSpace;
    }

    public void setWeaUpSpace(int weaUpSpace) {
        this.weaUpSpace = new SimpleIntegerProperty(weaUpSpace);
    }

    public int getCarAutoUp() {
        if(carAutoUp == null){
            return 0;
        }
        return carAutoUp.get();
    }

    public SimpleIntegerProperty carAutoUpProperty() {
        return carAutoUp;
    }

    public void setCarAutoUp(int carAutoUp) {
        this.carAutoUp = new SimpleIntegerProperty(carAutoUp);
    }

    public int getCarAutoSave() {
        if(carAutoSave == null){
            return 0;
        }
        return carAutoSave.get();
    }

    public SimpleIntegerProperty carAutoSaveProperty() {
        return carAutoSave;
    }

    public void setCarAutoSave(int carAutoSave) {
        this.carAutoSave = new SimpleIntegerProperty(carAutoSave);
    }

    public int getCarUpSpace() {
        if(carUpSpace == null){
            return 0;
        }
        return carUpSpace.get();
    }

    public SimpleIntegerProperty carUpSpaceProperty() {
        return carUpSpace;
    }

    public void setCarUpSpace(int carUpSpace) {
        this.carUpSpace = new SimpleIntegerProperty(carUpSpace);
    }

    public int getDustAutoUp() {
        if(dustAutoUp == null){
            return 0;
        }
        return dustAutoUp.get();
    }

    public SimpleIntegerProperty dustAutoUpProperty() {
        return dustAutoUp;
    }

    public void setDustAutoUp(int dustAutoUp) {
        this.dustAutoUp = new SimpleIntegerProperty(dustAutoUp);
    }

    public int getDustAutoSave() {
        if(dustAutoSave == null){
            return 0;
        }
        return dustAutoSave.get();
    }

    public SimpleIntegerProperty dustAutoSaveProperty() {
        return dustAutoSave;
    }

    public void setDustAutoSave(int dustAutoSave) {
        this.dustAutoSave = new SimpleIntegerProperty(dustAutoSave);
    }

    public int getDustUpSpace() {
        if(dustUpSpace == null){
            return 0;
        }
        return dustUpSpace.get();
    }

    public SimpleIntegerProperty dustUpSpaceProperty() {
        return dustUpSpace;
    }

    public void setDustUpSpace(int dustUpSpace) {
        this.dustUpSpace = new SimpleIntegerProperty(dustUpSpace);
    }

    public int getEvent_01() {
        if(event_01 == null){
            return 0;
        }
        return event_01.get();
    }

    public SimpleIntegerProperty event_01Property() {
        return event_01;
    }

    public void setEvent_01(int event_01) {
        this.event_01 = new SimpleIntegerProperty(event_01);
    }

    public int getEvent_02() {
        if(event_01 == null){
            return 0;
        }
        return event_02.get();
    }

    public SimpleIntegerProperty event_02Property() {
        return event_02;
    }

    public void setEvent_02(int event_02) {
        this.event_02 = new SimpleIntegerProperty(event_02);
    }

    public int getEvent_03() {
        if(event_03 == null){
            return 0;
        }
        return event_03.get();
    }

    public SimpleIntegerProperty event_03Property() {
        return event_03;
    }

    public void setEvent_03(int event_03) {
        this.event_03 = new SimpleIntegerProperty(event_03);
    }

    public int getEvent_04() {
        if(event_04 == null){
            return 0;
        }
        return event_04.get();
    }

    public SimpleIntegerProperty event_04Property() {
        return event_04;
    }

    public void setEvent_04(int event_04) {
        this.event_04 = new SimpleIntegerProperty(event_04);
    }

    public int getEvent_05() {
        if(event_05 == null){
            return 0;
        }
        return event_05.get();
    }

    public SimpleIntegerProperty event_05Property() {
        return event_05;
    }

    public void setEvent_05(int event_05) {
        this.event_05 = new SimpleIntegerProperty(event_05);
    }

    public int getEvent_06() {
        if(event_06 == null){
            return 0;
        }
        return event_06.get();
    }

    public SimpleIntegerProperty event_06Property() {
        return event_06;
    }

    public void setEvent_06(int event_06) {
        this.event_06 = new SimpleIntegerProperty(event_06);
    }

    public int getEvent_07() {
        if(event_07 == null){
            return 0;
        }
        return event_07.get();
    }

    public SimpleIntegerProperty event_07Property() {
        return event_07;
    }

    public void setEvent_07(int event_07) {
        this.event_07 = new SimpleIntegerProperty(event_07);
    }

    public int getEvent_08() {
        if(event_08 == null){
            return 0;
        }
        return event_08.get();
    }

    public SimpleIntegerProperty event_08Property() {
        return event_08;
    }

    public void setEvent_08(int event_08) {
        this.event_08 = new SimpleIntegerProperty(event_08);
    }

    public int getEvent_09() {
        if(event_09 == null){
            return 0;
        }
        return event_09.get();
    }

    public SimpleIntegerProperty event_09Property() {
        return event_09;
    }

    public void setEvent_09(int event_09) {
        this.event_09 = new SimpleIntegerProperty(event_09);
    }

    public int getEvent_10() {
        if(event_10 == null){
            return 0;
        }
        return event_10.get();
    }

    public SimpleIntegerProperty event_10Property() {
        return event_10;
    }

    public void setEvent_10(int event_10) {
        this.event_10 = new SimpleIntegerProperty(event_10);
    }

    public int getEvent_11() {
        if(event_11 == null){
            return 0;
        }
        return event_11.get();
    }

    public SimpleIntegerProperty event_11Property() {
        return event_11;
    }

    public void setEvent_11(int event_11) {
        this.event_11 = new SimpleIntegerProperty(event_11);
    }

    public int getEvent_12() {
        if(event_12 == null){
            return 0;
        }
        return event_12.get();
    }

    public SimpleIntegerProperty event_12Property() {
        return event_12;
    }

    public void setEvent_12(int event_12) {
        this.event_12 = new SimpleIntegerProperty(event_12);
    }

    public int getEvent_13() {
        if(event_13 == null){
            return 0;
        }
        return event_13.get();
    }

    public SimpleIntegerProperty event_13Property() {
        return event_13;
    }

    public void setEvent_13(int event_13) {
        this.event_13 = new SimpleIntegerProperty(event_13);
    }

    public int getON_OFF_LEQZ() {
        if(ON_OFF_LEQZ == null){
            return 0;
        }
        return ON_OFF_LEQZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQZProperty() {
        return ON_OFF_LEQZ;
    }

    public void setON_OFF_LEQZ(int ON_OFF_LEQZ) {
        this.ON_OFF_LEQZ = new SimpleIntegerProperty(ON_OFF_LEQZ);
    }

    public int getON_OFF_LEQC() {
        if(ON_OFF_LEQC == null){
            return 0;
        }
        return ON_OFF_LEQC.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQCProperty() {
        return ON_OFF_LEQC;
    }

    public void setON_OFF_LEQC(int ON_OFF_LEQC) {
        this.ON_OFF_LEQC = new SimpleIntegerProperty(ON_OFF_LEQC);
    }

    public int getON_OFF_LEQA() {
        if(ON_OFF_LEQA == null){
            return 0;
        }
        return ON_OFF_LEQA.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQAProperty() {
        return ON_OFF_LEQA;
    }

    public void setON_OFF_LEQA(int ON_OFF_LEQA) {
        this.ON_OFF_LEQA = new SimpleIntegerProperty(ON_OFF_LEQA);
    }

    public int getON_OFF_LPFZ() {
        if(ON_OFF_LPFZ == null){
            return 0;
        }
        return ON_OFF_LPFZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LPFZProperty() {
        return ON_OFF_LPFZ;
    }

    public void setON_OFF_LPFZ(int ON_OFF_LPFZ) {
        this.ON_OFF_LPFZ = new SimpleIntegerProperty(ON_OFF_LPFZ);
    }

    public int getON_OFF_LPSZ() {
        if(ON_OFF_LPSZ == null){
            return 0;
        }
        return ON_OFF_LPSZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LPSZProperty() {
        return ON_OFF_LPSZ;
    }

    public void setON_OFF_LPSZ(int ON_OFF_LPSZ) {
        this.ON_OFF_LPSZ = new SimpleIntegerProperty(ON_OFF_LPSZ);
    }

    public int getON_OFF_LPIZ() {
        if(ON_OFF_LPIZ == null){
            return 0;
        }
        return ON_OFF_LPIZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LPIZProperty() {
        return ON_OFF_LPIZ;
    }

    public void setON_OFF_LPIZ(int ON_OFF_LPIZ) {
        this.ON_OFF_LPIZ = new SimpleIntegerProperty(ON_OFF_LPIZ);
    }

    public int getON_OFF_LPFC() {
        if(ON_OFF_LPFC == null){
            return 0;
        }
        return ON_OFF_LPFC.get();
    }

    public SimpleIntegerProperty ON_OFF_LPFCProperty() {
        return ON_OFF_LPFC;
    }

    public void setON_OFF_LPFC(int ON_OFF_LPFC) {
        this.ON_OFF_LPFC = new SimpleIntegerProperty(ON_OFF_LPFC);
    }

    public int getON_OFF_LPSC() {
        if(ON_OFF_LPSC == null){
            return 0;
        }
        return ON_OFF_LPSC.get();
    }

    public SimpleIntegerProperty ON_OFF_LPSCProperty() {
        return ON_OFF_LPSC;
    }

    public void setON_OFF_LPSC(int ON_OFF_LPSC) {
        this.ON_OFF_LPSC = new SimpleIntegerProperty(ON_OFF_LPSC);
    }

    public int getON_OFF_LPIC() {
        if(ON_OFF_LPIC == null ){
            return 0;
        }
        return ON_OFF_LPIC.get();
    }

    public SimpleIntegerProperty ON_OFF_LPICProperty() {
        return ON_OFF_LPIC;
    }

    public void setON_OFF_LPIC(int ON_OFF_LPIC) {
        this.ON_OFF_LPIC = new SimpleIntegerProperty(ON_OFF_LPIC);
    }

    public int getON_OFF_LPFA() {
        if(ON_OFF_LPFA == null){
            return 0;
        }
        return ON_OFF_LPFA.get();
    }

    public SimpleIntegerProperty ON_OFF_LPFAProperty() {
        return ON_OFF_LPFA;
    }

    public void setON_OFF_LPFA(int ON_OFF_LPFA) {
        this.ON_OFF_LPFA = new SimpleIntegerProperty(ON_OFF_LPFA);
    }

    public int getON_OFF_LPSA() {
        if(ON_OFF_LPSA == null){
            return 0;
        }
        return ON_OFF_LPSA.get();
    }

    public SimpleIntegerProperty ON_OFF_LPSAProperty() {
        return ON_OFF_LPSA;
    }

    public void setON_OFF_LPSA(int ON_OFF_LPSA) {
        this.ON_OFF_LPSA = new SimpleIntegerProperty(ON_OFF_LPSA);
    }

    public int getON_OFF_LPIA() {
        if(ON_OFF_LPIA == null){
            return 0;
        }
        return ON_OFF_LPIA.get();
    }

    public SimpleIntegerProperty ON_OFF_LPIAProperty() {
        return ON_OFF_LPIA;
    }

    public void setON_OFF_LPIA(int ON_OFF_LPIA) {
        this.ON_OFF_LPIA = new SimpleIntegerProperty(ON_OFF_LPIA);
    }

    public int getON_OFF_PEAKZ() {
        if(ON_OFF_PEAKZ == null){
            return 0;
        }
        return ON_OFF_PEAKZ.get();
    }

    public SimpleIntegerProperty ON_OFF_PEAKZProperty() {
        return ON_OFF_PEAKZ;
    }

    public void setON_OFF_PEAKZ(int ON_OFF_PEAKZ) {
        this.ON_OFF_PEAKZ = new SimpleIntegerProperty(ON_OFF_PEAKZ);
    }

    public int getON_OFF_PEAKC() {
        if(ON_OFF_PEAKC == null){
            return 0;
        }
        return ON_OFF_PEAKC.get();
    }

    public SimpleIntegerProperty ON_OFF_PEAKCProperty() {
        return ON_OFF_PEAKC;
    }

    public void setON_OFF_PEAKC(int ON_OFF_PEAKC) {
        this.ON_OFF_PEAKC = new SimpleIntegerProperty(ON_OFF_PEAKC);
    }

    public int getON_OFF_PEAKA() {
        if(ON_OFF_PEAKA == null){
            return 0;
        }
        return ON_OFF_PEAKA.get();
    }

    public SimpleIntegerProperty ON_OFF_PEAKAProperty() {
        return ON_OFF_PEAKA;
    }

    public void setON_OFF_PEAKA(int ON_OFF_PEAKA) {
        this.ON_OFF_PEAKA = new SimpleIntegerProperty(ON_OFF_PEAKA);
    }

    public int getON_OFF_HOUR() {
        if(ON_OFF_HOUR == null){
            return 0;
        }
        return ON_OFF_HOUR.get();
    }

    public SimpleIntegerProperty ON_OFF_HOURProperty() {
        return ON_OFF_HOUR;
    }

    public void setON_OFF_HOUR(int ON_OFF_HOUR) {
        this.ON_OFF_HOUR = new SimpleIntegerProperty(ON_OFF_HOUR);
    }

    public int getON_OFF_DAY() {
        if(ON_OFF_DAY == null){
            return 0;
        }
        return ON_OFF_DAY.get();
    }

    public SimpleIntegerProperty ON_OFF_DAYProperty() {
        return ON_OFF_DAY;
    }

    public void setON_OFF_DAY(int ON_OFF_DAY) {
        this.ON_OFF_DAY = new SimpleIntegerProperty(ON_OFF_DAY);
    }

    public int getON_OFF_UDT() {
        if(ON_OFF_UDT == null){
            return 0;
        }
        return ON_OFF_UDT.get();
    }

    public SimpleIntegerProperty ON_OFF_UDTProperty() {
        return ON_OFF_UDT;
    }

    public void setON_OFF_UDT(int ON_OFF_UDT) {
        this.ON_OFF_UDT = new SimpleIntegerProperty(ON_OFF_UDT);
    }

    public int getON_OFF_13OCT() {
        if(ON_OFF_13OCT == null){
            return 0;
        }
        return ON_OFF_13OCT.get();
    }

    public SimpleIntegerProperty ON_OFF_13OCTProperty() {
        return ON_OFF_13OCT;
    }

    public void setON_OFF_13OCT(int ON_OFF_13OCT) {
        this.ON_OFF_13OCT = new SimpleIntegerProperty(ON_OFF_13OCT);
    }

    public int getON_OFF_11OCT() {
        if(ON_OFF_11OCT == null){
            return 0;
        }
        return ON_OFF_11OCT.get();
    }

    public SimpleIntegerProperty ON_OFF_11OCTProperty() {
        return ON_OFF_11OCT;
    }

    public void setON_OFF_11OCT(int ON_OFF_11OCT) {
        this.ON_OFF_11OCT = new SimpleIntegerProperty(ON_OFF_11OCT);
    }

    public int getON_OFF_RADF() {
        if(ON_OFF_RADF == null){
            return 0;
        }
        return ON_OFF_RADF.get();
    }

    public SimpleIntegerProperty ON_OFF_RADFProperty() {
        return ON_OFF_RADF;
    }

    public void setON_OFF_RADF(int ON_OFF_RADF) {
        this.ON_OFF_RADF = new SimpleIntegerProperty(ON_OFF_RADF);
    }

    public int getON_OFF_FAMF() {
        if(ON_OFF_FAMF == null){
            return 0;
        }
        return ON_OFF_FAMF.get();
    }

    public SimpleIntegerProperty ON_OFF_FAMFProperty() {
        return ON_OFF_FAMF;
    }

    public void setON_OFF_FAMF(int ON_OFF_FAMF) {
        this.ON_OFF_FAMF = new SimpleIntegerProperty(ON_OFF_FAMF);
    }

    public int getON_OFF_PDWIV() {
        if(ON_OFF_PDWIV == null){
            return 0;
        }
        return ON_OFF_PDWIV.get();
    }

    public SimpleIntegerProperty ON_OFF_PDWIVProperty() {
        return ON_OFF_PDWIV;
    }

    public void setON_OFF_PDWIV(int ON_OFF_PDWIV) {
        this.ON_OFF_PDWIV = new SimpleIntegerProperty(ON_OFF_PDWIV);
    }

    public int getON_OFF_LEQ1S() {
        if(ON_OFF_LEQ1S == null){
            return 0;
        }
        return ON_OFF_LEQ1S.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQ1SProperty() {
        return ON_OFF_LEQ1S;
    }

    public void setON_OFF_LEQ1S(int ON_OFF_LEQ1S) {
        this.ON_OFF_LEQ1S = new SimpleIntegerProperty(ON_OFF_LEQ1S);
    }

    public int getHasOct() {
        if(hasOct == null){
            return 0;
        }
        return hasOct.get();
    }

    public SimpleIntegerProperty hasOctProperty() {
        return hasOct;
    }

    public void setHasOct(int hasOct) {
        this.hasOct = new SimpleIntegerProperty(hasOct);
    }

    public int getHasAll() {
        if(hasAll == null){
            return 0;
        }
        return hasAll.get();
    }

    public SimpleIntegerProperty hasAllProperty() {
        return hasAll;
    }

    public void setHasAll(int hasAll) {
        this.hasAll = new SimpleIntegerProperty(hasAll);
    }

    public int getHasRecord() {
        if(hasRecord == null){
            return 0;
        }
        return hasRecord.get();
    }

    public SimpleIntegerProperty hasRecordProperty() {
        return hasRecord;
    }

    public void setHasRecord(int hasRecord) {
        this.hasRecord = new SimpleIntegerProperty(hasRecord);
    }

    public int getHasSoundtrans() {
        if(hasSoundtrans == null){
            return 0;
        }
        return hasSoundtrans.get();
    }

    public SimpleIntegerProperty hasSoundtransProperty() {
        return hasSoundtrans;
    }

    public void setHasSoundtrans(int hasSoundtrans) {
        this.hasSoundtrans = new SimpleIntegerProperty(hasSoundtrans);
    }

    public int getRecord_On_Off() {
        if(record_On_Off == null){
            return 0;
        }
        return record_On_Off.get();
    }

    public SimpleIntegerProperty record_On_OffProperty() {
        return record_On_Off;
    }

    public void setRecord_On_Off(int record_On_Off) {
        this.record_On_Off = new SimpleIntegerProperty(record_On_Off);
    }

    public String getVersion_Hardware() {
        if(version_Hardware == null){
            return "";
        }
        return version_Hardware.get();
    }

    public StringProperty version_HardwareProperty() {
        return version_Hardware;
    }

    public void setVersion_Hardware(String version_Hardware) {
        this.version_Hardware = new SimpleStringProperty(version_Hardware);
    }

    public String getVersion_Linux() {
        if(version_Linux == null){
            return "";
        }
        return version_Linux.get();
    }

    public StringProperty version_LinuxProperty() {
        return version_Linux;
    }

    public void setVersion_Linux(String version_Linux) {
        this.version_Linux = new SimpleStringProperty(version_Linux);
    }

    public String getVersion_N_VIEW() {
        if(version_N_VIEW == null){
            return "";
        }
        return version_N_VIEW.get();
    }

    public StringProperty version_N_VIEWProperty() {
        return version_N_VIEW;
    }

    public void setVersion_N_VIEW(String version_N_VIEW) {
        this.version_N_VIEW = new SimpleStringProperty(version_N_VIEW);
    }

    public String getVersion_NoiseMonitor() {
        if(version_NoiseMonitor == null){
            return "";
        }
        return version_NoiseMonitor.get();
    }

    public StringProperty version_NoiseMonitorProperty() {
        return version_NoiseMonitor;
    }

    public void setVersion_NoiseMonitor(String version_NoiseMonitor) {
        this.version_NoiseMonitor = new SimpleStringProperty(version_NoiseMonitor);
    }

    public String getVersion_normal() {
        if(version_normal == null){
            return "";
        }
        return version_normal.get();
    }

    public StringProperty version_normalProperty() {
        return version_normal;
    }

    public void setVersion_normal(String version_normal) {
        this.version_normal = new SimpleStringProperty(version_normal);
    }

    public InfoNoiseManager(String noiseManagerId, Double sample, int upSpace, Double dayOverValue, Double nightOverValue, int overDlay, int isExceed, Double dayOctValue, Double nightOctValue, int octDlay, int isOct, Double dayRecordValue, Double nightRecordValue, int recordDlay, int isRecord, Date recordStartTime, Date recordEndTime, int recordModel, String freWight, String timeWight, int initime, Date adjustTime, int adjustSpace, int isAutoAdjust, int weaAutoUp, int weaAutoSave, int weaUpSpace, int carAutoUp, int carAutoSave, int carUpSpace, int dustAutoUp, int dustAutoSave, int dustUpSpace, int event_01, int event_02, int event_03, int event_04, int event_05, int event_06, int event_07, int event_08, int event_09, int event_10, int event_11, int event_12, int event_13, int ON_OFF_LEQZ, int ON_OFF_LEQC, int ON_OFF_LEQA, int ON_OFF_LPFZ, int ON_OFF_LPSZ, int ON_OFF_LPIZ, int ON_OFF_LPFC, int ON_OFF_LPSC, int ON_OFF_LPIC, int ON_OFF_LPFA, int ON_OFF_LPSA, int ON_OFF_LPIA, int ON_OFF_PEAKZ, int ON_OFF_PEAKC, int ON_OFF_PEAKA, int ON_OFF_HOUR, int ON_OFF_DAY, int ON_OFF_UDT, int ON_OFF_13OCT, int ON_OFF_11OCT, int ON_OFF_RADF, int ON_OFF_FAMF, int ON_OFF_PDWIV, int ON_OFF_LEQ1S, int hasOct, int hasAll, int hasRecord, int hasSoundtrans, int record_On_Off, String version_Hardware, String version_Linux, String version_N_VIEW, String version_NoiseMonitor, String version_normal) {
        this.noiseManagerId = new SimpleStringProperty(noiseManagerId);
        this.sample = new SimpleDoubleProperty(sample);
        this.upSpace = new SimpleIntegerProperty(upSpace);
        this.dayOverValue = new SimpleDoubleProperty(dayOverValue);
        this.nightOverValue = new SimpleDoubleProperty(nightOverValue);
        this.overDlay = new SimpleIntegerProperty(overDlay);
        this.isExceed = new SimpleIntegerProperty(isExceed);
        this.dayOctValue = new SimpleDoubleProperty(dayOctValue);
        this.nightOctValue = new SimpleDoubleProperty(nightOctValue);
        this.octDlay = new SimpleIntegerProperty(octDlay);
        this.isOct = new SimpleIntegerProperty(isOct);
        this.dayRecordValue = new SimpleDoubleProperty(dayRecordValue);
        this.nightRecordValue = new SimpleDoubleProperty(nightRecordValue);
        this.recordDlay = new SimpleIntegerProperty(recordDlay);
        this.isRecord = new SimpleIntegerProperty(isRecord);
        this.recordStartTime = recordStartTime;
        this.recordEndTime = recordEndTime;
        this.recordModel = new SimpleIntegerProperty(recordModel);
        this.freWight = new SimpleStringProperty(freWight);
        this.timeWight = new SimpleStringProperty(timeWight);
        this.initime = new SimpleIntegerProperty(initime);
        this.adjustTime = adjustTime;
        this.adjustSpace = new SimpleIntegerProperty(adjustSpace);
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
        this.weaAutoUp = new SimpleIntegerProperty(weaAutoUp);
        this.weaAutoSave = new SimpleIntegerProperty(weaAutoSave);
        this.weaUpSpace = new SimpleIntegerProperty(weaUpSpace);
        this.carAutoUp = new SimpleIntegerProperty(carAutoUp);
        this.carAutoSave = new SimpleIntegerProperty(carAutoSave);
        this.carUpSpace = new SimpleIntegerProperty(carUpSpace);
        this.dustAutoUp = new SimpleIntegerProperty(dustAutoUp);
        this.dustAutoSave = new SimpleIntegerProperty(dustAutoSave);
        this.dustUpSpace = new SimpleIntegerProperty(dustUpSpace);
        this.event_01 = new SimpleIntegerProperty(event_01);
        this.event_02 = new SimpleIntegerProperty(event_02);
        this.event_03 = new SimpleIntegerProperty(event_03);
        this.event_04 = new SimpleIntegerProperty(event_04);
        this.event_05 = new SimpleIntegerProperty(event_05);
        this.event_06 = new SimpleIntegerProperty(event_06);
        this.event_07 = new SimpleIntegerProperty(event_07);
        this.event_08 = new SimpleIntegerProperty(event_08);
        this.event_09 = new SimpleIntegerProperty(event_09);
        this.event_10 = new SimpleIntegerProperty(event_10);
        this.event_11 = new SimpleIntegerProperty(event_11);
        this.event_12 = new SimpleIntegerProperty(event_12);
        this.event_13 = new SimpleIntegerProperty(event_13);
        this.ON_OFF_LEQZ = new SimpleIntegerProperty(ON_OFF_LEQZ);
        this.ON_OFF_LEQC = new SimpleIntegerProperty(ON_OFF_LEQC);
        this.ON_OFF_LEQA = new SimpleIntegerProperty(ON_OFF_LEQA);
        this.ON_OFF_LPFZ = new SimpleIntegerProperty(ON_OFF_LPFZ);
        this.ON_OFF_LPSZ = new SimpleIntegerProperty(ON_OFF_LPSZ);
        this.ON_OFF_LPIZ = new SimpleIntegerProperty(ON_OFF_LPIZ);
        this.ON_OFF_LPFC = new SimpleIntegerProperty(ON_OFF_LPFC);
        this.ON_OFF_LPSC = new SimpleIntegerProperty(ON_OFF_LPSC);
        this.ON_OFF_LPIC = new SimpleIntegerProperty(ON_OFF_LPIC);
        this.ON_OFF_LPFA = new SimpleIntegerProperty(ON_OFF_LPFA);
        this.ON_OFF_LPSA = new SimpleIntegerProperty(ON_OFF_LPSA);
        this.ON_OFF_LPIA = new SimpleIntegerProperty(ON_OFF_LPIA);
        this.ON_OFF_PEAKZ = new SimpleIntegerProperty(ON_OFF_PEAKZ);
        this.ON_OFF_PEAKC = new SimpleIntegerProperty(ON_OFF_PEAKC);
        this.ON_OFF_PEAKA = new SimpleIntegerProperty(ON_OFF_PEAKA);
        this.ON_OFF_HOUR = new SimpleIntegerProperty(ON_OFF_HOUR);
        this.ON_OFF_DAY = new SimpleIntegerProperty(ON_OFF_DAY);
        this.ON_OFF_UDT = new SimpleIntegerProperty(ON_OFF_UDT);
        this.ON_OFF_13OCT = new SimpleIntegerProperty(ON_OFF_13OCT);
        this.ON_OFF_11OCT = new SimpleIntegerProperty(ON_OFF_11OCT);
        this.ON_OFF_RADF = new SimpleIntegerProperty(ON_OFF_RADF);
        this.ON_OFF_FAMF = new SimpleIntegerProperty(ON_OFF_FAMF);
        this.ON_OFF_PDWIV = new SimpleIntegerProperty(ON_OFF_PDWIV);
        this.ON_OFF_LEQ1S = new SimpleIntegerProperty(ON_OFF_LEQ1S);
        this.hasOct = new SimpleIntegerProperty(hasOct);
        this.hasAll = new SimpleIntegerProperty(hasAll);
        this.hasRecord = new SimpleIntegerProperty(hasRecord);
        this.hasSoundtrans = new SimpleIntegerProperty(hasSoundtrans);
        this.record_On_Off = new SimpleIntegerProperty(record_On_Off);
        this.version_Hardware = new SimpleStringProperty(version_Hardware);
        this.version_Linux = new SimpleStringProperty(version_Linux);
        this.version_N_VIEW = new SimpleStringProperty(version_N_VIEW);
        this.version_NoiseMonitor = new SimpleStringProperty(version_NoiseMonitor);
        this.version_normal = new SimpleStringProperty(version_normal);
    }

    public InfoNoiseManager() {
    }
}
