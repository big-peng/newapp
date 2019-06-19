package com.hzaihua.jfoenix.controller.measure;

import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import com.hzaihua.jfoenix.load.device.AddDeviceBeforeLoad;
import com.hzaihua.jfoenix.load.device.EditDeviceAfterLoad;
import com.hzaihua.jfoenix.load.noiseDevice.EditNoiseDeviceLoad;
import com.hzaihua.jfoenix.service.InfoMeasureService;
import com.hzaihua.jfoenix.service.InfoNoiseService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.*;
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

@ViewController(value = "/views/fxml/measure/EditFixedMeasure.fxml")
public class EditFixedMeasureController {
    //测点基本信息
    @FXML private Label MeasureCode; //测点编号
    @FXML private TextField MeasureName; //测点名称
    @FXML private TextField MeasureUserName; //测点单位
    @FXML private TextField MeasureAddress; //测点地址
    @FXML private TextField Longitude; //测点经度
    @FXML private TextField Latitude; //测点纬度
    @FXML private TextField Remark; //备注
    @FXML private ImageView MeasureHead; //图片信息
    @FXML private JFXButton photoChange; //选择图片按钮

    //设备列表信息
    @FXML private TableView<InfoNoiseDevice> infoNoiseTreeView;
    @FXML private TableColumn noiseCode;
    @FXML private TableColumn noiseType;
    @FXML private TableColumn linkPort;
    public static ObservableList<InfoNoiseDevice> downNoiseList = FXCollections.observableArrayList();

    //列表按钮操作
    @FXML private HBox editMeasure;
    @FXML private Text actiontarget;//提示信息
    @FXML private JFXButton addFixedNoiseDevice; //添加设备
    @FXML private JFXButton editFixedNoiseDevice; //编辑设备
    @FXML private JFXButton deleteNoiseDevice; //删除设备
    @FXML private JFXButton deviceBeforeManager; //前端管理
    @FXML private JFXButton commitFixedMeasure; //确认修改

    @FXML private AnchorPane root;//删除成功后的提示出现地
    @FXML private JFXDialog dialog;
    public static InfoNoiseDevice infoNoiseDevice;//需要删除时传入的对象
    public static String row;

    String path = null;
    InfoNoiseService infoNoiseService = BeanFactoryUtil.getApplicationContext().getBean(InfoNoiseService.class);
    InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);


    @PostConstruct
    public void init(){

        //需要编辑的测点信息展示
        measureGrid();

        //设备信息列表
        downNoiseList();

        //添加设备按钮
        addFixedNoiseDevice.setOnAction(event -> {
            AddDeviceBeforeLoad addDeviceBeforeLoad = new AddDeviceBeforeLoad();
        });

        //建立删除按钮点击事件
        JFXSnackbar snackbar = new JFXSnackbar(root);
        snackbar.setPrefWidth(300);
        root.getChildren().remove(dialog);
        //删除设备按钮操作
        deleteNoiseDevice.setOnAction(event -> {
            JFXAlert alert = new JFXAlert((Stage) deleteNoiseDevice.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("提示！"));
            layout.setBody(new Label("你确定要删除"+infoNoiseDevice.getDeviceCode()+"这条设备信息吗？\n" +
                    "删除后无法恢复"));
            JFXButton trueButton = new JFXButton("确认");
            JFXButton closeButton = new JFXButton("取消");
            closeButton.getStyleClass().add("dialog-accept");
            trueButton.getStyleClass().add("dialog-accept");
            trueButton.setStyle("-fx-text-fill: #D34336;-fx-background-color: white");
            closeButton.setOnAction(event1 -> alert.hideWithAnimation());
            trueButton.setOnAction(event2 -> {
                downNoiseList.remove(infoNoiseDevice);
                //删除成功后的提示，可以根据返回值判断是否删除成功，并弹出对应信息
                infoNoiseTreeView.setItems(downNoiseList);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                        new JFXSnackbarLayout("已删除成功", "",null/*event1 -> snackbar.close()*/),
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
        editFixedNoiseDevice.setOnAction(event -> {
            EditDeviceAfterLoad editDeviceAfterLoad = new EditDeviceAfterLoad();
        });

        //前端管理按钮操作
        deviceBeforeManager.setOnAction(event -> {
            EditNoiseDeviceLoad editNoiseDeviceLoad = new EditNoiseDeviceLoad();
        });

        //图片选择按钮
        photoChange.setOnAction(event -> {
            FileChooser fileChooser=new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            path = file.getPath();
            String lastName = path.substring(path.lastIndexOf(".")+1,path.length());
            if(file.length()>2*1024*1024){
                actiontarget.setText("文件过大,请重新选择");
            }else if(!("jpg".equals(lastName)) && !("png".equals(lastName)) && !("JPG".equals(lastName)) && !("PNG".equals(lastName))){
                actiontarget.setText("图片格式不正确，请重新选择");
                MeasureHead.setImage(null);
            }else if(path == null || path == ""){
                actiontarget.setText("请重新选择..");
            }else {
                MeasureHead.setImage(new Image("file:" + path));
            }
        });
    }
    private void downNoiseList(){
        downNoiseList = infoNoiseService.queryByMeasureCode(MainController.deleteMeasureCode);
        noiseCode.setCellValueFactory(new PropertyValueFactory<>("deviceCode"));
        noiseType.setCellValueFactory(new PropertyValueFactory<>("deviceType"));
        linkPort.setCellValueFactory(new PropertyValueFactory<>("linkPort"));
        infoNoiseTreeView.setItems(downNoiseList);
        //表格中的监听事件
        infoNoiseTreeView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<InfoNoiseDevice>() {
                    @Override
                    public void changed(ObservableValue<? extends InfoNoiseDevice> observable, InfoNoiseDevice oldValue, InfoNoiseDevice newValue) {
                        infoNoiseDevice = newValue;
                        row = newValue.getDeviceCode();
                        editMeasure.setDisable(false);
                    }
                }
        );
    }

    private void measureGrid(){
        InfoMeasure infoMeasure = infoMeasureService.queryByMeasureCode(MainController.deleteMeasureCode);
        MeasureCode.setText(infoMeasure.getMeasureCode());
        MeasureName.setText(infoMeasure.getMeasureName());
        MeasureUserName.setText(infoMeasure.getMeasureUserName());
        MeasureAddress.setText(infoMeasure.getMeasureAddress());
        Longitude.setText(infoMeasure.getLongitude());
        Latitude.setText(infoMeasure.getLatitude());
        Remark.setText(infoMeasure.getRemark());
        if(infoMeasure.getMeasureHead() != null){
            MeasureHead.setImage(new Image(infoMeasure.getMeasureHead()));
        }else {
            MeasureHead.setImage(null);
        }
    }
}
