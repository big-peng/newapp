package com.hzaihua.jfoenix.load.User;

import com.hzaihua.jfoenix.controller.user.EditUserPasswordController;
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

public class EditPasswordLoad extends Application{
    public EditPasswordLoad(){
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
        Flow flow = new Flow(EditUserPasswordController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, false, true);
        Scene scene = new Scene(decorator, 540, 250);
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(UserInfoController.class.getResource("/views/css/systemSetup.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("修改密码");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
