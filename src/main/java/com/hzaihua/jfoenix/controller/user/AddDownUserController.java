package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.AddDownUserLoad;
import com.hzaihua.jfoenix.load.measure.UndistributeMeasureLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/user/addDownUser.fxml")
public class AddDownUserController {
    @FXML
    private JFXButton comitAddDownUser;

    @FXML
    private JFXButton distributeMeasure;

    @PostConstruct
    public void init(){
        comitAddDownUser.setOnAction(event -> {
            AddDownUserLoad addDownUserLoad = new AddDownUserLoad();
        });
        distributeMeasure.setOnAction(event -> {
            UndistributeMeasureLoad undistributeMeasureLoad = new UndistributeMeasureLoad();
        });
    }
}
