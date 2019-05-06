package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.controller.measure.UndistributeMeasureController;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.load.User.AddDownUserLoad;
import com.hzaihua.jfoenix.load.measure.UndisMeasureLoad;
import com.hzaihua.jfoenix.load.measure.UndistributeMeasureLoad;
import com.hzaihua.jfoenix.service.InfoMeasureService;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.hzaihua.jfoenix.util.PswMD5;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@ViewController(value = "/views/fxml/user/addDownUser.fxml")
public class AddDownUserController {
    //提交添加按钮
    @FXML
    private JFXButton commitAddDownUser;
    //分配测点按钮
    @FXML
    private JFXButton distributeMeasure;
    //选择图片按钮
    @FXML
    private JFXButton fileChoose;

    //需要输入的属性
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField againPassword;
    @FXML
    private TextField downName;
    @FXML
    private TextField downTelephone;
    @FXML
    private TextField occupation;
    @FXML
    private TextField company;
    //头像
    @FXML
    private ImageView headFileName;
    //用户类型下拉框
    @FXML
    private ComboBox<String> downUserType;
    //分配测点列表
    @FXML
    private TableView<InfoMeasure> downDeviceTreeTableView;
    //列表中的属性
    @FXML
    private TableColumn measureCode;
    @FXML
    private TableColumn measureName;
    public static ObservableList<InfoMeasure> undistriList = FXCollections.observableArrayList();
    //提示框
    @FXML
    private Text actiontarget;

    String path = null;

    @PostConstruct
    public void init() {
        InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
        InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);
        fileChoose.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                path = file.getPath();
                String suxx = path.substring(path.lastIndexOf(".") + 1, path.length());
                if (file.length() > 2 * 1024 * 1024) {
                    actiontarget.setText("文件过大,请重新选择");
                } else if (!("jpg".equals(suxx)) && !("png".equals(suxx)) && !("JPG".equals(suxx)) && !("PNG".equals(suxx))) {
                    actiontarget.setText("图片格式不正确，请重新选择");
                    headFileName.setImage(null);
                } else if (path == null || path == "") {
                    actiontarget.setText("请重新选择");
                } else {
                    headFileName.setImage(new Image("file:" + path));
                }
            }

        });

        undisMeatrueList();

        //必须输入项判断
        username.focusedProperty().addListener((ob, old, now) -> {
            if (!now) {
                InfoUser user = infoUserService.queryByUserName(username.getText());
                System.out.println(username.getText());
                System.out.println(user);
                if (user == null) {
                    actiontarget.setText("用户名不存在，可以创建");
                } else {
                    actiontarget.setText("用户名存在");
                }
            }
        });
        distributeMeasure.setOnAction(event -> {
            UndisMeasureLoad undisMeasureLoad = new UndisMeasureLoad();
        });
        commitAddDownUser.setOnAction(event -> {
            Stage stage = (Stage) commitAddDownUser.getScene().getWindow();
            String addUserName = username.getText();
            String addPassword = password.getText();
            String addAgainPassword = againPassword.getText();
            String addName = downName.getText();
            String addPhone = downTelephone.getText();
            String addOcc = occupation.getText();
            String addComp = company.getText();
            //密码、名称和电话验证正则表达式
            String check = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,20}$";
            String re = "^[\u4e00-\u9fa5]{2,4}$";
            String reg = "^(-?)[1-9]+\\d*|0";
            String rege = "^[1][\\d]{10}";

            if ("".equals(addUserName)) {
                actiontarget.setText("用户名不能为空");
            } else if ("".equals(addPassword)) {
                actiontarget.setText("密码不能为空");
            } else if (!(addPassword.matches(check))) {
                actiontarget.setText("密码格式不正确");
            } else if (!(PswMD5.EncoderByMD5(addAgainPassword).equals(PswMD5.EncoderByMD5(addPassword)))) {
                actiontarget.setText("两次输入的密码不相同，请确认");
            } else if ("".equals(addName)) {
                actiontarget.setText("名字不能为空");
            } else if (!addName.matches(re)) {
                actiontarget.setText("名称格式不正确");
            } else if ("".equals(addPhone)) {
                actiontarget.setText("电话号码不能为空");
            } else if (addPhone.matches(reg) && !(addPhone.matches(rege))) {
                actiontarget.setText("电话号码格式不正确");
            } else {
                //添加用户
                InfoUser infoUser = new InfoUser();
                infoUser.setUserName(addUserName);
                infoUser.setPassword(PswMD5.EncoderByMD5(addPassword));
                infoUser.setNickName(addName);
                infoUser.setPhone(addPhone);
                infoUser.setOccupation(addOcc);
                infoUser.setCompany(addComp);
                infoUser.setUserType(downUserType.getValue());
                infoUser.setParentUser("3");
                infoUser.setStatus("离线");
                infoUser.setHeadFileName("file:" + path);
                infoUserService.addInfoUser(infoUser, undistriList);
                undistriList.clear();
                infoUser.setStatus("0");
                infoUser.setUserType("0");
                UserInfoController.downUserList.add(infoUser);
                stage.close();
            }
        });

    }

    private void undisMeatrueList() {
        measureCode.setCellValueFactory(new PropertyValueFactory<>("measureCode"));
        measureName.setCellValueFactory(new PropertyValueFactory<>("measureName"));
        downDeviceTreeTableView.setItems(undistriList);
    }
}
