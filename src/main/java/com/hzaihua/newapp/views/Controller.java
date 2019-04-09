package com.hzaihua.newapp.views;

import com.hzaihua.newapp.dao.StudentDao;
import com.hzaihua.newapp.entity.Student;
import com.hzaihua.newapp.websocket.WebSocketServer;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
@org.springframework.stereotype.Controller
public class Controller /*implements Initializable */{
    @Resource
    private StudentDao studentDao;
    @Resource
    private WebSocketServer webSocketServer;

    @FXML
    private Text actiontarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button exitLogin;

    /*@FXML
    private Pane pane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private HBox hBox1;*/
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
                stage.close();
                LayoutSampleCSS main = new LayoutSampleCSS();
            }else{
                actiontarget.setText("登录失败，密码错误");

            }
        }else{
            actiontarget.setText("登录失败，账号错误");
        }
    }

    @ResponseBody
    @RequestMapping("sendMessage")
    public String sendMessage(String message){
        System.out.println(message);
        webSocketServer.sendMessage(message);
        return "true";
    }
    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.prefWidthProperty().bind(pane.widthProperty());//宽度绑定为Pane宽度
        *//*pane.setPrefHeight(pane.getPrefHeight()-240.0);
        hBox1.prefHeightProperty().bind(pane.heightProperty());*//*
        hBox1.prefWidthProperty().bind(pane.widthProperty());
    }*/
}
