package org.example.vko7;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht4 extends Application {


    static int red;
    static int green;
    static int blue;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text teksti = new Text("Muokkaa minua!");
        Slider fontti_säädin = new Slider(0,100,1); fontti_säädin.setOrientation(Orientation.VERTICAL);
        fontti_säädin.setPrefHeight(300); fontti_säädin.setLayoutX(480);
        Slider rbg_säädin = new Slider(0,240,1);
        rbg_säädin.setLayoutY(280); rbg_säädin.setPrefWidth(480);

        rbg_säädin.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                teksti.setFill(Color.hsb(t1.doubleValue(),1,1));
            }
        });
        fontti_säädin.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                teksti.setFont(Font.font("Muokkaa minua!", t1.doubleValue()));
            }
        });
        Pane paneeli = new Pane();
        paneeli.getChildren().addAll(teksti, fontti_säädin, rbg_säädin);
        teksti.setLayoutY(150); teksti.setLayoutX(50);

        Scene kehys = new Scene(paneeli, 500, 300);
        primaryStage. setTitle("Aseta kellolle aika"); // otsikko ikkunalle
        primaryStage.setScene(kehys); // sijoitetaan kehys ik
        primaryStage.show();
    }
}
