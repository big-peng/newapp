package com.hzaihua.jfoenix.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;
import java.io.File;

@ViewController(value = "/views/fxml/system/systemSetup.fxml")
public class SystemSetupController {
    @FXML
    private JFXButton fileChoose;
    @FXML
    private JFXTextField filePath;
    @FXML
    private Label pathWarning;

    @PostConstruct
    public void init(){
        fileChoose.setOnAction(event -> {
            //目录选择
            DirectoryChooser directoryChooser=new DirectoryChooser();
            String initialDirectory = "D:\\";
            if (filePath.getText()!=null&&!filePath.getText().equals("")){
                initialDirectory = filePath.getText();
            }
            File initial = new File(initialDirectory);
            directoryChooser.setInitialDirectory(initial);
            File file = null;
            try{
                file = directoryChooser.showDialog(new Stage());
                pathWarning.setText("");
            }catch(IllegalArgumentException e){
                pathWarning.setText("路径输入不正确");
            }
            if(file!=null){
                String path = file.getPath();
                filePath.setText(path);
            }
        });
    }
}
