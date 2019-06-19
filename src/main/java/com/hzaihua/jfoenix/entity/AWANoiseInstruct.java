package com.hzaihua.jfoenix.entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AWANoiseInstruct extends RecursiveTreeObject<AWANoiseInstruct> {
    private StringProperty noiseInstructId; //指令ID
    private StringProperty noiseCode; //设备编号
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
    private SimpleDoubleProperty recordModel; //上传模式
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
    private SimpleIntegerProperty ON_OFF_MIN; //分钟统计数据自动上传
    private SimpleIntegerProperty ON_OFF_HOUR; //小时统计数据自动上传
    private SimpleIntegerProperty ON_OFF_DAY; //天统计数据自动上传
    private SimpleIntegerProperty ON_OFF_UDT; //自定义积分时间统计数据自动上传
    private SimpleIntegerProperty ON_OFF_13OCT; //1/3频谱数据按照采样间隔参数的间隔自动上传
    private SimpleIntegerProperty ON_OFF_11OCT; //1/1频谱数据按照采样间隔参数的间隔自动上传
    private SimpleIntegerProperty ON_OFF_RADF; //仪器出错时复位
    private SimpleIntegerProperty ON_OFF_FAMF; //存储器加载失败时格式化存储器
    private SimpleIntegerProperty ON_OFF_PDWIV; //低电压数据保护
    private SimpleIntegerProperty ON_OFF_LEQ1S; //保存每秒的Leq，包括A、C、Z 3个计权

    @Override
    public String toString() {
        return "AWANoiseInstruct{" +
                "noiseInstructId=" + noiseInstructId +
                ", noiseCode=" + noiseCode +
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
                ", ON_OFF_MIN=" + ON_OFF_MIN +
                ", ON_OFF_HOUR=" + ON_OFF_HOUR +
                ", ON_OFF_DAY=" + ON_OFF_DAY +
                ", ON_OFF_UDT=" + ON_OFF_UDT +
                ", ON_OFF_13OCT=" + ON_OFF_13OCT +
                ", ON_OFF_11OCT=" + ON_OFF_11OCT +
                ", ON_OFF_RADF=" + ON_OFF_RADF +
                ", ON_OFF_FAMF=" + ON_OFF_FAMF +
                ", ON_OFF_PDWIV=" + ON_OFF_PDWIV +
                ", ON_OFF_LEQ1S=" + ON_OFF_LEQ1S +
                '}';
    }

    public String getNoiseInstructId() {
        return noiseInstructId.get();
    }

    public StringProperty noiseInstructIdProperty() {
        return noiseInstructId;
    }

    public void setNoiseInstructId(String noiseInstructId) {
        this.noiseInstructId = new SimpleStringProperty(noiseInstructId);
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

    public Double getSample() {
        return sample.get();
    }

    public SimpleDoubleProperty sampleProperty() {
        return sample;
    }

    public void setSample(Double sample) {
        this.sample = new SimpleDoubleProperty(sample);
    }

    public int getUpSpace() {
        return upSpace.get();
    }

    public SimpleIntegerProperty upSpaceProperty() {
        return upSpace;
    }

    public void setUpSpace(int upSpace) {
        this.upSpace = new SimpleIntegerProperty(upSpace);
    }

    public double getDayOverValue() {
        return dayOverValue.get();
    }

    public SimpleDoubleProperty dayOverValueProperty() {
        return dayOverValue;
    }

    public void setDayOverValue(double dayOverValue) {
        this.dayOverValue = new SimpleDoubleProperty(dayOverValue);
    }

    public double getNightOverValue() {
        return nightOverValue.get();
    }

    public SimpleDoubleProperty nightOverValueProperty() {
        return nightOverValue;
    }

    public void setNightOverValue(double nightOverValue) {
        this.nightOverValue = new SimpleDoubleProperty(nightOverValue);
    }

    public int getOverDlay() {
        return overDlay.get();
    }

    public SimpleIntegerProperty overDlayProperty() {
        return overDlay;
    }

    public void setOverDlay(int overDlay) {
        this.overDlay = new SimpleIntegerProperty(overDlay);
    }

    public int getIsExceed() {
        return isExceed.get();
    }

    public SimpleIntegerProperty isExceedProperty() {
        return isExceed;
    }

    public void setIsExceed(int isExceed) {
        this.isExceed = new SimpleIntegerProperty(isExceed);
    }

    public double getDayOctValue() {
        return dayOctValue.get();
    }

    public SimpleDoubleProperty dayOctValueProperty() {
        return dayOctValue;
    }

    public void setDayOctValue(double dayOctValue) {
        this.dayOctValue = new SimpleDoubleProperty(dayOctValue);
    }

    public double getNightOctValue() {
        return nightOctValue.get();
    }

    public SimpleDoubleProperty nightOctValueProperty() {
        return nightOctValue;
    }

    public void setNightOctValue(double nightOctValue) {
        this.nightOctValue = new SimpleDoubleProperty(nightOctValue);
    }

    public int getOctDlay() {
        return octDlay.get();
    }

    public SimpleIntegerProperty octDlayProperty() {
        return octDlay;
    }

    public void setOctDlay(int octDlay) {
        this.octDlay = new SimpleIntegerProperty(octDlay);
    }

    public int getIsOct() {
        return isOct.get();
    }

    public SimpleIntegerProperty isOctProperty() {
        return isOct;
    }

    public void setIsOct(int isOct) {
        this.isOct = new SimpleIntegerProperty(isOct);
    }

    public double getDayRecordValue() {
        return dayRecordValue.get();
    }

    public SimpleDoubleProperty dayRecordValueProperty() {
        return dayRecordValue;
    }

    public void setDayRecordValue(double dayRecordValue) {
        this.dayRecordValue = new SimpleDoubleProperty(dayRecordValue);
    }

    public double getNightRecordValue() {
        return nightRecordValue.get();
    }

    public SimpleDoubleProperty nightRecordValueProperty() {
        return nightRecordValue;
    }

    public void setNightRecordValue(double nightRecordValue) {
        this.nightRecordValue = new SimpleDoubleProperty(nightRecordValue);
    }

    public int getRecordDlay() {
        return recordDlay.get();
    }

    public SimpleIntegerProperty recordDlayProperty() {
        return recordDlay;
    }

    public void setRecordDlay(int recordDlay) {
        this.recordDlay = new SimpleIntegerProperty(recordDlay);
    }

    public int getIsRecord() {
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

    public double getRecordModel() {
        return recordModel.get();
    }

    public SimpleDoubleProperty recordModelProperty() {
        return recordModel;
    }

    public void setRecordModel(double recordModel) {
        this.recordModel = new SimpleDoubleProperty(recordModel);
    }

    public String getFreWight() {
        return freWight.get();
    }

    public StringProperty freWightProperty() {
        return freWight;
    }

    public void setFreWight(String freWight) {
        this.freWight = new SimpleStringProperty(freWight);
    }

    public String getTimeWight() {
        return timeWight.get();
    }

    public StringProperty timeWightProperty() {
        return timeWight;
    }

    public void setTimeWight(String timeWight) {
        this.timeWight = new SimpleStringProperty(timeWight);
    }

    public int getInitime() {
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
        return adjustSpace.get();
    }

    public SimpleIntegerProperty adjustSpaceProperty() {
        return adjustSpace;
    }

    public void setAdjustSpace(int adjustSpace) {
        this.adjustSpace = new SimpleIntegerProperty(adjustSpace);
    }

    public int getIsAutoAdjust() {
        return isAutoAdjust.get();
    }

    public SimpleIntegerProperty isAutoAdjustProperty() {
        return isAutoAdjust;
    }

    public void setIsAutoAdjust(int isAutoAdjust) {
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
    }

    public int getWeaAutoUp() {
        return weaAutoUp.get();
    }

    public SimpleIntegerProperty weaAutoUpProperty() {
        return weaAutoUp;
    }

    public void setWeaAutoUp(int weaAutoUp) {
        this.weaAutoUp = new SimpleIntegerProperty(weaAutoUp);
    }

    public int getWeaAutoSave() {
        return weaAutoSave.get();
    }

    public SimpleIntegerProperty weaAutoSaveProperty() {
        return weaAutoSave;
    }

    public void setWeaAutoSave(int weaAutoSave) {
        this.weaAutoSave = new SimpleIntegerProperty(weaAutoSave);
    }

    public int getWeaUpSpace() {
        return weaUpSpace.get();
    }

    public SimpleIntegerProperty weaUpSpaceProperty() {
        return weaUpSpace;
    }

    public void setWeaUpSpace(int weaUpSpace) {
        this.weaUpSpace = new SimpleIntegerProperty(weaUpSpace);
    }

    public int getCarAutoUp() {
        return carAutoUp.get();
    }

    public SimpleIntegerProperty carAutoUpProperty() {
        return carAutoUp;
    }

    public void setCarAutoUp(int carAutoUp) {
        this.carAutoUp = new SimpleIntegerProperty(carAutoUp);
    }

    public int getCarAutoSave() {
        return carAutoSave.get();
    }

    public SimpleIntegerProperty carAutoSaveProperty() {
        return carAutoSave;
    }

    public void setCarAutoSave(int carAutoSave) {
        this.carAutoSave = new SimpleIntegerProperty(carAutoSave);
    }

    public int getCarUpSpace() {
        return carUpSpace.get();
    }

    public SimpleIntegerProperty carUpSpaceProperty() {
        return carUpSpace;
    }

    public void setCarUpSpace(int carUpSpace) {
        this.carUpSpace = new SimpleIntegerProperty(carUpSpace);
    }

    public int getDustAutoUp() {
        return dustAutoUp.get();
    }

    public SimpleIntegerProperty dustAutoUpProperty() {
        return dustAutoUp;
    }

    public void setDustAutoUp(int dustAutoUp) {
        this.dustAutoUp = new SimpleIntegerProperty(dustAutoUp);
    }

    public int getDustAutoSave() {
        return dustAutoSave.get();
    }

    public SimpleIntegerProperty dustAutoSaveProperty() {
        return dustAutoSave;
    }

    public void setDustAutoSave(int dustAutoSave) {
        this.dustAutoSave = new SimpleIntegerProperty(dustAutoSave);
    }

    public int getDustUpSpace() {
        return dustUpSpace.get();
    }

    public SimpleIntegerProperty dustUpSpaceProperty() {
        return dustUpSpace;
    }

    public void setDustUpSpace(int dustUpSpace) {
        this.dustUpSpace = new SimpleIntegerProperty(dustUpSpace);
    }

    public int getEvent_01() {
        return event_01.get();
    }

    public SimpleIntegerProperty event_01Property() {
        return event_01;
    }

    public void setEvent_01(int event_01) {
        this.event_01 = new SimpleIntegerProperty(event_01);
    }

    public int getEvent_02() {
        return event_02.get();
    }

    public SimpleIntegerProperty event_02Property() {
        return event_02;
    }

    public void setEvent_02(int event_02) {
        this.event_02 = new SimpleIntegerProperty(event_02);
    }

    public int getEvent_03() {
        return event_03.get();
    }

    public SimpleIntegerProperty event_03Property() {
        return event_03;
    }

    public void setEvent_03(int event_03) {
        this.event_03 = new SimpleIntegerProperty(event_03);
    }

    public int getEvent_04() {
        return event_04.get();
    }

    public SimpleIntegerProperty event_04Property() {
        return event_04;
    }

    public void setEvent_04(int event_04) {
        this.event_04 = new SimpleIntegerProperty(event_04);
    }

    public int getEvent_05() {
        return event_05.get();
    }

    public SimpleIntegerProperty event_05Property() {
        return event_05;
    }

    public void setEvent_05(int event_05) {
        this.event_05 = new SimpleIntegerProperty(event_05);
    }

    public int getEvent_06() {
        return event_06.get();
    }

    public SimpleIntegerProperty event_06Property() {
        return event_06;
    }

    public void setEvent_06(int event_06) {
        this.event_06 = new SimpleIntegerProperty(event_06);
    }

    public int getEvent_07() {
        return event_07.get();
    }

    public SimpleIntegerProperty event_07Property() {
        return event_07;
    }

    public void setEvent_07(int event_07) {
        this.event_07 = new SimpleIntegerProperty(event_07);
    }

    public int getEvent_08() {
        return event_08.get();
    }

    public SimpleIntegerProperty event_08Property() {
        return event_08;
    }

    public void setEvent_08(int event_08) {
        this.event_08 = new SimpleIntegerProperty(event_08);
    }

    public int getEvent_09() {
        return event_09.get();
    }

    public SimpleIntegerProperty event_09Property() {
        return event_09;
    }

    public void setEvent_09(int event_09) {
        this.event_09 = new SimpleIntegerProperty(event_09);
    }

    public int getEvent_10() {
        return event_10.get();
    }

    public SimpleIntegerProperty event_10Property() {
        return event_10;
    }

    public void setEvent_10(int event_10) {
        this.event_10 = new SimpleIntegerProperty(event_10);
    }

    public int getEvent_11() {
        return event_11.get();
    }

    public SimpleIntegerProperty event_11Property() {
        return event_11;
    }

    public void setEvent_11(int event_11) {
        this.event_11 = new SimpleIntegerProperty(event_11);
    }

    public int getEvent_12() {
        return event_12.get();
    }

    public SimpleIntegerProperty event_12Property() {
        return event_12;
    }

    public void setEvent_12(int event_12) {
        this.event_12 = new SimpleIntegerProperty(event_12);
    }

    public int getEvent_13() {
        return event_13.get();
    }

    public SimpleIntegerProperty event_13Property() {
        return event_13;
    }

    public void setEvent_13(int event_13) {
        this.event_13 = new SimpleIntegerProperty(event_13);
    }

    public int getON_OFF_LEQZ() {
        return ON_OFF_LEQZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQZProperty() {
        return ON_OFF_LEQZ;
    }

    public void setON_OFF_LEQZ(int ON_OFF_LEQZ) {
        this.ON_OFF_LEQZ = new SimpleIntegerProperty(ON_OFF_LEQZ);
    }

    public int getON_OFF_LEQC() {
        return ON_OFF_LEQC.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQCProperty() {
        return ON_OFF_LEQC;
    }

    public void setON_OFF_LEQC(int ON_OFF_LEQC) {
        this.ON_OFF_LEQC = new SimpleIntegerProperty(ON_OFF_LEQC);
    }

    public int getON_OFF_LEQA() {
        return ON_OFF_LEQA.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQAProperty() {
        return ON_OFF_LEQA;
    }

    public void setON_OFF_LEQA(int ON_OFF_LEQA) {
        this.ON_OFF_LEQA = new SimpleIntegerProperty(ON_OFF_LEQA);
    }

    public int getON_OFF_LPFZ() {
        return ON_OFF_LPFZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LPFZProperty() {
        return ON_OFF_LPFZ;
    }

    public void setON_OFF_LPFZ(int ON_OFF_LPFZ) {
        this.ON_OFF_LPFZ = new SimpleIntegerProperty(ON_OFF_LPFZ);
    }

    public int getON_OFF_LPSZ() {
        return ON_OFF_LPSZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LPSZProperty() {
        return ON_OFF_LPSZ;
    }

    public void setON_OFF_LPSZ(int ON_OFF_LPSZ) {
        this.ON_OFF_LPSZ = new SimpleIntegerProperty(ON_OFF_LPSZ);
    }

    public int getON_OFF_LPIZ() {
        return ON_OFF_LPIZ.get();
    }

    public SimpleIntegerProperty ON_OFF_LPIZProperty() {
        return ON_OFF_LPIZ;
    }

    public void setON_OFF_LPIZ(int ON_OFF_LPIZ) {
        this.ON_OFF_LPIZ = new SimpleIntegerProperty(ON_OFF_LPIZ);
    }

    public int getON_OFF_LPFC() {
        return ON_OFF_LPFC.get();
    }

    public SimpleIntegerProperty ON_OFF_LPFCProperty() {
        return ON_OFF_LPFC;
    }

    public void setON_OFF_LPFC(int ON_OFF_LPFC) {
        this.ON_OFF_LPFC = new SimpleIntegerProperty(ON_OFF_LPFC);
    }

    public int getON_OFF_LPSC() {
        return ON_OFF_LPSC.get();
    }

    public SimpleIntegerProperty ON_OFF_LPSCProperty() {
        return ON_OFF_LPSC;
    }

    public void setON_OFF_LPSC(int ON_OFF_LPSC) {
        this.ON_OFF_LPSC = new SimpleIntegerProperty(ON_OFF_LPSC);
    }

    public int getON_OFF_LPIC() {
        return ON_OFF_LPIC.get();
    }

    public SimpleIntegerProperty ON_OFF_LPICProperty() {
        return ON_OFF_LPIC;
    }

    public void setON_OFF_LPIC(int ON_OFF_LPIC) {
        this.ON_OFF_LPIC = new SimpleIntegerProperty(ON_OFF_LPIC);
    }

    public int getON_OFF_LPFA() {
        return ON_OFF_LPFA.get();
    }

    public SimpleIntegerProperty ON_OFF_LPFAProperty() {
        return ON_OFF_LPFA;
    }

    public void setON_OFF_LPFA(int ON_OFF_LPFA) {
        this.ON_OFF_LPFA = new SimpleIntegerProperty(ON_OFF_LPFA);
    }

    public int getON_OFF_LPSA() {
        return ON_OFF_LPSA.get();
    }

    public SimpleIntegerProperty ON_OFF_LPSAProperty() {
        return ON_OFF_LPSA;
    }

    public void setON_OFF_LPSA(int ON_OFF_LPSA) {
        this.ON_OFF_LPSA = new SimpleIntegerProperty(ON_OFF_LPSA);
    }

    public int getON_OFF_LPIA() {
        return ON_OFF_LPIA.get();
    }

    public SimpleIntegerProperty ON_OFF_LPIAProperty() {
        return ON_OFF_LPIA;
    }

    public void setON_OFF_LPIA(int ON_OFF_LPIA) {
        this.ON_OFF_LPIA = new SimpleIntegerProperty(ON_OFF_LPIA);
    }

    public int getON_OFF_PEAKZ() {
        return ON_OFF_PEAKZ.get();
    }

    public SimpleIntegerProperty ON_OFF_PEAKZProperty() {
        return ON_OFF_PEAKZ;
    }

    public void setON_OFF_PEAKZ(int ON_OFF_PEAKZ) {
        this.ON_OFF_PEAKZ = new SimpleIntegerProperty(ON_OFF_PEAKZ);
    }

    public int getON_OFF_PEAKC() {
        return ON_OFF_PEAKC.get();
    }

    public SimpleIntegerProperty ON_OFF_PEAKCProperty() {
        return ON_OFF_PEAKC;
    }

    public void setON_OFF_PEAKC(int ON_OFF_PEAKC) {
        this.ON_OFF_PEAKC = new SimpleIntegerProperty(ON_OFF_PEAKC);
    }

    public int getON_OFF_PEAKA() {
        return ON_OFF_PEAKA.get();
    }

    public SimpleIntegerProperty ON_OFF_PEAKAProperty() {
        return ON_OFF_PEAKA;
    }

    public void setON_OFF_PEAKA(int ON_OFF_PEAKA) {
        this.ON_OFF_PEAKA = new SimpleIntegerProperty(ON_OFF_PEAKA);
    }

    public int getON_OFF_MIN() {
        return ON_OFF_MIN.get();
    }

    public SimpleIntegerProperty ON_OFF_MINProperty() {
        return ON_OFF_MIN;
    }

    public void setON_OFF_MIN(int ON_OFF_MIN) {
        this.ON_OFF_MIN = new SimpleIntegerProperty(ON_OFF_MIN);
    }

    public int getON_OFF_HOUR() {
        return ON_OFF_HOUR.get();
    }

    public SimpleIntegerProperty ON_OFF_HOURProperty() {
        return ON_OFF_HOUR;
    }

    public void setON_OFF_HOUR(int ON_OFF_HOUR) {
        this.ON_OFF_HOUR = new SimpleIntegerProperty(ON_OFF_HOUR);
    }

    public int getON_OFF_DAY() {
        return ON_OFF_DAY.get();
    }

    public SimpleIntegerProperty ON_OFF_DAYProperty() {
        return ON_OFF_DAY;
    }

    public void setON_OFF_DAY(int ON_OFF_DAY) {
        this.ON_OFF_DAY = new SimpleIntegerProperty(ON_OFF_DAY);
    }

    public int getON_OFF_UDT() {
        return ON_OFF_UDT.get();
    }

    public SimpleIntegerProperty ON_OFF_UDTProperty() {
        return ON_OFF_UDT;
    }

    public void setON_OFF_UDT(int ON_OFF_UDT) {
        this.ON_OFF_UDT = new SimpleIntegerProperty(ON_OFF_UDT);
    }

    public int getON_OFF_13OCT() {
        return ON_OFF_13OCT.get();
    }

    public SimpleIntegerProperty ON_OFF_13OCTProperty() {
        return ON_OFF_13OCT;
    }

    public void setON_OFF_13OCT(int ON_OFF_13OCT) {
        this.ON_OFF_13OCT = new SimpleIntegerProperty(ON_OFF_13OCT);
    }

    public int getON_OFF_11OCT() {
        return ON_OFF_11OCT.get();
    }

    public SimpleIntegerProperty ON_OFF_11OCTProperty() {
        return ON_OFF_11OCT;
    }

    public void setON_OFF_11OCT(int ON_OFF_11OCT) {
        this.ON_OFF_11OCT = new SimpleIntegerProperty(ON_OFF_11OCT);
    }

    public int getON_OFF_RADF() {
        return ON_OFF_RADF.get();
    }

    public SimpleIntegerProperty ON_OFF_RADFProperty() {
        return ON_OFF_RADF;
    }

    public void setON_OFF_RADF(int ON_OFF_RADF) {
        this.ON_OFF_RADF = new SimpleIntegerProperty(ON_OFF_RADF);
    }

    public int getON_OFF_FAMF() {
        return ON_OFF_FAMF.get();
    }

    public SimpleIntegerProperty ON_OFF_FAMFProperty() {
        return ON_OFF_FAMF;
    }

    public void setON_OFF_FAMF(int ON_OFF_FAMF) {
        this.ON_OFF_FAMF = new SimpleIntegerProperty(ON_OFF_FAMF);
    }

    public int getON_OFF_PDWIV() {
        return ON_OFF_PDWIV.get();
    }

    public SimpleIntegerProperty ON_OFF_PDWIVProperty() {
        return ON_OFF_PDWIV;
    }

    public void setON_OFF_PDWIV(int ON_OFF_PDWIV) {
        this.ON_OFF_PDWIV = new SimpleIntegerProperty(ON_OFF_PDWIV);
    }

    public int getON_OFF_LEQ1S() {
        return ON_OFF_LEQ1S.get();
    }

    public SimpleIntegerProperty ON_OFF_LEQ1SProperty() {
        return ON_OFF_LEQ1S;
    }

    public void setON_OFF_LEQ1S(int ON_OFF_LEQ1S) {
        this.ON_OFF_LEQ1S = new SimpleIntegerProperty(ON_OFF_LEQ1S);
    }

    public AWANoiseInstruct(String noiseInstructId, String noiseCode, double sample, int upSpace, double dayOverValue, double nightOverValue, int overDlay, int isExceed, double dayOctValue, double nightOctValue, int octDlay, int isOct, int dayRecordValue, int nightRecordValue, int recordDlay, int isRecord, Date recordStartTime, Date recordEndTime, double recordModel, String freWight, String timeWight, int initime, Date adjustTime, int adjustSpace, int isAutoAdjust, int weaAutoUp, int weaAutoSave, int weaUpSpace, int carAutoUp, int carAutoSave, int carUpSpace, int dustAutoUp, int dustAutoSave, int dustUpSpace, int event_01, int event_02, int event_03, int event_04, int event_05, int event_06, int event_07, int event_08, int event_09, int event_10, int event_11, int event_12, int event_13, int ON_OFF_LEQZ, int ON_OFF_LEQC, int ON_OFF_LEQA, int ON_OFF_LPFZ, int ON_OFF_LPSZ, int ON_OFF_LPIZ, int ON_OFF_LPFC, int ON_OFF_LPSC, int ON_OFF_LPIC, int ON_OFF_LPFA, int ON_OFF_LPSA, int ON_OFF_LPIA, int ON_OFF_PEAKZ, int ON_OFF_PEAKC, int ON_OFF_PEAKA, int ON_OFF_MIN, int ON_OFF_HOUR, int ON_OFF_DAY, int ON_OFF_UDT, int ON_OFF_13OCT, int ON_OFF_11OCT, int ON_OFF_RADF, int ON_OFF_FAMF, int ON_OFF_PDWIV, int ON_OFF_LEQ1S) {
        this.noiseInstructId = new SimpleStringProperty(noiseInstructId);
        this.noiseCode = new SimpleStringProperty(noiseCode);
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
        this.recordModel = new SimpleDoubleProperty(recordModel);
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
        this.ON_OFF_MIN = new SimpleIntegerProperty(ON_OFF_MIN);
        this.ON_OFF_HOUR = new SimpleIntegerProperty(ON_OFF_HOUR);
        this.ON_OFF_DAY = new SimpleIntegerProperty(ON_OFF_DAY);
        this.ON_OFF_UDT = new SimpleIntegerProperty(ON_OFF_UDT);
        this.ON_OFF_13OCT = new SimpleIntegerProperty(ON_OFF_13OCT);
        this.ON_OFF_11OCT = new SimpleIntegerProperty(ON_OFF_11OCT);
        this.ON_OFF_RADF = new SimpleIntegerProperty(ON_OFF_RADF);
        this.ON_OFF_FAMF = new SimpleIntegerProperty(ON_OFF_FAMF);
        this.ON_OFF_PDWIV = new SimpleIntegerProperty(ON_OFF_PDWIV);
        this.ON_OFF_LEQ1S = new SimpleIntegerProperty(ON_OFF_LEQ1S);
    }

    public AWANoiseInstruct() {
    }
}
