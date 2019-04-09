package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.EditUserLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

@ViewController(value = "/views/fxml/user/editUser.fxml")
public class EditUserController {
    @FXML
    private JFXButton comitEditUser;

    public void init(){
        comitEditUser.setOnAction(event -> {
            EditUserLoad editUserLoad = new EditUserLoad();
        });
    }
}
