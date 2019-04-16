package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.EditDownUserLoad;
import com.hzaihua.jfoenix.load.measure.UndistributeMeasureLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/user/editDownUser.fxml")
public class EditDownUserController {
    @FXML
    private JFXButton editDownUser;
    @FXML
    private JFXButton undistributeMeasure;

    @PostConstruct
    public void init(){
        editDownUser.setOnAction(event -> {
            EditDownUserLoad editDownUserLoad = new EditDownUserLoad();
        });
        undistributeMeasure.setOnAction(event -> {
            UndistributeMeasureLoad undistributeMeasureLoad = new UndistributeMeasureLoad();
        });
    }
}
