package com.hzaihua.jfoenix.load.measure;

import com.hzaihua.jfoenix.controller.measure.AddMoveMeasureController;
import com.hzaihua.jfoenix.controller.user.AddDownUserController;
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

public class AddMoveMeasureLoad extends Application{
    public AddMoveMeasureLoad(){
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
        Flow flow = new Flow(AddMoveMeasureController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, false, true);
        Scene scene = new Scene(decorator, 600, 650);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(UserInfoController.class.getResource("/views/css/systemSetup.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("添加测点");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
