package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;
import static com.hzaihua.jfoenix.controller.user.UserInfoController.downUserList;

@ViewController(value = "/views/fxml/user/findDownUser.fxml")
public class FindDownUserController {
    @FXML
    //查询下级用户确定按钮
    private JFXButton comitFindDownUsers;
    @FXML
    private TextField downUserName;
    @FXML
    private TextField downName;
    @FXML
    private TextField downTelephone;
    @FXML
    private Text actiontarget;

    @PostConstruct
    public void init(){
        InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
        comitFindDownUsers.setOnAction(event -> {
            Stage stage = (Stage)comitFindDownUsers.getScene().getWindow();
            String username = downUserName.getText();
            String name = downName.getText();
            String phone = downTelephone.getText();
            if("".equals(username) && "".equals(name) && "".equals(phone)) {
                actiontarget.setText("请至少输入一项搜索条件");
            }else{
                InfoUser user = infoUserService.queryUserByNameOrPhone(username, name, phone);
                downUserList.clear();
                downUserList.add(user);
                stage.close();
            }
        });
    }
}
