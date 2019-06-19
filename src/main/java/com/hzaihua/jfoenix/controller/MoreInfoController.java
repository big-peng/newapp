package com.hzaihua.jfoenix.controller;

import com.hzaihua.jfoenix.controller.TCPLink.SendingThread;
import com.hzaihua.jfoenix.service.DeviceManageService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MoreInfoController implements Initializable {
    @FXML
    public TableView<StateDevice> treeTableView;
    @FXML
    private TableColumn deviceCode;
    @FXML
    private TableColumn deviceType;
    @FXML
    private TableColumn linkState;
    @FXML
    private TableColumn dataTime;
    @FXML
    private TableColumn data;
    @FXML
    private TableColumn linkPort;
    @FXML
    private TableColumn address;

    DeviceManageService deviceManageService = BeanFactoryUtil.getApplicationContext().getBean(DeviceManageService.class);
    public static ObservableList<StateDevice> dummyData;
    public static ObservableList<StateDevice> stateDevices = null;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        deviceCode.setCellValueFactory(new PropertyValueFactory("deviceCode"));
        deviceType.setCellValueFactory(new PropertyValueFactory("deviceType"));
        linkState.setCellValueFactory(new PropertyValueFactory("linkState"));
        dataTime.setCellValueFactory(new PropertyValueFactory("dataTime"));
        data.setCellValueFactory(new PropertyValueFactory("data"));
        linkPort.setCellValueFactory(new PropertyValueFactory("linkPort"));
        address.setCellValueFactory(new PropertyValueFactory("address"));


        dummyData = deviceManageService.queryDeviceByMeasureCode(MainController.deleteMeasureCode);
        stateDevices = deviceManageService.queryAll();
        treeTableView.setItems(dummyData);
        SendingThread sendingThread = new SendingThread(SendingThread.socket);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(dummyData != null){
                    for (StateDevice stateDevice : stateDevices) {
                        for (StateDevice dummyDatum : dummyData) {
                            if(stateDevice.getDeviceCode().equals(dummyDatum.getDeviceCode())){
                                if(sendingThread.deviceCode.equals(dummyDatum.getDeviceCode())) {
                                    dummyDatum.setDataTime(sendingThread.flag);
                                    dummyDatum.setData(sendingThread.data);
                                }
                            }
                        }
                    }
                }
            }
        };
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);
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
        private StringProperty deviceCode = new SimpleStringProperty();
        private StringProperty deviceType = new SimpleStringProperty();
        private StringProperty linkState = new SimpleStringProperty();
        private StringProperty dataTime = new SimpleStringProperty();
        private StringProperty data = new SimpleStringProperty();
        private StringProperty linkPort = new SimpleStringProperty();
        private StringProperty address = new SimpleStringProperty();

        public String getDeviceCode() {
            return deviceCode.get();
        }

        public StringProperty deviceCodeProperty() {
            return deviceCode;
        }

        public void setDeviceCode(String deviceCode) {
            this.deviceCode.set(deviceCode);
        }

        public String getDeviceType() {
            return deviceType.get();
        }

        public StringProperty deviceTypeProperty() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType.set(deviceType);
        }

        public String getLinkState() {
            return linkState.get();
        }

        public StringProperty linkStateProperty() {
            return linkState;
        }

        public void setLinkState(String linkState) {
            this.linkState.set(linkState);
        }

        public String getDataTime() {
            return dataTime.get();
        }

        public StringProperty dataTimeProperty() {
            return dataTime;
        }

        public void setDataTime(String dataTime) {
            this.dataTime.set(dataTime);
        }

        public String getData() {
            return data.get();
        }

        public StringProperty dataProperty() {
            return data;
        }

        public void setData(String data) {
            this.data.set(data);
        }

        public String getLinkPort() {
            return linkPort.get();
        }

        public StringProperty linkPortProperty() {
            return linkPort;
        }

        public void setLinkPort(String linkPort) {
            this.linkPort.set(linkPort);
        }

        public String getAddress() {
            return address.get();
        }

        public StringProperty addressProperty() {
            return address;
        }

        public void setAddress(String address) {
            this.address.set(address);
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
