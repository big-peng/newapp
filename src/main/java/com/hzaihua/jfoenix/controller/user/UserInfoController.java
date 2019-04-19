package com.hzaihua.jfoenix.controller.user;

import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.controller.MoreInfoController;
import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.load.User.AddDownUserLoad;
import com.hzaihua.jfoenix.load.User.FindDownUserLoad;
import com.hzaihua.jfoenix.load.User.EditPasswordLoad;
import com.hzaihua.jfoenix.load.User.EditUserLoad;
import com.hzaihua.jfoenix.service.InfoUserService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@ViewController(value = "/views/fxml/user/UserInfo.fxml")
public class UserInfoController {
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
    //删除数据的编号
    private static String deleteUserName;
    //查询到的全部数据
    static ObservableList<InfoUser> downUserList = null;
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
    @FXML
    //刷新列表
    private JFXButton renovate;

    private int id;
    //表格中需要呈现的数据
    ObservableList<InfoUser> nowdownUserList = FXCollections.observableArrayList();
    //当前登录的用户信息
    InfoUserService infoUserService = BeanFactoryUtil.getApplicationContext().getBean(InfoUserService.class);
    @FXML
    private JFXTreeTableView<InfoUser> downUserTreeTableView;
    @FXML
    private AnchorPane root;
    //当前用户标签
    @FXML
    private Label userName;
    @FXML
    private Label userType;
    @FXML
    private Label nickName;
    @FXML
    private Label phone;
    @FXML
    private Label occupation;
    @FXML
    private Label company;
    @FXML
    private ImageView headFileName;
    //下级用户列表标签
    @FXML
    private JFXPopup moreInfoPopup;
    @FXML
    private JFXTreeTableColumn downusername;
    @FXML
    private JFXTreeTableColumn downname;
    @FXML
    private JFXTreeTableColumn status;
    @FXML
    private JFXTreeTableColumn downtype;
    @FXML
    private JFXTreeTableColumn downphone;
    //需要删除的行数
    private int deleteRow;

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
        //刷新列表操作
        renovate.setOnAction(event -> {
            downUserList = infoUserService.queryAllInfoUser();
            downUserTreeTableView.setRoot(new RecursiveTreeItem<>(downUserList, RecursiveTreeObject::getChildren));
            downUserTreeTableView.setShowRoot(false);
        });

        //下级用户表格
        downUserTableView();

        //当前登录用户信息
        userInfoGrid();


        //建立删除按钮点击事件
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
                if(infoUserService.deleteByUserName(deleteUserName)){
                    downUserList.remove(id);
                    //删除成功后的提示，可以根据返回值判断是否删除成功，并弹出对应信息
                    downUserTreeTableView.setRoot(new RecursiveTreeItem<>(downUserList, RecursiveTreeObject::getChildren));
                    downUserTreeTableView.setShowRoot(false);
                    downUserHbox.setDisable(true);
                    downUserTreeTableView.setShowRoot(false);
                    id = -1;
                    snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                            new JFXSnackbarLayout("删除成功", "",null/*event1 -> snackbar.close()*/),
                            Duration.millis(2000), null));
                }
            });
            List<JFXButton> buttons = new ArrayList<JFXButton>();
            buttons.add(trueButton);
            buttons.add(closeButton);
            layout.setActions(buttons);
            alert.setContent(layout);
            alert.show();
        });
    }

    public <T> void setupCellValueFactory(JFXTreeTableColumn<InfoUser, T> column, Function<InfoUser, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<InfoUser, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private void downUserTableView(){
        downUserList = infoUserService.queryAllInfoUser();
        setupCellValueFactory(downusername,InfoUser::userNameProperty);
        setupCellValueFactory(downname, InfoUser::nickNameProperty);
        setupCellValueFactory(status,InfoUser::statusProperty);
        setupCellValueFactory(downtype,InfoUser::userTypeProperty);
        setupCellValueFactory(downphone,InfoUser::phoneProperty);
        downUserTreeTableView.setRoot(new RecursiveTreeItem<>(downUserList, RecursiveTreeObject::getChildren));
        downUserTreeTableView.setShowRoot(false);

        //表格的点击事件
        downUserTreeTableView.setRowFactory(tv->{
            TreeTableRow<InfoUser> row = new TreeTableRow<InfoUser>();
            row.setOnMouseClicked(event -> {
                if(event.getButton().toString().equals("PRIMARY") && event.getClickCount() == 1 && (! row.isEmpty())){
                    InfoUser emailInfo = row.getItem();
                    //记录选中的
                    if (deleteRow == row.getIndex()){
                        //如果点击第二次，刷新表格以取消选中
                        downUserTreeTableView.setRoot(new RecursiveTreeItem<>(downUserList, RecursiveTreeObject::getChildren));
                        downUserTreeTableView.setShowRoot(false);
                        deleteRow = -1;
                        downUserHbox.setDisable(true);
                    }else {
                        deleteRow = row.getIndex();
                        deleteUserName = row.getItem().getUserName();
                        downUserHbox.setDisable(false);
                    }
                }

            });
            return row;
        });
    }

    private void userInfoGrid(){
        InfoUser infoUser = infoUserService.queryByUserName("admin");
        userName.setText(infoUser.getUserName());
        nickName.setText(infoUser.getNickName());
        userType.setText(infoUser.getUserType());
        phone.setText(infoUser.getPhone());
        occupation.setText(infoUser.getOccupation());
        company.setText(infoUser.getCompany());
        headFileName.setImage(new Image(infoUser.getHeadFileName()));
    }
}
