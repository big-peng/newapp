package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.EditPasswordLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

@ViewController(value = "/views/fxml/user/editPassword.fxml")
public class EditUserPasswordController {

    @FXML
    private JFXButton comitEditPassword;

    public void init(){
        comitEditPassword.setOnAction(event -> {
            EditPasswordLoad editPasswordLoad = new EditPasswordLoad();
        });
    }
}