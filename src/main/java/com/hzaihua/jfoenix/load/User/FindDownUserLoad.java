package com.hzaihua.jfoenix.load.User;

import com.hzaihua.jfoenix.controller.user.FindDownUserController;
import com.hzaihua.jfoenix.decorator.CustomJFXDecorator;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FindDownUserLoad extends Application {
    public FindDownUserLoad(){
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
        Flow flow = new Flow(FindDownUserController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, false, true);
        Scene scene = new Scene(decorator, 410, 250);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(FindDownUserController.class.getResource("/views/css/systemSetup.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("搜索下级用户");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
