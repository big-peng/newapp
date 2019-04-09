package com.hzaihua.newapp;

import com.hzaihua.newapp.views.JavaFXMain;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzaihua.newapp.dao")
public class NewappApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launchApp(NewappApplication.class, JavaFXMain.class, args);
    }
}

