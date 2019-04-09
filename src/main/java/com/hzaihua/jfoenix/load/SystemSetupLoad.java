package com.hzaihua.jfoenix.load;

import com.hzaihua.jfoenix.controller.MainController;
import com.hzaihua.jfoenix.controller.SystemSetupController;
import com.hzaihua.jfoenix.decorator.CustomJFXDecorator;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SystemSetupLoad extends Application {
    public SystemSetupLoad() {
        super();
        try{
            start(new Stage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*primaryStage.setResizable(false);
        //设置窗口的图标.
        //primaryStage.getIcons().add(new Image(
        //        SystemSetupController.class.getResourceAsStream("logo.png")));
        //Parent root = loader.load();
        primaryStage.setTitle("图书管理系统");
        DefaultFlowContainer container = new DefaultFlowContainer();
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, true, true);
        Scene scene = new Scene(decorator, 700, 460);
        scene.getStylesheets().add(SystemSetupController.class.getResource("/views/css/systemSetup.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();*/


        ViewFlowContext flowContext = new ViewFlowContext();
        flowContext.register("Stage", primaryStage);

        //系统托盘图标
        /*SystemTray tray = SystemTray.getSystemTray();
        BufferedImage image = ImageIO.read(MainLoad.class
                .getResourceAsStream("/views/img/Thunderx1.jpg"));
        TrayIcon trayIcon = new TrayIcon(image, "自动备份工具");
        trayIcon.setToolTip("自动备份工具");
        tray.add(trayIcon);*/

// create flow and flow container, flow container controls view decoration and view exchange
        Flow flow = new Flow(SystemSetupController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);

// JFXDecorator will be applied to primaryStage, and decorated on view which is created by flow container
        /*JFXDecorator decorator = new JFXDecorator(primaryStage, container.getView(),
                false, true, true);*/
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, false, true);
// init scene with a decorator
        Scene scene = new Scene(decorator, 700, 460);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(SystemSetupController.class.getResource("/views/css/systemSetup.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setY(220);
        primaryStage.setX(600);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("系统设置");
        primaryStage.setHeight(600);
        primaryStage.setWidth(700);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
