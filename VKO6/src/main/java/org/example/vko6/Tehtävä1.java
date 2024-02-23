package org.example.vko6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Tehtävä1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kiännetään");

        Rectangle rectangle = new Rectangle(200,100);
        rectangle.setY(170);
        rectangle.setX(250);
        rectangle.setStroke(Color.BLACK); rectangle.setFill(Color.TRANSPARENT);

        Button turn = new Button("Käännä");
        turn.setLayoutX(0);
        turn.setLayoutY(200);

        turn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == turn){
                    rectangle.getTransforms().add(new Rotate(45,300,220));
                }
            }
        });

        Pane root = new Pane();
        root.getChildren().addAll(turn, rectangle);
        Scene ikkuna = new Scene(root,600,500);
        primaryStage.setScene(ikkuna);
        primaryStage.show();
    }
}