package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.entity.DownUser;
import com.hzaihua.jfoenix.load.User.AddDownUserLoad;
import com.hzaihua.jfoenix.load.User.FindDownUserLoad;
import com.hzaihua.jfoenix.load.User.EditPasswordLoad;
import com.hzaihua.jfoenix.load.User.EditUserLoad;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ViewController(value = "/views/fxml/user/UserInfo.fxml")
public class UserInfoController {
    //查询到的全部数据
    ObservableList<DownUser> dummyData = null;
    //表格中需要呈现的数据
    ObservableList<DownUser> nowDummyData = FXCollections.observableArrayList();
    //查询下级用户按钮
    @FXML
    private JFXButton findDownUser;
    //编辑当前用户按钮
    @FXML
    private JFXButton editUser;
    //修改密码按钮
    @FXML
    private JFXButton editPassword;
    //删除下级用户按钮
    @FXML
    private JFXButton deleteDownUser;
    @FXML
    private JFXButton addDownUser;
    @FXML
    private JFXTreeTableView<DownUser> downUserTreeTableView;
    @FXML
    private StackPane root;
    @FXML
    private JFXDialog dialog;
    //下级用户表格框
    @FXML
    private HBox downUserHbox;
    @FXML
    //修改用户信息提交按钮
    private JFXButton comitEditUser;
    @FXML
    //修改密码提交按钮
    private JFXButton comitEditPassword;
    private int id;

    @PostConstruct
    public void init(){
        //搜索用户操作
        findDownUser.setOnAction(event->{
            FindDownUserLoad findDownUserLoad = new FindDownUserLoad();
        });

        //编辑用户信息操作
        editUser.setOnAction(event -> {
            EditUserLoad editUserLoad = new EditUserLoad();
        });

        //修改密码操作
        editPassword.setOnAction(event -> {
            EditPasswordLoad editPasswordLoad = new EditPasswordLoad();
        });

        //添加用户操作
        addDownUser.setOnAction(event -> {
            AddDownUserLoad addDownUserLoad = new AddDownUserLoad();
        });

        /*//建立删除按钮点击事件
        JFXSnackbar snackbar = new JFXSnackbar(root);
        snackbar.setPrefWidth(300);
        root.getChildren().remove(dialog);
        //删除按钮操作
        deleteDownUser.setOnAction(action->{
            JFXAlert alert = new JFXAlert((Stage) deleteDownUser.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("提示！"));
            layout.setBody(new Label("你确定要删除测点"+id+"吗？\n" +
                    "删除后将无法恢复"));
            JFXButton trueButton = new JFXButton("确认");
            JFXButton closeButton = new JFXButton("取消");
            closeButton.getStyleClass().add("dialog-accept");
            trueButton.getStyleClass().add("dialog-accept");
            trueButton.setStyle("-fx-text-fill: #D34336;-fx-background-color: white");
            closeButton.setOnAction(event -> alert.hideWithAnimation());
            trueButton.setOnAction(event -> {
                alert.hideWithAnimation();
                //先从数据库中删除，返回删除成功之后在删除表格中的
                //删除不能以行数为标准删除，否则会出Bug
                dummyData.remove(nowDummyData.get(id));
                nowDummyData.remove(id);
                //删除成功后的提示，可以根据返回值判断是否删除成功，并弹出对应信息
                downUserTreeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                downUserTreeTableView.setShowRoot(false);
                downUserHbox.setDisable(true);
                *//*treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                treeTableView.setShowRoot(false);*//*
                id = -1;
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                        new JFXSnackbarLayout("删除成功", "",null*//*event1 -> snackbar.close()*//*),
                        Duration.millis(1500), null));
            });
            List<JFXButton> buttons = new ArrayList<JFXButton>();
            buttons.add(trueButton);
            buttons.add(closeButton);
            layout.setActions(buttons);
            alert.setContent(layout);
            alert.show();
        });*/
    }
}
