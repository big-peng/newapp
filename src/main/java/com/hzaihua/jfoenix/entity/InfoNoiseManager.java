package com.hzaihua.jfoenix.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

public class InfoNoiseManager {
    private StringProperty NoiseMeasureID; //设备编号
    private SimpleIntegerProperty Sample; //瞬时采样间隔
    private SimpleIntegerProperty UpSpace; //瞬时上传间隔
    private SimpleDoubleProperty DayOverValue; //噪声白天超标值
    private SimpleDoubleProperty NightOverValue; //噪声晚上超标值
    private SimpleIntegerProperty OverDlay; //噪声超标延时
    private SimpleDoubleProperty DayOctValue; //频谱白天超标限值
    private SimpleDoubleProperty NightOctValue; //频谱晚上超标限值
    private SimpleIntegerProperty OctDlay; //频谱超标延时
    private SimpleIntegerProperty IsOct; //是否超标频谱分析
    private SimpleDoubleProperty DayRecordValue; //录音白天超标
    private SimpleDoubleProperty NightRecordValue; //录音晚上超标
    private SimpleIntegerProperty RecordDlay; //录音超标延时
    private SimpleIntegerProperty IsRecord; //是否录音
    private DatePicker RecordStartTime; //上传开始时间
    private DatePicker RecordEndTime; //上传结束时间
    private SimpleIntegerProperty RecordModel; //上传模式
    private SimpleIntegerProperty FreWight; //频率计权
    private SimpleIntegerProperty TimeWight; //时间计权
    private DatePicker AdjustTime; //校准时间
    private SimpleIntegerProperty AdjustSpace; //校准间隔
    private SimpleIntegerProperty isAutoAdjust; //是否自动电校准
    private SimpleIntegerProperty WeaAutoUp; //气象自动上传
    private SimpleIntegerProperty WeaAutoSave; //气象自动保存
    private SimpleIntegerProperty WeaUpSpace; //气象采集间隔
    private SimpleIntegerProperty CarAutoUp; //车流量自动上传
    private SimpleIntegerProperty CarAutoSave; //车流量自动保存
    private SimpleIntegerProperty CarUpSpace; //车流量采集间隔
    private SimpleIntegerProperty DustAutoUp; //粉尘自动上传
    private SimpleIntegerProperty DustAutoSave; //粉尘自动保存
    private SimpleIntegerProperty DustUpSpace; //粉尘采集间隔
    private SimpleIntegerProperty Event01; //手动控制电校准
    private SimpleIntegerProperty Event02; //自动电校准
    private SimpleIntegerProperty Event03; //加热
    private SimpleIntegerProperty Event04; //噪声超标
    private SimpleIntegerProperty Event05; //仪器启动
    private SimpleIntegerProperty Event06; //仪器正常关机
    private SimpleIntegerProperty Event07; //停电
    private SimpleIntegerProperty Event08; //机箱门被打开
    private SimpleIntegerProperty Event09; //读声级计出错
    private SimpleIntegerProperty Event10; //存储器出错
    private SimpleIntegerProperty Event11; //USB口出错
    private SimpleIntegerProperty Event12; //电池电压不足
    private SimpleIntegerProperty Event13; //声校准
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
    private SimpleIntegerProperty HasOct; //是否有频谱授权
    private SimpleIntegerProperty HasAll; //是否有积分授权
    private SimpleIntegerProperty HasRecord; //是否有记录功能
    private SimpleIntegerProperty HasSoundtrans; //实时语音授权
    private SimpleIntegerProperty Record_On_Off; //录音启动终止
    private StringProperty version_Hardware; //硬件版本
    private StringProperty version_Linux; //内核版本
    private StringProperty version_N_VIEW; //界面版本
    private StringProperty version_NoiseMonitor; //采集版本
    private StringProperty version_normal; //协议版本

    @Override
    public String toString() {
        return "InfoNoiseManager{" +
                "NoiseMeasureID=" + NoiseMeasureID +
                ", Sample=" + Sample +
                ", UpSpace=" + UpSpace +
                ", DayOverValue=" + DayOverValue +
                ", NightOverValue=" + NightOverValue +
                ", OverDlay=" + OverDlay +
                ", DayOctValue=" + DayOctValue +
                ", NightOctValue=" + NightOctValue +
                ", OctDlay=" + OctDlay +
                ", IsOct=" + IsOct +
                ", DayRecordValue=" + DayRecordValue +
                ", NightRecordValue=" + NightRecordValue +
                ", RecordDlay=" + RecordDlay +
                ", IsRecord=" + IsRecord +
                ", RecordStartTime=" + RecordStartTime +
                ", RecordEndTime=" + RecordEndTime +
                ", RecordModel=" + RecordModel +
                ", FreWight=" + FreWight +
                ", TimeWight=" + TimeWight +
                ", AdjustTime=" + AdjustTime +
                ", AdjustSpace=" + AdjustSpace +
                ", isAutoAdjust=" + isAutoAdjust +
                ", WeaAutoUp=" + WeaAutoUp +
                ", WeaAutoSave=" + WeaAutoSave +
                ", WeaUpSpace=" + WeaUpSpace +
                ", CarAutoUp=" + CarAutoUp +
                ", CarAutoSave=" + CarAutoSave +
                ", CarUpSpace=" + CarUpSpace +
                ", DustAutoUp=" + DustAutoUp +
                ", DustAutoSave=" + DustAutoSave +
                ", DustUpSpace=" + DustUpSpace +
                ", Event01=" + Event01 +
                ", Event02=" + Event02 +
                ", Event03=" + Event03 +
                ", Event04=" + Event04 +
                ", Event05=" + Event05 +
                ", Event06=" + Event06 +
                ", Event07=" + Event07 +
                ", Event08=" + Event08 +
                ", Event09=" + Event09 +
                ", Event10=" + Event10 +
                ", Event11=" + Event11 +
                ", Event12=" + Event12 +
                ", Event13=" + Event13 +
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
                ", HasOct=" + HasOct +
                ", HasAll=" + HasAll +
                ", HasRecord=" + HasRecord +
                ", HasSoundtrans=" + HasSoundtrans +
                ", Record_On_Off=" + Record_On_Off +
                ", version_Hardware=" + version_Hardware +
                ", version_Linux=" + version_Linux +
                ", version_N_VIEW=" + version_N_VIEW +
                ", version_NoiseMonitor=" + version_NoiseMonitor +
                ", version_normal=" + version_normal +
                '}';
    }

    public String getNoiseMeasureID() {
        return NoiseMeasureID.get();
    }

    public StringProperty noiseMeasureIDProperty() {
        return NoiseMeasureID;
    }

    public void setNoiseMeasureID(String noiseMeasureID) {
        this.NoiseMeasureID = new SimpleStringProperty(noiseMeasureID);
    }

    public int getSample() {
        return Sample.get();
    }

    public SimpleIntegerProperty sampleProperty() {
        return Sample;
    }

    public void setSample(int sample) {
        this.Sample = new SimpleIntegerProperty(sample);
    }

    public int getUpSpace() {
        return UpSpace.get();
    }

    public SimpleIntegerProperty upSpaceProperty() {
        return UpSpace;
    }

    public void setUpSpace(int upSpace) {
        this.UpSpace = new SimpleIntegerProperty(upSpace);
    }

    public double getDayOverValue() {
        return DayOverValue.get();
    }

    public SimpleDoubleProperty dayOverValueProperty() {
        return DayOverValue;
    }

    public void setDayOverValue(double dayOverValue) {
        this.DayOverValue = new SimpleDoubleProperty(dayOverValue);
    }

    public double getNightOverValue() {
        return NightOverValue.get();
    }

    public SimpleDoubleProperty nightOverValueProperty() {
        return NightOverValue;
    }

    public void setNightOverValue(double nightOverValue) {
        this.NightOverValue = new SimpleDoubleProperty(nightOverValue);
    }

    public int getOverDlay() {
        return OverDlay.get();
    }

    public SimpleIntegerProperty overDlayProperty() {
        return OverDlay;
    }

    public void setOverDlay(int overDlay) {
        this.OverDlay = new SimpleIntegerProperty(overDlay);
    }

    public double getDayOctValue() {
        return DayOctValue.get();
    }

    public SimpleDoubleProperty dayOctValueProperty() {
        return DayOctValue;
    }

    public void setDayOctValue(double dayOctValue) {
        this.DayOctValue = new SimpleDoubleProperty(dayOctValue);
    }

    public double getNightOctValue() {
        return NightOctValue.get();
    }

    public SimpleDoubleProperty nightOctValueProperty() {
        return NightOctValue;
    }

    public void setNightOctValue(double nightOctValue) {
        this.NightOctValue = new SimpleDoubleProperty(nightOctValue);
    }

    public int getOctDlay() {
        return OctDlay.get();
    }

    public SimpleIntegerProperty octDlayProperty() {
        return OctDlay;
    }

    public void setOctDlay(int octDlay) {
        this.OctDlay = new SimpleIntegerProperty(octDlay);
    }

    public int getIsOct() {
        return IsOct.get();
    }

    public SimpleIntegerProperty isOctProperty() {
        return IsOct;
    }

    public void setIsOct(int isOct) {
        this.IsOct = new SimpleIntegerProperty(isOct);
    }

    public double getDayRecordValue() {
        return DayRecordValue.get();
    }

    public SimpleDoubleProperty dayRecordValueProperty() {
        return DayRecordValue;
    }

    public void setDayRecordValue(double dayRecordValue) {
        this.DayRecordValue = new SimpleDoubleProperty(dayRecordValue);
    }

    public double getNightRecordValue() {
        return NightRecordValue.get();
    }

    public SimpleDoubleProperty nightRecordValueProperty() {
        return NightRecordValue;
    }

    public void setNightRecordValue(double nightRecordValue) {
        this.NightRecordValue = new SimpleDoubleProperty(nightRecordValue);
    }

    public int getRecordDlay() {
        return RecordDlay.get();
    }

    public SimpleIntegerProperty recordDlayProperty() {
        return RecordDlay;
    }

    public void setRecordDlay(int recordDlay) {
        this.RecordDlay = new SimpleIntegerProperty(recordDlay);
    }

    public int getIsRecord() {
        return IsRecord.get();
    }

    public SimpleIntegerProperty isRecordProperty() {
        return IsRecord;
    }

    public void setIsRecord(int isRecord) {
        this.IsRecord = new SimpleIntegerProperty(isRecord);
    }

    public DatePicker getRecordStartTime() {
        return RecordStartTime;
    }

    public void setRecordStartTime(DatePicker recordStartTime) {
        RecordStartTime = recordStartTime;
    }

    public DatePicker getRecordEndTime() {
        return RecordEndTime;
    }

    public void setRecordEndTime(DatePicker recordEndTime) {
        RecordEndTime = recordEndTime;
    }

    public int getRecordModel() {
        return RecordModel.get();
    }

    public SimpleIntegerProperty recordModelProperty() {
        return RecordModel;
    }

    public void setRecordModel(int recordModel) {
        this.RecordModel = new SimpleIntegerProperty(recordModel);
    }

    public int getFreWight() {
        return FreWight.get();
    }

    public SimpleIntegerProperty freWightProperty() {
        return FreWight;
    }

    public void setFreWight(int freWight) {
        this.FreWight = new SimpleIntegerProperty(freWight);
    }

    public int getTimeWight() {
        return TimeWight.get();
    }

    public SimpleIntegerProperty timeWightProperty() {
        return TimeWight;
    }

    public void setTimeWight(int timeWight) {
        this.TimeWight = new SimpleIntegerProperty(timeWight);
    }

    public DatePicker getAdjustTime() {
        return AdjustTime;
    }

    public void setAdjustTime(DatePicker adjustTime) {
        AdjustTime = adjustTime;
    }

    public int getAdjustSpace() {
        return AdjustSpace.get();
    }

    public SimpleIntegerProperty adjustSpaceProperty() {
        return AdjustSpace;
    }

    public void setAdjustSpace(int adjustSpace) {
        this.AdjustSpace = new SimpleIntegerProperty(adjustSpace);
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
        return WeaAutoUp.get();
    }

    public SimpleIntegerProperty weaAutoUpProperty() {
        return WeaAutoUp;
    }

    public void setWeaAutoUp(int weaAutoUp) {
        this.WeaAutoUp = new SimpleIntegerProperty(weaAutoUp);
    }

    public int getWeaAutoSave() {
        return WeaAutoSave.get();
    }

    public SimpleIntegerProperty weaAutoSaveProperty() {
        return WeaAutoSave;
    }

    public void setWeaAutoSave(int weaAutoSave) {
        this.WeaAutoSave = new SimpleIntegerProperty(weaAutoSave);
    }

    public int getWeaUpSpace() {
        return WeaUpSpace.get();
    }

    public SimpleIntegerProperty weaUpSpaceProperty() {
        return WeaUpSpace;
    }

    public void setWeaUpSpace(int weaUpSpace) {
        this.WeaUpSpace = new SimpleIntegerProperty(weaUpSpace);
    }

    public int getCarAutoUp() {
        return CarAutoUp.get();
    }

    public SimpleIntegerProperty carAutoUpProperty() {
        return CarAutoUp;
    }

    public void setCarAutoUp(int carAutoUp) {
        this.CarAutoUp = new SimpleIntegerProperty(carAutoUp);
    }

    public int getCarAutoSave() {
        return CarAutoSave.get();
    }

    public SimpleIntegerProperty carAutoSaveProperty() {
        return CarAutoSave;
    }

    public void setCarAutoSave(int carAutoSave) {
        this.CarAutoSave = new SimpleIntegerProperty(carAutoSave);
    }

    public int getCarUpSpace() {
        return CarUpSpace.get();
    }

    public SimpleIntegerProperty carUpSpaceProperty() {
        return CarUpSpace;
    }

    public void setCarUpSpace(int carUpSpace) {
        this.CarUpSpace = new SimpleIntegerProperty(carUpSpace);
    }

    public int getDustAutoUp() {
        return DustAutoUp.get();
    }

    public SimpleIntegerProperty dustAutoUpProperty() {
        return DustAutoUp;
    }

    public void setDustAutoUp(int dustAutoUp) {
        this.DustAutoUp = new SimpleIntegerProperty(dustAutoUp);
    }

    public int getDustAutoSave() {
        return DustAutoSave.get();
    }

    public SimpleIntegerProperty dustAutoSaveProperty() {
        return DustAutoSave;
    }

    public void setDustAutoSave(int dustAutoSave) {
        this.DustAutoSave = new SimpleIntegerProperty(dustAutoSave);
    }

    public int getDustUpSpace() {
        return DustUpSpace.get();
    }

    public SimpleIntegerProperty dustUpSpaceProperty() {
        return DustUpSpace;
    }

    public void setDustUpSpace(int dustUpSpace) {
        this.DustUpSpace = new SimpleIntegerProperty(dustUpSpace);
    }

    public int getEvent01() {
        return Event01.get();
    }

    public SimpleIntegerProperty event01Property() {
        return Event01;
    }

    public void setEvent01(int event01) {
        this.Event01 = new SimpleIntegerProperty(event01);
    }

    public int getEvent02() {
        return Event02.get();
    }

    public SimpleIntegerProperty event02Property() {
        return Event02;
    }

    public void setEvent02(int event02) {
        this.Event02 = new SimpleIntegerProperty(event02);
    }

    public int getEvent03() {
        return Event03.get();
    }

    public SimpleIntegerProperty event03Property() {
        return Event03;
    }

    public void setEvent03(int event03) {
        this.Event03 = new SimpleIntegerProperty(event03);
    }

    public int getEvent04() {
        return Event04.get();
    }

    public SimpleIntegerProperty event04Property() {
        return Event04;
    }

    public void setEvent04(int event04) {
        this.Event04 = new SimpleIntegerProperty(event04);
    }

    public int getEvent05() {
        return Event05.get();
    }

    public SimpleIntegerProperty event05Property() {
        return Event05;
    }

    public void setEvent05(int event05) {
        this.Event05 = new SimpleIntegerProperty(event05);
    }

    public int getEvent06() {
        return Event06.get();
    }

    public SimpleIntegerProperty event06Property() {
        return Event06;
    }

    public void setEvent06(int event06) {
        this.Event06 = new SimpleIntegerProperty(event06);
    }

    public int getEvent07() {
        return Event07.get();
    }

    public SimpleIntegerProperty event07Property() {
        return Event07;
    }

    public void setEvent07(int event07) {
        this.Event07 = new SimpleIntegerProperty(event07);
    }

    public int getEvent08() {
        return Event08.get();
    }

    public SimpleIntegerProperty event08Property() {
        return Event08;
    }

    public void setEvent08(int event08) {
        this.Event08 = new SimpleIntegerProperty(event08);
    }

    public int getEvent09() {
        return Event09.get();
    }

    public SimpleIntegerProperty event09Property() {
        return Event09;
    }

    public void setEvent09(int event09) {
        this.Event09 = new SimpleIntegerProperty(event09);
    }

    public int getEvent10() {
        return Event10.get();
    }

    public SimpleIntegerProperty event10Property() {
        return Event10;
    }

    public void setEvent10(int event10) {
        this.Event10 = new SimpleIntegerProperty(event10);
    }

    public int getEvent11() {
        return Event11.get();
    }

    public SimpleIntegerProperty event11Property() {
        return Event11;
    }

    public void setEvent11(int event11) {
        this.Event11 = new SimpleIntegerProperty(event11);
    }

    public int getEvent12() {
        return Event12.get();
    }

    public SimpleIntegerProperty event12Property() {
        return Event12;
    }

    public void setEvent12(int event12) {
        this.Event12 = new SimpleIntegerProperty(event12);
    }

    public int getEvent13() {
        return Event13.get();
    }

    public SimpleIntegerProperty event13Property() {
        return Event13;
    }

    public void setEvent13(int event13) {
        this.Event13 = new SimpleIntegerProperty(event13);
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

    public int getHasOct() {
        return HasOct.get();
    }

    public SimpleIntegerProperty hasOctProperty() {
        return HasOct;
    }

    public void setHasOct(int hasOct) {
        this.HasOct = new SimpleIntegerProperty(hasOct);
    }

    public int getHasAll() {
        return HasAll.get();
    }

    public SimpleIntegerProperty hasAllProperty() {
        return HasAll;
    }

    public void setHasAll(int hasAll) {
        this.HasAll = new SimpleIntegerProperty(hasAll);
    }

    public int getHasRecord() {
        return HasRecord.get();
    }

    public SimpleIntegerProperty hasRecordProperty() {
        return HasRecord;
    }

    public void setHasRecord(int hasRecord) {
        this.HasRecord = new SimpleIntegerProperty(hasRecord);
    }

    public int getHasSoundtrans() {
        return HasSoundtrans.get();
    }

    public SimpleIntegerProperty hasSoundtransProperty() {
        return HasSoundtrans;
    }

    public void setHasSoundtrans(int hasSoundtrans) {
        this.HasSoundtrans = new SimpleIntegerProperty(hasSoundtrans);
    }

    public int getRecord_On_Off() {
        return Record_On_Off.get();
    }

    public SimpleIntegerProperty record_On_OffProperty() {
        return Record_On_Off;
    }

    public void setRecord_On_Off(int record_On_Off) {
        this.Record_On_Off = new SimpleIntegerProperty(record_On_Off);
    }

    public String getVersion_Hardware() {
        return version_Hardware.get();
    }

    public StringProperty version_HardwareProperty() {
        return version_Hardware;
    }

    public void setVersion_Hardware(String version_Hardware) {
        this.version_Hardware = new SimpleStringProperty(version_Hardware);
    }

    public String getVersion_Linux() {
        return version_Linux.get();
    }

    public StringProperty version_LinuxProperty() {
        return version_Linux;
    }

    public void setVersion_Linux(String version_Linux) {
        this.version_Linux = new SimpleStringProperty(version_Linux);
    }

    public String getVersion_N_VIEW() {
        return version_N_VIEW.get();
    }

    public StringProperty version_N_VIEWProperty() {
        return version_N_VIEW;
    }

    public void setVersion_N_VIEW(String version_N_VIEW) {
        this.version_N_VIEW = new SimpleStringProperty(version_N_VIEW);
    }

    public String getVersion_NoiseMonitor() {
        return version_NoiseMonitor.get();
    }

    public StringProperty version_NoiseMonitorProperty() {
        return version_NoiseMonitor;
    }

    public void setVersion_NoiseMonitor(String version_NoiseMonitor) {
        this.version_NoiseMonitor = new SimpleStringProperty(version_NoiseMonitor);
    }

    public String getVersion_normal() {
        return version_normal.get();
    }

    public StringProperty version_normalProperty() {
        return version_normal;
    }

    public void setVersion_normal(String version_normal) {
        this.version_normal = new SimpleStringProperty(version_normal);
    }

    public InfoNoiseManager(String noiseMeasureID, int sample, int upSpace, double dayOverValue, double nightOverValue, int overDlay, double dayOctValue, double nightOctValue, int octDlay, int isOct, double dayRecordValue, double nightRecordValue, int recordDlay, int isRecord, DatePicker recordStartTime, DatePicker recordEndTime, int recordModel, int freWight, int timeWight, DatePicker adjustTime, int adjustSpace, int isAutoAdjust, int weaAutoUp, int weaAutoSave, int weaUpSpace, int carAutoUp, int carAutoSave, int carUpSpace, int dustAutoUp, int dustAutoSave, int dustUpSpace, int event01, int event02, int event03, int event04, int event05, int event06, int event07, int event08, int event09, int event10, int event11, int event12, int event13, int ON_OFF_LEQZ, int ON_OFF_LEQC, int ON_OFF_LEQA, int ON_OFF_LPFZ, int ON_OFF_LPSZ, int ON_OFF_LPIZ, int ON_OFF_LPFC, int ON_OFF_LPSC, int ON_OFF_LPIC, int ON_OFF_LPFA, int ON_OFF_LPSA, int ON_OFF_LPIA, int ON_OFF_PEAKZ, int ON_OFF_PEAKC, int ON_OFF_PEAKA, int ON_OFF_MIN, int ON_OFF_HOUR, int ON_OFF_DAY, int ON_OFF_UDT, int ON_OFF_13OCT, int ON_OFF_11OCT, int ON_OFF_RADF, int ON_OFF_FAMF, int ON_OFF_PDWIV, int ON_OFF_LEQ1S, int hasOct, int hasAll, int hasRecord, int hasSoundtrans, int record_On_Off, String version_Hardware, String version_Linux, String version_N_VIEW, String version_NoiseMonitor, String version_normal) {
        NoiseMeasureID = new SimpleStringProperty(noiseMeasureID);
        Sample = new SimpleIntegerProperty(sample);
        UpSpace = new SimpleIntegerProperty(upSpace);
        DayOverValue = new SimpleDoubleProperty(dayOverValue);
        NightOverValue = new SimpleDoubleProperty(nightOverValue);
        OverDlay = new SimpleIntegerProperty(overDlay);
        DayOctValue = new SimpleDoubleProperty(dayOctValue);
        NightOctValue = new SimpleDoubleProperty(nightOctValue);
        OctDlay = new SimpleIntegerProperty(octDlay);
        IsOct = new SimpleIntegerProperty(isOct);
        DayRecordValue = new SimpleDoubleProperty(dayRecordValue);
        NightRecordValue = new SimpleDoubleProperty(nightRecordValue);
        RecordDlay = new SimpleIntegerProperty(recordDlay);
        IsRecord = new SimpleIntegerProperty(isRecord);
        RecordStartTime =recordStartTime;
        RecordEndTime = recordEndTime;
        RecordModel = new SimpleIntegerProperty(recordModel);
        FreWight = new SimpleIntegerProperty(freWight);
        TimeWight = new SimpleIntegerProperty(timeWight);
        AdjustTime = adjustTime;
        AdjustSpace = new SimpleIntegerProperty(adjustSpace);
        this.isAutoAdjust = new SimpleIntegerProperty(isAutoAdjust);
        WeaAutoUp = new SimpleIntegerProperty(weaAutoUp);
        WeaAutoSave = new SimpleIntegerProperty(weaAutoSave);
        WeaUpSpace = new SimpleIntegerProperty(weaUpSpace);
        CarAutoUp = new SimpleIntegerProperty(carAutoUp);
        CarAutoSave = new SimpleIntegerProperty(carAutoSave);
        CarUpSpace = new SimpleIntegerProperty(carUpSpace);
        DustAutoUp = new SimpleIntegerProperty(dustAutoUp);
        DustAutoSave = new SimpleIntegerProperty(dustAutoSave);
        DustUpSpace = new SimpleIntegerProperty(dustUpSpace);
        Event01 = new SimpleIntegerProperty(event01);
        Event02 = new SimpleIntegerProperty(event02);
        Event03 = new SimpleIntegerProperty(event03);
        Event04 = new SimpleIntegerProperty(event04);
        Event05 = new SimpleIntegerProperty(event05);
        Event06 = new SimpleIntegerProperty(event06);
        Event07 = new SimpleIntegerProperty(event07);
        Event08 = new SimpleIntegerProperty(event08);
        Event09 = new SimpleIntegerProperty(event09);
        Event10 = new SimpleIntegerProperty(event10);
        Event11 = new SimpleIntegerProperty(event11);
        Event12 = new SimpleIntegerProperty(event12);
        Event13 = new SimpleIntegerProperty(event13);
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
        this.HasOct = new SimpleIntegerProperty(hasOct);
        this.HasAll = new SimpleIntegerProperty(hasAll);
        this.HasRecord = new SimpleIntegerProperty(hasRecord);
        this.HasSoundtrans = new SimpleIntegerProperty(hasSoundtrans);
        this.Record_On_Off = new SimpleIntegerProperty(record_On_Off);
        this.version_Hardware = new SimpleStringProperty(version_Hardware);
        this.version_Linux = new SimpleStringProperty(version_Linux);
        this.version_N_VIEW = new SimpleStringProperty(version_N_VIEW);
        this.version_NoiseMonitor = new SimpleStringProperty(version_NoiseMonitor);
        this.version_normal = new SimpleStringProperty(version_normal);
    }

    public InfoNoiseManager() {
    }
}
