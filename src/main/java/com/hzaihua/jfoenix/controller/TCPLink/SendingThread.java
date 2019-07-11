package com.hzaihua.jfoenix.controller.TCPLink;

import com.hzaihua.jfoenix.controller.Hbase.HbaseController;
import com.hzaihua.jfoenix.controller.MoreInfoController;
import com.hzaihua.jfoenix.controller.noiseDevice.NoiseDeviceManageController;
import com.hzaihua.jfoenix.entity.*;
import com.hzaihua.jfoenix.service.*;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.*;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


public class SendingThread extends Thread {

    public static Socket socket;

    public SendingThread(Socket socket) {
        this.socket = socket;
    }

    public static String instruct;
    public static double[] values;
    public static List devices;
    public static String deviceCode;
    public static String flag;
    public static String data;
    String value = null;
    String[] split = null;
    Leq1sCodeService leq1sCodeService = BeanFactoryUtil.getApplicationContext().getBean(Leq1sCodeService.class);
    LpDateService lpDateService = BeanFactoryUtil.getApplicationContext().getBean(LpDateService.class);
    EventCodeService eventCodeService = BeanFactoryUtil.getApplicationContext().getBean(EventCodeService.class);
    WeatherLPService weatherLPService = BeanFactoryUtil.getApplicationContext().getBean(WeatherLPService.class);
    WeatherHourService weatherHourService = BeanFactoryUtil.getApplicationContext().getBean(WeatherHourService.class);
    WeatherDateService weatherDateService = BeanFactoryUtil.getApplicationContext().getBean(WeatherDateService.class);
    CarFlowLPService carFlowLPService = BeanFactoryUtil.getApplicationContext().getBean(CarFlowLPService.class);
    CarFlowHourService carFlowHourService = BeanFactoryUtil.getApplicationContext().getBean(CarFlowHourService.class);
    CarFlowDateService carFlowDateService = BeanFactoryUtil.getApplicationContext().getBean(CarFlowDateService.class);
    DustLPService dustLPService = BeanFactoryUtil.getApplicationContext().getBean(DustLPService.class);
    DustHourService dustHourService = BeanFactoryUtil.getApplicationContext().getBean(DustHourService.class);
    DustDateService dustDateService = BeanFactoryUtil.getApplicationContext().getBean(DustDateService.class);
    Oct31CodeService oct31CodeService = BeanFactoryUtil.getApplicationContext().getBean(Oct31CodeService.class);
    OctCodeService octCodeService = BeanFactoryUtil.getApplicationContext().getBean(OctCodeService.class);
    InfoNoiseManagerService infoNoiseManagerService = BeanFactoryUtil.getApplicationContext().getBean(InfoNoiseManagerService.class);
    StaCodeService staCodeService = BeanFactoryUtil.getApplicationContext().getBean(StaCodeService.class);
    HourStaCodeService hourStaCodeService = BeanFactoryUtil.getApplicationContext().getBean(HourStaCodeService.class);
    DateStaCodeService dateStaCodeService = BeanFactoryUtil.getApplicationContext().getBean(DateStaCodeService.class);
    public static int rtn;
    final List<Put> puts = new CopyOnWriteArrayList<>();
    final List<Put> HourPuts = new CopyOnWriteArrayList<>();
    final List<Put> DatePuts = new CopyOnWriteArrayList<>();
    static Configuration conf = null;


    public void run() {
        SendingSock(instruct);
        while (true) {
            AcceptSock();
        }
    }


    private String getCode(String pack, String node) {
        String temp = ("<" + node + ">");
        int beginPos = pack.indexOf(temp, 0);
        String endTemp = "</" + node + ">";
        int endPos = pack.indexOf(endTemp, 0);
        if (beginPos != -1 && endPos != -1) {
            return pack.substring(beginPos + temp.length() + 1, endPos - 1);
        }
        return null;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    //接收
    public void AcceptSock() {
        InputStream inputStream = null;
        conf= HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","hbasenode47,hbasenode48,hbasenode49");//服务地址
        conf.set("hbase.zookeeper.property.clientPort","2181");//端口号
        try {
            inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            char[] chars = new char[1024];

            while (bufferedReader.read(chars, 0, 1024) > 0) {
                String pack = new String(chars);
                String classes = getCode(pack, "Class");
                System.out.println("服务端接收到客户端信息：" + classes + ",当前客户端ip为："
                        + socket.getInetAddress().getHostAddress());
                if (classes.equals("N000")) {
                    String name = getCode(pack, "Name");
                    deviceCode = getCode(pack,"Code");
                    System.out.println(name);
                    SendingInstruct sendingInstruct = new SendingInstruct();
                    SendingThread.instruct = sendingInstruct.instruct000();
                    SendingThread sendingThread = new SendingThread(SendingThread.socket);
                    sendingThread.SendingSock(SendingThread.instruct);
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N123")) { //提取实时采样数据采样间隔
                    value = getCode(pack, "Value");
                    NoiseDeviceManageController.infoNoiseManager.setSample(Double.valueOf(value));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N108")) { //提取实时采样数据上报间隔
                    value = getCode(pack, "Value");
                    NoiseDeviceManageController.infoNoiseManager.setUpSpace(Integer.valueOf(value));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N121")) { //提取计权参数(需总值授权)
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setFreWight(split[0]);
                    NoiseDeviceManageController.infoNoiseManager.setTimeWight(split[1]);
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N113")) { //提取积分时间
                    value = getCode(pack, "Value");
                    NoiseDeviceManageController.infoNoiseManager.setInitime(Integer.valueOf(value));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N106")) { //提取报警上限
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setDayOverValue(Double.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setNightOverValue(Double.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setOverDlay(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N201")) { //提取OCT参数(需频谱授权)
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setDayOctValue(Double.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setNightOctValue(Double.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setOctDlay(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N125")) { //提取录音参数(需录音授权)
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setDayRecordValue(Double.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setNightRecordValue(Double.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setRecordDlay(Integer.valueOf(split[2]));
                    NoiseDeviceManageController.infoNoiseManager.setIsRecord(Integer.valueOf(split[3]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N128")) { //提取录音文件自动上传参数(需录音授权)
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    Date startTime = sdf.parse(split[0]);
                    Date endTime = sdf.parse(split[1]);
                    NoiseDeviceManageController.infoNoiseManager.setRecordStartTime(startTime);
                    NoiseDeviceManageController.infoNoiseManager.setRecordEndTime(endTime);
                    NoiseDeviceManageController.infoNoiseManager.setIsRecord(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N115")) { //提取下端监测设备自动校零校满(电校准)时间和间隔
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    Date ajTime = sdf.parse(split[0]);
                    NoiseDeviceManageController.infoNoiseManager.setAdjustTime(ajTime);
                    NoiseDeviceManageController.infoNoiseManager.setAdjustSpace(Integer.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setIsAutoAdjust(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N205")) { //提取气象参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setWeaAutoSave(Integer.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setWeaAutoUp(Integer.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setWeaUpSpace(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N207")) { //提取车流量参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setCarAutoSave(Integer.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setCarAutoUp(Integer.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setCarUpSpace(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N209")) { //提取粉尘参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setDustAutoSave(Integer.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setDustAutoUp(Integer.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setDustUpSpace(Integer.valueOf(split[2]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N203")) { //提取其他开关量
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LEQZ(Integer.valueOf(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LEQC(Integer.valueOf(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LEQA(Integer.valueOf(split[2]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPFZ(Integer.valueOf(split[3]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPSZ(Integer.valueOf(split[4]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPIZ(Integer.valueOf(split[5]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPFC(Integer.valueOf(split[6]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPSC(Integer.valueOf(split[7]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPIC(Integer.valueOf(split[8]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPFA(Integer.valueOf(split[9]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPSA(Integer.valueOf(split[10]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LPIA(Integer.valueOf(split[11]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_PEAKZ(Integer.valueOf(split[12]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_PEAKC(Integer.valueOf(split[13]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_PEAKA(Integer.valueOf(split[14]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_HOUR(Integer.valueOf(split[15]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_DAY(Integer.valueOf(split[16]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_UDT(Integer.valueOf(split[17]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_RADF(Integer.valueOf(split[18]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_FAMF(Integer.valueOf(split[19]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_PDWIV(Integer.valueOf(split[20]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_LEQ1S(Integer.valueOf(split[21]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_13OCT(Integer.valueOf(split[22]));
                    NoiseDeviceManageController.infoNoiseManager.setON_OFF_11OCT(Integer.valueOf(split[23]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N119")) { //提取事件保存和上传允许参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setEvent_01(Integer.parseInt(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_02(Integer.parseInt(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_03(Integer.parseInt(split[2]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_04(Integer.parseInt(split[3]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_05(1);
                    NoiseDeviceManageController.infoNoiseManager.setEvent_06(1);
                    NoiseDeviceManageController.infoNoiseManager.setEvent_07(Integer.parseInt(split[6]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_08(Integer.parseInt(split[7]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_09(Integer.parseInt(split[8]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_10(Integer.parseInt(split[9]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_11(1);
                    NoiseDeviceManageController.infoNoiseManager.setEvent_12(Integer.parseInt(split[11]));
                    NoiseDeviceManageController.infoNoiseManager.setEvent_13(Integer.parseInt(split[12]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N110")) { //提取现场机系统时间
                    value = getCode(pack, "Value");
                    String nowTime = sdf.format(value); //????提取的时间显示在哪?
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N117")) { //提取备注
                    value = getCode(pack, "Value");//????提取的备注显示在哪?
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N211")) { //提取测点名称
                    value = getCode(pack, "Value"); //????提取的测点名称显示在哪?
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N102")) {  //提取历史事件记录
                    for (int i=0;i<3000;i++){
                        value = getCode(pack, "H"+i);
                        split = value.split(",");
                        EventCode eventCode = new EventCode();
                        eventCode.setEventCode(UUID.randomUUID().toString().replace("-",""));
                        eventCode.setEventSourceType("1");
                        eventCode.setEventSource(getCode(pack,"Code"));
                        eventCode.setEventType(Integer.parseInt(split[4]));
                        eventCode.setEventStartTime(sdf.parse(split[2]));
                        eventCode.setEventEndTime(sdf.parse(split[3]));
                        eventCode.setEventLevel(Integer.parseInt(split[5]));
                        eventCode.setEventDescribe(split[6]);
                        eventCodeService.insertEvent(eventCode);
                    }
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N103")) {  //提取实时事件列表
                    for (int i = 0;i < 3000;i++) {
                        value = getCode(pack, "H"+i);
                        if(value == null) return;
                        split = value.split(",");
                    }
                    //实时事件记录
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N131")) { //提取瞬时声级记录（一秒一个采样数据）
                    Connection connection= ConnectionFactory.createConnection(conf);
                    Table table=connection.getTable(TableName.valueOf("LpData_code"));
                    for (int i = 0; i < 10000; i++) {
                        value = getCode(pack, "H" + i);
                        if (value == null) return;
                        split = value.split(",");
                        Date datetime = simpleDateFormat.parse(split[2]);
                        LpDateCode lpDateCode = new LpDateCode();
                        lpDateCode.setNoiseCode(getCode(pack, "Code"));
                        lpDateCode.setMeasureTime(datetime);
                        if ("Lasp".equals(split[4])) {
                            lpDateCode.setLASP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLASP(0);
                        }
                        if ("Lafp".equals(split[4])) {
                            lpDateCode.setLAFP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLAFP(0);
                        }
                        if ("Laip".equals(split[4])) {
                            lpDateCode.setLAIP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLAIP(0);
                        }
                        if ("Lcsp".equals(split[4])) {
                            lpDateCode.setLCSP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLCSP(0);
                        }
                        if ("Lcfp".equals(split[4])) {
                            lpDateCode.setLCFP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLCFP(0);
                        }
                        if ("Lcip".equals(split[4])) {
                            lpDateCode.setLCIP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLCIP(0);
                        }
                        if ("Lzsp".equals(split[4])) {
                            lpDateCode.setLZSP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLZSP(0);
                        }
                        if ("Lzfp".equals(split[4])) {
                            lpDateCode.setLZFP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLZFP(0);
                        }
                        if ("Lzip".equals(split[4])) {
                            lpDateCode.setLZIP(Double.parseDouble(split[5]));
                        } else {
                            lpDateCode.setLZIP(0);
                        }
                        lpDateCode.setNormal("");
                        lpDateCode.setSift("");
                        lpDateService.saveLpDateCode(lpDateCode);

                        //存储到Hbase数据库中
                        Put put=new Put(Bytes.toBytes("measureTime"));
                        put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                        put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(String.valueOf(datetime)));
                        if ("Lasp".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lasp"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lasp"),Bytes.toBytes(0));
                        }
                        if ("Lafp".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lafp"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lafp"),Bytes.toBytes(0));
                        }
                        if ("Laip".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Laip"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Laip"),Bytes.toBytes(0));
                        }
                        if ("Lcsp".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lcsp"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lcsp"),Bytes.toBytes(0));
                        }
                        if ("Lcfp".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lcfp"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lcfp"),Bytes.toBytes(0));
                        }
                        if ("Lcip".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lcip"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lcip"),Bytes.toBytes(0));
                        }
                        if ("Lzsp".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lzsp"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lzsp"),Bytes.toBytes(0));
                        }
                        if ("Lzfp".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lzfp"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lzfp"),Bytes.toBytes(0));
                        }
                        if ("Lzip".equals(split[4])) {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lzip"),Bytes.toBytes(split[5]));
                        } else {
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Lzip"),Bytes.toBytes(0));
                        }
                        puts.add(put);
                    }
                    table.put(puts);
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N132")) { //提取OCT记录(频谱授权)
                    Connection connection= ConnectionFactory.createConnection(conf);
                    for (int i=0;i<3000;i++){
                        value = getCode(pack, "H"+i);
                        if (value == null) return;
                        split = value.split(","); //根据发送指令时给的参数选择是存到OCT中还是OCT31中
                        if(SendingInstruct.dataType == 0){
                            Table table=connection.getTable(TableName.valueOf("Oct31_code"));
                            ObservableList<Oct31Code> oct31Codes = oct31CodeService.queryAllOct31Code();
                            for (Oct31Code oct31Code : oct31Codes) {
                                if(!(oct31Code.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(oct31Code.getMeasureTime()).equals(sdf.format(split[2])))){
                                    Oct31Code oct31Code1 = new Oct31Code();
                                    oct31Code1.setNoiseCode(getCode(pack,"Code"));
                                    oct31Code1.setMeasureTime(sdf.parse(split[2]));
                                    oct31Code1.setMillisecond(Integer.parseInt(split[3]));
                                    oct31Code1.setHZ10(Double.parseDouble(split[4]));
                                    oct31Code1.setHZ12P5(Double.parseDouble(split[5]));
                                    oct31Code1.setHZ16(Double.parseDouble(split[6]));
                                    oct31Code1.setHZ20(Double.parseDouble(split[7]));
                                    oct31Code1.setHZ25(Double.parseDouble(split[8]));
                                    oct31Code1.setHZ31P5(Double.parseDouble(split[9]));
                                    oct31Code1.setHZ40(Double.parseDouble(split[10]));
                                    oct31Code1.setHZ50(Double.parseDouble(split[11]));
                                    oct31Code1.setHZ63(Double.parseDouble(split[12]));
                                    oct31Code1.setHZ80(Double.parseDouble(split[13]));
                                    oct31Code1.setHZ100(Double.parseDouble(split[14]));
                                    oct31Code1.setHZ125(Double.parseDouble(split[15]));
                                    oct31Code1.setHZ160(Double.parseDouble(split[16]));
                                    oct31Code1.setHZ200(Double.parseDouble(split[17]));
                                    oct31Code1.setHZ250(Double.parseDouble(split[18]));
                                    oct31Code1.setHZ315(Double.parseDouble(split[19]));
                                    oct31Code1.setHZ400(Double.parseDouble(split[20]));
                                    oct31Code1.setHZ500(Double.parseDouble(split[21]));
                                    oct31Code1.setHZ630(Double.parseDouble(split[22]));
                                    oct31Code1.setHZ800(Double.parseDouble(split[23]));
                                    oct31Code1.setHZ1000(Double.parseDouble(split[24]));
                                    oct31Code1.setHZ1250(Double.parseDouble(split[25]));
                                    oct31Code1.setHZ1600(Double.parseDouble(split[26]));
                                    oct31Code1.setHZ2000(Double.parseDouble(split[27]));
                                    oct31Code1.setHZ2500(Double.parseDouble(split[28]));
                                    oct31Code1.setHZ3150(Double.parseDouble(split[29]));
                                    oct31Code1.setHZ4000(Double.parseDouble(split[30]));
                                    oct31Code1.setHZ5000(Double.parseDouble(split[31]));
                                    oct31Code1.setHZ6300(Double.parseDouble(split[32]));
                                    oct31Code1.setHZ8000(Double.parseDouble(split[33]));
                                    oct31Code1.setHZ10000(Double.parseDouble(split[34]));
                                    oct31Code1.setHZ12500(Double.parseDouble(split[35]));
                                    oct31Code1.setHZ16000(Double.parseDouble(split[36]));
                                    oct31Code1.setHZ20000(Double.parseDouble(split[37]));
                                    //将接收到的数据放入一个对象内，存入数据库
                                    oct31CodeService.saveOct31Code(oct31Code1);
                                    Put put = new Put(Bytes.toBytes("oct31Code"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("Millisecond"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ10"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ12P5"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ16"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ20"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ25"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ31P5"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ40"),Bytes.toBytes(split[10]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ50"),Bytes.toBytes(split[11]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ63"),Bytes.toBytes(split[12]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ80"),Bytes.toBytes(split[13]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ100"),Bytes.toBytes(split[14]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ125"),Bytes.toBytes(split[15]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ160"),Bytes.toBytes(split[16]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ200"),Bytes.toBytes(split[17]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ250"),Bytes.toBytes(split[18]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ315"),Bytes.toBytes(split[19]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ400"),Bytes.toBytes(split[20]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ500"),Bytes.toBytes(split[21]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ630"),Bytes.toBytes(split[22]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ800"),Bytes.toBytes(split[23]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ1000"),Bytes.toBytes(split[24]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ1250"),Bytes.toBytes(split[25]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ1600"),Bytes.toBytes(split[26]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ2000"),Bytes.toBytes(split[27]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ2500"),Bytes.toBytes(split[28]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ3150"),Bytes.toBytes(split[29]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ4000"),Bytes.toBytes(split[30]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ5000"),Bytes.toBytes(split[31]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ6300"),Bytes.toBytes(split[32]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ8000"),Bytes.toBytes(split[33]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ10000"),Bytes.toBytes(split[34]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ12500"),Bytes.toBytes(split[35]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ16000"),Bytes.toBytes(split[36]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ20000"),Bytes.toBytes(split[37]));
                                    puts.add(put);
                                }else {
                                    continue;
                                }
                            }
                            table.put(puts);
                        }
                        if(SendingInstruct.dataType == 1){
                            ObservableList<OctCode> octCodes = octCodeService.queryAllOct();
                            Table table=connection.getTable(TableName.valueOf("Oct_code"));
                            for (OctCode octCode : octCodes) {
                                if(!(octCode.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(octCode.getMeasureTime()).equals(sdf.format(split[2])))){
                                    OctCode octCode1 = new OctCode();
                                    octCode1.setNoiseCode(getCode(pack,"Code"));
                                    octCode1.setMeasureTime(sdf.parse(split[2]));
                                    octCode1.setMillisecond(Integer.parseInt(split[3]));
                                    octCode1.setHZ16(Double.parseDouble(split[4]));
                                    octCode1.setHZ31P5(Double.parseDouble(split[5]));
                                    octCode1.setHZ63(Double.parseDouble(split[6]));
                                    octCode1.setHZ125(Double.parseDouble(split[7]));
                                    octCode1.setHZ250(Double.parseDouble(split[8]));
                                    octCode1.setHZ500(Double.parseDouble(split[9]));
                                    octCode1.setHZ1000(Double.parseDouble(split[10]));
                                    octCode1.setHZ2000(Double.parseDouble(split[11]));
                                    octCode1.setHZ4000(Double.parseDouble(split[12]));
                                    octCode1.setHZ8000(Double.parseDouble(split[13]));
                                    octCode1.setHZ16000(Double.parseDouble(split[14]));
                                    //将接收到的数据放入一个对象中存入数据库
                                    octCodeService.saveOctCode(octCode1);

                                    //存入Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("octCode"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes((split[3])));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ16"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ31P5"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ63"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ125"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ250"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ500"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ1000"),Bytes.toBytes(split[10]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ2000"),Bytes.toBytes(split[11]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ4000"),Bytes.toBytes(split[12]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ8000"),Bytes.toBytes(split[13]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("HZ16000"),Bytes.toBytes(split[14]));
                                    puts.add(put);
                                }else {
                                    continue;
                                }
                            }
                            table.put(puts);
                        }
                    }
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn")); //提取接收返回标记
                } else if (classes.equals("N133")) { //提取每秒的Leq历史数据
                    Connection connection=ConnectionFactory.createConnection(conf);
                    Table table=connection.getTable(TableName.valueOf("Leq1s_code"));
                    for (int i = 0; i < 10000; i++) {
                        value = getCode(pack, "H" + i);
                        if (value == null) return;
                        split = value.split(",");
                        Leq1SCode leq1SCode = new Leq1SCode();
                        leq1SCode.setNoiseCode(getCode(pack, "Code"));
                        leq1SCode.setMeasureTime(sdf.parse(split[2]));
                        leq1SCode.setLEQA(Double.parseDouble(split[3]));
                        leq1SCode.setLEQC(Double.parseDouble(split[4]));
                        leq1SCode.setLEQZ(Double.parseDouble(split[5]));
                        leq1sCodeService.saveLeq1sCode(leq1SCode);

                        //存入Hbase数据库中
                        System.out.println(".............添加数据..........");
                        System.out.println(table);
                        Put put=new Put(Bytes.toBytes("leq1s"));
                        put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                        put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                        put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LEQA"),Bytes.toBytes(split[3]));
                        put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LEQC"),Bytes.toBytes(split[4]));
                        put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LEQC"),Bytes.toBytes(split[5]));
                        puts.add(put);
                    }
                    table.put(puts);
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N130")) { //污染物分钟数据（读一段时间内的统计数据）
                    Connection connection=ConnectionFactory.createConnection(conf);
                    Table staTable=connection.getTable(TableName.valueOf("sta_code"));
                    Table hourStaTable=connection.getTable(TableName.valueOf("HourSta_code"));
                    Table dateStaTable=connection.getTable(TableName.valueOf("DateSta_code"));
                    for (int i = 0;i < 3000;i++) {
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        if(SendingInstruct.dataType == 0){
                            StaCode staCode = new StaCode();
                            staCode.setNoiseCode(getCode(pack,"Code"));
                            staCode.setMeasureTime(sdf.parse(split[2]));
                            staCode.setLeqT(Double.parseDouble(split[3]));
                            staCode.setLAF5(Double.parseDouble(split[4]));
                            staCode.setLAF10(Double.parseDouble(split[5]));
                            staCode.setLAF50(Double.parseDouble(split[6]));
                            staCode.setLAF90(Double.parseDouble(split[7]));
                            staCode.setLAF95(Double.parseDouble(split[8]));
                            staCode.setLAFmax(Double.parseDouble(split[9]));
                            staCode.setLAFmin(Double.parseDouble(split[10]));
                            staCode.setSD(Double.parseDouble(split[11]));
                            staCode.setNormal(null);
                            staCode.setSift(null);
                            staCode.setSoftRate(0);
                            staCode.setDetail(0);
                            staCode.setRate(Double.parseDouble(split[19]));
                            staCodeService.saveStaCode(staCode);
                            //保存到Hbase数据库中
                            Put put = new Put(Bytes.toBytes("staCode"));
                            put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                            put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LeqT"),Bytes.toBytes(split[3]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF5"),Bytes.toBytes(split[4]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF10"),Bytes.toBytes(split[5]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF50"),Bytes.toBytes(split[6]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF90"),Bytes.toBytes(split[7]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF95"),Bytes.toBytes(split[8]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAFmax"),Bytes.toBytes(split[9]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAFmin"),Bytes.toBytes(split[10]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SD"),Bytes.toBytes(split[11]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Normal"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Sift"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SoftRate"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Detail"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Rate"),Bytes.toBytes(split[19]));
                            puts.add(put);
                        }else if(SendingInstruct.dataType == 1){
                            HourStaCode hourStaCode = new HourStaCode();
                            hourStaCode.setNoiseCode(getCode(pack,"Code"));
                            hourStaCode.setMeasureTime(sdf.parse(split[2]));
                            hourStaCode.setLeqT(Double.parseDouble(split[3]));
                            hourStaCode.setLAF5(Double.parseDouble(split[4]));
                            hourStaCode.setLAF10(Double.parseDouble(split[5]));
                            hourStaCode.setLAF50(Double.parseDouble(split[6]));
                            hourStaCode.setLAF90(Double.parseDouble(split[7]));
                            hourStaCode.setLAF95(Double.parseDouble(split[8]));
                            hourStaCode.setLAFmax(Double.parseDouble(split[9]));
                            hourStaCode.setLAFmin(Double.parseDouble(split[10]));
                            hourStaCode.setSD(Double.parseDouble(split[11]));
                            hourStaCode.setNormal(null);
                            hourStaCode.setSift(null);
                            hourStaCode.setSoftRate(0);
                            hourStaCode.setRate(Double.parseDouble(split[19]));
                            hourStaCodeService.saveHourStaCode(hourStaCode);

                            //保存到Hbase数据库中
                            Put put = new Put(Bytes.toBytes("hourStaCode"));
                            put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                            put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LeqT"),Bytes.toBytes(split[3]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF5"),Bytes.toBytes(split[4]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF10"),Bytes.toBytes(split[5]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF50"),Bytes.toBytes(split[6]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF90"),Bytes.toBytes(split[7]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF95"),Bytes.toBytes(split[8]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAFmax"),Bytes.toBytes(split[9]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAFmin"),Bytes.toBytes(split[10]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SD"),Bytes.toBytes(split[11]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Normal"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Sift"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SoftRate"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Rate"),Bytes.toBytes(split[19]));
                            puts.add(put);
                        }else if(SendingInstruct.dataType == 2){
                            DateStaCode dateStaCode = new DateStaCode();
                            dateStaCode.setNoiseCode(getCode(pack,"Code"));
                            dateStaCode.setMeasureTime(sdf.parse(split[2]));
                            dateStaCode.setLeqT(Double.parseDouble(split[3]));
                            dateStaCode.setLAF5(Double.parseDouble(split[4]));
                            dateStaCode.setLAF10(Double.parseDouble(split[5]));
                            dateStaCode.setLAF50(Double.parseDouble(split[6]));
                            dateStaCode.setLAF90(Double.parseDouble(split[7]));
                            dateStaCode.setLAF95(Double.parseDouble(split[8]));
                            dateStaCode.setLAFmax(Double.parseDouble(split[9]));
                            dateStaCode.setLAFmin(Double.parseDouble(split[10]));
                            dateStaCode.setSD(Double.parseDouble(split[11]));
                            dateStaCode.setLd(Double.parseDouble(split[12]));
                            dateStaCode.setLn(Double.parseDouble(split[13]));
                            dateStaCode.setLdn(Double.parseDouble(split[14]));
                            dateStaCode.setNormal(null);
                            dateStaCode.setSift(null);
                            dateStaCode.setSoftRate(0);
                            if(split[19].equals("-")){
                                dateStaCode.setRate(0);
                            }
                            dateStaCodeService.saveDateStaCode(dateStaCode);

                            //保存到Hbase数据库中
                            Put put = new Put(Bytes.toBytes("hourStaCode"));
                            put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                            put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LeqT"),Bytes.toBytes(split[3]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF5"),Bytes.toBytes(split[4]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF10"),Bytes.toBytes(split[5]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF50"),Bytes.toBytes(split[6]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF90"),Bytes.toBytes(split[7]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAF95"),Bytes.toBytes(split[8]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAFmax"),Bytes.toBytes(split[9]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("LAFmin"),Bytes.toBytes(split[10]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SD"),Bytes.toBytes(split[11]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Ld"),Bytes.toBytes(split[12]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Ln"),Bytes.toBytes(split[13]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Ldn"),Bytes.toBytes(split[14]));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Normal"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Sift"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SoftRate"),Bytes.toBytes(0));
                            put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Rate"),Bytes.toBytes(split[19]));
                            puts.add(put);
                        }
                    }
                    if(SendingInstruct.dataType == 0){
                        staTable.put(puts);
                    }else if(SendingInstruct.dataType == 1){
                        hourStaTable.put(puts);
                    }else if(SendingInstruct.dataType == 2){
                        dateStaTable.put(puts);
                    }
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N134")) { //读气象历史数据
                    Connection connection=ConnectionFactory.createConnection(conf);
                    Table table = connection.getTable(TableName.valueOf("WeatherLp"));
                    for (int i = 0; i < 3000 ; i++) {
                        value = getCode(pack, "H"+i);
                        if(value == null) return;
                        split = value.split(",");
                        ObservableList<WeatherLP> result = weatherLPService.queryAll();
                        for (WeatherLP weatherLP : result) {
                            if (!(weatherLP.getNoiseCode().equals(getCode(pack, "Code"))) && !(weatherLP.getMeasureTime().equals(sdf.parse(split[2])))) {
                                WeatherLP weatherLP1 = new WeatherLP();
                                weatherLP1.setNoiseCode(getCode(pack,"Code"));
                                weatherLP1.setMeasureTime(sdf.parse(split[2]));
                                weatherLP1.setUnitTime(Integer.parseInt(split[3]));
                                if(split[2].equals("-")){
                                    weatherLP1.setW_Speed(0);
                                }else {
                                    weatherLP1.setW_Speed(Double.parseDouble(split[4]));
                                }
                                if(split[3].equals("-")){
                                    weatherLP1.setW_Direction(0);
                                }else {
                                    weatherLP1.setW_Direction(Double.parseDouble(split[5]));
                                }
                                if(split[4].equals("-")){
                                    weatherLP1.setA_Temp(0);
                                }else {
                                    weatherLP1.setA_Temp(Double.parseDouble(split[6]));
                                }
                                if(split[5].equals("-")){
                                    weatherLP1.setHumi_R(0);
                                }else {
                                    weatherLP1.setHumi_R(Double.parseDouble(split[7]));
                                }
                                if(split[6].equals("-")){
                                    weatherLP1.setAri_p(0);
                                }else {
                                    weatherLP1.setAri_p(Double.parseDouble(split[8]));
                                }
                                if(split[7].equals("-")){
                                    weatherLP1.setPRF(0);
                                }else {
                                    weatherLP1.setPRF(Double.parseDouble(split[9]));
                                }
                                //保存到数据库中
                                weatherLPService.saveWeatherLP(weatherLP1);

                                //保存到Hbase数据库中
                                Put put = new Put(Bytes.toBytes("weatherLp"));
                                put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("UnitTime"),Bytes.toBytes(split[3]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("W_Speed"),Bytes.toBytes(split[4]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("W_Direction"),Bytes.toBytes(split[5]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("A_Temp"),Bytes.toBytes(split[6]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Humi_R"),Bytes.toBytes(split[7]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Ari_p"),Bytes.toBytes(split[8]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PRF"),Bytes.toBytes(split[9]));
                                puts.add(put);
                            }else {
                                continue;
                            }
                        }
                    }
                    table.put(puts);
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N135")) { //读车流量历史数据
                    Connection connection=ConnectionFactory.createConnection(conf);
                    Table weatherLpTable = connection.getTable(TableName.valueOf("WeatherLp"));
                    Table weatherHourTable = connection.getTable(TableName.valueOf("WeatherHour"));
                    Table weatherDateTable = connection.getTable(TableName.valueOf("WeatherDate"));
                    Date date = new Date();
                    String hourTime = sdf.format(date.getTime()-60*60);
                    String dateTime = sdf.format(date.getTime()-60*60*24);
                    for (int i = 0 ; i < 10000 ; i++) {
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        ObservableList<CarFlowLP> result = carFlowLPService.queryAllCar();
                        for (CarFlowLP carFlowLP : result) {
                            if(!(carFlowLP.getNoiseCode().equals(getCode(pack,"Code"))) && !(carFlowLP.getMeasureTime().equals(sdf.parse(split[2])))){
                                CarFlowLP carFlowLP1 = new CarFlowLP();
                                carFlowLP1.setNoiseCode(getCode(pack,"Code"));
                                carFlowLP1.setMeasureTime(sdf.parse(split[2]));
                                carFlowLP1.setRadarID(split[3]);
                                carFlowLP1.setUnitTime(Integer.parseInt(split[4]));
                                carFlowLP1.setRoadWayNum(Integer.parseInt(split[5]));
                                carFlowLP1.setTotalFlux(Double.parseDouble(split[6]));
                                carFlowLP1.setOccupyRation(Double.parseDouble(split[7]));
                                carFlowLP1.setLongRation(Double.parseDouble(split[8]));
                                carFlowLP1.setMidRation(Double.parseDouble(split[9]));
                                carFlowLP1.setShortRation(Double.parseDouble(split[10]));
                                carFlowLP1.setAvgSpeed(Double.parseDouble(split[11]));
                                carFlowLP1.setLongSpeed(Double.parseDouble(split[12]));
                                carFlowLP1.setMidSpeed(Double.parseDouble(split[13]));
                                carFlowLP1.setShortSpeed(Double.parseDouble(split[14]));
                                carFlowLP1.setPreFlux(Double.parseDouble(split[15]));
                                carFlowLP1.setLongCarNums(Double.parseDouble(split[16]));
                                carFlowLP1.setMidCarNums(Double.parseDouble(split[17]));
                                carFlowLP1.setShortCarNums(Double.parseDouble(split[18]));
                                //保存到数据库中
                                carFlowLPService.saveCarFlow(carFlowLP1);

                                //保存到Hbase数据库中
                                Put put = new Put(Bytes.toBytes("carFlowLp"));
                                put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("radarID"),Bytes.toBytes(split[3]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[4]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("roadWayNum"),Bytes.toBytes(split[5]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("totalFlux"),Bytes.toBytes(split[6]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("occupyRation"),Bytes.toBytes(split[7]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longRation"),Bytes.toBytes(split[8]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midRation"),Bytes.toBytes(split[9]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortRation"),Bytes.toBytes(split[10]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("avgSpeed"),Bytes.toBytes(split[11]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longSpeed"),Bytes.toBytes(split[12]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midSpeed"),Bytes.toBytes(split[13]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortSpeed"),Bytes.toBytes(split[14]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("preFlux"),Bytes.toBytes(split[15]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longCarNums"),Bytes.toBytes(split[16]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midCarNums"),Bytes.toBytes(split[17]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortCarNums"),Bytes.toBytes(split[18]));
                                puts.add(put);
                            }else {
                                continue;
                            }
                        }
                        weatherLpTable.put(puts);
                        //小时统计数据
                        if(hourTime.equals(sdf.format(split[2]))){
                            ObservableList<CarFlowHour> carFlowHours = carFlowHourService.queryAllCarHour();
                            for (CarFlowHour carFlowHour : carFlowHours) {
                                if(!(carFlowHour.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(carFlowHour.getMeasureTime()).equals(sdf.format(split[2])))){
                                    CarFlowHour carFlowHour1 = new CarFlowHour();
                                    carFlowHour1.setNoiseCode(getCode(pack,"Code"));
                                    carFlowHour1.setMeasureTime(sdf.parse(split[2]));
                                    carFlowHour1.setRadarID(split[3]);
                                    carFlowHour1.setUnitTime(Integer.parseInt(split[4]));
                                    carFlowHour1.setRoadWayNum(Integer.parseInt(split[5]));
                                    carFlowHour1.setTotalFlux(Double.parseDouble(split[6]));
                                    carFlowHour1.setOccupyRation(Double.parseDouble(split[7]));
                                    carFlowHour1.setLongRation(Double.parseDouble(split[8]));
                                    carFlowHour1.setMidRation(Double.parseDouble(split[9]));
                                    carFlowHour1.setShortRation(Double.parseDouble(split[10]));
                                    carFlowHour1.setAvgSpeed(Double.parseDouble(split[11]));
                                    carFlowHour1.setLongSpeed(Double.parseDouble(split[12]));
                                    carFlowHour1.setMidSpeed(Double.parseDouble(split[13]));
                                    carFlowHour1.setShortSpeed(Double.parseDouble(split[14]));
                                    carFlowHour1.setPreFlux(Double.parseDouble(split[15]));
                                    carFlowHour1.setLongCarNums(Double.parseDouble(split[16]));
                                    carFlowHour1.setMidCarNums(Double.parseDouble(split[17]));
                                    carFlowHour1.setShortCarNums(Double.parseDouble(split[18]));
                                    carFlowHourService.saveCarFlowHour(carFlowHour1);

                                    //保存到Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("carFlowHour"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("radarID"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("roadWayNum"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("totalFlux"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("occupyRation"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longRation"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midRation"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortRation"),Bytes.toBytes(split[10]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("avgSpeed"),Bytes.toBytes(split[11]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longSpeed"),Bytes.toBytes(split[12]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midSpeed"),Bytes.toBytes(split[13]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortSpeed"),Bytes.toBytes(split[14]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("preFlux"),Bytes.toBytes(split[15]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longCarNums"),Bytes.toBytes(split[16]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midCarNums"),Bytes.toBytes(split[17]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortCarNums"),Bytes.toBytes(split[18]));
                                    HourPuts.add(put);
                                }
                            }
                        }else {
                            continue;
                        }
                        hourTime = sdf.format(date.getTime() - 60*60);
                    }
                    weatherHourTable.put(HourPuts);
                    //天统计数据
                    for (int i=0;i<10000;i++){
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        if(sdf.format(dateTime).equals(split[2])){
                            ObservableList<CarFlowDate> carFlowDates = carFlowDateService.queryAllCarDate();
                            for (CarFlowDate carFlowDate : carFlowDates) {
                                if(!(carFlowDate.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(carFlowDate.getMeasureTime()).equals(sdf.format(split[2])))){
                                    CarFlowDate carFlowDate1 = new CarFlowDate();
                                    carFlowDate1.setNoiseCode(getCode(pack,"Code"));
                                    carFlowDate1.setMeasureTime(sdf.parse(split[2]));
                                    carFlowDate1.setRadarID(split[3]);
                                    carFlowDate1.setUnitTime(Integer.parseInt(split[4]));
                                    carFlowDate1.setRoadWayNum(Integer.parseInt(split[5]));
                                    carFlowDate1.setTotalFlux(Double.parseDouble(split[6]));
                                    carFlowDate1.setOccupyRation(Double.parseDouble(split[7]));
                                    carFlowDate1.setLongRation(Double.parseDouble(split[8]));
                                    carFlowDate1.setMidRation(Double.parseDouble(split[9]));
                                    carFlowDate1.setShortRation(Double.parseDouble(split[10]));
                                    carFlowDate1.setAvgSpeed(Double.parseDouble(split[11]));
                                    carFlowDate1.setLongSpeed(Double.parseDouble(split[12]));
                                    carFlowDate1.setMidSpeed(Double.parseDouble(split[13]));
                                    carFlowDate1.setShortSpeed(Double.parseDouble(split[14]));
                                    carFlowDate1.setPreFlux(Double.parseDouble(split[15]));
                                    carFlowDate1.setLongCarNums(Double.parseDouble(split[16]));
                                    carFlowDate1.setMidCarNums(Double.parseDouble(split[17]));
                                    carFlowDate1.setShortCarNums(Double.parseDouble(split[18]));
                                    carFlowDateService.saveCarFlowDate(carFlowDate1);

                                    //保存到Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("carFlowDate"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("radarID"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("roadWayNum"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("totalFlux"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("occupyRation"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longRation"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midRation"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortRation"),Bytes.toBytes(split[10]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("avgSpeed"),Bytes.toBytes(split[11]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longSpeed"),Bytes.toBytes(split[12]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midSpeed"),Bytes.toBytes(split[13]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortSpeed"),Bytes.toBytes(split[14]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("preFlux"),Bytes.toBytes(split[15]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("longCarNums"),Bytes.toBytes(split[16]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("midCarNums"),Bytes.toBytes(split[17]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("shortCarNums"),Bytes.toBytes(split[18]));
                                    DatePuts.add(put);
                                }
                            }
                        }else {
                            continue;
                        }
                        dateTime = sdf.format(date.getTime() - 60*60*24);
                    }
                    weatherDateTable.put(DatePuts);
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N136")) { //读粉尘历史数据
                    Connection connection=ConnectionFactory.createConnection(conf);
                    Table dustLpTable = connection.getTable(TableName.valueOf("dustLp"));
                    Table dustHourTable = connection.getTable(TableName.valueOf("dustHour"));
                    Table dustDateTable = connection.getTable(TableName.valueOf("dustDate"));
                    Date date = new Date();
                    String hourTime = sdf.format(date.getTime()-60*60);
                    String dateTime = sdf.format(date.getTime()-60*60*24);
                    for (int i = 0; i<3000; i++) {
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        ObservableList<DustLP> dustLPS = dustLPService.queryAllDustLP();
                        for (DustLP dustLP : dustLPS) {
                            if(!(dustLP.getNoiseCode().equals(getCode(pack,"Code"))) && !(dustLP.getMeasureTime().equals(sdf.parse(split[2])))){
                                DustLP dustLP1 = new DustLP();
                                dustLP1.setNoiseCode(getCode(pack,"Code"));
                                dustLP1.setMeasureTime(sdf.parse(split[2]));
                                dustLP1.setUnitTime(Integer.parseInt(split[3]));
                                if(split[4].equals("-")){
                                    dustLP1.setTSP(0);
                                }else {
                                    dustLP1.setTSP(Double.parseDouble(split[4]));
                                }
                                if(split[5].equals("-")){
                                    dustLP1.setPM10(0);
                                }else {
                                    dustLP1.setPM10(Double.parseDouble(split[5]));
                                }
                                if(split[6].equals("-")){
                                    dustLP1.setPM2_5(0);
                                }else {
                                    dustLP1.setPM2_5(Double.parseDouble(split[6]));
                                }
                                if(split[7].equals("-")){
                                    dustLP1.setSOx(0);
                                }else {
                                    dustLP1.setSOx(Double.parseDouble(split[7]));
                                }
                                if(split[8].equals("-")){
                                    dustLP1.setNOx(0);
                                }else {
                                    dustLP1.setNOx(Double.parseDouble(split[8]));
                                }
                                if(split[9].equals("-")){
                                    dustLP1.setAnion(0);
                                }else {
                                    dustLP1.setAnion(Double.parseDouble(split[9]));
                                }
                                dustLPService.saveDustLp(dustLP1);

                                //保存到Hbase数据库中
                                Put put = new Put(Bytes.toBytes("dustLp"));
                                put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[3]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("TSP"),Bytes.toBytes(split[4]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PM10"),Bytes.toBytes(split[5]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PM2_5"),Bytes.toBytes(split[6]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SOx"),Bytes.toBytes(split[7]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("NOx"),Bytes.toBytes(split[8]));
                                put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Anion"),Bytes.toBytes(split[9]));
                                puts.add(put);
                            }else {
                                continue;
                            }
                        }
                    }
                    dustLpTable.put(puts);
                    //小时统计
                    for (int i=0;i<3000;i++){
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        if(hourTime.equals(sdf.format(split[2]))){
                            ObservableList<DustHour> dustHours = dustHourService.queryAllDustHour();
                            for (DustHour dustHour : dustHours) {
                                if(!(dustHour.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(dustHour.getMeasureTime()).equals(sdf.format(split[2])))){
                                    DustHour dustHour1 = new DustHour();
                                    dustHour1.setNoiseCode(getCode(pack,"Code"));
                                    dustHour1.setMeasureTime(sdf.parse(split[2]));
                                    dustHour1.setUnitTime(Integer.parseInt(split[3]));
                                    dustHour1.setTSP(Double.parseDouble(split[4]));
                                    dustHour1.setPM10(Double.parseDouble(split[5]));
                                    dustHour1.setPM2_5(Double.parseDouble(split[6]));
                                    dustHour1.setSOx(Double.parseDouble(split[7]));
                                    dustHour1.setNOx(Double.parseDouble(split[8]));
                                    dustHour1.setAnion(Double.parseDouble(split[9]));
                                    dustHour1.setMaxTSP(0);
                                    dustHour1.setMinTSP(0);
                                    dustHour1.setMaxPM10(0);
                                    dustHour1.setMinPM10(0);
                                    dustHour1.setMaxPM25(0);
                                    dustHour1.setMinPM25(0);
                                    dustHour1.setMaxSOx(0);
                                    dustHour1.setMinSOx(0);
                                    dustHour1.setMaxNOx(0);
                                    dustHour1.setMinNOx(0);
                                    dustHour1.setMaxAnion(0);
                                    dustHour1.setMinAnion(0);
                                    dustHourService.saveDustHour(dustHour1);

                                    //保存到Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("dustHour"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("TSP"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PM10"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PM2_5"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SOx"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("NOx"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Anion"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxTSP"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minTSP"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxPM10"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minPM10"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxPM25"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minPM25"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxSOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minSOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxNOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minNOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxAnion"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minAnion"),Bytes.toBytes(0));
                                    HourPuts.add(put);
                                }else {
                                    continue;
                                }
                            }
                        }else {
                            continue;
                        }
                        hourTime = sdf.format(date.getTime()-60*60);
                    }
                    dustHourTable.put(puts);
                    //天统计
                    for (int i=0;i<3000;i++){
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        if(dateTime.equals(sdf.format(split[2]))){
                            ObservableList<DustDate> dustDates = dustDateService.queryAllDustDate();
                            for (DustDate dustDate : dustDates) {
                                if(!(dustDate.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(dustDate.getMeasureTime()).equals(sdf.format(split[2])))){
                                    DustDate dustDate1 = new DustDate();
                                    dustDate1.setNoiseCode(getCode(pack,"Code"));
                                    dustDate1.setMeasureTime(sdf.parse(split[2]));
                                    dustDate1.setUnitTime(Integer.parseInt(split[3]));
                                    dustDate1.setTSP(Double.parseDouble(split[4]));
                                    dustDate1.setPM10(Double.parseDouble(split[5]));
                                    dustDate1.setPM2_5(Double.parseDouble(split[6]));
                                    dustDate1.setSOx(Double.parseDouble(split[7]));
                                    dustDate1.setNOx(Double.parseDouble(split[8]));
                                    dustDate1.setAnion(Double.parseDouble(split[9]));
                                    dustDate1.setMaxTSP(0);
                                    dustDate1.setMinTSP(0);
                                    dustDate1.setMaxPM10(0);
                                    dustDate1.setMinPM10(0);
                                    dustDate1.setMaxPM25(0);
                                    dustDate1.setMinPM25(0);
                                    dustDate1.setMaxSOx(0);
                                    dustDate1.setMinSOx(0);
                                    dustDate1.setMaxNOx(0);
                                    dustDate1.setMinNOx(0);
                                    dustDate1.setMaxAnion(0);
                                    dustDate1.setMinAnion(0);
                                    dustDateService.saveDustDate(dustDate1);

                                    //保存到Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("dustDate"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("TSP"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PM10"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PM2_5"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("SOx"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("NOx"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("Anion"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxTSP"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minTSP"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxPM10"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minPM10"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxPM25"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minPM25"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxSOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minSOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxNOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minNOx"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxAnion"),Bytes.toBytes(0));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minAnion"),Bytes.toBytes(0));
                                    DatePuts.add(put);
                                }else {
                                    continue;
                                }
                            }
                        }else {
                            continue;
                        }
                        dateTime = sdf.format(date.getTime()-60*60*24);
                    }
                    dustDateTable.put(DatePuts);
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N137")) { //读气象统计历史数据
                    Connection connection=ConnectionFactory.createConnection(conf);
                    Table weatherHourTable = connection.getTable(TableName.valueOf("weatherHour"));
                    Table weatherDateTable = connection.getTable(TableName.valueOf("weatherDate"));
                    Date date = new Date();
                    String hourTime = sdf.format(date.getTime()-60*60);
                    String dateTime = sdf.format(date.getTime()-60*60*24);
                    for (int i = 0;i < 3000;i++) {
                        value = getCode(pack, "H" + i);
                        if (value == null) return;
                        split = value.split(",");
                        if (hourTime.equals(sdf.format(split[2]))) {
                            ObservableList<WeatherHour> weatherHours = weatherHourService.queryAllWeaHour();
                            for (WeatherHour weatherHour : weatherHours) {
                                if (!(weatherHour.getNoiseCode().equals(getCode(pack, "Code"))) && !(sdf.format(weatherHour.getMeasureTime()).equals(sdf.format(split[2])))) {
                                    WeatherHour weatherHour1 = new WeatherHour();
                                    weatherHour1.setNoiseCode(getCode(pack, "Code"));
                                    weatherHour1.setMeasureTime(sdf.parse(split[2]));
                                    weatherHour1.setUnitTime(Integer.parseInt(split[3]));
                                    weatherHour1.setW_Speed(Double.parseDouble(split[4]));
                                    weatherHour1.setW_Direction(Double.parseDouble(split[5]));
                                    weatherHour1.setA_Temp(Double.parseDouble(split[6]));
                                    weatherHour1.setHumi_R(Double.parseDouble(split[7]));
                                    weatherHour1.setAri_p(Double.parseDouble(split[8]));
                                    weatherHour1.setPRF(Double.parseDouble(split[9]));
                                    weatherHour1.setMaxSpeed(Double.parseDouble(split[10]));
                                    weatherHour1.setMinSpeed(Double.parseDouble(split[11]));
                                    weatherHour1.setMaxAtemp(Double.parseDouble(split[12]));
                                    weatherHour1.setMinAtemp(Double.parseDouble(split[13]));
                                    weatherHour1.setMaxHumi(Double.parseDouble(split[14]));
                                    weatherHour1.setMinHumi(Double.parseDouble(split[15]));
                                    weatherHour1.setMaxAri(Double.parseDouble(split[16]));
                                    weatherHour1.setMinAri(Double.parseDouble(split[17]));
                                    weatherHourService.saveWeatherHour(weatherHour1);

                                    //保存到Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("weatherHour"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("w_Speed"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("w_Direction"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("a_Temp"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("humi_R"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("ari_p"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PRF"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxSpeed"),Bytes.toBytes(split[10]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minSpeed"),Bytes.toBytes(split[11]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxAtemp"),Bytes.toBytes(split[12]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minAtemp"),Bytes.toBytes(split[13]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxHumi"),Bytes.toBytes(split[14]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minHumi"),Bytes.toBytes(split[15]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxAri"),Bytes.toBytes(split[16]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minAri"),Bytes.toBytes(split[17]));
                                    HourPuts.add(put);
                                } else {
                                    continue;
                                }
                            }
                        }else {
                            continue;
                        }
                        hourTime = sdf.format(date.getTime() - 60*60);
                    }
                    weatherHourTable.put(HourPuts);
                    //天统计
                    for (int i=0;i<3000;i++){
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        if(dateTime.equals(sdf.format(split[2]))){
                            ObservableList<WeatherDate> weatherDates = weatherDateService.queryAllWeaDate();
                            for (WeatherDate weatherDate : weatherDates) {
                                if(!(weatherDate.getNoiseCode().equals(getCode(pack,"Code"))) && !(sdf.format(weatherDate.getMeasureTime()).equals(sdf.format(split[2])))){
                                    WeatherDate weatherDate1 = new WeatherDate();
                                    weatherDate1.setNoiseCode(getCode(pack,"Code"));
                                    weatherDate1.setMeasureTime(sdf.parse(split[2]));
                                    weatherDate1.setUnitTime(Integer.parseInt(split[3]));
                                    weatherDate1.setW_Speed(Double.parseDouble(split[4]));
                                    weatherDate1.setW_Direction(Double.parseDouble(split[5]));
                                    weatherDate1.setA_Temp(Double.parseDouble(split[6]));
                                    weatherDate1.setHumi_R(Double.parseDouble(split[7]));
                                    weatherDate1.setAri_p(Double.parseDouble(split[8]));
                                    weatherDate1.setPRF(Double.parseDouble(split[9]));
                                    weatherDate1.setMaxSpeed(Double.parseDouble(split[10]));
                                    weatherDate1.setMinSpeed(Double.parseDouble(split[11]));
                                    weatherDate1.setMaxAtemp(Double.parseDouble(split[12]));
                                    weatherDate1.setMinAtemp(Double.parseDouble(split[13]));
                                    weatherDate1.setMaxHumi(Double.parseDouble(split[14]));
                                    weatherDate1.setMinHumi(Double.parseDouble(split[15]));
                                    weatherDate1.setMaxAri(Double.parseDouble(split[16]));
                                    weatherDate1.setMinAri(Double.parseDouble(split[17]));
                                    weatherDateService.saveWeatherDate(weatherDate1);

                                    //保存到Hbase数据库中
                                    Put put = new Put(Bytes.toBytes("weatherDate"));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("noiseCode"),Bytes.toBytes(getCode(pack,"Code")));
                                    put.addColumn(Bytes.toBytes("info1"),Bytes.toBytes("measureTime"),Bytes.toBytes(sdf.format(sdf.parse(split[2]))));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("unitTime"),Bytes.toBytes(split[3]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("w_Speed"),Bytes.toBytes(split[4]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("w_Direction"),Bytes.toBytes(split[5]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("a_Temp"),Bytes.toBytes(split[6]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("humi_R"),Bytes.toBytes(split[7]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("ari_p"),Bytes.toBytes(split[8]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("PRF"),Bytes.toBytes(split[9]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxSpeed"),Bytes.toBytes(split[10]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minSpeed"),Bytes.toBytes(split[11]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxAtemp"),Bytes.toBytes(split[12]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minAtemp"),Bytes.toBytes(split[13]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxHumi"),Bytes.toBytes(split[14]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minHumi"),Bytes.toBytes(split[15]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("maxAri"),Bytes.toBytes(split[16]));
                                    put.addColumn(Bytes.toBytes("info2"),Bytes.toBytes("minAri"),Bytes.toBytes(split[17]));
                                    DatePuts.add(put);
                                }else {
                                    continue;
                                }
                            }
                        }else {
                            continue;
                        }
                        dateTime = sdf.format(date.getTime() - 60*60*24);
                    }
                    weatherDateTable.put(DatePuts);
                    //需要循环提取，提取成功则添加到数据库，提取失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N140")) { //及时采样命令（心跳指令）
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    if(value != null){

                    }
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N141")) { //提取设备状态
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.stateNoise.setWindSpeed(Double.parseDouble(split[0]));
                    NoiseDeviceManageController.stateNoise.setOutTemperature(Double.parseDouble(split[1]));
                    NoiseDeviceManageController.stateNoise.setHumi_R(Double.parseDouble(split[2]));
                    NoiseDeviceManageController.stateNoise.setAriPressure(Double.parseDouble(split[3]));
                    NoiseDeviceManageController.stateNoise.setRainfall(Double.parseDouble(split[4]));
                    NoiseDeviceManageController.stateNoise.setBatteryVoltage(Double.parseDouble(split[5]));
                    NoiseDeviceManageController.stateNoise.setWorkingVoltage(Double.parseDouble(split[6]));
                    NoiseDeviceManageController.stateNoise.setHumidity(Double.parseDouble(split[7]));
                    NoiseDeviceManageController.stateNoise.setTemperature(Double.parseDouble(split[8]));
                    NoiseDeviceManageController.stateNoise.setLongitude(Double.parseDouble(split[9]));
                    NoiseDeviceManageController.stateNoise.setLatitude(Double.parseDouble(split[10]));
                    NoiseDeviceManageController.stateNoise.setSpeed(Double.parseDouble(split[11]));
                    NoiseDeviceManageController.stateNoise.setUsedRoom(Double.parseDouble(split[12]));
                    NoiseDeviceManageController.stateNoise.setFreeRoom(Double.parseDouble(split[13]));
                    //提取成功则把数据传入一个状态对象中，通过对象的属性传输到该设备前端管理的状态界面，失败则发送操作失败指令
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N143")) { //录音启动和终止指令
                    value = getCode(pack, "Value");
                    if(value != null){
                        split = value.split("/");
                    }
                    //在操作成功时会返回该次录音的文件和路径
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N144")) { //录像启动和终止指令
                    value = getCode(pack, "Value");
                    if(value != null){

                    }
                    //在操作成功时会返回该次录像的文件和路径
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N145")) { //拍照指令
                    value = getCode(pack, "Value");
                    if(value != null){
                        split = value.split("/");
                        System.out.println(split[3]);
                        NoiseDeviceManageController.makePhoto.setImage(new Image(split[3]));
                    }
                    //在操作成功时会返回该次拍照的文件和路径
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N146")) { //显示屏节目回读
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功返回的是显示屏类型和节目数据包
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N147")) { //灵敏度读取
                    value = getCode(pack, "Value");
                    //成功返回的是灵敏度数据
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N042")) { //数据传输指令（下传上）
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功则会返回两个数据，一个是发往下位机的哪个输出口，一个是发送的内容
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N150")) { //提取服务器参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功会返回两个数据，一个是服务器IP，一个是连接端口号
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N152")) { //提取网卡参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功则返回本机IP、子网掩码、默认网关、DNS服务器IP
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N160")) { //提取授权参数
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setHasAll(Integer.parseInt(split[0]));
                    NoiseDeviceManageController.infoNoiseManager.setHasOct(Integer.parseInt(split[1]));
                    NoiseDeviceManageController.infoNoiseManager.setHasRecord(Integer.parseInt(split[2]));
                    NoiseDeviceManageController.infoNoiseManager.setHasSoundtrans(Integer.parseInt(split[3]));
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N171")) { //升级文件分块传输请求
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //返回4个数据：文件名称、传输起始位置、传输长度、传输数据
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N172")) { //检查升级文件传输完成情况
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //返回的是文件传输百分比，如果百分比为-1，表示该文件不接收
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N174")) { //读取当前版本
                    value = getCode(pack, "H0");
                    split = value.split(",");
                    NoiseDeviceManageController.infoNoiseManager.setVersion_Hardware(split[0]);
                    NoiseDeviceManageController.infoNoiseManager.setVersion_Linux(split[1]);
                    NoiseDeviceManageController.infoNoiseManager.setVersion_N_VIEW(split[2]);
                    NoiseDeviceManageController.infoNoiseManager.setVersion_NoiseMonitor(split[3]);
                    String result = getCode(pack, "H1");
                    String[] split1 = result.split(",");
                    //H1中返回的是软件编译时间
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N178")) { //读取仪器当前通信协议版本
                    value = getCode(pack, "Value");
                    //返回的是当前通信协议版本
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N180")) { //读取目录中的文件信息
                    for (int i = 0;i < 3000;i++) {
                        value = getCode(pack, "H"+i);
                        if(value == null)return;
                        split = value.split(",");
                        NoiseDeviceManageController.noiseFile.setNoiseCode(getCode(pack,"Code"));
                        NoiseDeviceManageController.noiseFile.setFileName(split[2]);
                        NoiseDeviceManageController.noiseFile.setFileType(split[3]);
                        NoiseDeviceManageController.noiseFile.setFileDateTime(sdf.parse(split[5]));
                        NoiseDeviceManageController.fileList.add(NoiseDeviceManageController.noiseFile);
                    }
                    //通过循环获取，文件名或者文件夹、type中0表示文件，1表示文件夹、文件大小、修改时间，跟目录为“/”
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N181")) { //读取文件
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    NoiseDeviceManageController.oneNoiseFile.setFileName(split[2]);
                    NoiseDeviceManageController.oneNoiseFile.setFileSize((split[3]));
                    NoiseDeviceManageController.oneNoiseFile.setFileOffset(Integer.valueOf(split[4]));
                    NoiseDeviceManageController.oneNoiseFile.setFileDataSize(Integer.valueOf(split[5]));
                    NoiseDeviceManageController.oneNoiseFile.setFileData(split[6]);
                    //返回的是文件名、文件大小、当前包中的数据在录音文件的偏移地址、当前包中数据的大小
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N001")) { //实时瞬时声级自动上传命令
                    value = getCode(pack, "Value");
                    if (value == null)continue;
                    split = value.split(",");
                    deviceCode = getCode(pack, "Code");
                    if(MoreInfoController.dummyData != null) {
                        for (MoreInfoController.StateDevice stateDevice : MoreInfoController.stateDevices) {
                            for (MoreInfoController.StateDevice dummyDatum : MoreInfoController.dummyData) {
                                if (stateDevice.getDeviceCode().equals(dummyDatum.getDeviceCode())) {
                                    if (deviceCode.equals(stateDevice.getDeviceCode())) {
                                        stateDevice.setDataTime(getCode(pack, "Flag"));
                                        stateDevice.setData(split[0]);
                                        flag = stateDevice.getDataTime();
                                        data = stateDevice.getData();
                                    }
                                }
                            }
                        }
                    }
                    //接收的数据个数不是固定的，根据开关量判断传入的是哪种数据，提取第一个数据放入表格中显示
                } else if (classes.equals("N010")) { //OCT数据自动上传命令
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功会返回的数据类型、时间、时间的毫秒部分、data是数据
                    //数据类型为1/3OCT时，会有34个数据
                    if(split[0].equals("0")){
                        Oct31Code oct31Code = new Oct31Code();
                        oct31Code.setNoiseCode(getCode(pack,"Code"));
                        oct31Code.setMeasureTime(sdf.parse(split[1]));
                        oct31Code.setMillisecond(Integer.parseInt(split[2]));
                        oct31Code.setHZ10(Double.parseDouble(split[3]));
                        oct31Code.setHZ12P5(Double.parseDouble(split[4]));
                        oct31Code.setHZ16(Double.parseDouble(split[5]));
                        oct31Code.setHZ20(Double.parseDouble(split[6]));
                        oct31Code.setHZ25(Double.parseDouble(split[7]));
                        oct31Code.setHZ31P5(Double.parseDouble(split[8]));
                        oct31Code.setHZ40(Double.parseDouble(split[9]));
                        oct31Code.setHZ50(Double.parseDouble(split[10]));
                        oct31Code.setHZ63(Double.parseDouble(split[11]));
                        oct31Code.setHZ80(Double.parseDouble(split[12]));
                        oct31Code.setHZ100(Double.parseDouble(split[13]));
                        oct31Code.setHZ125(Double.parseDouble(split[14]));
                        oct31Code.setHZ160(Double.parseDouble(split[15]));
                        oct31Code.setHZ200(Double.parseDouble(split[16]));
                        oct31Code.setHZ250(Double.parseDouble(split[17]));
                        oct31Code.setHZ315(Double.parseDouble(split[18]));
                        oct31Code.setHZ400(Double.parseDouble(split[19]));
                        oct31Code.setHZ500(Double.parseDouble(split[20]));
                        oct31Code.setHZ630(Double.parseDouble(split[21]));
                        oct31Code.setHZ800(Double.parseDouble(split[22]));
                        oct31Code.setHZ1000(Double.parseDouble(split[23]));
                        oct31Code.setHZ1250(Double.parseDouble(split[24]));
                        oct31Code.setHZ1600(Double.parseDouble(split[25]));
                        oct31Code.setHZ2000(Double.parseDouble(split[26]));
                        oct31Code.setHZ2500(Double.parseDouble(split[27]));
                        oct31Code.setHZ3150(Double.parseDouble(split[28]));
                        oct31Code.setHZ4000(Double.parseDouble(split[29]));
                        oct31Code.setHZ5000(Double.parseDouble(split[30]));
                        oct31Code.setHZ6300(Double.parseDouble(split[31]));
                        oct31Code.setHZ8000(Double.parseDouble(split[32]));
                        oct31Code.setHZ10000(Double.parseDouble(split[33]));
                        oct31Code.setHZ12500(Double.parseDouble(split[34]));
                        oct31Code.setHZ16000(Double.parseDouble(split[35]));
                        oct31Code.setHZ20000(Double.parseDouble(split[36]));
                        //将接收到的数据放入一个对象内，存入数据库
                        oct31CodeService.saveOct31Code(oct31Code);
                    }else if(split[0].equals(0)){//数据类型为1/10OCT时，会有11个数据
                        OctCode octCode = new OctCode();
                        octCode.setNoiseCode(getCode(pack,"Code"));
                        octCode.setMeasureTime(sdf.parse(split[1]));
                        octCode.setMillisecond(Integer.parseInt(split[2]));
                        octCode.setHZ16(Double.parseDouble(split[3]));
                        octCode.setHZ31P5(Double.parseDouble(split[4]));
                        octCode.setHZ63(Double.parseDouble(split[5]));
                        octCode.setHZ125(Double.parseDouble(split[6]));
                        octCode.setHZ250(Double.parseDouble(split[7]));
                        octCode.setHZ500(Double.parseDouble(split[8]));
                        octCode.setHZ1000(Double.parseDouble(split[9]));
                        octCode.setHZ2000(Double.parseDouble(split[10]));
                        octCode.setHZ4000(Double.parseDouble(split[11]));
                        octCode.setHZ8000(Double.parseDouble(split[12]));
                        octCode.setHZ16000(Double.parseDouble(split[13]));
                        //将接收到的数据放入一个对象中存入数据库
                        octCodeService.saveOctCode(octCode);
                    }
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N011")) { //实时积分统计声级自动上传命令
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功返回数据类型：0为积分统计数据； 1为小时统计数据；2为天统计数据
                    //以及数据后面数据可以会变化，根据字段名存入数据
                    //rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N012")) { //录音文件自动上传(录音授权)
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功返回数据：录音文件名、文件大小、当前包中数据在录音文件的偏移地址、包中数据大小
                    rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N013")) { //气象数据自动上传命令
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功返回风速、风向、温度、湿度、大气压、雨量、单位时间
                    WeatherLP weatherLP = new WeatherLP();
                    weatherLP.setNoiseCode(getCode(pack,"Code"));
                    weatherLP.setMeasureTime(sdf.parse(split[0]));
                    weatherLP.setUnitTime(Integer.parseInt(split[1]));
                    if(split[2].equals("-")){
                        weatherLP.setW_Speed(0);
                    }else {
                        weatherLP.setW_Speed(Double.parseDouble(split[2]));
                    }
                    if(split[3].equals("-")){
                        weatherLP.setW_Direction(0);
                    }else {
                        weatherLP.setW_Direction(Double.parseDouble(split[3]));
                    }
                    if(split[4].equals("-")){
                        weatherLP.setA_Temp(0);
                    }else {
                        weatherLP.setA_Temp(Double.parseDouble(split[4]));
                    }
                    if(split[5].equals("-")){
                        weatherLP.setHumi_R(0);
                    }else {
                        weatherLP.setHumi_R(Double.parseDouble(split[5]));
                    }
                    if(split[6].equals("-")){
                        weatherLP.setAri_p(0);
                    }else {
                        weatherLP.setAri_p(Double.parseDouble(split[6]));
                    }
                    if(split[7].equals("-")){
                        weatherLP.setPRF(0);
                    }else {
                        weatherLP.setPRF(Double.parseDouble(split[7]));
                    }
                    //保存到数据库中
                    weatherLPService.saveWeatherLP(weatherLP);
                    //当接收数据为-时，表示没有数据
                    //rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N014")) { //车流量数据自动上传命令
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功返回雷达编号、车道、总车流量、单位时间车道占有率（总、单位）、长车、中车、短车
                    //平均车速、长车平均车速、中车平均车速、短车平均速度、平均车流量、平均长车流量、平均中车流量、平均短车流量、单位时间
                    CarFlowLP carFlowLP = new CarFlowLP();
                    carFlowLP.setNoiseCode(getCode(pack,"Code"));
                    carFlowLP.setMeasureTime(sdf.parse(split[0]));
                    carFlowLP.setRadarID(split[1]);
                    carFlowLP.setUnitTime(Integer.parseInt(split[2]));
                    carFlowLP.setRoadWayNum(Integer.parseInt(split[3]));
                    carFlowLP.setTotalFlux(Double.parseDouble(split[4]));
                    carFlowLP.setOccupyRation(Double.parseDouble(split[5]));
                    carFlowLP.setLongRation(Double.parseDouble(split[6]));
                    carFlowLP.setMidRation(Double.parseDouble(split[7]));
                    carFlowLP.setShortRation(Double.parseDouble(split[8]));
                    carFlowLP.setAvgSpeed(Double.parseDouble(split[9]));
                    carFlowLP.setLongSpeed(Double.parseDouble(split[10]));
                    carFlowLP.setMidSpeed(Double.parseDouble(split[11]));
                    carFlowLP.setShortSpeed(Double.parseDouble(split[12]));
                    carFlowLP.setPreFlux(Double.parseDouble(split[13]));
                    carFlowLP.setLongCarNums(Double.parseDouble(split[14]));
                    carFlowLP.setMidCarNums(Double.parseDouble(split[15]));
                    carFlowLP.setShortCarNums(Double.parseDouble(split[16]));
                    //保存到数据库中
                    carFlowLPService.saveCarFlow(carFlowLP);
                    //rtn = Integer.parseInt(getCode(pack, "Rtn"));//提取接收返回标记
                } else if (classes.equals("N015")) { //粉尘数据自动上传命令
                    value = getCode(pack, "Value");
                    split = value.split(",");
                    //成功返回时间、采集的时间间隔、总悬浮颗粒物
                    //如果有“-”代表没有数据
                    DustLP dustLP = new DustLP();
                    dustLP.setNoiseCode(getCode(pack,"Code"));
                    dustLP.setMeasureTime(sdf.parse(split[0]));
                    dustLP.setUnitTime(Integer.parseInt(split[1]));
                    if(split[2].equals("-")){
                        dustLP.setTSP(0);
                    }else {
                        dustLP.setTSP(Double.parseDouble(split[2]));
                    }
                    if(split[3].equals("-")){
                        dustLP.setPM10(0);
                    }else {
                        dustLP.setPM10(Double.parseDouble(split[3]));
                    }
                    if(split[4].equals("-")){
                        dustLP.setPM2_5(0);
                    }else {
                        dustLP.setPM2_5(Double.parseDouble(split[4]));
                    }
                    if(split[5].equals("-")){
                        dustLP.setSOx(0);
                    }else {
                        dustLP.setSOx(Double.parseDouble(split[5]));
                    }
                    if(split[6].equals("-")){
                        dustLP.setNOx(0);
                    }else {
                        dustLP.setNOx(Double.parseDouble(split[6]));
                    }
                    if(split[7].equals("-")){
                        dustLP.setAnion(0);
                    }else {
                        dustLP.setAnion(Double.parseDouble(split[7]));
                    }
                    dustLPService.saveDustLp(dustLP);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //前端管理设置参数之后生成指令
    //发送
    public void SendingSock(String instruct) {
        System.out.println(instruct);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(instruct.getBytes());
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            BufferedReader buff = new BufferedReader(new InputStreamReader(byteArrayInputStream));
            PrintWriter printWriter = new PrintWriter(outputStream);
            String xx = null;
            while ((xx = buff.readLine()) != null) {
                printWriter.println(xx);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //设备指令列表
    //AWANoiseInstructService awaNoiseInstructService = BeanFactoryUtil.getApplicationContext().getBean(AWANoiseInstructService.class);
    //ObservableList<AWANoiseInstruct> noiseInstructs = awaNoiseInstructService.queryNoiseInstructByNoiseCode(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
    //InstructionsService instructionsService = BeanFactoryUtil.getApplicationContext().getBean(InstructionsService.class);
    //AWANoiseInstruct awaNoiseInstruct = new AWANoiseInstruct();

    /*public void run(){
        try {
            List<Instructions> instructionsList = instructionsService.queryInstructByNoiseCode(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
            for (Instructions instructions : instructionsList) {
                instruct = instructions.getInstructInput();
                System.out.println(instruct);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(instruct.getBytes());
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader buff= new BufferedReader(new InputStreamReader(byteArrayInputStream));
                PrintWriter printWriter = new PrintWriter(outputStream);
                String xx = null;
                while ((xx = buff.readLine()) != null){
                    printWriter.println(xx);
                    printWriter.flush();
                    instructions.setInstructRet(100);
                }
                if(instructions.getInstructRet() == 100){
                    instructionsService.deleteInstructions(instructions.getInstructFlag());
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    /**
     * 把指令拼接成JSON格式字符串，暂时不用
     * */
    /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private void changeNoiseJSON(){
        //为设备指令设置参数
        awaNoiseInstruct.setNoiseInstructId(UUID.randomUUID().toString().replace("-",""));
        awaNoiseInstruct.setNoiseCode(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
        awaNoiseInstruct.setSample(NoiseDeviceManageController.infoNoiseManager.getSample());
        awaNoiseInstruct.setUpSpace(NoiseDeviceManageController.infoNoiseManager.getUpSpace());
        awaNoiseInstruct.setDayOverValue(NoiseDeviceManageController.infoNoiseManager.getDayOverValue());
        awaNoiseInstruct.setNightOverValue(NoiseDeviceManageController.infoNoiseManager.getNightOverValue());
        awaNoiseInstruct.setOverDlay(NoiseDeviceManageController.infoNoiseManager.getOverDlay());
        awaNoiseInstruct.setIsExceed(NoiseDeviceManageController.infoNoiseManager.getIsExceed());
        awaNoiseInstruct.setDayOctValue(NoiseDeviceManageController.infoNoiseManager.getDayOctValue());
        awaNoiseInstruct.setNightOctValue(NoiseDeviceManageController.infoNoiseManager.getNightOctValue());
        awaNoiseInstruct.setOctDlay(NoiseDeviceManageController.infoNoiseManager.getOctDlay());
        awaNoiseInstruct.setIsOct(NoiseDeviceManageController.infoNoiseManager.getIsOct());
        awaNoiseInstruct.setDayRecordValue(NoiseDeviceManageController.infoNoiseManager.getDayRecordValue());
        awaNoiseInstruct.setNightRecordValue(NoiseDeviceManageController.infoNoiseManager.getNightRecordValue());
        awaNoiseInstruct.setRecordDlay(NoiseDeviceManageController.infoNoiseManager.getRecordDlay());
        awaNoiseInstruct.setIsRecord(NoiseDeviceManageController.infoNoiseManager.getIsRecord());
        awaNoiseInstruct.setRecordStartTime(NoiseDeviceManageController.infoNoiseManager.getRecordStartTime());
        awaNoiseInstruct.setRecordEndTime(NoiseDeviceManageController.infoNoiseManager.getRecordEndTime());
        awaNoiseInstruct.setRecordModel(NoiseDeviceManageController.infoNoiseManager.getRecordModel());
        awaNoiseInstruct.setFreWight(NoiseDeviceManageController.infoNoiseManager.getFreWight());
        awaNoiseInstruct.setTimeWight(NoiseDeviceManageController.infoNoiseManager.getTimeWight());
        awaNoiseInstruct.setInitime(NoiseDeviceManageController.infoNoiseManager.getInitime());
        awaNoiseInstruct.setAdjustTime(NoiseDeviceManageController.infoNoiseManager.getAdjustTime());
        awaNoiseInstruct.setAdjustSpace(NoiseDeviceManageController.infoNoiseManager.getAdjustSpace());
        awaNoiseInstruct.setIsAutoAdjust(NoiseDeviceManageController.infoNoiseManager.getIsAutoAdjust());
        awaNoiseInstruct.setWeaAutoUp(NoiseDeviceManageController.infoNoiseManager.getWeaAutoUp());
        awaNoiseInstruct.setWeaAutoSave(NoiseDeviceManageController.infoNoiseManager.getWeaAutoSave());
        awaNoiseInstruct.setWeaUpSpace(NoiseDeviceManageController.infoNoiseManager.getWeaUpSpace());
        awaNoiseInstruct.setCarAutoUp(NoiseDeviceManageController.infoNoiseManager.getCarAutoUp());
        awaNoiseInstruct.setCarAutoSave(NoiseDeviceManageController.infoNoiseManager.getCarAutoSave());
        awaNoiseInstruct.setCarUpSpace(NoiseDeviceManageController.infoNoiseManager.getCarUpSpace());
        awaNoiseInstruct.setDustAutoUp(NoiseDeviceManageController.infoNoiseManager.getDustAutoUp());
        awaNoiseInstruct.setDustAutoSave(NoiseDeviceManageController.infoNoiseManager.getDustAutoSave());
        awaNoiseInstruct.setDustUpSpace(NoiseDeviceManageController.infoNoiseManager.getDustUpSpace());
        awaNoiseInstruct.setEvent_01(NoiseDeviceManageController.infoNoiseManager.getEvent_01());
        awaNoiseInstruct.setEvent_02(NoiseDeviceManageController.infoNoiseManager.getEvent_02());
        awaNoiseInstruct.setEvent_03(NoiseDeviceManageController.infoNoiseManager.getEvent_03());
        awaNoiseInstruct.setEvent_04(NoiseDeviceManageController.infoNoiseManager.getEvent_04());
        awaNoiseInstruct.setEvent_05(NoiseDeviceManageController.infoNoiseManager.getEvent_05());
        awaNoiseInstruct.setEvent_06(NoiseDeviceManageController.infoNoiseManager.getEvent_06());
        awaNoiseInstruct.setEvent_07(NoiseDeviceManageController.infoNoiseManager.getEvent_07());
        awaNoiseInstruct.setEvent_08(NoiseDeviceManageController.infoNoiseManager.getEvent_08());
        awaNoiseInstruct.setEvent_09(NoiseDeviceManageController.infoNoiseManager.getEvent_09());
        awaNoiseInstruct.setEvent_10(NoiseDeviceManageController.infoNoiseManager.getEvent_10());
        awaNoiseInstruct.setEvent_11(NoiseDeviceManageController.infoNoiseManager.getEvent_11());
        awaNoiseInstruct.setEvent_12(NoiseDeviceManageController.infoNoiseManager.getEvent_12());
        awaNoiseInstruct.setEvent_13(NoiseDeviceManageController.infoNoiseManager.getEvent_13());
        awaNoiseInstruct.setON_OFF_LEQZ(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQZ());
        awaNoiseInstruct.setON_OFF_LEQC(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQC());
        awaNoiseInstruct.setON_OFF_LEQA(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQA());
        awaNoiseInstruct.setON_OFF_LPFZ(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPFZ());
        awaNoiseInstruct.setON_OFF_LPSZ(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPSZ());
        awaNoiseInstruct.setON_OFF_LPIZ(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPIZ());
        awaNoiseInstruct.setON_OFF_LPFC(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPFC());
        awaNoiseInstruct.setON_OFF_LPSC(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPSC());
        awaNoiseInstruct.setON_OFF_LPIC(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPIC());
        awaNoiseInstruct.setON_OFF_LPFA(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPFA());
        awaNoiseInstruct.setON_OFF_LPSA(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPSA());
        awaNoiseInstruct.setON_OFF_LPIA(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LPIA());
        awaNoiseInstruct.setON_OFF_PEAKZ(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PEAKZ());
        awaNoiseInstruct.setON_OFF_PEAKC(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PEAKC());
        awaNoiseInstruct.setON_OFF_PEAKA(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PEAKA());
        awaNoiseInstruct.setON_OFF_MIN(NoiseDeviceManageController.infoNoiseManager.getON_OFF_MIN());
        awaNoiseInstruct.setON_OFF_HOUR(NoiseDeviceManageController.infoNoiseManager.getON_OFF_HOUR());
        awaNoiseInstruct.setON_OFF_DAY(NoiseDeviceManageController.infoNoiseManager.getON_OFF_DAY());
        awaNoiseInstruct.setON_OFF_UDT(NoiseDeviceManageController.infoNoiseManager.getON_OFF_UDT());
        awaNoiseInstruct.setON_OFF_13OCT(NoiseDeviceManageController.infoNoiseManager.getON_OFF_13OCT());
        awaNoiseInstruct.setON_OFF_11OCT(NoiseDeviceManageController.infoNoiseManager.getON_OFF_11OCT());
        awaNoiseInstruct.setON_OFF_RADF(NoiseDeviceManageController.infoNoiseManager.getON_OFF_RADF());
        awaNoiseInstruct.setON_OFF_FAMF(NoiseDeviceManageController.infoNoiseManager.getON_OFF_FAMF());
        awaNoiseInstruct.setON_OFF_PDWIV(NoiseDeviceManageController.infoNoiseManager.getON_OFF_PDWIV());
        awaNoiseInstruct.setON_OFF_LEQ1S(NoiseDeviceManageController.infoNoiseManager.getON_OFF_LEQ1S());

        //拼接JSON字符串
        StringBuffer inputNoiseInstruct = new StringBuffer("{");
        inputNoiseInstruct.append("\"noiseCode\":\""+awaNoiseInstruct.getNoiseCode()+"\",");
        inputNoiseInstruct.append("\"sample\":\""+awaNoiseInstruct.getSample()+"\",");
        inputNoiseInstruct.append("\"upSpace\":\""+awaNoiseInstruct.getUpSpace()+"\",");
        inputNoiseInstruct.append("\"dayOverValue\":\""+awaNoiseInstruct.getDayOverValue()+"\",");
        inputNoiseInstruct.append("\"nightOverValue\":\""+awaNoiseInstruct.getNightOverValue()+"\",");
        inputNoiseInstruct.append("\"overDlay\":\""+awaNoiseInstruct.getOverDlay()+"\",");
        inputNoiseInstruct.append("\"isExceed\":\""+awaNoiseInstruct.getIsExceed()+"\",");
        inputNoiseInstruct.append("\"dayOctValue\":\""+awaNoiseInstruct.getDayOctValue()+"\",");
        inputNoiseInstruct.append("\"nightOctValue\":\""+awaNoiseInstruct.getNightOctValue()+"\",");
        inputNoiseInstruct.append("\"octDlay\":\""+awaNoiseInstruct.getOctDlay()+"\",");
        inputNoiseInstruct.append("\"isOct\":\""+awaNoiseInstruct.getIsOct()+"\",");
        inputNoiseInstruct.append("\"dayRecordValue\":\""+awaNoiseInstruct.getDayRecordValue()+"\",");
        inputNoiseInstruct.append("\"nightRecordValue\":\""+awaNoiseInstruct.getNightRecordValue()+"\",");
        inputNoiseInstruct.append("\"recordDlay\":\""+awaNoiseInstruct.getRecordDlay()+"\",");
        inputNoiseInstruct.append("\"isRecord\":\""+awaNoiseInstruct.getIsExceed()+"\",");
        inputNoiseInstruct.append("\"recordStartTime\":\""+sdf.format(awaNoiseInstruct.getRecordStartTime())+"\",");
        inputNoiseInstruct.append("\"recordEndTime\":\""+sdf.format(awaNoiseInstruct.getRecordEndTime())+"\",");
        inputNoiseInstruct.append("\"recordModel\":\""+awaNoiseInstruct.getRecordModel()+"\",");
        inputNoiseInstruct.append("\"freWight\":\""+awaNoiseInstruct.getFreWight()+"\",");
        inputNoiseInstruct.append("\"timeWight\":\""+awaNoiseInstruct.getTimeWight()+"\",");
        inputNoiseInstruct.append("\"initime\":\""+awaNoiseInstruct.getInitime()+"\",");
        inputNoiseInstruct.append("\"adjustTime\":\""+sdf.format(awaNoiseInstruct.getAdjustTime())+"\",");
        inputNoiseInstruct.append("\"adjustSpace\":\""+awaNoiseInstruct.getAdjustSpace()+"\",");
        inputNoiseInstruct.append("\"isAutoAdjust\":\""+awaNoiseInstruct.getIsAutoAdjust()+"\",");
        inputNoiseInstruct.append("\"weaAutoUp\":\""+awaNoiseInstruct.getWeaAutoUp()+"\",");
        inputNoiseInstruct.append("\"weaAutoSave\":\""+awaNoiseInstruct.getWeaAutoSave()+"\",");
        inputNoiseInstruct.append("\"weaUpSpace\":\""+awaNoiseInstruct.getWeaUpSpace()+"\",");
        inputNoiseInstruct.append("\"carAutoUp\":\""+awaNoiseInstruct.getCarAutoUp()+"\",");
        inputNoiseInstruct.append("\"carAutoSave\":\""+awaNoiseInstruct.getCarAutoSave()+"\",");
        inputNoiseInstruct.append("\"carUpSpace\":\""+awaNoiseInstruct.getCarUpSpace()+"\",");
        inputNoiseInstruct.append("\"dustAutoUp\":\""+awaNoiseInstruct.getDustAutoUp()+"\",");
        inputNoiseInstruct.append("\"dustAutoSave\":\""+awaNoiseInstruct.getDustAutoSave()+"\",");
        inputNoiseInstruct.append("\"dustUpSpace\":\""+awaNoiseInstruct.getDustUpSpace()+"\",");
        inputNoiseInstruct.append("\"event_01\":\""+awaNoiseInstruct.getEvent_01()+"\",");
        inputNoiseInstruct.append("\"event_02\":\""+awaNoiseInstruct.getEvent_02()+"\",");
        inputNoiseInstruct.append("\"event_03\":\""+awaNoiseInstruct.getEvent_03()+"\",");
        inputNoiseInstruct.append("\"event_04\":\""+awaNoiseInstruct.getEvent_04()+"\",");
        inputNoiseInstruct.append("\"event_05\":\""+awaNoiseInstruct.getEvent_05()+"\",");
        inputNoiseInstruct.append("\"event_06\":\""+awaNoiseInstruct.getEvent_06()+"\",");
        inputNoiseInstruct.append("\"event_07\":\""+awaNoiseInstruct.getEvent_07()+"\",");
        inputNoiseInstruct.append("\"event_08\":\""+awaNoiseInstruct.getEvent_08()+"\",");
        inputNoiseInstruct.append("\"event_09\":\""+awaNoiseInstruct.getEvent_09()+"\",");
        inputNoiseInstruct.append("\"event_10\":\""+awaNoiseInstruct.getEvent_10()+"\",");
        inputNoiseInstruct.append("\"event_11\":\""+awaNoiseInstruct.getEvent_11()+"\",");
        inputNoiseInstruct.append("\"event_12\":\""+awaNoiseInstruct.getEvent_12()+"\",");
        inputNoiseInstruct.append("\"event_13\":\""+awaNoiseInstruct.getEvent_13()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LEQZ\":\""+awaNoiseInstruct.getON_OFF_LEQZ()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LEQC\":\""+awaNoiseInstruct.getON_OFF_LEQC()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LEQA\":\""+awaNoiseInstruct.getON_OFF_LEQA()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPFZ\":\""+awaNoiseInstruct.getON_OFF_LPFZ()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPSZ\":\""+awaNoiseInstruct.getON_OFF_LPSZ()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPIZ\":\""+awaNoiseInstruct.getON_OFF_LPIZ()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPFC\":\""+awaNoiseInstruct.getON_OFF_LPFC()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPSC\":\""+awaNoiseInstruct.getON_OFF_LPSC()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPIC\":\""+awaNoiseInstruct.getON_OFF_LPIC()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPFA\":\""+awaNoiseInstruct.getON_OFF_LPFA()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPSA\":\""+awaNoiseInstruct.getON_OFF_LPSA()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LPIA\":\""+awaNoiseInstruct.getON_OFF_LPIA()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_PEAKZ\":\""+awaNoiseInstruct.getON_OFF_PEAKZ()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_PEAKC\":\""+awaNoiseInstruct.getON_OFF_PEAKC()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_PEAKA\":\""+awaNoiseInstruct.getON_OFF_PEAKA()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_MIN\":\""+awaNoiseInstruct.getON_OFF_MIN()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_HOUR\":\""+awaNoiseInstruct.getON_OFF_HOUR()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_DAY\":\""+awaNoiseInstruct.getON_OFF_DAY()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_UDT\":\""+awaNoiseInstruct.getON_OFF_UDT()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_13OCT\":\""+awaNoiseInstruct.getON_OFF_13OCT()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_11OCT\":\""+awaNoiseInstruct.getON_OFF_11OCT()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_RADF\":\""+awaNoiseInstruct.getON_OFF_RADF()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_FAMF\":\""+awaNoiseInstruct.getON_OFF_FAMF()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_PDWIV\":\""+awaNoiseInstruct.getON_OFF_PDWIV()+"\",");
        inputNoiseInstruct.append("\"ON_OFF_LEQ1S\":\""+awaNoiseInstruct.getON_OFF_LEQ1S()+"\",");
        inputNoiseInstruct.append("}");
        //JSONObject jm = JSON.parseObject(inputInstruct.toString());
        Instructions instructions = new Instructions();
        instructions.setInstructFlag(UUID.randomUUID().toString().replace("-",""));
        instructions.setInstructType("noise");
        instructions.setInstructClass("设置参数");
        instructions.setUserName("admin");
        instructions.setNoiseCode(AddFixedMeasureController.infoNoiseDevice.getDeviceCode());
        instructions.setInstructInput(inputNoiseInstruct.toString());
        instructions.setInstructRet(0);
        instructions.setInstructResult(null);
        instructions.setCreateTime(new Date());
        instructions.setOutDieTime(60);
        instructionsService.saveInstructions(instructions);
    }*/
}
