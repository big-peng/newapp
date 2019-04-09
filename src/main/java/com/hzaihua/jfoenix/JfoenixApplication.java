package com.hzaihua.jfoenix;

import com.hzaihua.jfoenix.controller.LoginController;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JfoenixApplication extends AbstractJavaFxApplicationSupport {

    /*public static void main(String[] args) {
        SpringApplication.run(JfoenixApplication.class, args);
    }*/
    public static void main(String[] args) {
        launchApp(JfoenixApplication.class, LoginController.class,new LoadAnimate(), args);
    }

}
