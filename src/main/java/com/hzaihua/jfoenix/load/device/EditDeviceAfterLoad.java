package com.hzaihua.jfoenix.load.device;

import com.hzaihua.jfoenix.controller.Device.EditFixedDeviceController;
import com.hzaihua.jfoenix.controller.user.UserInfoController;
import com.hzaihua.jfoenix.decorator.CustomJFXDecorator;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditDeviceAfterLoad extends Application{
    public EditDeviceAfterLoad(){
        super();
        try {
            start(new Stage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewFlowContext flowContext = new ViewFlowContext();
        flowContext.register("Stage", primaryStage);
        Flow flow = new Flow(EditFixedDeviceController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, false, true);
        Scene scene = new Scene(decorator, 400, 500);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(UserInfoController.class.getResource("/views/css/systemSetup.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("编辑设备");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
