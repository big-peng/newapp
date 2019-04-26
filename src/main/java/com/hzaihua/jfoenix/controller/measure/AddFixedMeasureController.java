package com.hzaihua.jfoenix.controller.measure;


import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.load.device.AddDeviceBeforeLoad;
import com.hzaihua.jfoenix.service.InfoMeasureService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;
import java.io.File;

@ViewController(value = "/views/fxml/measure/AddFixedMeasure.fxml")
public class AddFixedMeasureController {
    @FXML
    private JFXButton addFixedDevice;
    //添加测点输入项
    @FXML
    private Label MeasureType;
    @FXML
    private TextField MeasureCode;
    @FXML
    private TextField MeasureName;
    @FXML
    private TextField MeasureUserName;
    @FXML
    private TextField MeasureAddress;
    @FXML
    private TextField Longitude;
    @FXML
    private TextField Latitude;
    @FXML
    private TextField Remark;
    @FXML
    private JFXButton fileChoose;
    @FXML
    private JFXCheckBox autoConnect;

    @FXML
    //图片信息
    private ImageView MeasureHead;
    @FXML
    //提示信息
    private Text actiontarget;

    @FXML
    //提交添加测点按钮
    private JFXButton commitFixedMeasure;

    String path = null;
    InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);

    @PostConstruct
    public void init(){
        addFixedDevice.setOnAction(event -> {
            AddDeviceBeforeLoad addDeviceBeforeLoad = new AddDeviceBeforeLoad();
        });

        //图片选择按钮
        fileChoose.setOnAction(event -> {
            FileChooser fileChooser=new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            path = file.getPath();
            String suxx = path.substring(path.lastIndexOf(".")+1,path.length());
            if(file.length()>2*1024*1024){
                actiontarget.setText("文件过大,请重新选择");
            }else if(!("jpg".equals(suxx)) && !("png".equals(suxx)) && !("JPG".equals(suxx)) && !("PNG".equals(suxx))){
                actiontarget.setText("图片格式不正确，请重新选择");
                MeasureHead.setImage(null);
            }else if(path == null || path == ""){
                actiontarget.setText("请重新选择");
            }else {
                MeasureHead.setImage(new Image("file:" + path));
            }
        });

        InfoMeasure infoMeasure = new InfoMeasure();
        //提交操作
        commitFixedMeasure.setOnAction(event -> {
            String measureType = MeasureType.getText();
            String measureCode = MeasureCode.getText();
            String measureName = MeasureName.getText();
            String measureUserName = MeasureUserName.getText();
            String measureAddress = MeasureAddress.getText();
            String measureLongitude = Longitude.getText();
            String measureLatitude = Latitude.getText();
            String measureRemark = Remark.getText();

            //判断输入的是不是数字的正则表达式
            String reg = "/^[0-9]+.?[0-9]*$/";
            if("".equals(measureCode) || measureCode == null){
                actiontarget.setText("测点编号不允许为空");
            }else if("".equals(measureName) || measureName == null){
                actiontarget.setText("测点名字不能为空");
            }else if(measureLongitude.matches(reg) || measureLatitude.matches(reg)){
                actiontarget.setText("输入格式不正确，请重新输入");
            }else if("".equals(measureLongitude) || measureLongitude == null){
                actiontarget.setText("请输入经度");
            }else if("".equals(measureLatitude) || measureLatitude == null){
                actiontarget.setText("请输入纬度");
            }else {
                //添加测点
                infoMeasure.setMeasureType(measureType);
                infoMeasure.setMeasureCode(measureCode);
                infoMeasure.setMeasureName(measureName);
                infoMeasure.setMeasureUserName(measureUserName);
                infoMeasure.setMeasureAddress(measureAddress);
                infoMeasure.setLongitude(measureLongitude);
                infoMeasure.setLatitude(measureLatitude);
                infoMeasure.setRemark(measureRemark);
                if(autoConnect.isSelected()){
                    infoMeasure.setAutoConnect(1);
                }else {
                    infoMeasure.setAutoConnect(0);
                }
                infoMeasure.setMeasureHead("file:"+path);
                infoMeasureService.saveMeasure(infoMeasure);
            }
        });
    }
}
