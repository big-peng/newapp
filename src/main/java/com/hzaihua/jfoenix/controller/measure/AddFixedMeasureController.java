package com.hzaihua.jfoenix.controller.measure;


import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.load.device.AddDeviceBeforeLoad;
import com.hzaihua.jfoenix.load.device.EditDeviceAfterLoad;
import com.hzaihua.jfoenix.load.noiseDevice.EditNoiseDeviceLoad;
import com.hzaihua.jfoenix.service.InfoMeasureService;
import com.hzaihua.jfoenix.service.InfoNoiseService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@ViewController(value = "/views/fxml/measure/AddFixedMeasure.fxml")
public class AddFixedMeasureController {
    @FXML private JFXButton addFixedDevice; //添加设备按钮
    //添加测点输入项
    @FXML private Label MeasureType;
    @FXML private TextField MeasureCode;
    @FXML private TextField MeasureName;
    @FXML private TextField MeasureUserName;
    @FXML private TextField MeasureAddress;
    @FXML private TextField Longitude;
    @FXML private TextField Latitude;
    @FXML private TextField Remark;
    @FXML private JFXButton fileChoose;
    @FXML private JFXCheckBox autoConnect;
    @FXML private ImageView MeasureHead;//图片信息

    //列表信息
    @FXML private TableView<InfoNoiseDevice> infoNoiseTreeView;
    @FXML private TableColumn noiseCode;
    @FXML private TableColumn noiseType;
    @FXML private TableColumn linkPort;
    public static ObservableList<InfoNoiseDevice> noiseList = FXCollections.observableArrayList();

    @FXML private HBox editMeasure;
    @FXML private Text actiontarget;//提示信息
    @FXML private JFXButton editFixedDevice;//编辑设备按钮
    @FXML private JFXButton deleteDevice;//删除设备按钮
    @FXML private JFXButton buforeManager;//前端管理按钮
    @FXML private JFXButton commitFixedMeasure;//提交添加测点按钮

    @FXML private AnchorPane root;//删除成功后的提示出现地
    @FXML private JFXDialog dialog;
    public static InfoNoiseDevice infoNoiseDevice;//需药删除时传入的对象

    String path = null;
    InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);
    InfoNoiseService infoNoiseService = BeanFactoryUtil.getApplicationContext().getBean(InfoNoiseService.class);

    @PostConstruct
    public void init(){
        //添加设备按钮
        addFixedDevice.setOnAction(event -> {
            AddDeviceBeforeLoad addDeviceBeforeLoad = new AddDeviceBeforeLoad();
        });

        //建立删除按钮点击事件
        JFXSnackbar snackbar = new JFXSnackbar(root);
        snackbar.setPrefWidth(300);
        root.getChildren().remove(dialog);
        //删除设备按钮操作
        deleteDevice.setOnAction(event -> {
            JFXAlert alert = new JFXAlert((Stage) deleteDevice.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("提示！"));
            layout.setBody(new Label("你确定要删除"+infoNoiseDevice.getDeviceCode()+"这条设备信息吗？\n" +
                    "删除后将无法恢复"));
            JFXButton trueButton = new JFXButton("确认");
            JFXButton closeButton = new JFXButton("取消");
            closeButton.getStyleClass().add("dialog-accept");
            trueButton.getStyleClass().add("dialog-accept");
            trueButton.setStyle("-fx-text-fill: #D34336;-fx-background-color: white");
            closeButton.setOnAction(event1 -> alert.hideWithAnimation());
            trueButton.setOnAction(event2 -> {
                noiseList.remove(infoNoiseDevice);
                //删除成功后的提示，可以根据返回值判断是否删除成功，并弹出对应信息
                infoNoiseTreeView.setItems(noiseList);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                        new JFXSnackbarLayout("删除成功", "",null/*event1 -> snackbar.close()*/),
                        Duration.millis(2000), null));
                alert.hideWithAnimation();
                if(infoNoiseDevice == null){
                    editMeasure.setDisable(true);
                }
            });
            List<JFXButton> buttons = new ArrayList<JFXButton>();
            buttons.add(trueButton);
            buttons.add(closeButton);
            layout.setActions(buttons);
            alert.setContent(layout);
            alert.show();
        });

        //编辑按钮操作
        editFixedDevice.setOnAction(event -> {
            EditDeviceAfterLoad editDeviceAfterLoad = new EditDeviceAfterLoad();
        });



        //判断设备编号是否已存在
        MeasureCode.focusedProperty().addListener((ob,old,now)->{
            if(!now){
                InfoMeasure infoMeasure = infoMeasureService.queryByMeasureCode(MeasureCode.getText());
                if(infoMeasure == null){
                    actiontarget.setText("用户名不存在，可以创建");
                }else{
                    actiontarget.setText("用户名存在");
                }
            }
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
        noiseDeviceList();
        InfoMeasure infoMeasure = new InfoMeasure();
        //提交操作
        commitFixedMeasure.setOnAction(event -> {
            Stage stage = (Stage)commitFixedMeasure.getScene().getWindow();
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
                StringBuffer buffer = new StringBuffer();
                for (InfoNoiseDevice infoNoiseDevice : noiseList) {
                    buffer.append(infoNoiseDevice.getStateType()).append(",").append(infoNoiseDevice.getDeviceCode()).append(";");
                    infoNoiseDevice.setMeasureCode(measureCode);
                    infoNoiseService.saveInfoNoiseDevice(infoNoiseDevice);
                }
                infoMeasure.setDeviceTypeAndIDs(buffer.toString());
                infoMeasureService.saveMeasure(infoMeasure);
            }
            stage.close();
        });
    }
    private void noiseDeviceList(){
        noiseCode.setCellValueFactory(new PropertyValueFactory<>("deviceCode"));
        noiseType.setCellValueFactory(new PropertyValueFactory<>("deviceType"));
        linkPort.setCellValueFactory(new PropertyValueFactory<>("linkPort"));
        infoNoiseTreeView.setItems(noiseList);

        //表格中的点击事件
        infoNoiseTreeView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<InfoNoiseDevice>() {
                    @Override
                    public void changed(ObservableValue<? extends InfoNoiseDevice> observable, InfoNoiseDevice oldValue, InfoNoiseDevice newValue) {
                        infoNoiseDevice = newValue;
                        editMeasure.setDisable(false);
                    }
                }
        );
    }
}
