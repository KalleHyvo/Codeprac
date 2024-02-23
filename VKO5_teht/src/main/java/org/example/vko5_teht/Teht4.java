package org.example.vko5_teht;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Teht4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tehtävä 4");
        Group root = new Group();
        Scene scene = new Scene(root,380,420, Color.WHITE);
        Ellipse soikio = new Ellipse(180,53);
            soikio.setCenterY(300);
            soikio.setCenterX(180);
            soikio.setFill(Color.YELLOW);
            soikio.setStroke(Color.BLACK);
        Line puu1 = new Line(130,250,130,40);
        Line puu2 = new Line(130,40,300,40);
        Line köysi = new Line(260,40,260,80);
        Circle pää = new Circle(20);
            pää.setCenterX(260);
            pää.setCenterY(100);
            pää.setFill(Color.RED);
            pää.setStroke(Color.BLACK);
        Line torso = new Line(260,120,260,180);
        torso.setStroke(Color.RED);

        Line käsi1 = new Line(260,130,280,160);
        käsi1.setStroke(Color.RED);

        Line käsi2 = new Line(260,130,240,160);
        käsi2.setStroke(Color.RED);

        Line jalka1 = new Line(260,180,280,200);
        jalka1.setStroke(Color.RED);

        Line jalka2 = new Line(260,180,240,200);
        jalka2.setStroke(Color.RED);

        root.getChildren().add(soikio);
        root.getChildren().add(puu1);
        root.getChildren().add(puu2);
        root.getChildren().add(köysi);
        root.getChildren().add(pää);
        root.getChildren().add(torso);
        root.getChildren().add(käsi1);
        root.getChildren().add(käsi2);
        root.getChildren().add(jalka1);
        root.getChildren().add(jalka2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
