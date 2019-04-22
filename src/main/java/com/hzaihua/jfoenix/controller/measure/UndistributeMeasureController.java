package com.hzaihua.jfoenix.controller.measure;


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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.annotation.PostConstruct;
import java.util.function.Function;

@ViewController(value = "/views/fxml/measure/undistributeMeasure.fxml")
public class UndistributeMeasureController {
    @FXML
    //分配测点提交按钮
    private JFXButton commitDistributeMeasure;
    @FXML
    //未分配测点表格
    private TableView<InfoMeasure> undistributeMeasureTreeView;
    @FXML
    //测点编号
    private TableColumn measureCode;
    @FXML
    //测点名称
    private TableColumn measureName;
    @FXML
    //复选框
    private TableColumn<InfoMeasure,Boolean> measureCheck;

    static ObservableList<InfoMeasure> undistributeMeatrueList = null;

    InfoMeasureService infoMeasureService = BeanFactoryUtil.getApplicationContext().getBean(InfoMeasureService.class);

    @PostConstruct
    public void init(){
        undistributeMeasureTreeView();
    }
    
    public <T> void setupCellValueFactory(JFXTreeTableColumn<InfoMeasure, T> column, Function<InfoMeasure, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<InfoMeasure, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }


    private void undistributeMeasureTreeView(){
        undistributeMeatrueList = infoMeasureService.queryUndistributeMeasure();
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
                        this.setGraphic(checkBox);
                        checkBox.selectedProperty().addListener((obVal, oldVal, newVal) -> {
                            if (newVal) {
                                // 添加选中时执行的代码
                                System.out.println("第" + this.getIndex() + "行被选中！");
                                // 获取当前单元格的对象
                                // this.getItem();
                            }

                        });
                    }
                }

            };
            return cell;
        });
        undistributeMeasureTreeView.setItems(infoMeasureService.queryUndistributeMeasure());
        /*setupCellValueFactory(measureCode, InfoMeasure::measureCodeProperty);
        setupCellValueFactory(measureName, InfoMeasure::measureNameProperty);
        undistributeMeasureTreeView.setRoot(new RecursiveTreeItem<>(undistributeMeatrueList, RecursiveTreeObject::getChildren));
        undistributeMeasureTreeView.setShowRoot(false);*/
    }
}
