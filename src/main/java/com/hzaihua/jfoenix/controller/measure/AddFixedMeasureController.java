package com.hzaihua.jfoenix.controller.measure;


import com.hzaihua.jfoenix.load.device.AddDeviceLoad;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/measure/AddFixedMeasure.fxml")
public class AddFixedMeasureController {
    @FXML
    private JFXButton addFixedDevice;

    @PostConstruct
    public void init(){
        addFixedDevice.setOnAction(event -> {
            System.out.println(123);
            AddDeviceLoad addDeviceLoad = new AddDeviceLoad();
        });
    }
}
