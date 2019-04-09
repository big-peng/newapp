package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.AddDownUserLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

@ViewController(value = "/views/fxml/user/addDownUser.fxml")
public class AddDownUserController {
    @FXML
    private JFXButton comitAddDownUser;

    public void init(){
        comitAddDownUser.setOnAction(event -> {
            AddDownUserLoad addDownUserLoad = new AddDownUserLoad();
        });
    }
}
