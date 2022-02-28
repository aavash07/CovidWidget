package com.aavash.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launch extends Application {

    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setOpacity(0);
        primaryStage.show();

        Stage secondaryStage = new Stage();
        secondaryStage.initStyle(StageStyle.UNDECORATED);
        secondaryStage.initOwner(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("/com/aavash/gui/widget/widget.fxml"));
        Scene scene = new Scene(root);
        secondaryStage.setScene(scene);
        secondaryStage.show();

        //make it start at right top aligned
        Rectangle2D visibleBounds = Screen.getPrimary().getVisualBounds();
        secondaryStage.setX(visibleBounds.getMaxX()-25-scene.getWidth());
        secondaryStage.setY(visibleBounds.getMinY()+25);

        //add support for drag and move
        scene.setOnMousePressed(event -> {
            xOffset = secondaryStage.getX()-event.getScreenX();
            yOffset = secondaryStage.getY()- event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            secondaryStage.setX(event.getScreenX()+xOffset);
            secondaryStage.setY(event.getScreenY()+yOffset);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
