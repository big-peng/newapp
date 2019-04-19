package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.load.User.EditPasswordLoad;
import com.hzaihua.jfoenix.load.User.FindDownUserLoad;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.hzaihua.jfoenix.util.PswMD5;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/user/editPassword.fxml")
public class EditUserPasswordController {

    @FXML
    private JFXButton comitEditPassword;
    @FXML
    private TextField oldPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField againPassword;
    @FXML
    private Text actiontarget;
    private EditPasswordLoad editPasswordLoad;

    @PostConstruct
    public void init() throws Exception{
        comitEditPassword.setOnAction(event -> {
            InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
            Stage stage = (Stage)comitEditPassword.getScene().getWindow();
            InfoUser infoUser = infoUserService.queryByUserName("admin");
            String check = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,20}$";
            String oldWord = oldPassword.getText();
            String newWord = newPassword.getText();
            String againWord = againPassword.getText();
            if ("".equals(oldWord)){
                actiontarget.setText("原密码不能为空");
            }else if(!(infoUser.getPassword()).equals(PswMD5.EncoderByMD5(oldWord))){
                actiontarget.setText("原密码错误");
            } else if(PswMD5.EncoderByMD5(oldWord).equals(PswMD5.EncoderByMD5(newWord))){
                actiontarget.setText("新密码与原密码相同，请重新输入");
            }else if("".equals(newWord) || "".equals(oldWord)){
                actiontarget.setText("新密码不能为空");
            }else if(!(newWord.matches(check))){
                System.out.println(newWord);
                System.out.println(newWord.matches(check));
                actiontarget.setText("新密码长度不正确");
            }else if(!(PswMD5.EncoderByMD5(newWord).equals(PswMD5.EncoderByMD5(againWord)))){
                actiontarget.setText("两次输入的密码不相同，请确认");
            }else if(PswMD5.EncoderByMD5(newWord).equals(PswMD5.EncoderByMD5(againWord))){
                actiontarget.setText("");
                infoUserService.updatePassword("3", PswMD5.EncoderByMD5(newWord));
                stage.close();
            }
        });
    }
}
