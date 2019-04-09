package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.load.User.FindDownUserLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

@ViewController(value = "/views/fxml/user/findDownUser.fxml")
public class FindDownUserController {
    @FXML
    //查询下级用户确定按钮
    private JFXButton comitEditDownUser;

    public void init(){
        comitEditDownUser.setOnAction(event -> {
            FindDownUserLoad findDownUserLoad = new FindDownUserLoad();
        });
    }
}
