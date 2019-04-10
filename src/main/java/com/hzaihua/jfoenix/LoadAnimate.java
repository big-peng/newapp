package com.hzaihua.jfoenix;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LoadAnimate extends SplashScreen {
    @Override
    public String getImagePath() {
        return "/views/img/load.gif";
    }

    @Override
    public boolean visible() {
        return true;
    }
    @Override
    public Parent getParent() {
        final ImageView imageView = new ImageView(getClass().getResource(getImagePath()).toExternalForm());
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        final VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView);
        vbox.setLayoutX(1);
        return vbox;
    }
}
