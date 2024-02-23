package org.example.vko5_teht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Teht2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tehtävä 2");
        VBox vbox = new VBox(20);
        vbox.getChildren().add(new Button(("Ylin")));
        vbox.getChildren().add(new Button(("Keskellä")));
        vbox.getChildren().add(new Button(("Alin")));

        Scene kuva = new Scene(vbox,380,420);
        primaryStage.setScene(kuva);
        primaryStage.show();
    }
}
