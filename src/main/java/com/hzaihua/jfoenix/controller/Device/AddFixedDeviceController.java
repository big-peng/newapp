package com.hzaihua.jfoenix.controller.Device;

import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.controller.TCPLink.SendingInstruct;
import com.hzaihua.jfoenix.controller.TCPLink.SendingSocketThread;
import com.hzaihua.jfoenix.controller.TCPLink.SendingThread;
import com.hzaihua.jfoenix.controller.measure.AddFixedMeasureController;
import com.hzaihua.jfoenix.controller.measure.EditFixedMeasureController;
import com.hzaihua.jfoenix.entity.AWAServerInstruct;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import com.hzaihua.jfoenix.entity.Instructions;
import com.hzaihua.jfoenix.entity.StateNoise;
import com.hzaihua.jfoenix.service.DeviceManageService;
import com.hzaihua.jfoenix.service.InfoNoiseService;
import com.hzaihua.jfoenix.service.InstructionsService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@ViewController(value = "/views/fxml/device/AddDeviceAfter.fxml")
public class AddFixedDeviceController {
    //前半部分输入内容
    @FXML private TextField NoiseDeviceCode;//设备编号
    @FXML private PasswordField DevicePassword;//设备连接密码
    @FXML private TextField LinkPort;//设备连接端口
    @FXML private TextField MicrophoneHeight;//话筒高度
    @FXML private ComboBox<String> FunCode;//功能区代码
    @FXML private TextField DTUSIM;

    //后半部分复选框内容
    @FXML private JFXCheckBox IsAutoAdjust;//是否自动较时
    @FXML private JFXCheckBox IsReadMin;//是否自动读取分钟统计数据
    @FXML private JFXCheckBox IsReadHour;//是否自动读取小时统计数据
    @FXML private JFXCheckBox IsReadDay;//是否自动读取天统计数据
    @FXML private JFXCheckBox IsReadLp;//是否自动读取瞬时声级数据
    @FXML private JFXCheckBox IsReadLeq1s;//是否自动读取每秒等效声级数据
    @FXML private JFXCheckBox IsReadOct;//是否自动读取频谱分析数据
    @FXML private JFXCheckBox IsReadWea;//是否自动读取气象数据
    @FXML private JFXCheckBox IsReadCar;//是否自动读取交通数据
    @FXML private JFXCheckBox IsReadDust;//是否自动读取空气数据
    @FXML private JFXCheckBox IsReadEvent;//是否自动读取事件数据
    @FXML private JFXCheckBox IsOpenVoice;//是否开启实时语音服务

    @FXML private Text actiontarget;//输入错误信息时提示框
    @FXML private JFXButton commitAddFixedDevice;//确认提交按钮

    InfoNoiseService infoNoiseService = BeanFactoryUtil.getApplicationContext().getBean(InfoNoiseService.class);
    String deviceCode = null;
    InfoNoiseDevice infoNoiseDevice = new InfoNoiseDevice();
    AWAServerInstruct awaServerInstruct = new AWAServerInstruct();
    InstructionsService instructionsService = BeanFactoryUtil.getApplicationContext().getBean(InstructionsService.class);

    @PostConstruct
    public void init(){

        //判断设备编号是否已存在
        NoiseDeviceCode.focusedProperty().addListener((ob,old,now)->{
            boolean a11 = true;
            if(!now){
                InfoNoiseDevice infoNoise = infoNoiseService.queryByNoiseCode(NoiseDeviceCode.getText());
                for (InfoNoiseDevice device : AddFixedMeasureController.noiseList) {
                    deviceCode = device.getDeviceCode();
                    if(deviceCode.equals(NoiseDeviceCode.getText())){
                        a11 = false;
                    }
                }
                if (infoNoise == null && a11){
                    actiontarget.setText("设备编号不存在，可以创建");
                }else{
                    actiontarget.setText("设备编号已存在");
                }
            }
        });

        //确认提交操作
        commitAddFixedDevice.setOnAction(event -> {
            Stage stage = (Stage)commitAddFixedDevice.getScene().getWindow();
            String noiseDeviceCode = NoiseDeviceCode.getText();
            String devicePassword = DevicePassword.getText();
            String linkPort = LinkPort.getText();
            String microphoneHeight = MicrophoneHeight.getText();
            String dtusim = DTUSIM.getText();

            //判断必须输入项是否为空
            String reg = "^\\d{6}$";
            String rege = "^\\d{4}$";
            String re="^(-?)[1-9]+\\d*|0";
            String regex="^[1][\\d]{10}";

            if("".equals(noiseDeviceCode)){
                actiontarget.setText("设备编号不允许为空");
            }else if("".equals(devicePassword)){
                actiontarget.setText("设备密码不能为空");
            }else if(!devicePassword.matches(reg)){
                actiontarget.setText("设备密码输入格式不正确,必须纯数字");
            }else if("".equals(linkPort)){
                actiontarget.setText("端口号不能为空");
            }else if(!linkPort.matches(rege)){
                actiontarget.setText("端口号输入格式不正确,必须是纯数字");
            }else if(dtusim.matches(re) && !(dtusim.matches(regex))){
                actiontarget.setText("SIM卡号输入格式不正确");
            }else {
                infoNoiseDevice.setDeviceCode(noiseDeviceCode);
                infoNoiseDevice.setDeviceType("AWA6218j");
                infoNoiseDevice.setDevicePassword(devicePassword);
                infoNoiseDevice.setLinkType(1);
                infoNoiseDevice.setLinkPort(Integer.parseInt(linkPort));
                infoNoiseDevice.setDTUSIM(dtusim);
                infoNoiseDevice.setFunCode(FunCode.getValue());
                infoNoiseDevice.setMicrophoneHeight(microphoneHeight);
                infoNoiseDevice.setIsAutoLink(1);
                if(IsAutoAdjust.isSelected()){
                    infoNoiseDevice.setIsAutoAdjust(1);
                }else {
                    infoNoiseDevice.setIsAutoAdjust(0);
                }
                if(IsReadMin.isSelected()){
                    infoNoiseDevice.setIsReadMin(1);
                }else {
                    infoNoiseDevice.setIsReadMin(0);
                }
                if(IsReadHour.isSelected()){
                    infoNoiseDevice.setIsReadHour(1);
                }else {
                    infoNoiseDevice.setIsReadHour(0);
                }
                if(IsReadDay.isSelected()){
                    infoNoiseDevice.setIsReadDay(1);
                }else {
                    infoNoiseDevice.setIsReadDay(0);
                }
                if(IsReadLp.isSelected()){
                    infoNoiseDevice.setIsReadLp(1);
                }else {
                    infoNoiseDevice.setIsReadLp(0);
                }
                if(IsReadLeq1s.isSelected()){
                    infoNoiseDevice.setIsReadLeq1s(1);
                }else {
                    infoNoiseDevice.setIsReadLeq1s(0);
                }
                if(IsReadOct.isSelected()){
                    infoNoiseDevice.setIsReadOct(1);
                }else {
                    infoNoiseDevice.setIsReadOct(0);
                }
                if(IsReadWea.isSelected()){
                    infoNoiseDevice.setIsReadWea(1);
                }else {
                    infoNoiseDevice.setIsReadWea(0);
                }
                if(IsReadCar.isSelected()){
                    infoNoiseDevice.setIsReadCar(1);
                }else {
                    infoNoiseDevice.setIsReadCar(0);
                }
                if(IsReadDust.isSelected()){
                    infoNoiseDevice.setIsReadDust(1);
                }else {
                    infoNoiseDevice.setIsReadDust(0);
                }
                if(IsReadEvent.isSelected()){
                    infoNoiseDevice.setIsReadEvent(1);
                }else {
                    infoNoiseDevice.setIsReadEvent(0);
                }
                if(IsOpenVoice.isSelected()){
                    infoNoiseDevice.setIsOpenVoice(1);
                }else {
                    infoNoiseDevice.setIsOpenVoice(0);
                }
                infoNoiseDevice.setStateType(1);
                AddFixedMeasureController.noiseList.add(infoNoiseDevice);
                EditFixedMeasureController.downNoiseList.add(infoNoiseDevice);
                //监听端口,发送连接指令
                if(!MainController.ports.containsKey(infoNoiseDevice.getLinkPort())) {
                    SendingInstruct.device = infoNoiseDevice.getDeviceCode();
                    SendingSocketThread.port = infoNoiseDevice.getLinkPort();
                    System.out.println(SendingSocketThread.port);
                    MainController.ports.put(infoNoiseDevice.getLinkPort(), infoNoiseDevice.getLinkPort());
                    new Thread(new SendingSocketThread()).start();
                    SendingInstruct sendingInstruct = new SendingInstruct();
                    SendingThread.instruct = sendingInstruct.instruct000();
                }
                stage.close();
            }
        });
    }


    /**
     * 把指令拼接成JSON格式字符串，暂时不用
     * */
    private void changeServiceJSON(){
        //服务器指令赋值
        awaServerInstruct.setInstructId(UUID.randomUUID().toString().replace("-",""));
        awaServerInstruct.setMeasureName(null);
        awaServerInstruct.setSubTree(null);
        awaServerInstruct.setDeviceType("AWA6218j");
        awaServerInstruct.setLatitude(12.0);
        awaServerInstruct.setLongitude(12.0);
        awaServerInstruct.setUserLatitude(10.0);
        awaServerInstruct.setUserLongitude(10.0);
        awaServerInstruct.setFunctionCode(infoNoiseDevice.getFunCode());
        awaServerInstruct.setMeasureAddress(null);
        awaServerInstruct.setDeviceAWAID(infoNoiseDevice.getDeviceCode());
        awaServerInstruct.setIsAutoAdjust(infoNoiseDevice.getIsAutoAdjust());
        awaServerInstruct.setIsReadMin(infoNoiseDevice.getIsReadMin());
        awaServerInstruct.setIsReadHour(infoNoiseDevice.getIsReadHour());
        awaServerInstruct.setIsReadDay(infoNoiseDevice.getIsReadDay());
        awaServerInstruct.setIsReadLp(infoNoiseDevice.getIsReadLp());
        awaServerInstruct.setIsReadLeq1s(infoNoiseDevice.getIsReadLeq1s());
        awaServerInstruct.setIsReadOct(infoNoiseDevice.getIsReadOct());
        awaServerInstruct.setIsReadWea(infoNoiseDevice.getIsReadWea());
        awaServerInstruct.setIsReadCar(infoNoiseDevice.getIsReadCar());
        awaServerInstruct.setIsReadDust(infoNoiseDevice.getIsReadDust());
        awaServerInstruct.setIsReadEvent(infoNoiseDevice.getIsReadEvent());
        awaServerInstruct.setIsOpenVoice(infoNoiseDevice.getIsOpenVoice());

        //转换json字符串
        StringBuffer inputServerInstruct = new StringBuffer();
        inputServerInstruct.append("{");
        inputServerInstruct.append("\"measureName\":\""+awaServerInstruct.getMeasureName()+"\",");
        inputServerInstruct.append("\"subTree\":\""+awaServerInstruct.getSubTree()+"\",");
        inputServerInstruct.append("\"deviceType\":\""+awaServerInstruct.getDeviceType()+"\",");
        inputServerInstruct.append("\"longitude\":\""+awaServerInstruct.getLongitude()+"\",");
        inputServerInstruct.append("\"latitude\":\""+awaServerInstruct.getLatitude()+"\",");
        inputServerInstruct.append("\"userLongitude\":\""+awaServerInstruct.getUserLongitude()+"\",");
        inputServerInstruct.append("\"userLatitude\":\""+awaServerInstruct.getUserLatitude()+"\",");
        inputServerInstruct.append("\"functionCode\":\""+awaServerInstruct.getFunctionCode()+"\",");
        inputServerInstruct.append("\"measureAddress\":\""+awaServerInstruct.getMeasureAddress()+"\",");
        inputServerInstruct.append("\"deviceAWAID\":\""+awaServerInstruct.getDeviceAWAID()+"\",");
        inputServerInstruct.append("\"isAutoAdjust\":\""+awaServerInstruct.getIsAutoAdjust()+"\",");
        inputServerInstruct.append("\"isReadMin\":\""+awaServerInstruct.getIsReadMin()+"\",");
        inputServerInstruct.append("\"isReadHour\":\""+awaServerInstruct.getIsReadHour()+"\",");
        inputServerInstruct.append("\"isReadDay\":\""+awaServerInstruct.getIsReadDay()+"\",");
        inputServerInstruct.append("\"isReadLp\":\""+awaServerInstruct.getIsReadLp()+"\",");
        inputServerInstruct.append("\"isReadLeq1s\":\""+awaServerInstruct.getIsReadLeq1s()+"\",");
        inputServerInstruct.append("\"isReadOct\":\""+awaServerInstruct.getIsReadOct()+"\",");
        inputServerInstruct.append("\"isReadWea\":\""+awaServerInstruct.getIsReadWea()+"\",");
        inputServerInstruct.append("\"isReadCar\":\""+awaServerInstruct.getIsReadCar()+"\",");
        inputServerInstruct.append("\"isReadDust\":\""+awaServerInstruct.getIsReadDust()+"\",");
        inputServerInstruct.append("\"isReadEvent\":\""+awaServerInstruct.getIsReadEvent()+"\",");
        inputServerInstruct.append("\"isOpenVoice\":\""+awaServerInstruct.getIsOpenVoice()+"\",");
        inputServerInstruct.append("}");

        //存入指令列表供使用
        Instructions instructions = new Instructions();
        instructions.setInstructFlag(UUID.randomUUID().toString().replace("-",""));
        instructions.setInstructType("noise");
        instructions.setInstructClass("设置参数");
        instructions.setUserName("admin");
        instructions.setNoiseCode(NoiseDeviceCode.getText());
        instructions.setInstructInput(inputServerInstruct.toString());
        instructions.setInstructRet(0);
        instructions.setInstructResult(null);
        instructions.setCreateTime(new Date());
        instructions.setOutDieTime(60);
        instructionsService.saveInstructions(instructions);
    }
}
