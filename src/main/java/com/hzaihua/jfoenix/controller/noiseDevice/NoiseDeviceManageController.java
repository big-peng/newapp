package com.hzaihua.jfoenix.controller.noiseDevice;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@ViewController(value = "/views/fxml/noiseDevice/noiseDeviceAfter.fxml")
public class NoiseDeviceManageController {
    @FXML
    private AnchorPane editPara;
    @FXML
    private JFXListView<Label> sideList;
    @FXML
    private JFXButton textButton;
    @FXML
    private JFXButton subTitleButton;
    @FXML
    private JFXButton timeButton;
    @FXML
    private JFXButton noiseButton;
    @FXML
    private VBox previewWindow;
    private ObservableList<Label> programList = FXCollections.observableArrayList();
    private Map<String, BasicPara> programParaList = new HashMap<String, BasicPara>();

    @PostConstruct
    public void init() {
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
        Label label1 = new Label("123");

        double sceneWidth = 200;
        double msgWidth = label1.getLayoutBounds().getWidth();

        KeyValue initKeyValue = new KeyValue(label1.translateXProperty(), -20);
        KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

        KeyValue endKeyValue = new KeyValue(label1.translateXProperty(), 200);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(3), endKeyValue);

        Timeline timeline = new Timeline(initFrame, endFrame);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        previewWindow.getChildren().add(label1);
        textButton.setOnAction(event -> {
            String programName = "文本" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            TextPara textPara = new TextPara();
            textPara.setProgramName(programName);
            programParaList.put(programName, textPara);
            textParaPage(textPara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        subTitleButton.setOnAction(event -> {
            String programName = "字幕" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            SubTitlePara subTitlePara = new SubTitlePara();
            subTitlePara.setProgramName(programName);
            programParaList.put(programName, subTitlePara);
            subTitleParaPage(subTitlePara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        timeButton.setOnAction(event -> {
            String programName = "时间" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            TimePara timePara = new TimePara();
            timePara.setProgramName(programName);
            programParaList.put(programName, timePara);
            timeParaPage(timePara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
        noiseButton.setOnAction(event -> {
            String programName = "噪声" + ((programList.size() == 0) ? "" : programList.size());
            Label label = new Label(programName);
            programList.add(label);
            sideList.setItems(programList);
            editPara.getChildren().clear();
            NoisePara noisePara = new NoisePara();
            noisePara.setProgramName(programName);
            programParaList.put(programName, noisePara);
            noiseParaPage(noisePara);
            sideList.getSelectionModel().select(programList.size() - 1);
        });
    }

    @FXML
    private void changePage() {
        editPara.getChildren().clear();
        String typeMark = sideList.getSelectionModel().getSelectedItem().getText();
        //System.out.println(typeMark);
        if (typeMark.contains("噪声")) {
            noiseParaPage((NoisePara) programParaList.get(typeMark));
        } else if (typeMark.contains("时间")) {
            timeParaPage((TimePara) programParaList.get(typeMark));
        } else if (typeMark.contains("字幕")) {
            subTitleParaPage((SubTitlePara) programParaList.get(typeMark));
        } else if (typeMark.contains("文本")) {
            textParaPage((TextPara) programParaList.get(typeMark));
        }
    }

    public void textParaPage(TextPara textPara) {
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setText(textPara.getProgramName());
        textField1_1.setDisable(true);

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(textPara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(textPara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(textPara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(textPara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("宋体", "微软雅黑"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.setPromptText("选择");
        //System.out.println(noisePara.getFontType());
        comboBox4_1_1.getSelectionModel().select(textPara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(textPara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("绿色", "红色"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.setPromptText("选择");
        //System.out.println(noisePara.getFontType());
        ColorPicker colorPicker1 = new ColorPicker();
        comboBox5_1_1.getSelectionModel().select(textPara.getColor());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<String> comboBox5_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox5_2_1.setPrefWidth(105);
        comboBox5_2_1.getSelectionModel().select(textPara.getSpacing());

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1, hBox5_2);


        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            TextPara textPara1 = new TextPara(textField1_1.getText(), textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_2_1.getValue(), comboBox5_1_1.getValue());
            //System.out.println(comboBox4_1_1.getValue());
            programParaList.put(textField1_1.getText(), textPara1);
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, button);
        editPara.getChildren().add(vBox);
    }

    public void noiseParaPage(NoisePara noisePara) {
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setText(noisePara.getProgramName());
        textField1_1.setDisable(true);

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(noisePara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(noisePara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(noisePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(noisePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("微软雅黑","宋体"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.setPromptText("选择");
        //System.out.println(noisePara.getFontType());
        comboBox4_1_1.getSelectionModel().select(noisePara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(noisePara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 174;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("间距:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.getSelectionModel().select(noisePara.getSpacing());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);
        hBox5.getChildren().addAll(hBox5_1);


        HBox hBox6 = new HBox(19);

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("达标颜色:");
        ComboBox<String> comboBox6_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0","1"));
        comboBox6_1_1.setPrefWidth(94);
        comboBox6_1_1.getSelectionModel().select(noisePara.getTrueColor());

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("超标颜色:");
        ComboBox<String> comboBox6_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox6_2_1.setPrefWidth(81);
        comboBox6_2_1.getSelectionModel().select(noisePara.getFalseColor());

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1, hBox6_2);


        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            NoisePara noisePara1 = new NoisePara(textField1_1.getText(), textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_1_1.getValue(), comboBox6_1_1.getValue(), comboBox6_2_1.getValue());
            //System.out.println(comboBox4_1_1.getValue());
            programParaList.put(textField1_1.getText(), noisePara1);
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, hBox6, button);
        editPara.getChildren().add(vBox);
    }

    public void subTitleParaPage(SubTitlePara subTitlePara) {
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setText(subTitlePara.getProgramName());
        textField1_1.setDisable(true);

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(subTitlePara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(subTitlePara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(subTitlePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(subTitlePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("宋体","微软雅黑"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.getSelectionModel().select(subTitlePara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(subTitlePara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("红", "黑"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.getSelectionModel().select(subTitlePara.getColor());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<String> comboBox5_2_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox5_2_1.setPrefWidth(105);
        comboBox5_2_1.getSelectionModel().select(subTitlePara.getSpacing());

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1, hBox5_2);


        HBox hBox6 = new HBox(20);
        hBox6.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("横向:");
        ComboBox<String> comboBox6_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox6_1_1.setPrefWidth(105);
        comboBox6_1_1.getSelectionModel().select(subTitlePara.getBroadwise());

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("纵向:");
        ComboBox<String> comboBox6_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5", "6"));
        comboBox6_2_1.setPrefWidth(105);
        comboBox6_2_1.getSelectionModel().select(subTitlePara.getPortrait());

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1, hBox6_2);


        HBox hBox7 = new HBox(20);
        hBox7.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox7_1 = new HBox(10);

        Label label7_1_1 = new Label("速度:");
        ComboBox<String> comboBox7_1_1 = new ComboBox<String>(FXCollections.observableArrayList("1", "2"));
        comboBox7_1_1.setPrefWidth(105);
        comboBox7_1_1.getSelectionModel().select(subTitlePara.getSpeed());

        hBox7_1.getChildren().add(label7_1_1);
        hBox7_1.getChildren().add(comboBox7_1_1);

        HBox hBox7_2 = new HBox(10);

        Label label7_2_1 = new Label("停留:");
        ComboBox<String> comboBox7_2_1 = new ComboBox<String>(FXCollections.observableArrayList("3", "4"));
        comboBox7_2_1.setPrefWidth(105);
        comboBox7_2_1.getSelectionModel().select(subTitlePara.getStay());

        hBox7_2.getChildren().add(label7_2_1);
        hBox7_2.getChildren().add(comboBox7_2_1);
        hBox7.getChildren().addAll(hBox7_1, hBox7_2);


        HBox hBox8 = new HBox(20);
        hBox8.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox8_1 = new HBox(10);

        Label label8_1_1 = new Label("排版:");
        ComboBox<String> comboBox8_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox8_1_1.setPrefWidth(105);
        comboBox8_1_1.getSelectionModel().select(subTitlePara.getTypesetting());

        hBox8_1.getChildren().add(label8_1_1);
        hBox8_1.getChildren().add(comboBox8_1_1);

        HBox hBox8_2 = new HBox(10);

        Label label8_2_1 = new Label("特技:");
        ComboBox<String> comboBox8_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5","6"));
        comboBox8_2_1.setPrefWidth(105);
        comboBox8_2_1.getSelectionModel().select(subTitlePara.getStunt());

        hBox8_2.getChildren().add(label8_2_1);
        hBox8_2.getChildren().add(comboBox8_2_1);
        hBox8.getChildren().addAll(hBox8_1, hBox8_2);


        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            SubTitlePara subTitlePara1 = new SubTitlePara(textField1_1.getText(), textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_1_1.getValue(), comboBox5_2_1.getValue(), comboBox6_1_1.getValue(), comboBox6_2_1.getValue(), comboBox7_1_1.getValue(), comboBox7_2_1.getValue(), comboBox8_1_1.getValue(), comboBox8_2_1.getValue());
            programParaList.put(textField1_1.getText(), subTitlePara1);
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, hBox6, hBox7, hBox8, button);
        editPara.getChildren().add(vBox);
    }

    public void timeParaPage(TimePara timePara) {
        HBox hBox1 = new HBox(10);

        Label label1_1 = new Label("区域名:");
        TextField textField1_1 = new TextField();
        textField1_1.setPrefWidth(267);
        textField1_1.setDisable(true);
        textField1_1.setText(timePara.getProgramName());

        hBox1.getChildren().add(0, label1_1);
        hBox1.getChildren().add(1, textField1_1);


        HBox hBox2 = new HBox(20);
        hBox2.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox2_1 = new HBox(10);

        Label label2_1_1 = new Label("X:");
        TextField textField2_1_1 = new TextField();
        textField2_1_1.setPrefWidth(105);
        textField2_1_1.setText(timePara.getX());

        hBox2_1.getChildren().add(0, label2_1_1);
        hBox2_1.getChildren().add(1, textField2_1_1);

        HBox hBox2_2 = new HBox(10);

        Label label2_2_1 = new Label("宽度:");
        TextField textField2_2_1 = new TextField();
        textField2_2_1.setPrefWidth(105);
        textField2_2_1.setText(timePara.getWidth());

        hBox2_2.getChildren().add(0, label2_2_1);
        hBox2_2.getChildren().add(1, textField2_2_1);
        hBox2.getChildren().addAll(hBox2_1, hBox2_2);


        HBox hBox3 = new HBox(20);
        hBox3.setStyle("-fx-padding: 0 0 0 28;");

        HBox hBox3_1 = new HBox(10);

        Label label3_1_1 = new Label("Y:");
        TextField textField3_1_1 = new TextField();
        textField3_1_1.setPrefWidth(105);
        textField3_1_1.setText(timePara.getY());

        hBox3_1.getChildren().add(label3_1_1);
        hBox3_1.getChildren().add(textField3_1_1);

        HBox hBox3_2 = new HBox(10);

        Label label3_2_1 = new Label("高度:");
        TextField textField3_2_1 = new TextField();
        textField3_2_1.setPrefWidth(105);
        textField3_2_1.setText(timePara.getHeight());

        hBox3_2.getChildren().add(label3_2_1);
        hBox3_2.getChildren().add(textField3_2_1);
        hBox3.getChildren().addAll(hBox3_1, hBox3_2);


        Separator separator = new Separator();
        separator.setPrefWidth(250);


        HBox hBox4 = new HBox(20);
        hBox4.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox4_1 = new HBox(10);

        Label label4_1_1 = new Label("字体:");
        ComboBox<String> comboBox4_1_1 = new ComboBox<String>(FXCollections.observableArrayList("宋体", "微软雅黑"));
        comboBox4_1_1.setPrefWidth(105);
        comboBox4_1_1.getSelectionModel().select(timePara.getFontType());

        hBox4_1.getChildren().add(label4_1_1);
        hBox4_1.getChildren().add(comboBox4_1_1);

        HBox hBox4_2 = new HBox(10);

        Label label4_2_1 = new Label("字号:");
        ComboBox<String> comboBox4_2_1 = new ComboBox<String>(FXCollections.observableArrayList("16", "17"));
        comboBox4_2_1.setPrefWidth(105);
        comboBox4_2_1.getSelectionModel().select(timePara.getFontSize());

        hBox4_2.getChildren().add(label4_2_1);
        hBox4_2.getChildren().add(comboBox4_2_1);
        hBox4.getChildren().addAll(hBox4_1, hBox4_2);


        HBox hBox5 = new HBox(20);
        hBox5.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox5_1 = new HBox(10);

        Label label5_1_1 = new Label("颜色:");
        ComboBox<String> comboBox5_1_1 = new ComboBox<String>(FXCollections.observableArrayList("红", "黑"));
        comboBox5_1_1.setPrefWidth(105);
        comboBox5_1_1.getSelectionModel().select(timePara.getColor());

        hBox5_1.getChildren().add(label5_1_1);
        hBox5_1.getChildren().add(comboBox5_1_1);

        HBox hBox5_2 = new HBox(10);

        Label label5_2_1 = new Label("间距:");
        ComboBox<String> comboBox5_2_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "1"));
        comboBox5_2_1.setPrefWidth(105);
        comboBox5_2_1.getSelectionModel().select(timePara.getSpacing());

        hBox5_2.getChildren().add(label5_2_1);
        hBox5_2.getChildren().add(comboBox5_2_1);
        hBox5.getChildren().addAll(hBox5_1, hBox5_2);


        HBox hBox6 = new HBox(20);
        hBox6.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox6_1 = new HBox(10);

        Label label6_1_1 = new Label("横向:");
        ComboBox<String> comboBox6_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox6_1_1.setPrefWidth(105);
        comboBox6_1_1.getSelectionModel().select(timePara.getBroadwise());

        hBox6_1.getChildren().add(label6_1_1);
        hBox6_1.getChildren().add(comboBox6_1_1);

        HBox hBox6_2 = new HBox(10);

        Label label6_2_1 = new Label("纵向:");
        ComboBox<String> comboBox6_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5","6"));
        comboBox6_2_1.setPrefWidth(105);
        comboBox6_2_1.getSelectionModel().select(timePara.getPortrait());

        hBox6_2.getChildren().add(label6_2_1);
        hBox6_2.getChildren().add(comboBox6_2_1);
        hBox6.getChildren().addAll(hBox6_1, hBox6_2);


        HBox hBox7 = new HBox(20);
        hBox7.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox7_1 = new HBox(10);

        Label label7_1_1 = new Label("速度:");
        ComboBox<String> comboBox7_1_1 = new ComboBox<String>(FXCollections.observableArrayList("1", "2"));
        comboBox7_1_1.setPrefWidth(105);
        comboBox7_1_1.getSelectionModel().select(timePara.getSpeed());

        hBox7_1.getChildren().add(label7_1_1);
        hBox7_1.getChildren().add(comboBox7_1_1);

        HBox hBox7_2 = new HBox(10);

        Label label7_2_1 = new Label("停留:");
        ComboBox<String> comboBox7_2_1 = new ComboBox<String>(FXCollections.observableArrayList("3", "4"));
        comboBox7_2_1.setPrefWidth(105);
        comboBox7_2_1.getSelectionModel().select(timePara.getStay());

        hBox7_2.getChildren().add(label7_2_1);
        hBox7_2.getChildren().add(comboBox7_2_1);
        hBox7.getChildren().addAll(hBox7_1, hBox7_2);


        HBox hBox8 = new HBox(20);
        hBox8.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox8_1 = new HBox(10);

        Label label8_1_1 = new Label("排版:");
        ComboBox<String> comboBox8_1_1 = new ComboBox<String>(FXCollections.observableArrayList("0", "2"));
        comboBox8_1_1.setPrefWidth(105);
        comboBox8_1_1.getSelectionModel().select(timePara.getTypesetting());

        hBox8_1.getChildren().add(label8_1_1);
        hBox8_1.getChildren().add(comboBox8_1_1);

        HBox hBox8_2 = new HBox(10);

        Label label8_2_1 = new Label("特技:");
        ComboBox<String> comboBox8_2_1 = new ComboBox<String>(FXCollections.observableArrayList("5", "6"));
        comboBox8_2_1.setPrefWidth(105);
        comboBox8_2_1.getSelectionModel().select(timePara.getStunt());

        hBox8_2.getChildren().add(label8_2_1);
        hBox8_2.getChildren().add(comboBox8_2_1);
        hBox8.getChildren().addAll(hBox8_1, hBox8_2);


        HBox hBox9 = new HBox(20);
        hBox9.setStyle("-fx-padding: 0 0 0 12;");

        HBox hBox9_1 = new HBox(10);

        Label label9_1_1 = new Label("风格:");
        ComboBox<String> comboBox9_1_1 = new ComboBox<String>(FXCollections.observableArrayList("YYYY-MM-DD HH:mm:ss"));
        comboBox9_1_1.setPrefWidth(267);
        comboBox9_1_1.getSelectionModel().select(timePara.getTimeStyle());

        hBox9_1.getChildren().add(label9_1_1);
        hBox9_1.getChildren().add(comboBox9_1_1);
        hBox9.getChildren().addAll(hBox9_1);

        VBox vBox = new VBox(10);
        JFXButton button = new JFXButton("预览");
        button.setOnAction(event -> {
            TimePara timePara1 = new TimePara(textField1_1.getText(), textField2_1_1.getText(), textField3_1_1.getText(), textField2_2_1.getText(), textField3_2_1.getText(), comboBox4_1_1.getValue(), comboBox4_2_1.getValue(), comboBox5_1_1.getValue(), comboBox5_2_1.getValue(), comboBox6_1_1.getValue(), comboBox6_2_1.getValue(), comboBox7_1_1.getValue(), comboBox7_2_1.getValue(), comboBox8_1_1.getValue(), comboBox8_2_1.getValue(), comboBox9_1_1.getValue());
            programParaList.put(textField1_1.getText(), timePara1);
        });
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, separator, hBox4, hBox5, hBox6, hBox7, hBox8, hBox9, button);
        editPara.getChildren().add(vBox);
    }

    public static class NoiseParaController {

    }

    public class BasicPara {
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

    public class NoisePara extends BasicPara {
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

        public NoisePara(String programName, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String trueColor, String falseColor) {
            super(programName, X, Y, width, height, fontType, fontSize, spacing);
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

    public class SubTitlePara extends BasicPara {
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

        public SubTitlePara(String programName, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String color, String broadwise, String portrait, String speed, String stay, String typesetting, String stunt) {
            super(programName, X, Y, width, height, fontType, fontSize, spacing);
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

    public class TimePara extends SubTitlePara {
        private String timeStyle;

        public TimePara(String programName, String X, String Y, String width, String height, String fontType, String fontSize, String spacing, String color, String broadwise, String portrait, String speed, String stay, String typesetting, String stunt, String timeStyle) {
            super(programName, X, Y, width, height, fontType, fontSize, spacing, color, broadwise, portrait, speed, stay, typesetting, stunt);
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

    public class TextPara extends BasicPara {
        private String color;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public TextPara(String programName, String x, String y, String width, String height, String fontType, String fontSize, String spacing, String color) {
            super(programName, x, y, width, height, fontType, fontSize, spacing);
            this.color = color;
        }

        public TextPara() {
        }
    }
}
