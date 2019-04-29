package com.hzaihua.jfoenix.controller.measure;


import com.hzaihua.jfoenix.controller.user.AddDownUserController;
import com.hzaihua.jfoenix.controller.user.EditDownUserController;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.service.InfoMeasureService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/measure/undisMeasure.fxml")
public class UndisMeasureController {
    @FXML
    //分配测点提交按钮
    private JFXButton commitDistributeMeasure;
    @FXML
    //未分配测点表格
    private TableView<InfoMeasure> undisMeasureTreeView;
    @FXML
    //测点编号
    private TableColumn measureCode;
    @FXML
    //测点名称
    private TableColumn measureName;
    @FXML
    //复选框
    private TableColumn<InfoMeasure,Boolean> measureCheck;

    public ObservableList<InfoMeasure> allMeasureList = FXCollections.observableArrayList();

    InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);

    @PostConstruct
    public void init(){
        undistributeMeasureTreeView();
        commitDistributeMeasure.setOnAction(event -> {
            Stage stage = (Stage)commitDistributeMeasure.getScene().getWindow();
            stage.close();
        });
    }


    private void undistributeMeasureTreeView(){
        allMeasureList = infoMeasureService.queryAllMeasure();
        measureCode.setCellValueFactory(new PropertyValueFactory<>("measureCode"));
        measureName.setCellValueFactory(new PropertyValueFactory<>("measureName"));
        measureCheck.setCellFactory((col) -> {
            TableCell<InfoMeasure, Boolean> cell = new TableCell<InfoMeasure, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);

                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        CheckBox checkBox = new CheckBox();
                        if (AddDownUserController.undistriList.contains(allMeasureList.get(this.getIndex()))){
                            checkBox.setSelected(true);
                        }
                        this.setGraphic(checkBox);
                        checkBox.selectedProperty().addListener((obVal, oldVal, newVal) -> {
                            if (newVal) {
                                AddDownUserController.undistriList.add(allMeasureList.get(this.getIndex()));
                            }else {
                                AddDownUserController.undistriList.remove(allMeasureList.get(this.getIndex()));
                            }
                        });
                    }
                }
            };
            return cell;
        });
        undisMeasureTreeView.setItems(allMeasureList);
    }
}
