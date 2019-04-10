package com.hzaihua.jfoenix.load;

import com.hzaihua.jfoenix.controller.MainController;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainLoad extends Application {

    public MainLoad() {
        super();
        try{
            start(new Stage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewFlowContext flowContext = new ViewFlowContext();
        flowContext.register("Stage", primaryStage);
        Flow flow = new Flow(MainController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(flowContext).start(container);
        CustomJFXDecorator decorator = new CustomJFXDecorator(primaryStage,container.getView(), false, true, true);
        Scene scene = new Scene(decorator, 1250, 600);
        primaryStage.getIcons().add(new Image("/views/img/Thunderx.jpg"));
        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.add(MainController.class.getResource("/views/css/main.css").toExternalForm());
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("爱华自动监测");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
