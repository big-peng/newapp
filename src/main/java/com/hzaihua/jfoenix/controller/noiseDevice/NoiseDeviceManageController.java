package com.hzaihua.jfoenix.controller.noiseDevice;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ViewController(value = "/views/fxml/noiseDevice/noiseDeviceAfter.fxml")
public class NoiseDeviceManageController {
    @FXML private AnchorPane editPara;
    @FXML private JFXListView<Label> sideList;
    @FXML private JFXButton subTitleButton;
    @FXML private JFXButton timeButton;
    @FXML private JFXButton noiseButton;
    private ObservableList<Label> programList = FXCollections.observableArrayList();
    private Map<String,BasicPara> programParaList = new HashMap<String,BasicPara>();
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
        subTitleButton.setOnAction(event -> {
            String programName = "字幕"+((programList.size()==0)?"":programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            programParaList.put(programName,new SubTitlePara());
            subTitleParaPage();
        });
        timeButton.setOnAction(event -> {
            String programName = "时间"+((programList.size()==0)?"":programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            programParaList.put(programName,new TimePara());
            timeParaPage();
        });
        noiseButton.setOnAction(event -> {
            String programName = "噪声"+((programList.size()==0)?"":programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            NoisePara noisePara = new NoisePara();
            noisePara.setProgramName(programName);
            programParaList.put(programName,noisePara);
            noiseParaPage(noisePara);
        });
    }

    @FXML
    private void changePage() {
        editPara.getChildren().clear();
        String typeMark = sideList.getSelectionModel().getSelectedItem().getText();
        System.out.println(typeMark);
        if (typeMark.contains("噪声")) {
            noiseParaPage((NoisePara)programParaList.get(typeMark));
        }else if(typeMark.contains("时间")){
            timeParaPage();
        }else if(typeMark.contains("字幕")){
            subTitleParaPage();
        }
    }

    public void noiseParaPage(NoisePara noisePara){
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(217);
        textField1_1.setText(noisePara.getProgramName());

        hBox1.getChildren().add(0,label1_1);
        hBox1.getChildren().add(1,textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(80);
        textField2_1_1.setText(noisePara.getX());

        hBox2_1.getChildren().add(0,label2_1_1);
        hBox2_1.getChildren().add(1,textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(80);
        textField2_2_1.setText(noisePara.getWidth());

        hBox2_2.getChildren().add(0,label2_2_1);
        hBox2_2.getChildren().add(1,textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1,hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(80);
        textField3_1_1.setText(noisePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(80);
        textField3_2_1.setText(noisePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1,hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(200);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<Label> comboBox4_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("宋体"),new Label("微软雅黑")));
        comboBox4_1_1.setPrefWidth(80);

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<Label> comboBox4_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("16"),new Label("17")));
        comboBox4_2_1.setPrefWidth(80);

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1,hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 149;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("间距:");
        ComboBox<Label> comboBox5_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("1")));
        comboBox5_1_1.setPrefWidth(80);

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);
        hBox5.getChildren().addAll(hBox5_1);


        HBox hBox6 = new HBox(19);

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("达标颜色:");
        ComboBox<Label> comboBox6_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("1")));
        comboBox6_1_1.setPrefWidth(69);

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("超标颜色:");
        ComboBox<Label> comboBox6_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("16"),new Label("17")));
        comboBox6_2_1.setPrefWidth(56);

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1,hBox6_2);


        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            NoisePara noisePara1 = new NoisePara(textField1_1.getText(),textField2_1_1.getText(),textField3_1_1.getText(),textField2_2_1.getText(),textField3_2_1.getText(),"","","","","");
            System.out.println(noisePara1.getProgramName());
            programParaList.put(textField1_1.getText(),noisePara1);
        });
        vBox.getChildren().addAll(hBox1,hBox2,hBox3,separator,hBox4,hBox5,hBox6,button);
        editPara.getChildren().add(vBox);
    }

    public void subTitleParaPage(){
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


        Separator separator = new Separator();
        separator.setPrefWidth(200);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<Label> comboBox4_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("宋体"),new Label("微软雅黑")));
        comboBox4_1_1.setPrefWidth(80);

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<Label> comboBox4_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("16"),new Label("17")));
        comboBox4_2_1.setPrefWidth(80);

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1,hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<Label> comboBox5_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("红"),new Label("黑")));
        comboBox5_1_1.setPrefWidth(80);

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<Label> comboBox5_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("1")));
        comboBox5_2_1.setPrefWidth(80);

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1,hBox5_2);


        HBox hBox6 = new HBox(20);
        hBox6.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("横向:");
        ComboBox<Label> comboBox6_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("2")));
        comboBox6_1_1.setPrefWidth(80);

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("纵向:");
        ComboBox<Label> comboBox6_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("5"),new Label("6")));
        comboBox6_2_1.setPrefWidth(80);

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1,hBox6_2);


        HBox hBox7 = new HBox(20);
        hBox7.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox7_1 = new HBox(10);

        Label label7_1_1 = new Label("速度:");
        ComboBox<Label> comboBox7_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("1"),new Label("2")));
        comboBox7_1_1.setPrefWidth(80);

        hBox7_1.getChildren().add(label7_1_1);
        hBox7_1.getChildren().add(comboBox7_1_1);

        HBox hBox7_2 = new HBox(10);

        Label label7_2_1 = new Label("停留:");
        ComboBox<Label> comboBox7_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("3"),new Label("4")));
        comboBox7_2_1.setPrefWidth(80);

        hBox7_2.getChildren().add(label7_2_1);
        hBox7_2.getChildren().add(comboBox7_2_1);
        hBox7.getChildren().addAll(hBox7_1,hBox7_2);


        HBox hBox8 = new HBox(20);
        hBox8.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox8_1 = new HBox(10);

        Label label8_1_1 = new Label("排版:");
        ComboBox<Label> comboBox8_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("2")));
        comboBox8_1_1.setPrefWidth(80);

        hBox8_1.getChildren().add(label8_1_1);
        hBox8_1.getChildren().add(comboBox8_1_1);

        HBox hBox8_2 = new HBox(10);

        Label label8_2_1 = new Label("特技:");
        ComboBox<Label> comboBox8_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("5"),new Label("6")));
        comboBox8_2_1.setPrefWidth(80);

        hBox8_2.getChildren().add(label8_2_1);
        hBox8_2.getChildren().add(comboBox8_2_1);
        hBox8.getChildren().addAll(hBox8_1,hBox8_2);


        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        vBox.getChildren().addAll(hBox1,hBox2,hBox3,separator,hBox4,hBox5,hBox6,hBox7,hBox8,button);
        editPara.getChildren().add(vBox);
    }

    public void timeParaPage(){
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


        Separator separator = new Separator();
        separator.setPrefWidth(200);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<Label> comboBox4_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("宋体"),new Label("微软雅黑")));
        comboBox4_1_1.setPrefWidth(80);

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<Label> comboBox4_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("16"),new Label("17")));
        comboBox4_2_1.setPrefWidth(80);

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1,hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<Label> comboBox5_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("红"),new Label("黑")));
        comboBox5_1_1.setPrefWidth(80);

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<Label> comboBox5_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("1")));
        comboBox5_2_1.setPrefWidth(80);

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1,hBox5_2);


        HBox hBox6 = new HBox(20);
        hBox6.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("横向:");
        ComboBox<Label> comboBox6_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("2")));
        comboBox6_1_1.setPrefWidth(80);

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("纵向:");
        ComboBox<Label> comboBox6_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("5"),new Label("6")));
        comboBox6_2_1.setPrefWidth(80);

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1,hBox6_2);


        HBox hBox7 = new HBox(20);
        hBox7.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox7_1 = new HBox(10);

        Label label7_1_1 = new Label("速度:");
        ComboBox<Label> comboBox7_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("1"),new Label("2")));
        comboBox7_1_1.setPrefWidth(80);

        hBox7_1.getChildren().add(label7_1_1);
        hBox7_1.getChildren().add(comboBox7_1_1);

        HBox hBox7_2 = new HBox(10);

        Label label7_2_1 = new Label("停留:");
        ComboBox<Label> comboBox7_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("3"),new Label("4")));
        comboBox7_2_1.setPrefWidth(80);

        hBox7_2.getChildren().add(label7_2_1);
        hBox7_2.getChildren().add(comboBox7_2_1);
        hBox7.getChildren().addAll(hBox7_1,hBox7_2);


        HBox hBox8 = new HBox(20);
        hBox8.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox8_1 = new HBox(10);

        Label label8_1_1 = new Label("排版:");
        ComboBox<Label> comboBox8_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("0"),new Label("2")));
        comboBox8_1_1.setPrefWidth(80);

        hBox8_1.getChildren().add(label8_1_1);
        hBox8_1.getChildren().add(comboBox8_1_1);

        HBox hBox8_2 = new HBox(10);

        Label label8_2_1 = new Label("特技:");
        ComboBox<Label> comboBox8_2_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("5"),new Label("6")));
        comboBox8_2_1.setPrefWidth(80);

        hBox8_2.getChildren().add(label8_2_1);
        hBox8_2.getChildren().add(comboBox8_2_1);
        hBox8.getChildren().addAll(hBox8_1,hBox8_2);


        HBox hBox9 = new HBox(20);
        hBox9.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox9_1 = new HBox(10);

        Label label9_1_1 = new Label("风格:");
        ComboBox<Label> comboBox9_1_1 = new ComboBox<Label>(FXCollections.observableArrayList(new Label("YYYY-MM-DD HH:mm:ss")));
        comboBox9_1_1.setPrefWidth(217);

        hBox9_1.getChildren().add(label9_1_1);
        hBox9_1.getChildren().add(comboBox9_1_1);
        hBox9.getChildren().addAll(hBox9_1);

        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        vBox.getChildren().addAll(hBox1,hBox2,hBox3,separator,hBox4,hBox5,hBox6,hBox7,hBox8,hBox9,button);
        editPara.getChildren().add(vBox);
    }

    public static class NoiseParaController{

    }
    public class BasicPara{
        private String programName;
        private String X;
        private String Y;
        private String width;
        private String height;
        private String fontType;
        private String fontSize;
        private String spacing;

        public String getProgramName() {
            return programName;
        }

        public void setProgramName(String programName) {
            this.programName = programName;
        }

        public String getX() {
            return X;
        }

        public void setX(String x) {
            X = x;
        }

        public String getY() {
            return Y;
        }

        public void setY(String y) {
            Y = y;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getFontType() {
            return fontType;
        }

        public void setFontType(String fontType) {
            this.fontType = fontType;
        }

        public String getFontSize() {
            return fontSize;
        }

        public void setFontSize(String fontSize) {
            this.fontSize = fontSize;
        }

        public String getSpacing() {
            return spacing;
        }

        public void setSpacing(String spacing) {
            this.spacing = spacing;
        }

        public BasicPara(String programName, String x, String y, String width, String height, String fontType, String fontSize, String spacing) {
            this.programName = programName;
            X = x;
            Y = y;
            this.width = width;
            this.height = height;
            this.fontType = fontType;
            this.fontSize = fontSize;
            this.spacing = spacing;
        }

        @Override
        public String toString() {
            return "BasicPara{" +
                    "programName='" + programName + '\'' +
                    ", X='" + X + '\'' +
                    ", Y='" + Y + '\'' +
                    ", width='" + width + '\'' +
                    ", height='" + height + '\'' +
                    ", fontType='" + fontType + '\'' +
                    ", fontSize='" + fontSize + '\'' +
                    ", spacing='" + spacing + '\'' +
                    '}';
        }

        public BasicPara() {
        }
    }

    public class NoisePara extends BasicPara{
        private String trueColor;
        private String falseColor;

        public String getTrueColor() {
            return trueColor;
        }

        public void setTrueColor(String trueColor) {
            this.trueColor = trueColor;
        }

        public String getFalseColor() {
            return falseColor;
        }

        public void setFalseColor(String falseColor) {
            this.falseColor = falseColor;
        }

        public NoisePara(String programName,String X,String Y,String width,String height,String fontType,String fontSize,String spacing,String trueColor, String falseColor) {
            super(programName,X,Y,width,height,fontType,fontSize,spacing);
            this.trueColor = trueColor;
            this.falseColor = falseColor;
        }

        @Override
        public String toString() {
            return "NoisePara{" +
                    "programName='" + super.programName + '\'' +
                    ", X='" + super.X + '\'' +
                    ", Y='" + super.Y + '\'' +
                    ", width='" + super.width + '\'' +
                    ", height='" + super.height + '\'' +
                    ", fontType='" + super.fontType + '\'' +
                    ", fontSize='" + super.fontSize + '\'' +
                    ", spacing='" + super.spacing + '\'' +
                    ", trueColor='" + trueColor + '\'' +
                    ", falseColor='" + falseColor + '\'' +
                    '}';
        }

        public NoisePara() {
        }
    }

    public class SubTitlePara extends BasicPara{
        private String color;
        private String broadwise;//横向
        private String portrait;//纵向
        private String speed;
        private String stay;
        private String typesetting;//排版
        private String stunt;//特技

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBroadwise() {
            return broadwise;
        }

        public void setBroadwise(String broadwise) {
            this.broadwise = broadwise;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getStay() {
            return stay;
        }

        public void setStay(String stay) {
            this.stay = stay;
        }

        public String getTypesetting() {
            return typesetting;
        }

        public void setTypesetting(String typesetting) {
            this.typesetting = typesetting;
        }

        public String getStunt() {
            return stunt;
        }

        public void setStunt(String stunt) {
            this.stunt = stunt;
        }

        public SubTitlePara(String color, String broadwise, String portrait, String speed, String stay, String typesetting, String stunt,String programName,String X,String Y,String width,String height,String fontType,String fontSize,String spacing) {
            super(programName,X,Y,width,height,fontType,fontSize,spacing);
            this.color = color;
            this.broadwise = broadwise;
            this.portrait = portrait;
            this.speed = speed;
            this.stay = stay;
            this.typesetting = typesetting;
            this.stunt = stunt;
        }

        public SubTitlePara() {
        }

        @Override
        public String toString() {
            return "SubTitlePara{" +
                    "programName='" + super.programName + '\'' +
                    ", X='" + super.X + '\'' +
                    ", Y='" + super.Y + '\'' +
                    ", width='" + super.width + '\'' +
                    ", height='" + super.height + '\'' +
                    ", fontType='" + super.fontType + '\'' +
                    ", fontSize='" + super.fontSize + '\'' +
                    ", spacing='" + super.spacing + '\'' +
                    ", color='" + color + '\'' +
                    ", broadwise='" + broadwise + '\'' +
                    ", portrait='" + portrait + '\'' +
                    ", speed='" + speed + '\'' +
                    ", stay='" + stay + '\'' +
                    ", typesetting='" + typesetting + '\'' +
                    ", stunt='" + stunt + '\'' +
                    '}';
        }
    }

    public class TimePara extends SubTitlePara{
        private String timeStyle;

        public TimePara(String color, String broadwise, String portrait, String speed, String stay, String typesetting, String stunt, String programName, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String timeStyle) {
            super(color, broadwise, portrait, speed, stay, typesetting, stunt, programName, X, Y, width, height, fontType, fontSize, spacing);
            this.timeStyle = timeStyle;
        }

        public String getTimeStyle() {
            return timeStyle;
        }

        public void setTimeStyle(String timeStyle) {
            this.timeStyle = timeStyle;
        }

        public TimePara() {
        }


    }
}
