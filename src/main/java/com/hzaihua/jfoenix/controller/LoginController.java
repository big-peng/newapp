package com.hzaihua.jfoenix.controller;

import com.hzaihua.jfoenix.load.MainLoad;
import com.hzaihua.jfoenix.service.InfoUserService;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.annotation.Resource;

@FXMLView(value = "/views/fxml/login.fxml")
public class LoginController extends AbstractFxmlView {
    @Resource
    private InfoUserService infoUserService;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Text actiontarget;
    @FXML
    private Button exitLogin;
    @FXML
    protected void login(ActionEvent event) {
        System.out.println(username.getText()+","+password.getText());
        String result = infoUserService.pwdIsTrue(username.getText(),password.getText());
        if ("登录成功".equals(result)){
            Stage stage = (Stage)exitLogin.getScene().getWindow();
            MainLoad mainController = new MainLoad();
            stage.close();
        }
        actiontarget.setText(result);
    }
}
