package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;
import java.io.File;


@ViewController(value = "/views/fxml/user/editUser.fxml")
public class EditUserController {
    @FXML
    private JFXButton comitEditUser;
    @FXML
    private JFXButton photoChoose;

    @FXML
    private TextField nickName;
    @FXML
    private TextField phone;
    @FXML
    private TextField occupation;
    @FXML
    private TextField company;
    @FXML
    private ImageView headFileName;
    @FXML
    private Text actiontarget;

    String path = null;

    @PostConstruct
    public void init(){
        InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
        InfoUser infoUser = infoUserService.queryByUserName("admin");
        nickName.setText(infoUser.getNickName());
        phone.setText(infoUser.getPhone());
        occupation.setText(infoUser.getOccupation());
        company.setText(infoUser.getCompany());
        headFileName.setImage(new Image(infoUser.getHeadFileName()));

        //选择图片
        photoChoose.setOnAction(event -> {
            FileChooser fileChooser=new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            path = file.getPath();
            String suxx = path.substring(path.lastIndexOf(".")+1,path.length());
            if(file.length()>2*1024*1024){
                actiontarget.setText("文件过大,请重新选择");
            }else if(!("jpg".equals(suxx)) && !("png".equals(suxx)) && !("JPG".equals(suxx)) && !("PNG".equals(suxx))){
                actiontarget.setText("图片格式不正确，请重新选择");
                headFileName.setImage(null);
            }else if(path == null || path == ""){
                actiontarget.setText("请重新选择图片");
            }else {
                headFileName.setImage(new Image("file:" + path));
            }
        });


        //确定修改并提交到数据库
        comitEditUser.setOnAction(event -> {
            Stage stage = (Stage)comitEditUser.getScene().getWindow();
            String name = nickName.getText();
            String telephone = phone.getText();
            String occup = occupation.getText();
            String comp = company.getText();
            //名称和电话验证正则表达式
            String re = "^[\u4e00-\u9fa5]{2,4}$";
            String reg="^(-?)[1-9]+\\d*|0";
            String rege="^[1][\\d]{10}";
            if ("".equals(name)){
                actiontarget.setText("名字不能为空");
            }else if(!name.matches(re)){
                actiontarget.setText("名称格式不正确");
            }else if("".equals(telephone)){
                actiontarget.setText("电话号码不能为空");
            }else if(telephone.matches(reg) && !(telephone.matches(rege))){
                actiontarget.setText("电话号码格式不正确");
            }else {
                infoUser.setNickName(name);
                infoUser.setPhone(telephone);
                infoUser.setOccupation(occup);
                infoUser.setCompany(comp);
                infoUser.setHeadFileName("file:"+path);
                infoUserService.updateInfoUser(infoUser);
                actiontarget.setText("");
                stage.close();
            }
        });
    }
}
