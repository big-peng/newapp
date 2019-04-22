package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.load.measure.UndistributeMeasureLoad;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;

import static com.hzaihua.jfoenix.controller.user.UserInfoController.deleteUserName;

@ViewController(value = "/views/fxml/user/editDownUser.fxml")
public class EditDownUserController {

    @FXML
    //分配测点按钮
    private JFXButton undistributeMeasure;
    //用户类型下拉框
    @FXML
    private ComboBox<String> downUserType;
    //用户名称
    @FXML
    private Label downName;


    @PostConstruct
    public void init(){
        InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
        undistributeMeasure.setOnAction(event -> {
            UndistributeMeasureLoad undistributeMeasureLoad = new UndistributeMeasureLoad();
        });
        InfoUser infoUser = infoUserService.queryByUserName(deleteUserName);
        String downType = infoUser.getUserType();
        downName.setText(infoUser.getNickName());
        downUserType.setValue(downType);
    }
}
