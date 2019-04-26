package com.hzaihua.jfoenix.controller.Device;


import com.hzaihua.jfoenix.load.device.AddDeviceBeforeLoad;
import com.hzaihua.jfoenix.load.device.AddDeviceLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/device/AddDeviceBefore.fxml")
public class ChangeNoiseController {

    @FXML
    private JFXButton AWA6218j;

    @PostConstruct
    public void init(){
        AWA6218j.setOnAction(event -> {
            AddDeviceLoad addDeviceLoad = new AddDeviceLoad();
        });
    }
}
