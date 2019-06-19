package com.hzaihua.jfoenix.controller.noiseDevice;

import com.hzaihua.jfoenix.controller.TCPLink.SendingInstruct;
import com.hzaihua.jfoenix.controller.TCPLink.SendingThread;
import com.hzaihua.jfoenix.controller.measure.AddFixedMeasureController;
import com.hzaihua.jfoenix.entity.EventCode;
import com.hzaihua.jfoenix.entity.InfoNoiseManager;
import com.hzaihua.jfoenix.entity.Instructions;
import com.hzaihua.jfoenix.entity.StateNoise;
import com.hzaihua.jfoenix.service.EventCodeService;
import com.hzaihua.jfoenix.service.InfoNoiseManagerService;
import com.hzaihua.jfoenix.service.InstructionsService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTimePicker;
import io.datafx.controller.ViewController;
import javafx.animation.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ViewController(value = "/views/fxml/noiseDevice/noiseDeviceAfter.fxml")
public class NoiseDeviceManageController {
    //设置页面设置
    @FXML private TextField Sample; //瞬时采样间隔
    @FXML private TextField UpSpace; //瞬时上传间隔
    @FXML private ComboBox<String> TimeWight; //时间计权
    @FXML private ComboBox<String> FreWight; //频率计权
    @FXML private TextField Initime; //积分统计时间
    @FXML private CheckBox ON_OFF_UDT; //分钟统计数据自动上传
    @FXML private CheckBox ON_OFF_HOUR; //小时统计数据自动上传
    @FXML private CheckBox ON_OFF_DAY; //天统计数据自动上传
    @FXML private CheckBox IsExceed; //是否噪声超标报警
    @FXML private TextField DayOverValue; //噪声报警昼间超标限值
    @FXML private TextField NightOverValue; //噪声报警夜间超标限值
    @FXML private TextField OverDlay; //噪声报警延迟启动时间
    @FXML private CheckBox IsOct; //噪声超标频谱分析
    @FXML private TextField DayOctValue; //噪声超标频谱分析昼间超标限值
    @FXML private TextField NightOctValue; //噪声超标频谱分析夜间超标限值
    @FXML private TextField OctDlay; //噪声超标频谱分析延迟启动时间
    @FXML private CheckBox ON_OFF_11OCT; // 1/1OCT频谱分析数据自动上传
    @FXML private CheckBox ON_OFF_13OCT; // 1/3OCT频谱分析数据自动上传
    @FXML private CheckBox IsRecord; //噪声超标录音
    @FXML private TextField DayRecordValue; //噪声超标录音昼间超标限值
    @FXML private TextField NightRecordValue; //噪声超标录音夜间超标限值
    @FXML private TextField RecordDlay; //噪声超标录音延迟启动时间
    @FXML private ComboBox<String> RecordModel; //噪声超标录音上传模式
    @FXML private DatePicker RecordStartTime; //噪声超标录音优先上传始时 日期
    @FXML private JFXTimePicker StartTime; //噪声超标录音优先上传始时 时间
    @FXML private DatePicker RecordEndTime; //噪声超标录音优先上传终时 日期
    @FXML private JFXTimePicker EndTime; //噪声超标录音优先上传终时 时间
    @FXML private CheckBox isAutoAdjust; //自动校准
    @FXML private DatePicker AdjustTime; //校准起始日期
    @FXML private JFXTimePicker ajTime; //校准起始时间
    @FXML private ComboBox<String>  AdjustSpace; //每日校准间隔
    @FXML private CheckBox WeaAutoSave; //气象数据自动保存
    @FXML private CheckBox WeaAutoUp; //气象数据自动上传
    @FXML private TextField WeaUpSpace; //气象数据采样间隔
    @FXML private CheckBox CarAutoSave; //交通数据自动保存
    @FXML private CheckBox CarAutoUp; //交通数据自动上传
    @FXML private TextField CarUpSpace; //交通采样间隔
    @FXML private CheckBox DustAutoSave; //空气数据自动保存
    @FXML private CheckBox DustAutoUp; //空气数据自动上传
    @FXML private TextField DustUpSpace; //空气采样间隔
    @FXML private CheckBox ON_OFF_LEQA; //LeqA1s
    @FXML private CheckBox ON_OFF_LPFA; //LPFA
    @FXML private CheckBox ON_OFF_LPSA; //LPSA
    @FXML private CheckBox ON_OFF_LPIA; //LPIA
    @FXML private CheckBox ON_OFF_LEQC; //LeqC1s
    @FXML private CheckBox ON_OFF_LPFC; //LPFC
    @FXML private CheckBox ON_OFF_LPSC; //LPSC
    @FXML private CheckBox ON_OFF_LPIC; //LPIC
    @FXML private CheckBox ON_OFF_LEQZ; //LeqZ1s
    @FXML private CheckBox ON_OFF_LPFZ; //LPFZ
    @FXML private CheckBox ON_OFF_LPSZ; //LPSZ
    @FXML private CheckBox ON_OFF_LPIZ; //LPIZ
    @FXML private CheckBox Event_13; //声校准
    @FXML private CheckBox Event_01; //手动控制电校准
    @FXML private CheckBox Event_02; //自动电校准
    @FXML private CheckBox Event_03; //加热
    @FXML private CheckBox Event_04; //噪声超标
    @FXML private CheckBox Event_07; //停电
    @FXML private CheckBox Event_08; //机箱门被打开
    @FXML private CheckBox Event_09; //噪声数据出错
    @FXML private CheckBox Event_10; //存储器出错
    @FXML private CheckBox Event_12; //电池电压不足
    @FXML private CheckBox ON_OFF_RADF; //设备出错时复位
    @FXML private CheckBox ON_OFF_FAMF; //存储器出错自动修复失败时格式化
    @FXML private CheckBox ON_OFF_PDWIV; //低电压时数据存储保护

    /**
     * 状态界面设置
     * */
    @FXML private Label LinkState; //连接状态
    @FXML private Label NowDateTime; //噪声瞬时时间
    @FXML private Label LpTime; //噪声瞬时声级
    @FXML private Label UsedRoom; //存储器总容量
    @FXML private Label FreeRoom; //存储可用容量
    @FXML private Label BatteryVoltage; //后备电池电压
    @FXML private Label WorkingVoltage; //工作电压
    @FXML private Label NetworkState; //蜂窝信号强度
    @FXML private Label SIMICCID; //SIM卡ICCID
    @FXML private Label SIMIMSI; //SIM卡IMSI
    @FXML private Label OutTemperature; //空气温度
    @FXML private Label Humi_R; //空气湿度
    @FXML private Label AriPressure; //大气压强
    @FXML private Label WindSpeed; //风速
    @FXML private Label W_Direction; //风向
    @FXML private Label Rainfall; //雨量强度
    @FXML private Label PerFlux; //平均车流量
    @FXML private Label AvgSpeed; //平均车速
    @FXML private Label PM25; //空气PM2.5
    @FXML private Label PM10; //空气PM10

    //当时事件
    @FXML private TableView<EventCode> newTimeEvent; //当时事件记录
    @FXML private TableColumn nowEvent; //当时事件发生时间
    @FXML private TableColumn NowEventDescribe; //当时事件描述
    //历史事件
    @FXML private TableView<EventCode> eventListTableView; //历史事件记录
    @FXML private TableColumn EventStartTime; //历史事件开始时间
    @FXML private TableColumn EventEndTime; //历史事件结束时间
    @FXML private TableColumn EventDescribe; //历史事件描述
    public ObservableList<EventCode> events = FXCollections.observableArrayList();
    public static ObservableList<EventCode> eventList = FXCollections.observableArrayList();

    //授权信息
    @FXML private JFXButton changeAuthorize; //更改授权
    @FXML private CheckBox HasAll; //总值分析授权
    @FXML private CheckBox HasOct; //频谱分析授权
    @FXML private CheckBox HasRecord; //超标录音授权
    @FXML private CheckBox HasSoundtrans; //实时语音授权
    //内核、引擎
    @FXML private Label version_Hardware; //硬件版本
    @FXML private Label version_Linux; //内核版本
    @FXML private Label version_N_VIEW; //界面版本
    @FXML private Label version_NoiseMonitor; //采集版本
    //远程升级按钮
    @FXML private JFXButton sendFile; //文件传输
    @FXML private JFXButton otherSendFile; //分块文件传输
    @FXML private JFXButton checkUp; //检查传输
    @FXML private JFXButton cancelSend; //取消传输
    @FXML private JFXButton commitUpgrade; //远程升级

    /**
     * 文件操作界面
     * */
    @FXML private TableView<NoiseFile> noiseFileTableView; //文件列表
    @FXML private TableColumn noiseFileName; //文件名称
    @FXML private TableColumn noiseFileSize; //文件大小
    @FXML private TableColumn noiseFileCreateTime; //文件创建时间
    @FXML private JFXButton readFile; //读取文件按钮
    @FXML private TextField fileText; //文件目录
    @FXML private JFXButton returnBefore; //返回按钮操作
    @FXML private JFXButton readOneFile; //查看某个文件
    public static ObservableList<NoiseFile> fileList = FXCollections.observableArrayList();

    /**
     * 操作界面
     * */
    @FXML private JFXButton restoration; //复位按钮
    @FXML private JFXButton align; //校准按钮
    @FXML private JFXButton heating; //加热按钮
    @FXML private JFXButton sound; //录音开始按钮
    @FXML private JFXButton video; //录像开始按钮
    @FXML private JFXButton endSound; //录音结束按钮
    @FXML private JFXButton endVideo; //录像结束按钮
    @FXML private ProgressBar soundBar; //录音进度条
    @FXML private ProgressBar videoBar; //录像进度条
    @FXML private JFXButton photo; //拍照按钮
    @FXML public static ImageView makePhoto; //仪器传回来的照片
    /**
     * 节目界面设置
     * */
    @FXML private AnchorPane editPara;
    @FXML private JFXListView<Label> sideList;
    @FXML private JFXButton textButton;
    @FXML private JFXButton subTitleButton;
    @FXML private JFXButton timeButton;
    @FXML private JFXButton noiseButton;
    @FXML private JFXButton deleteButton;
    @FXML private AnchorPane previewWindow;

    @FXML private Text actiontarget;//输入错误提示框
    @FXML private JFXButton commitManager; //前端管理确定按钮
    @FXML private JFXButton commitSample; //修改瞬时采样间隔
    @FXML private JFXButton commitUpSpace; //修改瞬时长传间隔
    @FXML private JFXButton commitTF; // 修改时间、频率计权
    @FXML private JFXButton commitInitTime; //修改积分统计时间
    @FXML private JFXButton commitExceed; //修改噪声超标报警设置
    @FXML private JFXButton commitIsOct; //噪声超标频谱分析
    @FXML private JFXButton commitRecord; //修改超标录音
    @FXML private JFXButton commitStartTimeAndEndTime; //优先上传始时和终时设置
    @FXML private JFXButton commitAdjust; //自动校准
    @FXML private JFXButton commitWea; //气象设置
    @FXML private JFXButton commitCar; //车流量设置
    @FXML private JFXButton commitDust; //空气设置
    @FXML private JFXButton commitOpen; //各种开关量设置
    @FXML private JFXButton commitEvent; //事件上传开关设置


    //被选中的节目名
    private String selectedProgramName;
    private int y = 0;
    private ObservableList<Label> programList = FXCollections.observableArrayList();
    private Map<String, BasicPara> programParaMap = new HashMap<String, BasicPara>();

    InfoNoiseManagerService infoNoiseManagerService  = BeanFactoryUtil.getApplicationContext().getBean(InfoNoiseManagerService.class);
    public static InfoNoiseManager infoNoiseManager = new InfoNoiseManager();
    EventCodeService eventCodeService = BeanFactoryUtil.getApplicationContext().getBean(EventCodeService.class);
    InstructionsService instructionsService = BeanFactoryUtil.getApplicationContext().getBean(InstructionsService.class);
    Date startDate = null; //噪声优先上传始时
    Date endDate = null; //噪声优先上传终时
    Date adjust = null; //校准时间
    InfoNoiseManager infoNoiseManager1 = infoNoiseManagerService.queryByNoiseCode("100000");
    Instructions instructions = new Instructions();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    Runnable runnable;
    Date date;
    public static StateNoise stateNoise = new StateNoise();
    public static String fileName; //升级文件名
    public static Long FileSize; //升级文件大小
    public static byte[] fileData; //升级文件内容
    public static NoiseFile noiseFile = new NoiseFile(); //全部文件
    public static StringBuffer filePath = new StringBuffer();
    public static OneNoiseFile oneNoiseFile = new OneNoiseFile(); //查看单个文件信息

    @PostConstruct
    public void init() {
        //历史事件列表
        oldEventList();
        //授权信息
        authorize();
        //内核、引擎显示
        hardWareGrid();
        //节目设置
        program();
        //状态设置
        status();
        //读取仪器发送的参数
        accept();
        //录音和录像
        soundAndVideo();
        //读取文件
        allFile();

        //拍照按钮操作
        photo.setOnAction(event -> {
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct145();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });

        //发送设置瞬时采样间隔指令
        commitSample.setOnAction(event -> {
            infoNoiseManager.setSample(Double.valueOf(Sample.getText()));
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingThread.instruct = sendingInstruct.instruct124();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
            instructions.setInstructFlag(UUID.randomUUID().toString().replace("-",""));
            instructions.setInstructType("6218j");
            instructions.setInstructClass("N124");
            instructions.setUserName("admin");
            instructions.setNoiseCode(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
            instructions.setInstructInput(SendingThread.instruct);
            instructions.setInstructRet(SendingThread.rtn);
            instructions.setInstructResult("");
            instructions.setCreateTime(new Date());
            instructions.setOutDieTime(40);
            instructionsService.saveInstructions(instructions);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct124();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //发送设置瞬时上传间隔指令
        commitUpSpace.setOnAction(event -> {
            infoNoiseManager.setUpSpace(Integer.valueOf(UpSpace.getText()));
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct107();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1){
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct107();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //发送设置时间、频率计权指令
        commitTF.setOnAction(event -> {
            infoNoiseManager.setFreWight(FreWight.getValue());
            infoNoiseManager.setTimeWight(TimeWight.getValue());
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct122();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct122();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };


        //修改积分统计时间时发送指令
        commitInitTime.setOnAction(event -> {
            infoNoiseManager.setInitime(Integer.valueOf(Initime.getText()));
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingThread.instruct = sendingInstruct.instruct114();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct114();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //修改噪声超标报警时发送指令
        commitExceed.setOnAction(event -> {
            infoNoiseManager.setDayOverValue(Double.valueOf(DayOverValue.getText()));
            infoNoiseManager.setNightRecordValue(Double.valueOf(NightOverValue.getText()));
            infoNoiseManager.setOverDlay(Integer.valueOf(OverDlay.getText()));
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct105();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct105();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //噪声超标频谱分析
        commitIsOct.setOnAction(event -> {
            infoNoiseManager.setDayOctValue(Double.valueOf(DayOctValue.getText()));
            infoNoiseManager.setNightOctValue(Double.valueOf(NightOctValue.getText()));
            infoNoiseManager.setOctDlay(Integer.valueOf(OctDlay.getText()));
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct202();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct202();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //噪声超标录音
        commitRecord.setOnAction(event -> {
            infoNoiseManager.setDayRecordValue(Double.valueOf(DayRecordValue.getText()));
            infoNoiseManager.setNightRecordValue(Double.valueOf(NightRecordValue.getText()));
            infoNoiseManager.setRecordDlay(Integer.valueOf(RecordDlay.getText()));
            infoNoiseManager.setIsRecord(IsRecord.isSelected()?0:1);
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct126();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct126();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //噪声超标录音始时终时录音
        commitStartTimeAndEndTime.setOnAction(event -> {
            infoNoiseManager.setRecordStartTime(startDate);
            infoNoiseManager.setRecordEndTime(endDate);
            infoNoiseManager.setIsRecord(IsRecord.isSelected()?0:1);
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct129();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct129();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //自动校准
        commitAdjust.setOnAction(event -> {
            infoNoiseManager.setAdjustTime(adjust);
            infoNoiseManager.setAdjustSpace(Integer.valueOf(AdjustSpace.getValue()));
            infoNoiseManager.setIsAutoAdjust(isAutoAdjust.isSelected()?0:1);
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct116();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct116();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //设置气象属性之后发送指令
        commitWea.setOnAction(event -> {
            infoNoiseManager.setWeaAutoSave(WeaAutoSave.isSelected()?0:1);
            infoNoiseManager.setWeaAutoUp(WeaAutoUp.isSelected()?0:1);
            infoNoiseManager.setWeaUpSpace(Integer.valueOf(WeaUpSpace.getText()));
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct206();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct206();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //车流量设置之后发送指令
        commitCar.setOnAction(event -> {
            infoNoiseManager.setCarAutoSave(CarAutoSave.isSelected()?0:1);
            infoNoiseManager.setCarAutoUp(CarAutoUp.isSelected()?0:1);
            infoNoiseManager.setCarUpSpace(Integer.valueOf(CarUpSpace.getText()));
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct208();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct208();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //空气设置之后发送指令
        commitDust.setOnAction(event -> {
            infoNoiseManager.setDustAutoSave(DustAutoSave.isSelected()?0:1);
            infoNoiseManager.setDustAutoUp(DustAutoUp.isSelected()?0:1);
            infoNoiseManager.setDustUpSpace(Integer.valueOf(DustUpSpace.getText()));
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct210();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct210();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //设置开关量之后发送的指令
        commitOpen.setOnAction(event -> {
            infoNoiseManager.setON_OFF_LEQZ(ON_OFF_LEQZ.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LEQC(ON_OFF_LEQC.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LEQA(ON_OFF_LEQA.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPFZ(ON_OFF_LPFZ.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPSZ(ON_OFF_LPSZ.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPIZ(ON_OFF_LPIZ.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPFC(ON_OFF_LPFC.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPSC(ON_OFF_LPSC.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPIC(ON_OFF_LPIC.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPFA(ON_OFF_LPFA.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPSA(ON_OFF_LPSA.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LPIA(ON_OFF_LPIA.isSelected()?0:1);
            infoNoiseManager.setON_OFF_PEAKZ(0);
            infoNoiseManager.setON_OFF_PEAKC(0);
            infoNoiseManager.setON_OFF_PEAKA(0);
            infoNoiseManager.setON_OFF_HOUR(ON_OFF_HOUR.isSelected()?0:1);
            infoNoiseManager.setON_OFF_DAY(ON_OFF_DAY.isSelected()?0:1);
            infoNoiseManager.setON_OFF_UDT(ON_OFF_UDT.isSelected()?0:1);
            infoNoiseManager.setON_OFF_RADF(ON_OFF_RADF.isSelected()?0:1);
            infoNoiseManager.setON_OFF_FAMF(ON_OFF_FAMF.isSelected()?0:1);
            infoNoiseManager.setON_OFF_PDWIV(ON_OFF_PDWIV.isSelected()?0:1);
            infoNoiseManager.setON_OFF_LEQ1S(1);
            infoNoiseManager.setON_OFF_13OCT(ON_OFF_13OCT.isSelected()?0:1);
            infoNoiseManager.setON_OFF_11OCT(ON_OFF_11OCT.isSelected()?0:1);
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct204();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct204();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };

        //事件上传设置发送指令
        commitEvent.setOnAction(event -> {
            infoNoiseManager.setEvent_01(Event_01.isSelected()?0:1);
            infoNoiseManager.setEvent_02(Event_02.isSelected()?0:1);
            infoNoiseManager.setEvent_03(Event_03.isSelected()?0:1);
            infoNoiseManager.setEvent_04(Event_04.isSelected()?0:1);
            infoNoiseManager.setEvent_05(1);
            infoNoiseManager.setEvent_06(1);
            infoNoiseManager.setEvent_07(Event_07.isSelected()?0:1);
            infoNoiseManager.setEvent_08(Event_08.isSelected()?0:1);
            infoNoiseManager.setEvent_09(Event_09.isSelected()?0:1);
            infoNoiseManager.setEvent_10(Event_10.isSelected()?0:1);
            infoNoiseManager.setEvent_11(1);
            infoNoiseManager.setEvent_12(Event_12.isSelected()?0:1);
            infoNoiseManager.setEvent_13(Event_13.isSelected()?0:1);
            SendingThread.deviceCode = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct120();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                date = changeDate(instructions.getCreateTime());
                if(SendingThread.rtn == -1) {
                    for (int i = 0; i < 3; i++) {
                        if (SendingThread.rtn == -1) {
                            try {
                                SendingInstruct sendingInstruct1 = new SendingInstruct();
                                SendingThread.instruct = sendingInstruct1.instruct120();
                                SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                                sendingThread1.SendingSock(SendingThread.instruct);
                                sendingThread1.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }else if((new Date()).getTime() > date.getTime()){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        };


        //所有设置完之后，点击此按钮存入数据库，关闭窗口
        commitManager.setOnAction(event -> {
            Stage stage = (Stage)commitManager.getScene().getWindow();
            parameters();
            stage.close();
        });

        //监听发出的指令
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);

    }


    //计算时间
    private Date changeDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,40);
        return calendar.getTime();
    }

    //计算文件大小
    private long getFileSize(String filePath){
        long size = 0;
        FileInputStream fileInputStream = null;
        FileChannel fc = null;
        try {
            File file = new File(filePath);
            if(file.exists() && file.isFile()) {
                fileInputStream = new FileInputStream(file);
                fc = fileInputStream.getChannel();
                size = fc.size();
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    //获取问件内容
    private byte[] getFileData(String fileName){
        File file = new File(fileName);
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024000000];
            int len = 0;
            while (-1 != (len = bis.read(buffer,0,1024000000))){
                bos.write(buffer,0,len);
            }
            fileData = bos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileData;
    }

    /**
     * 设置操作 Start
     * */
    private void parameters(){
        //判断输入的是不是数字的正则表达式
        String reg = "^[0-9]*[1-9][0-9]*$";
        String rege = "^(-?\\d+)(\\.\\d+)?$";
        //基础部分
        String sample = Sample.getText();
        String upSpace = UpSpace.getText();
        String iniTime = Initime.getText();
        //噪声超标报警
        String dayOverValue = DayOverValue.getText();
        String nightOverValue = NightOverValue.getText();
        String overDlay = OverDlay.getText();
        //噪声超标频谱分析
        String dayOctValue = DayOctValue.getText();
        String nightOctValue = NightOctValue.getText();
        String octDlay = OctDlay.getText();
        //噪声超标录音
        String dayRecordValue = DayRecordValue.getText();
        String nightRecordValue = NightRecordValue.getText();
        String recordDlay = RecordDlay.getText();
        String recordModel = RecordModel.getValue();
        //自动校准
        String adjustSpace = AdjustSpace.getValue();
        //气象数据采样间隔
        String weaUpSpace = WeaUpSpace.getText();
        //交通数据采样间隔
        String carUpSpace = CarUpSpace.getText();
        //空气数据采样间隔
        String dustUpSpace = DustUpSpace.getText();

        //判断输入的是不是数字
        if(!(sample.matches(reg)) || !(sample.matches(rege))){
            Sample.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数或小数");
        }
        if(!(upSpace.matches(reg)) || !(upSpace.matches(rege))){
            UpSpace.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数或小数");
        }
        if(!(iniTime.matches(reg))){
            Initime.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(overDlay.matches(reg))){
            OverDlay.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(octDlay.matches(reg))){
            OctDlay.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(recordDlay.matches(reg))){
            RecordDlay.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(adjustSpace.matches(reg))){
            AdjustSpace.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(weaUpSpace.matches(reg))){
            WeaUpSpace.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(carUpSpace.matches(reg))){
            CarUpSpace.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(dustUpSpace.matches(reg))){
            DustUpSpace.setStyle("-fx-background-color: red");
            actiontarget.setText("只能输入正整数");
        }
        if(!(dayOverValue.matches(rege))){
            DayOverValue.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        if(!(nightOverValue.matches(rege))){
            NightOverValue.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        if(!(dayOctValue.matches(rege))){
            DayOctValue.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        if(!(nightOctValue.matches(rege))){
            NightOctValue.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        if(!(dayRecordValue.matches(rege))){
            DayRecordValue.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        if(!(nightRecordValue.matches(rege))){
            NightRecordValue.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        if(!(recordModel.matches(rege))){
            RecordModel.setStyle("-fx-background-color: red");
            actiontarget.setText("输入格式不正确，最多保留两位小数");
        }
        StartTime.set24HourView(true);
        EndTime.set24HourView(true);
        ajTime.set24HourView(true);
        StringBuffer recordStartTime = new StringBuffer();
        recordStartTime.append(RecordStartTime.getValue()).append(" ").append(StartTime.getValue()).append(":00");
        StringBuffer recordEndTime = new StringBuffer();
        recordEndTime.append(RecordEndTime.getValue()).append(" ").append(EndTime.getValue()).append(":00");
        StringBuffer adjTime = new StringBuffer();
        adjTime.append(AdjustTime.getValue()).append(" ").append(ajTime.getValue()).append(":00");
        String recStartTime = recordStartTime.toString();
        String recEndTime = recordEndTime.toString();
        String adjSpace = adjTime.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            startDate= sdf.parse(recStartTime);
            endDate = sdf.parse(recEndTime);
            adjust = sdf.parse(adjSpace);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        infoNoiseManager.setSample(Integer.valueOf(sample));
        infoNoiseManager.setUpSpace(Integer.valueOf(upSpace));
        infoNoiseManager.setTimeWight(TimeWight.getValue());
        infoNoiseManager.setFreWight(FreWight.getValue());
        infoNoiseManager.setInitime(Integer.valueOf(iniTime));
        infoNoiseManager.setON_OFF_UDT(ON_OFF_UDT.isSelected()?0:1);
        infoNoiseManager.setON_OFF_HOUR(ON_OFF_HOUR.isSelected()?0:1);
        infoNoiseManager.setON_OFF_DAY(ON_OFF_DAY.isSelected()?0:1);
        infoNoiseManager.setIsExceed(IsExceed.isSelected()?0:1);
        infoNoiseManager.setDayOverValue(Double.valueOf(dayOverValue));
        infoNoiseManager.setNightOverValue(Double.valueOf(nightOverValue));
        infoNoiseManager.setOverDlay(Integer.valueOf(overDlay));
        infoNoiseManager.setIsOct(IsOct.isSelected()?0:1);
        infoNoiseManager.setDayOctValue(Double.valueOf(dayOctValue));
        infoNoiseManager.setNightOctValue(Double.valueOf(nightOctValue));
        infoNoiseManager.setOctDlay(Integer.valueOf(octDlay));
        infoNoiseManager.setON_OFF_11OCT(ON_OFF_11OCT.isSelected()?0:1);
        infoNoiseManager.setON_OFF_13OCT(ON_OFF_13OCT.isSelected()?0:1);
        infoNoiseManager.setIsRecord(IsRecord.isSelected()?0:1);
        infoNoiseManager.setDayRecordValue(Double.valueOf(dayRecordValue));
        infoNoiseManager.setNightRecordValue(Double.valueOf(nightRecordValue));
        infoNoiseManager.setRecordDlay(Integer.valueOf(recordDlay));
        infoNoiseManager.setRecordModel(Integer.valueOf(recordModel));
        infoNoiseManager.setRecordStartTime(startDate);
        infoNoiseManager.setRecordEndTime(endDate);
        infoNoiseManager.setIsAutoAdjust(isAutoAdjust.isSelected()?0:1);
        infoNoiseManager.setAdjustTime(adjust);
        infoNoiseManager.setAdjustSpace(Integer.valueOf(adjustSpace));
        infoNoiseManager.setWeaAutoSave(WeaAutoSave.isSelected()?0:1);
        infoNoiseManager.setWeaAutoUp(WeaAutoUp.isSelected()?0:1);
        infoNoiseManager.setWeaUpSpace(Integer.valueOf(weaUpSpace));
        infoNoiseManager.setCarAutoSave(CarAutoSave.isSelected()?0:1);
        infoNoiseManager.setCarAutoUp(CarAutoUp.isSelected()?0:1);
        infoNoiseManager.setCarUpSpace(Integer.valueOf(carUpSpace));
        infoNoiseManager.setDustAutoSave(DustAutoSave.isSelected()?0:1);
        infoNoiseManager.setDustAutoUp(DustAutoUp.isSelected()?0:1);
        infoNoiseManager.setDustUpSpace(Integer.valueOf(dustUpSpace));
        infoNoiseManager.setON_OFF_LEQA(ON_OFF_LEQA.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPFA(ON_OFF_LPFA.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPSA(ON_OFF_LPSA.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPIA(ON_OFF_LPIA.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LEQC(ON_OFF_LEQC.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPFC(ON_OFF_LPFC.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPSC(ON_OFF_LPSC.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPIC(ON_OFF_LPIC.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LEQZ(ON_OFF_LEQZ.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPFZ(ON_OFF_LPFZ.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPSZ(ON_OFF_LPSZ.isSelected()?0:1);
        infoNoiseManager.setON_OFF_LPIZ(ON_OFF_LPIZ.isSelected()?0:1);
        infoNoiseManager.setEvent_13(Event_13.isSelected()?0:1);
        infoNoiseManager.setEvent_01(Event_01.isSelected()?0:1);
        infoNoiseManager.setEvent_02(Event_02.isSelected()?0:1);
        infoNoiseManager.setEvent_03(Event_03.isSelected()?0:1);
        infoNoiseManager.setEvent_04(Event_04.isSelected()?0:1);
        infoNoiseManager.setEvent_07(Event_07.isSelected()?0:1);
        infoNoiseManager.setEvent_08(Event_08.isSelected()?0:1);
        infoNoiseManager.setEvent_09(Event_09.isSelected()?0:1);
        infoNoiseManager.setEvent_10(Event_10.isSelected()?0:1);
        infoNoiseManager.setEvent_12(Event_12.isSelected()?0:1);
        infoNoiseManager.setON_OFF_RADF(ON_OFF_RADF.isSelected()?0:1);
        infoNoiseManager.setON_OFF_FAMF(ON_OFF_FAMF.isSelected()?0:1);
        infoNoiseManager.setON_OFF_PDWIV(ON_OFF_PDWIV.isSelected()?0:1);
        infoNoiseManager.setNoiseManagerId(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
        infoNoiseManager.setEvent_05(1);
        infoNoiseManager.setEvent_06(1);
        infoNoiseManager.setEvent_11(1);
        infoNoiseManager.setON_OFF_PEAKA(0);
        infoNoiseManager.setON_OFF_PEAKC(0);
        infoNoiseManager.setON_OFF_PEAKZ(0);
        infoNoiseManager.setVersion_Hardware("1");
        infoNoiseManager.setVersion_Linux("1");
        infoNoiseManager.setVersion_N_VIEW("1");
        infoNoiseManager.setVersion_NoiseMonitor("1");
        infoNoiseManager.setVersion_normal("1");
        infoNoiseManager.setHasAll(0);
        infoNoiseManager.setHasOct(0);
        infoNoiseManager.setHasSoundtrans(0);
        infoNoiseManager.setHasRecord(0);
        infoNoiseManager.setRecord_On_Off(0);
        infoNoiseManager.setON_OFF_LEQ1S(1);
        infoNoiseManagerService.saveInfoNoiseManager(infoNoiseManager);
    }

    //接收前端传过来的参数，为对应属性赋值
    private void accept(){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat sdff = new SimpleDateFormat("HH:mm");
        //String rstartTime = infoNoiseManager.getRecordStartTime().toString();
        //String rendTime = infoNoiseManager.getRecordEndTime().toString();
        //String adjTime = infoNoiseManager.getAdjustTime().toString();
        //String[] rstime = rstartTime.split(" ");
        //String[] retime = rendTime.split(" ");
        //String[] adTime = adjTime.split(" ");
        Sample.setText(String.valueOf(infoNoiseManager.getSample()));
        UpSpace.setText(String.valueOf(infoNoiseManager.getUpSpace()));
        TimeWight.setValue(infoNoiseManager.getTimeWight());
        FreWight.setValue(infoNoiseManager.getFreWight());
        Initime.setText(String.valueOf(infoNoiseManager.getInitime()));
        DayOverValue.setText(String.valueOf(infoNoiseManager.getDayOverValue()));
        NightOverValue.setText(String.valueOf(infoNoiseManager.getNightOverValue()));
        OverDlay.setText(String.valueOf(infoNoiseManager.getOverDlay()));
        DayOctValue.setText(String.valueOf(infoNoiseManager.getDayOctValue()));
        NightOctValue.setText(String.valueOf(infoNoiseManager.getNightOctValue()));
        OctDlay.setText(String.valueOf(infoNoiseManager.getOctDlay()));
        DayRecordValue.setText(String.valueOf(infoNoiseManager.getDayRecordValue()));
        NightRecordValue.setText(String.valueOf(infoNoiseManager.getNightRecordValue()));
        RecordDlay.setText(String.valueOf(infoNoiseManager.getRecordDlay()));
        if(infoNoiseManager.getIsRecord() == 1){IsRecord.setSelected(true);}
        //RecordStartTime.setPromptText(rstime[0]);
        //StartTime.setPromptText(rstime[1]);
        //RecordEndTime.setPromptText(retime[0]);
        //EndTime.setPromptText(retime[1]);
        ///AdjustTime.setPromptText(adTime[0]);
        //ajTime.setPromptText(adTime[1]);
        AdjustSpace.setValue(String.valueOf(infoNoiseManager.getAdjustSpace()));
        if(infoNoiseManager.getIsAutoAdjust() == 1){isAutoAdjust.setSelected(true);}
        if(infoNoiseManager.getWeaUpSpace() == 1)WeaAutoSave.setSelected(true);
        if(infoNoiseManager.getWeaAutoUp() == 1)WeaAutoUp.setSelected(true);
        WeaUpSpace.setText(String.valueOf(infoNoiseManager.getWeaUpSpace()));
        if(infoNoiseManager.getCarAutoSave() == 1)CarAutoSave.setSelected(true);
        if(infoNoiseManager.getCarAutoUp() == 1)CarAutoUp.setSelected(true);
        CarUpSpace.setText(String.valueOf(infoNoiseManager.getCarUpSpace()));
        if(infoNoiseManager.getDustAutoSave() == 1)DustAutoSave.setSelected(true);
        if(infoNoiseManager.getDustAutoUp() == 1)DustAutoUp.setSelected(true);
        CarUpSpace.setText(String.valueOf(infoNoiseManager.getDustUpSpace()));
        if(infoNoiseManager.getON_OFF_LEQZ() == 1)ON_OFF_LEQZ.setSelected(true);
        if(infoNoiseManager.getON_OFF_LEQC() == 1)ON_OFF_LEQC.setSelected(true);
        if(infoNoiseManager.getON_OFF_LEQA() == 1)ON_OFF_LEQA.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPFZ() == 1)ON_OFF_LPFZ.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPSZ() == 1)ON_OFF_LPSZ.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPIZ() == 1)ON_OFF_LPIZ.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPFC() == 1)ON_OFF_LPFC.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPSC() == 1)ON_OFF_LPSC.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPIC() == 1)ON_OFF_LPIC.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPFA() == 1)ON_OFF_LPFA.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPSA() == 1)ON_OFF_LPSA.setSelected(true);
        if(infoNoiseManager.getON_OFF_LPIA() == 1)ON_OFF_LPIA.setSelected(true);
        if(infoNoiseManager.getON_OFF_HOUR() == 1)ON_OFF_HOUR.setSelected(true);
        if(infoNoiseManager.getON_OFF_DAY() == 1)ON_OFF_DAY.setSelected(true);
        if(infoNoiseManager.getON_OFF_UDT() == 1)ON_OFF_UDT.setSelected(true);
        if(infoNoiseManager.getON_OFF_RADF() == 1)ON_OFF_RADF.setSelected(true);
        if(infoNoiseManager.getON_OFF_FAMF() == 1)ON_OFF_FAMF.setSelected(true);
        if(infoNoiseManager.getON_OFF_PDWIV() == 1)ON_OFF_PDWIV.setSelected(true);
        if(infoNoiseManager.getON_OFF_13OCT() == 1)ON_OFF_13OCT.setSelected(true);
        if(infoNoiseManager.getON_OFF_11OCT() == 1)ON_OFF_11OCT.setSelected(true);
        if(infoNoiseManager.getEvent_01() == 3)Event_01.setSelected(true);
        if(infoNoiseManager.getEvent_02() == 3)Event_02.setSelected(true);
        if(infoNoiseManager.getEvent_03() == 3)Event_03.setSelected(true);
        if(infoNoiseManager.getEvent_04() == 3)Event_04.setSelected(true);
        if(infoNoiseManager.getEvent_07() == 3)Event_07.setSelected(true);
        if(infoNoiseManager.getEvent_08() == 3)Event_08.setSelected(true);
        if(infoNoiseManager.getEvent_09() == 3)Event_09.setSelected(true);
        if(infoNoiseManager.getEvent_10() == 3)Event_10.setSelected(true);
        if(infoNoiseManager.getEvent_12() == 3)Event_12.setSelected(true);
        if(infoNoiseManager.getEvent_13() == 3)Event_13.setSelected(true);
    }

    /**
     * 设置操作 End
     *
     */

    /**
     * 状态操作 Start
     * */
    private void status(){
        LinkState.setText(String.valueOf(stateNoise.getLinkState()));
        NowDateTime.setText(String.valueOf(sdf.format(stateNoise.getNowDateTime())));
        LpTime.setText(SendingThread.data);
        UsedRoom.setText(String.valueOf(stateNoise.getUsedRoom()));
        FreeRoom.setText(String.valueOf(stateNoise.getUsedRoom()));
        BatteryVoltage.setText(String.valueOf(stateNoise.getBatteryVoltage()));
        WorkingVoltage.setText(String.valueOf(stateNoise.getWorkingVoltage()));
        NetworkState.setText(String.valueOf(stateNoise.getNetworkState()));
        SIMICCID.setText(stateNoise.getSIMICCID());
        SIMIMSI.setText(stateNoise.getSIMIMSI());
        OutTemperature.setText(String.valueOf(stateNoise.getOutTemperature()));
        Humi_R.setText(String.valueOf(stateNoise.getHumi_R()));
        AriPressure.setText(String.valueOf(stateNoise.getAriPressure()));
        WindSpeed.setText(String.valueOf(stateNoise.getWindSpeed()));
        W_Direction.setText(String.valueOf(stateNoise.getW_Direction()));
        Rainfall.setText(String.valueOf(stateNoise.getRainfall()));
        PerFlux.setText(String.valueOf(stateNoise.getPerFlux()));
        AvgSpeed.setText(String.valueOf(stateNoise.getAvgSpeed()));
        PM25.setText(String.valueOf(stateNoise.getPM25()));
        PM10.setText(String.valueOf(stateNoise.getPM10()));
    }

    //历史事件列表
    private void oldEventList(){
        eventList = eventCodeService.queryByEventSource(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
        for (EventCode eventCode : eventList) {
            Date startDate = eventCode.getEventStartTime();
            Date endDate = eventCode.getEventEndTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            eventCode.setStartTime(formatter.format(startDate));
            eventCode.setEndTime(formatter.format(endDate));
            EventStartTime.setCellValueFactory(new PropertyValueFactory<EventCode,String>("startTime"));
            EventEndTime.setCellValueFactory(new PropertyValueFactory<EventCode,String>("endTime"));
            EventDescribe.setCellValueFactory(new PropertyValueFactory<>("eventDescribe"));
            eventListTableView.setItems(eventList);
        }

    }
    //内核、引擎
    private void hardWareGrid(){
        version_Hardware.setText(infoNoiseManager1.getVersion_Hardware());
        version_Linux.setText(infoNoiseManager1.getVersion_Linux());
        version_N_VIEW.setText(infoNoiseManager1.getVersion_N_VIEW());
        version_NoiseMonitor.setText(infoNoiseManager1.getVersion_NoiseMonitor());
    }
    //授权信息
    private void authorize(){
        if(infoNoiseManager1.getHasAll() == 1){
            HasAll.setSelected(true);
        }else{
            HasAll.setSelected(false);
        }
        if(infoNoiseManager1.getHasOct() == 1){
            HasOct.setSelected(true);
        }else {
            HasOct.setSelected(false);
        }
        if(infoNoiseManager1.getHasRecord() == 1){
            HasRecord.setSelected(true);
        }else {
            HasRecord.setSelected(false);
        }
        if(infoNoiseManager1.getHasSoundtrans() == 1){
            HasSoundtrans.setSelected(true);
        }else {
            HasSoundtrans.setSelected(false);
        }
    }
    //远程升级操作
    private void upGrade(){
        sendFile.setOnAction(event -> {
            getFileSize(fileName);
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct170();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        otherSendFile.setOnAction(event -> {
            getFileSize(fileName); //获取文件大小
            getFileData(fileName); //获取文件内容
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct171();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        checkUp.setOnAction(event -> {
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct172();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        cancelSend.setOnAction(event -> {
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct173();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        commitUpgrade.setOnAction(event -> {
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct175();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
    }

    /**
     * 状态操作 End
     * */

    /**
     * 文件操作 start
     * */
    private void allFile(){
        //读取文件操作
        readFile.setOnAction(event -> {
            /*filePath.append(fileText.getText());
            filePath.toString();*/
            fileText.setText("/");
            filePath.append(fileText.getText());
            filePath.toString();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct180();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
            //文件列表
            noiseFileList();
        });

        //返回操作
        returnBefore.setOnAction(event -> {
            String[] split = fileText.getText().split("/");
            int pathLength = split.length;
            for (int i = 0;i<pathLength;i++){
                filePath.append("/"+split[i]);
            }
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct180();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });

        //查看某个文件发送指令
        readOneFile.setOnAction(event -> {
            if(noiseFile.getFileType().equals("1")){
                actiontarget.setText("选择的不是文件，请重新选择...");
            }
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct181();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
    }

    private void noiseFileList(){
        noiseFileName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        noiseFileSize.setCellValueFactory(new PropertyValueFactory<>("fileSize"));
        noiseFileCreateTime.setCellValueFactory(new PropertyValueFactory<>("fileDateTime"));
        noiseFileTableView.setItems(fileList);

        noiseFileTableView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<NoiseFile>() {
                    @Override
                    public void changed(ObservableValue<? extends NoiseFile> observable, NoiseFile oldValue, NoiseFile newValue) {
                        noiseFile = newValue;
                    }
                });

        //双击进入下一级目录
        noiseFileTableView.setRowFactory(tv->{
            TableRow<NoiseFile> row = new TableRow<NoiseFile>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && (!row.isEmpty())){
                    NoiseFile noiseFile = row.getItem();
                    filePath.append(noiseFile.getFileName());
                    filePath.toString();
                    fileText.setText("/"+filePath);
                    SendingInstruct sendingInstruct = new SendingInstruct();
                    SendingThread.instruct = sendingInstruct.instruct180();
                    SendingThread sendingThread = new SendingThread(SendingThread.socket);
                    sendingThread.SendingSock(SendingThread.instruct);
                }
            });
            return row;
        });
    }

    //发送查看全部文件时的临时对象，存储文件信息
    public static class NoiseFile{
        private StringProperty noiseCode;
        private StringProperty fileName;
        private StringProperty fileType;
        private StringProperty fileSize;
        private Date fileDateTime;

        @Override
        public String toString() {
            return "NoiseFile{" +
                    "noiseCode=" + noiseCode +
                    ", fileName=" + fileName +
                    ", fileType=" + fileType +
                    ", fileSize=" + fileSize +
                    ", fileDateTime=" + fileDateTime +
                    '}';
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

        public String getFileName() {
            return fileName.get();
        }

        public StringProperty fileNameProperty() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = new SimpleStringProperty(fileName);
        }

        public String getFileType() {
            return fileType.get();
        }

        public StringProperty fileTypeProperty() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = new SimpleStringProperty(fileType);
        }

        public String getFileSize() {
            return fileSize.get();
        }

        public StringProperty fileSizeProperty() {
            return fileSize;
        }

        public void setFileSize(String fileSize) {
            this.fileSize = new SimpleStringProperty(fileSize);
        }

        public Date getFileDateTime() {
            return fileDateTime;
        }

        public void setFileDateTime(Date fileDateTime) {
            this.fileDateTime = fileDateTime;
        }

        public NoiseFile(String noiseCode, String fileName, String fileType, String fileSize, Date fileDateTime) {
            this.noiseCode = new SimpleStringProperty(noiseCode);
            this.fileName = new SimpleStringProperty(fileName);
            this.fileType = new SimpleStringProperty(fileType);
            this.fileSize = new SimpleStringProperty(fileSize);
            this.fileDateTime = fileDateTime;
        }

        public NoiseFile() {
        }
    }
    //发送查询某个文件时。存储的单个文件信息
    public static class OneNoiseFile{
        private StringProperty fileName;
        private StringProperty fileSize;
        private SimpleIntegerProperty fileOffset;
        private SimpleIntegerProperty fileDataSize;
        private StringProperty fileData;

        @Override
        public String toString() {
            return "OneNoiseFile{" +
                    "fileName=" + fileName +
                    ", fileSize=" + fileSize +
                    ", fileOffset=" + fileOffset +
                    ", fileDataSize=" + fileDataSize +
                    ", fileData=" + fileData +
                    '}';
        }

        public String getFileName() {
            return fileName.get();
        }

        public StringProperty fileNameProperty() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = new SimpleStringProperty(fileName);
        }

        public String getFileSize() {
            return fileSize.get();
        }

        public StringProperty fileSizeProperty() {
            return fileSize;
        }

        public void setFileSize(String fileSize) {
            this.fileSize = new SimpleStringProperty(fileSize);
        }

        public int getFileOffset() {
            return fileOffset.get();
        }

        public SimpleIntegerProperty fileOffsetProperty() {
            return fileOffset;
        }

        public void setFileOffset(int fileOffset) {
            this.fileOffset = new SimpleIntegerProperty(fileOffset);
        }

        public int getFileDataSize() {
            return fileDataSize.get();
        }

        public SimpleIntegerProperty fileDataSizeProperty() {
            return fileDataSize;
        }

        public void setFileDataSize(int fileDataSize) {
            this.fileDataSize = new SimpleIntegerProperty(fileDataSize);
        }

        public String getFileData() {
            return fileData.get();
        }

        public StringProperty fileDataProperty() {
            return fileData;
        }

        public void setFileData(String fileData) {
            this.fileData = new SimpleStringProperty(fileData);
        }

        public OneNoiseFile(String fileName, String fileSize, int fileOffset, int fileDataSize, String fileData) {
            this.fileName = new SimpleStringProperty(fileName);
            this.fileSize = new SimpleStringProperty(fileSize);
            this.fileOffset = new SimpleIntegerProperty(fileOffset);
            this.fileDataSize = new SimpleIntegerProperty(fileDataSize);
            this.fileData = new SimpleStringProperty(fileData);
        }

        public OneNoiseFile() {
        }
    }
    /**
     * 文件操作 end
     * */

    /**
     * 操作界面 start
     * */
    private void soundAndVideo(){
        //开始录音
        sound.setOnAction(event -> {
            SendingInstruct.device = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct143();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        //开始录像
        video.setOnAction(event -> {
            SendingInstruct.device = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct144();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        //结束录音
        endSound.setOnAction(event -> {
            SendingInstruct.device = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct.info = 0;
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct143();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
        //结束录像
        endVideo.setOnAction(event -> {
            SendingInstruct.device = AddFixedMeasureController.infoNoiseDevice.getDeviceCode();
            SendingInstruct.info = 0;
            SendingInstruct sendingInstruct = new SendingInstruct();
            SendingThread.instruct = sendingInstruct.instruct144();
            SendingThread sendingThread = new SendingThread(SendingThread.socket);
            sendingThread.SendingSock(SendingThread.instruct);
        });
    }
    /**
     *操作界面 end
     * */

    /**
     * 节目操作 Start
     * */
    private void program(){
        textButton.setOnAction(event -> {
            String programName = "文本" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            TextPara textPara = new TextPara(programName, null, "0", y + "", "200", "40", "宋体", "16", "0", "红色", "文本");
            textPara.setProgramName(programName);
            programParaMap.put(programName, textPara);
            preview();
            textParaPage(textPara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        subTitleButton.setOnAction(event -> {
            String programName = "字幕" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            SubTitlePara subTitlePara = new SubTitlePara(programName, null, "0", y + "", "200", "40", "宋体", "16", "0", "红色", "0", "0", "1", "3", "0", "5", "爱护环境，人人有责");
            programParaMap.put(programName, subTitlePara);
            preview();
            subTitleParaPage(subTitlePara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        timeButton.setOnAction(event -> {
            String programName = "时间" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            TimePara timePara = new TimePara(programName, null, "0", y + "", "200", "40", "宋体", "16", "0", "红色", "0", "0", "1", "3", "0", "5", "yyyy-MM-dd HH:mm:ss");
            programParaMap.put(programName, timePara);
            preview();
            timeParaPage(timePara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        noiseButton.setOnAction(event -> {
            String programName = "噪声" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            NoisePara noisePara = new NoisePara(programName, null, "0", y + "", "200", "40", "宋体", "16", "0", "红色", "红色");
            programParaMap.put(programName, noisePara);
            preview();
            noiseParaPage(noisePara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        deleteButton.setOnAction(event -> {
            for (Label label : sideList.getItems()) {
                if (label.getText().equals(selectedProgramName)) {
                    sideList.getItems().remove(label);
                    break;
                }
            }
            programList.remove(selectedProgramName);
            programParaMap.remove(selectedProgramName);
            preview();
            selectedProgramName = null;
        });
        subTitleButton.fire();
    }

    @FXML
    private void changePage() {
        editPara.getChildren().clear();
        String typeMark = sideList.getSelectionModel().getSelectedItem().getText();
        //System.out.println(typeMark);
        if (typeMark.contains("噪声")) {
            noiseParaPage((NoisePara) programParaMap.get(typeMark));
        } else if (typeMark.contains("时间")) {
            timeParaPage((TimePara) programParaMap.get(typeMark));
        } else if (typeMark.contains("字幕")) {
            subTitleParaPage((SubTitlePara) programParaMap.get(typeMark));
        } else if (typeMark.contains("文本")) {
            textParaPage((TextPara) programParaMap.get(typeMark));
        }
    }

    public void preview() {
        previewWindow.getChildren().clear();
        int maxY = 0;
        for (BasicPara basicPara : programParaMap.values()) {
            Label label1 = null;
            if (basicPara instanceof NoisePara) {
                NoisePara noisePara = (NoisePara) basicPara;
                label1 = new Label("56.7");
            } else if (basicPara instanceof TimePara) {
                TimePara timePara = (TimePara) basicPara;

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat(timePara.getTimeStyle());
                String nowDate = sdf.format(date);

                label1 = new Label(nowDate);

                //动画开始的位置
                KeyValue initKeyValue = new KeyValue(label1.translateXProperty(), nowDate.length() * 10 + Integer.valueOf(timePara.getWidth()) - 50);
                KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

                //动画结束的位置
                KeyValue endKeyValue = new KeyValue(label1.translateXProperty(), nowDate.length() * -10 - 10);
                KeyFrame endFrame = new KeyFrame(Duration.seconds(10 - Integer.valueOf(timePara.getSpeed())), endKeyValue);

                Timeline timeline = new Timeline(initFrame, endFrame);

                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            } else if (basicPara instanceof SubTitlePara) {
                SubTitlePara subTitlePara = (SubTitlePara) basicPara;

                label1 = new Label(subTitlePara.getContent());

                //动画开始的位置
                KeyValue initKeyValue = new KeyValue(label1.translateXProperty(), subTitlePara.getContent().length() * 10 + Integer.valueOf(subTitlePara.getWidth()) - 50);
                KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

                //动画结束的位置
                KeyValue endKeyValue = new KeyValue(label1.translateXProperty(), subTitlePara.getContent().length() * -12 - 10);
                KeyFrame endFrame = new KeyFrame(Duration.seconds(10 - Integer.valueOf(subTitlePara.getSpeed())), endKeyValue);

                Timeline timeline = new Timeline(initFrame, endFrame);

                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            } else if (basicPara instanceof TextPara) {
                TextPara textPara = (TextPara) basicPara;
                label1 = new Label(textPara.getContent());
            }
            label1.setStyle("-fx-font-family: STSong;-fx-font-size: " + basicPara.getFontSize() + ";");
            label1.setAlignment(Pos.CENTER);
            label1.setPrefSize(Integer.valueOf(basicPara.getWidth()) - 4, Integer.valueOf(basicPara.getHeight()) - 4);
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(label1);
            scrollPane.setPrefSize(Integer.valueOf(basicPara.getWidth()), Integer.valueOf(basicPara.getHeight()));
            scrollPane.setLayoutX(Integer.valueOf(basicPara.getX()));
            scrollPane.setLayoutY(Integer.valueOf(basicPara.getY()));
            scrollPane.setStyle("-fx-border-color: #949494;");
            scrollPane.setOnMouseClicked(event -> {
                for (Label label : sideList.getItems()) {
                    if (label.getText().equals(basicPara.getProgramName())) {
                        sideList.getSelectionModel().select(label);
                        changePage();
                    }
                }
                select(basicPara.getProgramName());
            });
            if (Integer.valueOf(basicPara.getY())+Integer.valueOf(basicPara.getHeight())>maxY){
                maxY = Integer.valueOf(basicPara.getY())+Integer.valueOf(basicPara.getHeight());
            }
            basicPara.setScrollPane(scrollPane);
            previewWindow.getChildren().add(scrollPane);
        }
        y = maxY;
    }

    public void select(String selected) {
        if (selectedProgramName != null) {
            programParaMap.get(selectedProgramName).getScrollPane().setStyle("-fx-border-color: #949494;");
        }
        selectedProgramName = selected;
        programParaMap.get(selectedProgramName).getScrollPane().setStyle("-fx-border-color: #e50018;");
    }

    public void textParaPage(TextPara textPara) {

        select(textPara.getProgramName());
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setText(textPara.getProgramName());
        textField1_1.setDisable(true);

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(textPara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(textPara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(textPara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(textPara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("宋体", "微软雅黑"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.setPromptText("选择");
        //System.out.println(noisePara.getFontType());
        comboBox4_1_1.getSelectionModel().select(textPara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("13", "14", "15", "16", "17", "18", "19", "20"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(textPara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("绿色", "红色"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.setPromptText("选择");
        //System.out.println(noisePara.getFontType());
        ColorPicker colorPicker1 = new ColorPicker();
        comboBox5_1_1.getSelectionModel().select(textPara.getColor());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<String> comboBox5_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox5_2_1.setPrefWidth(105);
        comboBox5_2_1.getSelectionModel().select(textPara.getSpacing());

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1, hBox5_2);

        TextField textField6 = new TextField();
        textField6.setText(textPara.getContent());
        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            TextPara textPara1 = new TextPara(textField1_1.getText(), null, textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_2_1.getValue(), comboBox5_1_1.getValue(), textField6.getText());
            //System.out.println(comboBox4_1_1.getValue());
            programParaMap.put(textField1_1.getText(), textPara1);
            preview();
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, textField6, button);
        editPara.getChildren().add(vBox);
    }

    public void noiseParaPage(NoisePara noisePara) {
        select(noisePara.getProgramName());
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setText(noisePara.getProgramName());
        textField1_1.setDisable(true);

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(noisePara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(noisePara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(noisePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(noisePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("微软雅黑", "宋体"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.setPromptText("选择");
        //System.out.println(noisePara.getFontType());
        comboBox4_1_1.getSelectionModel().select(noisePara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("13", "14", "15", "16", "17", "18", "19", "20"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(noisePara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 174;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("间距:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.getSelectionModel().select(noisePara.getSpacing());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);
        hBox5.getChildren().addAll(hBox5_1);


        HBox hBox6 = new HBox(19);

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("达标颜色:");
        ComboBox<String> comboBox6_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox6_1_1.setPrefWidth(94);
        comboBox6_1_1.getSelectionModel().select(noisePara.getTrueColor());

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("超标颜色:");
        ComboBox<String> comboBox6_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox6_2_1.setPrefWidth(81);
        comboBox6_2_1.getSelectionModel().select(noisePara.getFalseColor());

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1, hBox6_2);


        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            NoisePara noisePara1 = new NoisePara(textField1_1.getText(), null, textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_1_1.getValue(), comboBox6_1_1.getValue(), comboBox6_2_1.getValue());
            //System.out.println(comboBox4_1_1.getValue());
            programParaMap.put(textField1_1.getText(), noisePara1);
            preview();
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, hBox6, button);
        editPara.getChildren().add(vBox);
    }

    public void subTitleParaPage(SubTitlePara subTitlePara) {
        select(subTitlePara.getProgramName());
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setText(subTitlePara.getProgramName());
        textField1_1.setDisable(true);

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(subTitlePara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(subTitlePara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(subTitlePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(subTitlePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("宋体", "微软雅黑"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.getSelectionModel().select(subTitlePara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(subTitlePara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("红", "黑"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.getSelectionModel().select(subTitlePara.getColor());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<String> comboBox5_2_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox5_2_1.setPrefWidth(105);
        comboBox5_2_1.getSelectionModel().select(subTitlePara.getSpacing());

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1, hBox5_2);


        HBox hBox6 = new HBox(20);
        hBox6.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("横向:");
        ComboBox<String> comboBox6_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox6_1_1.setPrefWidth(105);
        comboBox6_1_1.getSelectionModel().select(subTitlePara.getBroadwise());

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("纵向:");
        ComboBox<String> comboBox6_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5", "6"));
        comboBox6_2_1.setPrefWidth(105);
        comboBox6_2_1.getSelectionModel().select(subTitlePara.getPortrait());

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1, hBox6_2);


        HBox hBox7 = new HBox(20);
        hBox7.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox7_1 = new HBox(10);

        Label label7_1_1 = new Label("速度:");
        ComboBox<String> comboBox7_1_1 = new ComboBox<String>(FXCollections.observableArrayList("1", "2"));
        comboBox7_1_1.setPrefWidth(105);
        comboBox7_1_1.getSelectionModel().select(subTitlePara.getSpeed());

        hBox7_1.getChildren().add(label7_1_1);
        hBox7_1.getChildren().add(comboBox7_1_1);

        HBox hBox7_2 = new HBox(10);

        Label label7_2_1 = new Label("停留:");
        ComboBox<String> comboBox7_2_1 = new ComboBox<String>(FXCollections.observableArrayList("3", "4"));
        comboBox7_2_1.setPrefWidth(105);
        comboBox7_2_1.getSelectionModel().select(subTitlePara.getStay());

        hBox7_2.getChildren().add(label7_2_1);
        hBox7_2.getChildren().add(comboBox7_2_1);
        hBox7.getChildren().addAll(hBox7_1, hBox7_2);


        HBox hBox8 = new HBox(20);
        hBox8.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox8_1 = new HBox(10);

        Label label8_1_1 = new Label("排版:");
        ComboBox<String> comboBox8_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox8_1_1.setPrefWidth(105);
        comboBox8_1_1.getSelectionModel().select(subTitlePara.getTypesetting());

        hBox8_1.getChildren().add(label8_1_1);
        hBox8_1.getChildren().add(comboBox8_1_1);

        HBox hBox8_2 = new HBox(10);

        Label label8_2_1 = new Label("特技:");
        ComboBox<String> comboBox8_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5", "6"));
        comboBox8_2_1.setPrefWidth(105);
        comboBox8_2_1.getSelectionModel().select(subTitlePara.getStunt());

        hBox8_2.getChildren().add(label8_2_1);
        hBox8_2.getChildren().add(comboBox8_2_1);
        hBox8.getChildren().addAll(hBox8_1, hBox8_2);


        TextField textField9 = new TextField();
        textField9.setText(subTitlePara.getContent());
        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            SubTitlePara subTitlePara1 = new SubTitlePara(textField1_1.getText(), null, textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_1_1.getValue(), comboBox5_2_1.getValue(), comboBox6_1_1.getValue(), comboBox6_2_1.getValue(), comboBox7_1_1.getValue(), comboBox7_2_1.getValue(), comboBox8_1_1.getValue(), comboBox8_2_1.getValue(), textField9.getText());
            programParaMap.put(textField1_1.getText(), subTitlePara1);
            preview();
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, hBox6, hBox7, hBox8, textField9, button);
        editPara.getChildren().add(vBox);
    }

    public void timeParaPage(TimePara timePara) {
        select(timePara.getProgramName());
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setDisable(true);
        textField1_1.setText(timePara.getProgramName());

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(timePara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(timePara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(timePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(timePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("宋体", "微软雅黑"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.getSelectionModel().select(timePara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(timePara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("红", "黑"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.getSelectionModel().select(timePara.getColor());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<String> comboBox5_2_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox5_2_1.setPrefWidth(105);
        comboBox5_2_1.getSelectionModel().select(timePara.getSpacing());

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1, hBox5_2);


        HBox hBox6 = new HBox(20);
        hBox6.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("横向:");
        ComboBox<String> comboBox6_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox6_1_1.setPrefWidth(105);
        comboBox6_1_1.getSelectionModel().select(timePara.getBroadwise());

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("纵向:");
        ComboBox<String> comboBox6_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5", "6"));
        comboBox6_2_1.setPrefWidth(105);
        comboBox6_2_1.getSelectionModel().select(timePara.getPortrait());

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1, hBox6_2);


        HBox hBox7 = new HBox(20);
        hBox7.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox7_1 = new HBox(10);

        Label label7_1_1 = new Label("速度:");
        ComboBox<String> comboBox7_1_1 = new ComboBox<String>(FXCollections.observableArrayList("1", "2"));
        comboBox7_1_1.setPrefWidth(105);
        comboBox7_1_1.getSelectionModel().select(timePara.getSpeed());

        hBox7_1.getChildren().add(label7_1_1);
        hBox7_1.getChildren().add(comboBox7_1_1);

        HBox hBox7_2 = new HBox(10);

        Label label7_2_1 = new Label("停留:");
        ComboBox<String> comboBox7_2_1 = new ComboBox<String>(FXCollections.observableArrayList("3", "4"));
        comboBox7_2_1.setPrefWidth(105);
        comboBox7_2_1.getSelectionModel().select(timePara.getStay());

        hBox7_2.getChildren().add(label7_2_1);
        hBox7_2.getChildren().add(comboBox7_2_1);
        hBox7.getChildren().addAll(hBox7_1, hBox7_2);


        HBox hBox8 = new HBox(20);
        hBox8.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox8_1 = new HBox(10);

        Label label8_1_1 = new Label("排版:");
        ComboBox<String> comboBox8_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox8_1_1.setPrefWidth(105);
        comboBox8_1_1.getSelectionModel().select(timePara.getTypesetting());

        hBox8_1.getChildren().add(label8_1_1);
        hBox8_1.getChildren().add(comboBox8_1_1);

        HBox hBox8_2 = new HBox(10);

        Label label8_2_1 = new Label("特技:");
        ComboBox<String> comboBox8_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5", "6"));
        comboBox8_2_1.setPrefWidth(105);
        comboBox8_2_1.getSelectionModel().select(timePara.getStunt());

        hBox8_2.getChildren().add(label8_2_1);
        hBox8_2.getChildren().add(comboBox8_2_1);
        hBox8.getChildren().addAll(hBox8_1, hBox8_2);


        HBox hBox9 = new HBox(20);
        hBox9.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox9_1 = new HBox(10);

        Label label9_1_1 = new Label("风格:");
        ComboBox<String> comboBox9_1_1 = new ComboBox<String>(FXCollections.observableArrayList("yyyy-MM-dd HH:mm:ss"));
        comboBox9_1_1.setPrefWidth(267);
        comboBox9_1_1.getSelectionModel().select(timePara.getTimeStyle());

        hBox9_1.getChildren().add(label9_1_1);
        hBox9_1.getChildren().add(comboBox9_1_1);
        hBox9.getChildren().addAll(hBox9_1);

        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            TimePara timePara1 = new TimePara(textField1_1.getText(), null, textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_1_1.getValue(), comboBox5_2_1.getValue(), comboBox6_1_1.getValue(), comboBox6_2_1.getValue(), comboBox7_1_1.getValue(), comboBox7_2_1.getValue(), comboBox8_1_1.getValue(), comboBox8_2_1.getValue(), comboBox9_1_1.getValue());
            programParaMap.put(textField1_1.getText(), timePara1);
            preview();
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, button);
        editPara.getChildren().add(vBox);
    }

    public static class NoiseParaController {

    }

    public class BasicPara {
        private String programName;
        private ScrollPane scrollPane;
        private String X;
        private String Y;
        private String width;
        private String height;
        private String fontType;
        private String fontSize;
        private String spacing;

        public ScrollPane getScrollPane() {
            return scrollPane;
        }

        public void setScrollPane(ScrollPane scrollPane) {
            this.scrollPane = scrollPane;
        }

        public String getProgramName() {
            return programName;
        }

        public void setProgramName(String programName) {
            this.programName = programName;
        }

        public String getX() {
            return X;
        }

        public void setX(String x) {
            X = x;
        }

        public String getY() {
            return Y;
        }

        public void setY(String y) {
            Y = y;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getFontType() {
            return fontType;
        }

        public void setFontType(String fontType) {
            this.fontType = fontType;
        }

        public String getFontSize() {
            return fontSize;
        }

        public void setFontSize(String fontSize) {
            this.fontSize = fontSize;
        }

        public String getSpacing() {
            return spacing;
        }

        public void setSpacing(String spacing) {
            this.spacing = spacing;
        }

        public BasicPara(String programName, ScrollPane scrollPane, String x, String y, String width, String height, String fontType, String fontSize, String spacing) {
            this.programName = programName;
            this.scrollPane = scrollPane;
            X = x;
            Y = y;
            this.width = width;
            this.height = height;
            this.fontType = fontType;
            this.fontSize = fontSize;
            this.spacing = spacing;
        }

        @Override
        public String toString() {
            return "BasicPara{" +
                    "programName='" + programName + '\'' +
                    ", X='" + X + '\'' +
                    ", Y='" + Y + '\'' +
                    ", width='" + width + '\'' +
                    ", height='" + height + '\'' +
                    ", fontType='" + fontType + '\'' +
                    ", fontSize='" + fontSize + '\'' +
                    ", spacing='" + spacing + '\'' +
                    '}';
        }

        public BasicPara() {
        }
    }

    public class NoisePara extends BasicPara {
        private String trueColor;
        private String falseColor;

        public String getTrueColor() {
            return trueColor;
        }

        public void setTrueColor(String trueColor) {
            this.trueColor = trueColor;
        }

        public String getFalseColor() {
            return falseColor;
        }

        public void setFalseColor(String falseColor) {
            this.falseColor = falseColor;
        }

        public NoisePara(String programName, ScrollPane scrollPane, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String trueColor, String falseColor) {
            super(programName, scrollPane, X, Y, width, height, fontType, fontSize, spacing);
            this.trueColor = trueColor;
            this.falseColor = falseColor;
        }

        @Override
        public String toString() {
            return "NoisePara{" +
                    "programName='" + super.programName + '\'' +
                    ", X='" + super.X + '\'' +
                    ", Y='" + super.Y + '\'' +
                    ", width='" + super.width + '\'' +
                    ", height='" + super.height + '\'' +
                    ", fontType='" + super.fontType + '\'' +
                    ", fontSize='" + super.fontSize + '\'' +
                    ", spacing='" + super.spacing + '\'' +
                    ", trueColor='" + trueColor + '\'' +
                    ", falseColor='" + falseColor + '\'' +
                    '}';
        }

        public NoisePara() {
        }
    }

    public class SubTitlePara extends BasicPara {
        private String color;
        private String broadwise;//横向
        private String portrait;//纵向
        private String speed;
        private String stay;
        private String typesetting;//排版
        private String stunt;//特技
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBroadwise() {
            return broadwise;
        }

        public void setBroadwise(String broadwise) {
            this.broadwise = broadwise;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getStay() {
            return stay;
        }

        public void setStay(String stay) {
            this.stay = stay;
        }

        public String getTypesetting() {
            return typesetting;
        }

        public void setTypesetting(String typesetting) {
            this.typesetting = typesetting;
        }

        public String getStunt() {
            return stunt;
        }

        public void setStunt(String stunt) {
            this.stunt = stunt;
        }

        public SubTitlePara(String programName, ScrollPane scrollPane, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String color, String broadwise, String portrait, String speed, String stay, String typesetting, String stunt, String content) {
            super(programName, scrollPane, X, Y, width, height, fontType, fontSize, spacing);
            this.color = color;
            this.broadwise = broadwise;
            this.portrait = portrait;
            this.speed = speed;
            this.stay = stay;
            this.typesetting = typesetting;
            this.stunt = stunt;
            this.content = content;
        }

        public SubTitlePara() {
        }

        @Override
        public String toString() {
            return "SubTitlePara{" +
                    "programName='" + super.programName + '\'' +
                    ", X='" + super.X + '\'' +
                    ", Y='" + super.Y + '\'' +
                    ", width='" + super.width + '\'' +
                    ", height='" + super.height + '\'' +
                    ", fontType='" + super.fontType + '\'' +
                    ", fontSize='" + super.fontSize + '\'' +
                    ", spacing='" + super.spacing + '\'' +
                    ", color='" + color + '\'' +
                    ", broadwise='" + broadwise + '\'' +
                    ", portrait='" + portrait + '\'' +
                    ", speed='" + speed + '\'' +
                    ", stay='" + stay + '\'' +
                    ", typesetting='" + typesetting + '\'' +
                    ", stunt='" + stunt + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    public class TimePara extends SubTitlePara {
        private String timeStyle;

        public TimePara(String programName, ScrollPane scrollPane, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String color, String broadwise, String portrait, String speed, String stay, String typesetting, String stunt, String timeStyle) {
            super(programName, scrollPane, X, Y, width, height, fontType, fontSize, spacing, color, broadwise, portrait, speed, stay, typesetting, stunt, "");
            this.timeStyle = timeStyle;
        }

        public String getTimeStyle() {
            return timeStyle;
        }

        public void setTimeStyle(String timeStyle) {
            this.timeStyle = timeStyle;
        }

        public TimePara() {
        }

    }

    public class TextPara extends BasicPara {
        private String color;
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public TextPara(String programName, ScrollPane scrollPane, String x, String y, String width, String height, String fontType, String fontSize, String spacing, String color, String content) {
            super(programName, scrollPane, x, y, width, height, fontType, fontSize, spacing);
            this.color = color;
            this.content = content;
        }

        public TextPara() {
        }
        /**
         * 节目操作 End
         * */
    }

}
