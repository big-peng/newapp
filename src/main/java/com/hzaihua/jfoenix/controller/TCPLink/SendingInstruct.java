package com.hzaihua.jfoenix.controller.TCPLink;

import com.hzaihua.jfoenix.controller.Device.AddFixedDeviceController;
import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.controller.measure.AddFixedMeasureController;
import com.hzaihua.jfoenix.controller.measure.ReadNotesController;
import com.hzaihua.jfoenix.controller.noiseDevice.NoiseDeviceManageController;
import com.hzaihua.jfoenix.service.InfoNoiseManagerService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SendingInstruct{


    StringBuffer sub = new StringBuffer();
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    SimpleDateFormat simdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String instruct = null;
    public static int temp = 1;
    public static int info = 1;
    public static String device;
    public static int dataType = 0;

    public SendingInstruct() {}

    /**
     *  提取仪器编号（通用指令）
     * */
    public String instruct000(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[000000]</Pwd>");
        sub.append("<Class>[N000]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置超标报警上限
     * */
    public String instruct105(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N105]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[DayStdValue,NightStdValue,OnTime]</Name>");
        sub.append("<Unit>[ dB,dB,s]</Unit>");
        sub.append("<Value>["+ NoiseDeviceManageController.infoNoiseManager.getDayOverValue()+","+NoiseDeviceManageController.infoNoiseManager.getNightOverValue()+","+NoiseDeviceManageController.infoNoiseManager.getOverDlay()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取超标报警上限
     * */
    public String instruct106(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N106]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置实时采样数据上报间隔
     * */
    public String instruct107(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N107]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[RtdInterval]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getSample()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取实时采样数据上报间隔
     * */
    public String instruct108(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N108]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取现场机系统时间
     * */
    public String instruct110(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N110]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置现场机系统时间
     * */
    public String instruct111(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N111]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[SystemTime]</Name>");
        sub.append("<Value>["+simdf.format(date)+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置现场机访问密码
     * */
    public String instruct112(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N112]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[PW]</Name>");
        sub.append("<Value>["+ AddFixedMeasureController.infoNoiseDevice.getDevicePassword()+"]</Value>"); //设置密码。应该是设备的密码
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取积分时间
     * */
    public String instruct113(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N113]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置积分时间
     * */
    public String instruct114(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N114]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[initTime]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getInitime()+"]</Value>"); //和数据库中的列名存在差异
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取下端监测设备自动校零校满(电校准)时间和间隔
     * */
    public String instruct115(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N115]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置下端监测设备自动校零校满(电校准)时间和间隔
     * */
    public String instruct116(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N116]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[DateTime,AdjInterval,Enable]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getAdjustTime()+","+NoiseDeviceManageController.infoNoiseManager.getAdjustSpace()+","+NoiseDeviceManageController.infoNoiseManager.getIsAutoAdjust()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取备注
     * */
    public String instruct117(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N117]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置备注
     * */
    public String instruct118(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N118]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[Remark]</Name>");
        sub.append("<Value>["+ AddFixedMeasureController.infoMeasure.getRemark()+"]</Value>"); //测点的备注
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取事件保存和上传允许参数
     * */
    public String instruct119(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N119]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置事件保存和上传允许参数
     * */
    public String instruct120(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N120]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[Event_01,Event_02,Event_03,Event_04,Event_05,Event_06,Event_07,Event_08,Event_09,Event_10,Event_11,Event_12,Event_13]</Name>"); //事件说明1-13
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getEvent_01()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_02()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_03()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_04()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_05()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_06()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_07()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_08()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_09()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_10()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_11()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_12()+","
                +NoiseDeviceManageController.infoNoiseManager.getEvent_13()+","
                +"]</Value>"); //是否允许自动上传 0表示不也许上传和保存允许，1为只允许保存，2为只允许上传，3为允许上传和保存。
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取计权参数(需总值授权)
     * */
    public String instruct121(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N121]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *设置计权参数(需总值授权)
     * */
    public String instruct122(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N122]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[F_Weighting,T_Weighting]</Name>"); //和数据库中列名不一致
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getFreWight()+","+NoiseDeviceManageController.infoNoiseManager.getTimeWight()+"]</Value>"); //计权值
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *提取实时采样数据采样间隔
     * */
    public String instruct123(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N123]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }
    /**
     * 设置实时采样数据采样间隔
     * */
    public String instruct124(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N124]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[CollectionCyc]</Name>"); //和数据库中列名不一致
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getSample()+"]</Value>"); //采样间隔值
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    /**
     * 提取录音参数(需录音授权)
     * */
    public String instruct125(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N125]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }
    /**
     *设置录音参数(需录音授权)
     * */
    public String instruct126(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N126]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[RecorderOverDay,RecorderOverNight,RecorderOnTime,Enrecorder]</Name>"); //和数据库中列名不一致
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getDayRecordValue()+","+NoiseDeviceManageController.infoNoiseManager.getNightRecordValue()+","+NoiseDeviceManageController.infoNoiseManager.getRecordDlay()+","+NoiseDeviceManageController.infoNoiseManager.getIsRecord()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 删除文件
     *
     * */
    public String instruct127(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N127]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime,DataType]</Name>");
        sub.append("<Value>["+"]</Value>"); //未做设置.开始时间，结束时间
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取录音文件自动上传参数(需录音授权)
     * */
    public String instruct128(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N128]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }
    /**
     * 设置录音文件自动上传参数(需录音授权)
     * */
    public String instruct129(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N129]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime,Auto_Up]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getRecordStartTime()+","+NoiseDeviceManageController.infoNoiseManager.getRecordEndTime()+","+NoiseDeviceManageController.infoNoiseManager.getRecordModel()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *提取OCT参数(需频谱授权)
     */
    public String instruct201(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N201]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置OCT参数(需频谱授权)
     * */
    public String instruct202(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N202]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[octOverDay,octOverNight,octOnTime,EnOct]</Name>");
        sub.append("<Value>["+"]</Value>"); //参数未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取其他开关量参数
     * */
    public String instruct203(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N203]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }
    /**
     * 设置其他开关量参数
     * */
    public String instruct204(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N204]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[LEQZ,LEQC,LEQA,LPFZ,LPSZ,LPIZ,LPFC,LPSC,LPIC,LPFA,LPSA,LPIA,PEAKZ,PEAKC,PEAKA,HOUR,DAY,UDT,RADF,FAMF,PDWIV,LEQ1S,1/3OCT,1/1OCT]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQZ()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQC()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQA()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPFZ()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPSZ()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPIZ()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPFC()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPSC()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPIC()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPFA()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPSA()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPIA()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PEAKZ()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PEAKC()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PEAKA()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_HOUR()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_DAY()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_UDT()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_RADF()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_FAMF()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PDWIV()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQ1S()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_13OCT()+",");
        sub.append(NoiseDeviceManageController.infoNoiseManager.getON_OFF_11OCT()+",");
        sub.append("]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *提取气象参数
     * */
    public String instruct205(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N205]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置气象参数
     * */
    public String instruct206(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N206]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[enUp,enSave,cycle]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getWeaAutoUp()+","+NoiseDeviceManageController.infoNoiseManager.getWeaAutoSave()+","+NoiseDeviceManageController.infoNoiseManager.getWeaUpSpace()+"]</Value>"); //参数未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取车流量参数
     * */
    public String instruct207(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N207]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置车流量参数
     * */
    public String instruct208(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N208]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[enUp,enSave,cycle]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getCarAutoUp()+","+NoiseDeviceManageController.infoNoiseManager.getCarAutoSave()+","+NoiseDeviceManageController.infoNoiseManager.getCarUpSpace()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取粉尘参数
     * */
    public String instruc209(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N209]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置粉尘参数
     * */
    public String instruct210(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N210]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[enUp,enSave,cycle]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.infoNoiseManager.getDustAutoUp()+","+NoiseDeviceManageController.infoNoiseManager.getDustAutoSave()+","+NoiseDeviceManageController.infoNoiseManager.getDustUpSpace()+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取测点名称
     * */
    public String instruct211(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N211]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置测点名称
     * */
    public String instruct212(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N212]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[MeasureName]</Name>");
        sub.append("<Value>["+"]</Value>"); //测点数据，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *提取历史事件记录
     */
    public String instruct102(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N102]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime,DataType]</Name>");
        sub.append("<Value>["+"]</Value>"); //事件参数，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct102Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N102]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>"); //操作结果
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取实时事件列表
     * */
    public String instruct103(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N103]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 污染物分钟数据（读一段时间内的统计数据）
     * */
    public String instruct130(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N130]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime,DataType]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+","+dataType+"]</Value>"); //事件参数，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct130Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N130]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>"); //操作结果
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取瞬时声级记录（一秒一个采样数据）
     * */
    public String instruct131(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N131]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+"]</Value>"); //
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct131Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N131]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>"); //操作结果
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取OCT记录(频谱授权)
     * @暂时不管
     * */
    public String instruct132(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N132]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime,DataType]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+","+dataType+"]</Value>"); //事件参数，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct132Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N132]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>"); //操作结果
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取每秒的Leq历史数据
     * */
    public String instruct133(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N133]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct133Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N133]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 读气象历史数据
     * */
    public String instruct134(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N134]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct134Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N134]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *读车流量历史数据
     * */
    public String instruct135(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N135]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct135Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N135]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 读粉尘历史数据
     * */
    public String instruct136(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N136]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct136Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N136]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }
    /**
     *读气象统计历史数据
     */
    public String instruct137(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N137]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[BeginTime,EndTime]</Name>");
        sub.append("<Value>["+simdf.format(MainController.oldTime)+","+simdf.format(new Date())+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
    public String instruct137Next(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N137]</Class>");
        sub.append("<Rtn>["+temp+"]</Rtn>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设备操作命令
     * */
    public String instruct104(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N104]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Value>["+"]</Value>"); //操作标记，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 即时采样命令(心跳指令)
     * @特殊设置，每4分钟发送一次
     * */
    public String instruct140(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[000000]</Pwd>");
        sub.append("<Class>[N140]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设备状态读取
     * */
    public String instruct141(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[000000]</Pwd>");
        sub.append("<Class>[N141]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo></Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 数据传输指令（上传下）
     * */
    public String instruct142(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N142]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Value>["+"]</Value>"); //传送数据内容，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *录音启动和终止指令
     */
    public String instruct143(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N143]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Value>["+info+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     *录像启动和终止指令
     */
    public String instruct144(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N144]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Value>["+info+"]</Value>");
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 拍照指令
     * */
    public String instruct145(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N145]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 显示屏控制
     * */
    public String instruct146(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N146]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[DeviceType,Data]</Name>");
        sub.append("<Value>["+"]</Value>"); //显示器选择，节目内容设置 未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 显示屏节目回读
     * */
    public String instruct148(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N148]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 灵敏度读取
     * */
    public String instruct147(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N147]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 数据传输指令（下传上）
     * */
    public String instruct042(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N042]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Value>["+"]</Value>"); //传送数据内容，未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取服务器参数
     * */
    public String instruct150(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N150]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置服务器参数
     * */
    public String instruct151(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N151]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[IP,Port]</Name>");
        sub.append("<Value>["+"]</Value>"); //服务器参数 未设置，应该是编辑设备时发送
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取网卡参数
     * */
    public String instruct152(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N152]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置网卡参数
     * */
    public String instruct153(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N153]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[IPADDR,NETMASK,GATEWAY,DNS]</Name>");
        sub.append("<Value>["+"]</Value>"); //网卡参数 未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 提取授权参数
     * */
    public String instruct160(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N160]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 设置授权参数
     * */
    public String instruct161(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N161]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Value>["+"]</Value>"); //授权码 未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 升级文件传输请求
     * */
    public String instruct170(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N170]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>["+NoiseDeviceManageController.fileName+"]</Name>"); //文件名称，需要设置
        sub.append("<Value>["+NoiseDeviceManageController.FileSize+"]</Value>"); //文件大小，通过文件名称计算 未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 升级文件分块传输请求
     * */
    public String instruct171(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N171]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[FileName,Offset,Size,Data]</Name>"); //文件名称、传输起始位置、传输长度、传输的数据，需要设置
        sub.append("<Value>["+NoiseDeviceManageController.fileName+","+NoiseDeviceManageController.FileSize+","+0+","+NoiseDeviceManageController.fileData+"]</Value>"); //文件大小，通过文件名称计算 未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 检查升级文件传输完成情况
     * */
    public String instruct172(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N172]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 取消升级文件的传输
     * */
    public String instruct173(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N173]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 读取当前版本
     * */
    public String instruct174(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N174]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 确定开始升级程序
     * */
    public String instruct175(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N175]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 删除前端升级的程序文件
     * */
    public String instruct176(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N176]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 语音连接请求指令(实时语音授权)
     * */
    public String instruct177(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N177]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[Port]</Name>");
        sub.append("<Value>["+"]</Value>"); //应该是设备的监听端口
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 读取仪器当前通信协议版本
     * */
    public String instruct178(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N178]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 读取目录中的文件信息
     * */
    public String instruct180(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N180]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[Folder]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.filePath+"]</Value>"); //@“/”为根目录(/mnt/)，下级目录表示符为“/”
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }

    /**
     * 读取文件
     * */
    public String instruct181(){
        sub.append("<Package><LtdInfo>");
        sub.append("<Code>["+device+"]</Code>");
        sub.append("<Pwd>[123456]</Pwd>");
        sub.append("<Class>[N181]</Class>");
        sub.append("<Flag>["+sdf.format(date)+"]</Flag>");
        sub.append("</LtdInfo>");
        sub.append("<Data>");
        sub.append("<Name>[FileName]</Name>");
        sub.append("<Value>["+NoiseDeviceManageController.filePath+"/"+NoiseDeviceManageController.noiseFile.getFileName()+"]</Value>"); //文件目录和名称 需要设置 未设置
        sub.append("</Data>");
        sub.append("</Package>");
        instruct = sub.toString();
        return instruct;
    }
}
