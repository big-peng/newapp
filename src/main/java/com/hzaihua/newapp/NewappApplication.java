package com.hzaihua.newapp;

import com.hzaihua.newapp.views.JavaFXMain;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzaihua.newapp.dao")
public class NewappApplication extends AbstractJavaFxApplicationSupport {

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        super.start(primaryStage);
    }*/
    /*public static void main(String[] args) {
        launch(args);
    }*/
    /*主方法与SpringBoot不同，调用的是AbstractJavaFxApplicationSupport类中的
    launchApp方法，其中JavaFXMain为我们的主界面的启动类*/
    public static void main(String[] args) {
        launchApp(NewappApplication.class, JavaFXMain.class, args);
    }
}

