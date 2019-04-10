package com.hzaihua.jfoenix.controller;

import com.hzaihua.jfoenix.load.SystemSetupLoad;
import com.hzaihua.jfoenix.load.User.UserLoad;
import com.hzaihua.jfoenix.load.measure.AddFixedMeasureLoad;
import com.hzaihua.jfoenix.load.measure.AddMoveMeasureLoad;
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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

@ViewController(value = "/views/fxml/main/main.fxml")
public class MainController {
    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";
    private final String[] names = {"Morley", "Scott", "Kruger", "Lain",
            "Kennedy", "Gawron", "Han", "Hall", "Aydogdu", "Grace",
            "Spiers", "Perera", "Smith", "Connoly",
            "Sokolowski", "Chaow", "James", "June",};

    /*@FXML
    private JFXDrawer drawer;*/
    private final Random random = new SecureRandom();
    //查询到的全部数据
    ObservableList<Person> dummyData = null;
    //表格中需要呈现的数据
    ObservableList<Person> nowDummyData = FXCollections.observableArrayList();
    ObservableList<Person> searchFieldDummyData = FXCollections.observableArrayList();
    ObservableList<Person> searchComboBoxDummyData = FXCollections.observableArrayList();
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
    private JFXTreeTableView<Person> treeTableView;
    @FXML
    private JFXTreeTableColumn<Person, String> firstNameColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> lastNameColumn;
    @FXML
    private JFXTreeTableColumn<Person, Integer> ageColumn;
    @FXML
    private JFXTextField searchField;
    // editable table view
    @FXML
    private JFXTreeTableView<Person> editableTreeTableView;
    @FXML
    private JFXTreeTableColumn<Person, String> firstNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, String> lastNameEditableColumn;
    @FXML
    private JFXTreeTableColumn<Person, Integer> ageEditableColumn;
    @FXML
    private Label treeTableViewCount;
    @FXML
    private JFXButton treeTableViewAdd;
    @FXML
    private JFXButton treeTableViewRemove;
    @FXML
    private Label editableTreeTableViewCount;
    //用来记录选中的是哪一个设备或测点
    //private String id;
    private int id;
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
                treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                treeTableView.setShowRoot(false);
                disableHBox.setDisable(true);
                /*treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                treeTableView.setShowRoot(false);*/
                id = -1;
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
        ObservableList<Label> as = FXCollections.observableArrayList();
        for (String name:names) {
            as.add(new Label(name));
        }
        searchComboBox.setItems(as);
    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<Person, T> column, Function<Person, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private void setupReadOnlyTableView() {
        setupCellValueFactory(firstNameColumn, Person::firstNameProperty);
        setupCellValueFactory(lastNameColumn, Person::lastNameProperty);
        setupCellValueFactory(ageColumn, p -> p.age.asObject());

        //创建表格中的数据
        dummyData = generateDummyData(100);
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
            TreeTableRow<Person> row = new TreeTableRow<Person>();
            row.setOnMouseClicked(event -> {
                if (event.getButton().toString().equals("SECONDARY") && (! row.isEmpty()) ) {
                    Person emailInfo = row.getItem();
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
                    Person emailInfo = row.getItem();
                    //记录选中的
                    System.out.println(row.getIndex());
                    //id = emailInfo.firstNameProperty().getValue();
                    if (id == row.getIndex()){
                        //如果点击第二次，刷新表格以取消选中
                        treeTableView.setRoot(new RecursiveTreeItem<>(nowDummyData, RecursiveTreeObject::getChildren));
                        treeTableView.setShowRoot(false);
                        id = -1;
                        disableHBox.setDisable(true);
                    }else {
                        id = row.getIndex();
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
    private ChangeListener<String> setupSearchField(final JFXTreeTableView<MainController.Person> tableView) {
        return (o, oldVal, newVal) -> {
            nowDummyData.clear();
            nowDummyData.addAll(dummyData);
            if (newVal!=null){
                for (Person person:dummyData){
                    if (!person.firstName.get().contains(newVal) && !person.lastName.get().contains(newVal) && !Integer.toString(person.age.get()).contains(newVal)){
                        nowDummyData.remove(person);
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
            }*/
            /*tableView.setPredicate(personProp -> {
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

    private ChangeListener<Label> setupSearchComboBox(final JFXTreeTableView<MainController.Person> tableView) {
        return (o, oldVal, newVal) ->{
            nowDummyData.clear();
            nowDummyData.addAll(dummyData);
            if (newVal != null){
                for (Person person:dummyData){
                    if (!person.firstName.get().contains(newVal.getText())){
                        nowDummyData.remove(person);
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

    private ObservableList<Person> generateDummyData(final int numberOfEntries) {
        final ObservableList<Person> dummyData = FXCollections.observableArrayList();
        for (int i = 0; i < numberOfEntries; i++) {
            dummyData.add(createNewRandomPerson());
        }
        return dummyData;
    }

    //创建随机数据，之后可以修改成查询数据并封装
    private Person createNewRandomPerson() {
        return new Person(names[random.nextInt(names.length)],
                names[random.nextInt(names.length)],
                random.nextInt(100));
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
     * 可以再该类中设置列数据，可以将其当成entity类
     */

    static final class Person extends RecursiveTreeObject<Person> {
        //设置列的数据类型
        final StringProperty firstName;
        final StringProperty lastName;
        final SimpleIntegerProperty age;
        //DoubleProperty money;

        Person(String firstName, String lastName, int age) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.age = new SimpleIntegerProperty(age);
        }

        StringProperty firstNameProperty() {
            return firstName;
        }

        StringProperty lastNameProperty() {
            return lastName;
        }
    }
}
