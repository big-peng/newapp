package com.hzaihua.jfoenix.controller;

import com.hzaihua.jfoenix.load.MainLoad;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@FXMLView(value = "/views/fxml/login.fxml")
public class LoginController extends AbstractFxmlView {
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
        /*System.out.println(studentDao);
        List<Student> list = studentDao.selectAll();
        System.out.println(list);*/
        if ("admin".equals(username.getText())){
            if ("123".equals(password.getText())){
                actiontarget.setText("登录成功");
                Stage stage = (Stage)exitLogin.getScene().getWindow();
                MainLoad mainController = new MainLoad();
                stage.close();
            }else{
                actiontarget.setText("登录失败，密码错误");
            }
        }else{
            actiontarget.setText("登录失败，账号错误");
        }
    }
}
