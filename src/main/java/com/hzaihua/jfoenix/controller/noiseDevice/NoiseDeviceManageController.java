package com.hzaihua.jfoenix.controller.noiseDevice;

import com.jfoenix.controls.JFXDialog;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;

@ViewController(value = "/views/fxml/noiseDevice/noiseDeviceAfter.fxml")
public class NoiseDeviceManageController {
    @FXML private AnchorPane editPara;
    @PostConstruct
    public void init(){
        /*FXMLLoader outerLoader = new FXMLLoader(getClass().getResource("/views/fxml/noiseDevice/noiseDeviceAfter.fxml"));
        FXMLLoader loaderChange = new FXMLLoader(getClass().getResource("/views/fxml/noiseDevice/paraPage/NoisePara.fxml"));
        //loaderChange.setController(new NoiseDeviceManageController());
        loaderChange.setRoot(outerLoader.getNamespace().get("editPara"));
        System.out.println(loaderChange.getRoot().toString());
        try{
            loaderChange.load();
        }catch (Exception e){
            e.printStackTrace();
        }*/
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(217);

        hBox1.getChildren().add(0,label1_1);
        hBox1.getChildren().add(1,textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(80);

        hBox2_1.getChildren().add(0,label2_1_1);
        hBox2_1.getChildren().add(1,textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(80);

        hBox2_2.getChildren().add(0,label2_2_1);
        hBox2_2.getChildren().add(1,textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1,hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(80);

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(80);

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1,hBox3_2);


        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox1,hBox2,hBox3);
        editPara.getChildren().add(vBox);
    }
    public static class NoiseParaController{

    }
}
