package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.EditDownUserLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

@ViewController(value = "/views/fxml/user/editDownUser.fxml")
public class EditDownUserController {
    @FXML
    private JFXButton editDownUser;

    public void init(){
        editDownUser.setOnAction(event -> {
            EditDownUserLoad editDownUserLoad = new EditDownUserLoad();
        });
    }
}
