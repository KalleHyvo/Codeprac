package org.example.vko5_teht;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Teht3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tehtävä 3");
        Group root = new Group();
        Scene scene = new Scene(root,380,420, Color.WHITE);

        Circle ympyra1 = new Circle(20,Color.BLACK);
            ympyra1.setCenterX(190);
            ympyra1.setCenterY(90);
            ympyra1.setStroke(Color.BLACK);
        Circle ympyra2 = new Circle(20,Color.BLACK);
            ympyra2.setCenterX(190);
            ympyra2.setCenterY(140);
            ympyra2.setStroke(Color.BLACK);
        Circle ympyra3 = new Circle(20,Color.BLACK);
            ympyra3.setCenterX(190);
            ympyra3.setCenterY(190);
            ympyra3.setStroke(Color.BLACK);

        Rectangle kulmio1 = new Rectangle(60,150);
            kulmio1.setFill(Color.TRANSPARENT);
            kulmio1.setStroke(Color.BLACK);
            kulmio1.setX(161);
            kulmio1.setY(67);
        Rectangle kulmio2 = new Rectangle(20,150);
            kulmio2.setFill(Color.BROWN);
            kulmio2.setStroke(Color.BLACK);
            kulmio2.setX(180);
            kulmio2.setY(216);

        VBox taulu = new VBox(); taulu.setSpacing(20);
        RadioButton red = new RadioButton("Punainen");
        RadioButton yellow = new RadioButton("Keltainen");
        RadioButton green = new RadioButton("Vihreä");
        RadioButton random = new RadioButton("Joku");
        taulu.getChildren().addAll(red, yellow, green, random);

        red.setOnAction((e) -> {
            ympyra1.setFill(Color.RED);
            ympyra2.setFill(Color.BLACK);
            ympyra3.setFill(Color.BLACK);
        });


        root.getChildren().add(ympyra1);
        root.getChildren().add(ympyra2);
        root.getChildren().add(ympyra3);
        root.getChildren().add(kulmio1);
        root.getChildren().add(kulmio2);
        root.getChildren().add(taulu);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
