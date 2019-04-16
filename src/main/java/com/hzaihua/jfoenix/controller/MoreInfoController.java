package com.hzaihua.jfoenix.controller;

import com.hzaihua.jfoenix.service.DeviceManageService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class MoreInfoController implements Initializable {
    @FXML
    private JFXTreeTableView<StateDevice> treeTableView;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> deviceCode;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> deviceType;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> linkState;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> dataTime;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> data;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> linkPort;
    @FXML
    private JFXTreeTableColumn<StateDevice, String> address;

    DeviceManageService deviceManageService = BeanFactoryUtil.getApplicationContext().getBean(DeviceManageService.class);
    @Override
    public void initialize(URL url, ResourceBundle rb){
        ObservableList<StateDevice> dummyData = deviceManageService.queryDeviceByMeasureCode(MainController.deleteMeasureCode);
        treeTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        treeTableView.setShowRoot(false);
    }

    private void setupReadOnlyTableView() {
        setupCellValueFactory(deviceCode,StateDevice::deviceCodeProperty);
        setupCellValueFactory(deviceType,StateDevice::deviceTypeProperty);
        setupCellValueFactory(linkState,StateDevice::linkStateProperty);
        setupCellValueFactory(dataTime,StateDevice::dataTimeProperty);
        setupCellValueFactory(data,StateDevice::dataProperty);
        setupCellValueFactory(linkPort,StateDevice::linkPortProperty);
        setupCellValueFactory(address,StateDevice::addressProperty);
    }

    public <T> void setupCellValueFactory(JFXTreeTableColumn<StateDevice, T> column, Function<StateDevice, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<StateDevice, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    //表格的实体类
    public static class StateDevice extends RecursiveTreeObject<StateDevice>{
        private SimpleStringProperty deviceCode;//测点的编号
        private SimpleStringProperty deviceType;//测点的名称
        private SimpleStringProperty linkState;//测点中的设备连接状态
        private SimpleStringProperty dataTime;//数值时间
        private SimpleStringProperty data;//数值
        private SimpleStringProperty linkPort;//测点的位置信息
        private SimpleStringProperty address;//测点的其他参数

        public String getDeviceCode() {
            return deviceCode.get();
        }

        public SimpleStringProperty deviceCodeProperty() {
            return deviceCode;
        }

        public void setDeviceCode(String deviceCode) {
            this.deviceCode = new SimpleStringProperty(deviceCode);
        }

        public String getDeviceType() {
            return deviceType.get();
        }

        public SimpleStringProperty deviceTypeProperty() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = new SimpleStringProperty(deviceType);
        }

        public String getLinkState() {
            return linkState.get();
        }

        public SimpleStringProperty linkStateProperty() {
            return linkState;
        }

        public void setLinkState(String linkState) {
            this.linkState = new SimpleStringProperty(linkState);
        }

        public String getDataTime() {
            return dataTime.get();
        }

        public SimpleStringProperty dataTimeProperty() {
            return dataTime;
        }

        public void setDataTime(String dataTime) {
            this.dataTime = new SimpleStringProperty(dataTime);
        }

        public String getData() {
            return data.get();
        }

        public SimpleStringProperty dataProperty() {
            return data;
        }

        public void setData(String data) {
            this.data = new SimpleStringProperty(data);
        }

        public String getLinkPort() {
            return linkPort.get();
        }

        public SimpleStringProperty linkPortProperty() {
            return linkPort;
        }

        public void setLinkPort(String linkPort) {
            this.linkPort = new SimpleStringProperty(linkPort);
        }

        public String getAddress() {
            return address.get();
        }

        public SimpleStringProperty addressProperty() {
            return address;
        }

        public void setAddress(String address) {
            this.address = new SimpleStringProperty(address);
        }

        public StateDevice(String deviceCode, String deviceType, String linkState, String dataTime, String data, String linkPort, String address) {
            this.deviceCode = new SimpleStringProperty(deviceCode);
            this.deviceType = new SimpleStringProperty(deviceType);
            this.linkState = new SimpleStringProperty(linkState);
            this.dataTime = new SimpleStringProperty(dataTime);
            this.data = new SimpleStringProperty(data);
            this.linkPort = new SimpleStringProperty(linkPort);
            this.address = new SimpleStringProperty(address);
        }

        public StateDevice() {
        }

        @Override
        public String toString() {
            return "StateDevice{" +
                    "deviceCode=" + deviceCode +
                    ", deviceType=" + deviceType +
                    ", linkState=" + linkState +
                    ", dataTime=" + dataTime +
                    ", data=" + data +
                    ", linkPort=" + linkPort +
                    ", address=" + address +
                    '}';
        }
    }
}
