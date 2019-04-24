package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.controller.measure.UndistributeMeasureController;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.load.measure.UndistributeMeasureLoad;
import com.hzaihua.jfoenix.service.InfoMeasureService;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

import static com.hzaihua.jfoenix.controller.user.UserInfoController.deleteUserName;

@ViewController(value = "/views/fxml/user/editDownUser.fxml")
public class EditDownUserController {

    @FXML
    //确定分配测点按钮
    private JFXButton commitEditDownUser;
    @FXML
    //分配测点按钮
    private JFXButton undistributeMeasure;
    //用户类型下拉框
    @FXML
    private ComboBox<String> downUserType;
    //用户名称
    @FXML
    private Label downName;
    @FXML
    //即将分配测点列表
    public static TableView<InfoMeasure> editUserTreeTableView;
    //列表中的属性
    @FXML
    private TableColumn measureCode;
    @FXML
    private TableColumn measureName;
    public static ObservableList<InfoMeasure> undisList = FXCollections.observableArrayList();


    @PostConstruct
    public void init(){
        InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
        InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);

        //调出选择未分配测点界面
        undistributeMeasure.setOnAction(event -> {
            undisList.clear();
            UndistributeMeasureLoad undistributeMeasureLoad = new UndistributeMeasureLoad();
        });
        InfoUser infoUser = infoUserService.queryByUserName(deleteUserName);
        String downType = infoUser.getUserType();
        downName.setText(infoUser.getNickName());
        downUserType.setValue(downType);

        undisTable();

        //确认修改操作
        commitEditDownUser.setOnAction(event -> {
            Stage stage = (Stage)commitEditDownUser.getScene().getWindow();
            //修改测点所属用户
            for (InfoMeasure measure : undisList) {
                InfoMeasure infoMeasure = infoMeasureService.queryByMeasureCode(measure.getMeasureCode());
                infoMeasure.setMeasureUserName(infoUser.getUserName());
                infoMeasureService.updateMeasureUser(infoMeasure);
            }
            stage.close();
        });
    }

    //已选择测点显示框
    private void undisTable(){
        measureCode.setCellValueFactory(new PropertyValueFactory<>("measureCode"));
        measureName.setCellValueFactory(new PropertyValueFactory<>("measureName"));
    }
}
