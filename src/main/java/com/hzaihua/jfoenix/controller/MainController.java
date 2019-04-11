package com.hzaihua.jfoenix.controller;

import com.hzaihua.jfoenix.load.SystemSetupLoad;
import com.hzaihua.jfoenix.load.User.UserLoad;
import com.hzaihua.jfoenix.load.measure.AddFixedMeasureLoad;
import com.hzaihua.jfoenix.load.measure.AddMoveMeasureLoad;
import com.hzaihua.jfoenix.service.DeviceManageService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeTableRow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.annotation.PostConstruct;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import org.springframework.stereotype.Controller;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

@ViewController(value = "/views/fxml/main/main.fxml")
public class MainController {
    private final Random random = new SecureRandom();
    //查询到的全部数据
    ObservableList<StateMeasure> dummyData = null;
    //表格中需要呈现的数据
    ObservableList<StateMeasure> nowDummyData = FXCollections.observableArrayList();
    ObservableList<StateMeasure> searchFieldDummyData = FXCollections.observableArrayList();
    ObservableList<StateMeasure> searchComboBoxDummyData = FXCollections.observableArrayList();
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;
    @FXML
    private StackPane optionsBurgerFile;
    @FXML
    private StackPane optionsBurgerEdit;
    @FXML
    private StackPane optionsBurgerOperate;
    @FXML
    private JFXButton changeMeasure;
    private JFXPopup toolbarPopupFile;
    private JFXPopup toolbarPopupEdit;
    private JFXPopup toolbarPopupOperate;
    private JFXPopup moreInfoPopup;
    private JFXPopup changeMeasureMove;
    // readonly table view
    @FXML
    private JFXTreeTableView<StateMeasure> treeTableView;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> measureCode;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> measureName;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> linkState;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> dataTime;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> data;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> address;
    @FXML
    private JFXTreeTableColumn<StateMeasure, String> other;
    @FXML
    private JFXTextField searchField;

    @FXML
    private Label treeTableViewCount;
    @FXML
    private JFXButton treeTableViewAdd;
    @FXML
    private JFXButton treeTableViewRemove;
    @FXML
    private Label editableTreeTableViewCount;
    //用来记录选中的是哪一个设备或测点，为测点编号
    //private String id;
    //要删除的行数
    private int deleteRow;
    //要删除的数据的测点编号
    private String deleteMeasureCode;
    @FXML
    private HBox disableHBox;
    @FXML
    private JFXButton deleteButton;
    @FXML
    private JFXButton clearSearch;
    @FXML
    private JFXComboBox searchComboBox;
    @FXML
    private StackPane root;
    @FXML
    private JFXDialog dialog;

    @PostConstruct
    public void init() throws Exception {
        FXMLLoader loaderFile = new FXMLLoader(getClass().getResource("/views/fxml/main/mainPopupFile.fxml"));
        toolbarPopupFile = new JFXPopup(loaderFile.load());
        FXMLLoader loaderEdit = new FXMLLoader(getClass().getResource("/views/fxml/main/mainPopupEdit.fxml"));
        loaderEdit.setController(new InputController());
        toolbarPopupEdit = new JFXPopup(loaderEdit.load());
        FXMLLoader loaderOperate = new FXMLLoader(getClass().getResource("/views/fxml/main/mainPopupOperate.fxml"));
        loaderOperate.setController(new PopupOperateController());
        toolbarPopupOperate = new JFXPopup(loaderOperate.load());
        FXMLLoader loaderChange = new FXMLLoader(getClass().getResource("/views/fxml/measure/changeMasure.fxml"));
        loaderChange.setController(new ChangeMeasureController());
        changeMeasureMove = new JFXPopup(loaderChange.load());
        optionsBurgerFile.setOnMouseClicked(e -> toolbarPopupFile.show(optionsBurgerFile,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                49.99));
        optionsBurgerEdit.setOnMouseClicked(e -> toolbarPopupEdit.show(optionsBurgerEdit,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                50));
        optionsBurgerOperate.setOnMouseClicked(e -> toolbarPopupOperate.show(optionsBurgerOperate,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                50));
        changeMeasure.setOnMouseClicked(e -> changeMeasureMove.show(changeMeasure,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                50));

        // 给中间的页面赋上内容
        //只读的表格
        setupReadOnlyTableView();
        //可以编辑的表格
        //setupEditableTableView();

        //建立删除按钮点击事件
        JFXSnackbar snackbar = new JFXSnackbar(root);
        snackbar.setPrefWidth(300);

        root.getChildren().remove(dialog);
        deleteButton.setOnAction(action->{
            JFXAlert alert = new JFXAlert((Stage) deleteButton.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setOverlayClose(false);
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setHeading(new Label("提示！"));
            layout.setBody(new Label("你确定要删除测点"+deleteMeasureCode+"吗？\n" +
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
                dummyData.remove(nowDummyData.get(deleteRow));
                nowDummyData.remove(deleteRow);
                //删除成功后的提示，可以根据返回值判断是否删除成功，并弹出对应信息
                treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                treeTableView.setShowRoot(false);
                disableHBox.setDisable(true);
                /*treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                treeTableView.setShowRoot(false);*/
                deleteRow = -1;
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                        new JFXSnackbarLayout("删除成功", "",null/*event1 -> snackbar.close()*/),
                        Duration.millis(2000), null));
            });
            List<JFXButton> buttons = new ArrayList<JFXButton>();
            buttons.add(trueButton);
            buttons.add(closeButton);
            layout.setActions(buttons);
            alert.setContent(layout);
            alert.show();
        });
        //清除按钮的事件，可以清除下拉框以及输入框
        clearSearch.setOnAction(event -> {
            searchComboBox.setValue(null);
            searchField.setText(null);
        });
        //给筛选的下拉框赋值
        /*ObservableList<Label> as = FXCollections.observableArrayList();
        for (String name:names) {
            as.add(new Label(name));
        }
        searchComboBox.setItems(as);*/
    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<StateMeasure, T> column, Function<StateMeasure, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<StateMeasure, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    DeviceManageService deviceManageService = BeanFactoryUtil.getApplicationContext().getBean(DeviceManageService.class);
    private void setupReadOnlyTableView() {
        setupCellValueFactory(measureCode, StateMeasure::measureCodeProperty);
        setupCellValueFactory(measureName, StateMeasure::measureNameProperty);
        setupCellValueFactory(linkState, StateMeasure::linkStateProperty);
        setupCellValueFactory(dataTime, StateMeasure::dataTimeProperty);
        setupCellValueFactory(data, StateMeasure::dataProperty);
        setupCellValueFactory(address, StateMeasure::addressProperty);
        setupCellValueFactory(other, StateMeasure::otherProperty);

        //创建表格中的数据
        System.out.println(deviceManageService);
        dummyData = deviceManageService.getIndexList();
        nowDummyData.addAll(dummyData);
        treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));

        treeTableView.setShowRoot(false);
        /*TableRow<Person> row = new TableRow<Person>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                //Person emailInfo = row.getItem();
                System.out.println(123);
            }
        });*/
        /*System.out.println(firstNameColumn.getTreeTableView());
        treeTableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                //Person emailInfo = row.getItem();
                System.out.println(event.getSource());

            }
        });*/
        //表格的点击事件
        treeTableView.setRowFactory(tv->{
            TreeTableRow<StateMeasure> row = new TreeTableRow<StateMeasure>();
            row.setOnMouseClicked(event -> {
                if (event.getButton().toString().equals("SECONDARY") && (! row.isEmpty()) ) {
                    StateMeasure emailInfo = row.getItem();
                    FXMLLoader moreInfo = new FXMLLoader(getClass().getResource("/views/fxml/system/MoreInfo.fxml"));
                    try {
                        moreInfoPopup = new JFXPopup(moreInfo.load());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    moreInfoPopup.show(row,
                            JFXPopup.PopupVPosition.TOP,
                            JFXPopup.PopupHPosition.LEFT,
                            2,
                            50);
                }else if(event.getButton().toString().equals("PRIMARY") && event.getClickCount() == 1 && (! row.isEmpty()) ){
                    StateMeasure emailInfo = row.getItem();
                    //记录选中的
                    System.out.println(row.getIndex());
                    //id = emailInfo.firstNameProperty().getValue();
                    if (deleteRow == row.getIndex()){
                        //如果点击第二次，刷新表格以取消选中
                        treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                        treeTableView.setShowRoot(false);
                        deleteRow = -1;
                        disableHBox.setDisable(true);
                    }else {
                        deleteRow = row.getIndex();
                        deleteMeasureCode = row.getItem().getMeasureCode();
                        disableHBox.setDisable(false);
                    }
                }
            });
            return row;
        });
        searchFieldDummyData.addAll(dummyData);
        searchComboBoxDummyData.addAll(dummyData);
        searchField.textProperty().addListener(setupSearchField(treeTableView));
        searchComboBox.getSelectionModel().selectedItemProperty().addListener(setupSearchComboBox(treeTableView));
    }

    //搜索框的实现
    private ChangeListener<String> setupSearchField(final JFXTreeTableView<MainController.StateMeasure> tableView) {
        return (o, oldVal, newVal) -> {
            nowDummyData.clear();
            nowDummyData.addAll(dummyData);
            if (newVal!=null){
                for (StateMeasure stateMeasure:dummyData){
                    if (!stateMeasure.measureCode.get().contains(newVal) && !stateMeasure.measureName.get().contains(newVal)) {
                        nowDummyData.remove(stateMeasure);
                    }
                }
            }
            searchFieldDummyData.clear();
            searchFieldDummyData.addAll(nowDummyData);
            nowDummyData.retainAll(searchComboBoxDummyData);
            /*if (newVal.contains(oldVal)){
                for (Person person:dummyData){
                    if (!person.firstName.get().contains(newVal) && !person.lastName.get().contains(newVal) && !Integer.toString(person.age.get()).contains(newVal)){
                        nowDummyData.remove(person);
                    }
                }
            }else {
                ObservableList<Person> searchDummyData = FXCollections.observableArrayList();
                searchDummyData.addAll(this.searchFieldDummyData);
                for (Person person:dummyData){
                    if (!person.firstName.get().contains(newVal) && !person.lastName.get().contains(newVal) && !Integer.toString(person.age.get()).contains(newVal)){
                        searchDummyData.remove(person);
                    }
                }
                nowDummyData.clear();
                nowDummyData.addAll(searchDummyData);
            }*//*
            *//*tableView.setPredicate(personProp -> {
                final Person person = personProp.getValue();
                if (newVal == null) {
                    return true;
                } else {
                    return person.firstName.get().contains(newVal)
                            || person.lastName.get().contains(newVal)
                            || Integer.toString(person.age.get()).contains(newVal);
                }
            });*/
        };
    }

    private ChangeListener<Label> setupSearchComboBox(final JFXTreeTableView<MainController.StateMeasure> tableView) {
        return (o, oldVal, newVal) ->{
            nowDummyData.clear();
            nowDummyData.addAll(dummyData);
            if (newVal != null){
                for (StateMeasure stateMeasure:dummyData){
                    if (!stateMeasure.linkState.get().equals(newVal.getText())){
                        nowDummyData.remove(stateMeasure);
                    }
                }
            }
            searchComboBoxDummyData.clear();
            searchComboBoxDummyData.addAll(nowDummyData);
            nowDummyData.retainAll(searchFieldDummyData);
        };
                /*tableView.setPredicate(personProp -> {
                    final Person person = personProp.getValue();
                    searchDummyData.addAll(nowDummyData);
                    if (newVal==null){
                        return true;
                    }else {
                        return person.firstName.get().contains(newVal.getText());
                    }
                });*/
    }

    public static final class InputController {
        @FXML
        private JFXListView<?> toolbarPopupList;

        // close application
        @FXML
        private void submit() {
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 1) {
                SystemSetupLoad systemSetupLoad = new SystemSetupLoad();
            }else if(toolbarPopupList.getSelectionModel().getSelectedIndex()==0){
                UserLoad userLoad = new UserLoad();
            }
        }
    }

    public static final class ChangeMeasureController{
        @FXML
        private JFXListView<?> changeMeasureList;

        @FXML
        private void submit(){
            if(changeMeasureList.getSelectionModel().getSelectedIndex() == 0){
                AddFixedMeasureLoad addFixedMeasureLoad = new AddFixedMeasureLoad();
            }else if(changeMeasureList.getSelectionModel().getSelectedIndex() == 1){
                AddMoveMeasureLoad addMoveMeasureLoad = new AddMoveMeasureLoad();
            }
        }
    }

    public static final class PopupOperateController {
        @FXML
        private JFXListView<?> toolbarPopupList;

        // close application
        @FXML
        private void submit() {
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 1) {
                SystemSetupLoad systemSetupLoad = new SystemSetupLoad();
            }
        }
    }

    /*
     * data class
     * 可以再该类中设置列数据
     */
    public static class StateMeasure extends RecursiveTreeObject<StateMeasure> {
        private StringProperty measureCode;//测点的编号
        private StringProperty measureName;//测点的名称
        private StringProperty linkState;//测点中的设备连接状态
        private StringProperty dataTime;//数值时间
        private StringProperty data;//数值
        private StringProperty address;//测点的位置信息
        private StringProperty other;//测点的其他参数

        public String getMeasureCode() {
            return measureCode.get();
        }

        public StringProperty measureCodeProperty() {
            return measureCode;
        }

        public void setMeasureCode(String measureCode) {
            this.measureCode = new SimpleStringProperty(measureCode);
        }

        public String getMeasureName() {
            return measureName.get();
        }

        public StringProperty measureNameProperty() {
            return measureName;
        }

        public void setMeasureName(String measureName) {
            this.measureName = new SimpleStringProperty(measureName);
        }

        public String getLinkState() {
            return linkState.get();
        }

        public StringProperty linkStateProperty() {
            return linkState;
        }

        public void setLinkState(String linkState) {
            this.linkState = new SimpleStringProperty(linkState);
        }

        public String getDataTime() {
            return dataTime.get();
        }

        public StringProperty dataTimeProperty() {
            return dataTime;
        }

        public void setDataTime(String dataTime) {
            this.dataTime = new SimpleStringProperty(dataTime);
        }

        public String getData() {
            return data.get();
        }

        public StringProperty dataProperty() {
            return data;
        }

        public void setData(String data) {
            this.data = new SimpleStringProperty(data);
        }

        public String getAddress() {
            return address.get();
        }

        public StringProperty addressProperty() {
            return address;
        }

        public void setAddress(String address) {
            this.address = new SimpleStringProperty(address);
        }

        public String getOther() {
            return other.get();
        }

        public StringProperty otherProperty() {
            return other;
        }

        public void setOther(String other) {
            this.other = new SimpleStringProperty(other);
        }

        public StateMeasure(String measureCode, String measureName, String linkState, String dataTime, String data, String address, String other) {
            this.measureCode = new SimpleStringProperty(measureCode);
            this.measureName = new SimpleStringProperty(measureName);
            this.linkState = new SimpleStringProperty(linkState);
            this.dataTime = new SimpleStringProperty(dataTime);
            this.data = new SimpleStringProperty(data);
            this.address = new SimpleStringProperty(address);
            this.other = new SimpleStringProperty(other);
        }

        @Override
        public String toString() {
            return "StateMeasure{" +
                    "measureCode=" + measureCode +
                    ", measureName=" + measureName +
                    ", linkState=" + linkState +
                    ", dataTime=" + dataTime +
                    ", data=" + data +
                    ", address=" + address +
                    ", other=" + other +
                    '}';
        }
    }
}
