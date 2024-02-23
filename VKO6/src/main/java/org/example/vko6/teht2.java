package org.example.vko6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class teht2 extends Application {

    static double y_cord = 169.5;
    static double x_cord = 199.5;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Katso kuinka pallo liikkuu");

        Circle pallo = new Circle(100);
        pallo.setLayoutX(300); pallo.setLayoutY(270);
        pallo.setStroke(Color.BLACK); pallo.setFill(Color.TRANSPARENT);

        Button up = new Button("Ylös");
        Button down = new Button("Alas");
        up.setLayoutX(285); up.setLayoutY(20);
        down.setLayoutX(285); down.setLayoutY(450);

        Button left = new Button("Vasen");
        Button right = new Button("Oikea");
        left.setLayoutX(20); left.setLayoutY(225);
        right.setLayoutX(550); right.setLayoutY(225);

        up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == up){
                    y_cord = y_cord - 1;
                    pallo.relocate(x_cord,y_cord);
                }
            }
        });
        down.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == down){
                    y_cord = y_cord + 1;
                    pallo.relocate(x_cord,y_cord);
                }
            }
        });
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                x_cord = x_cord - 1;
                pallo.relocate(x_cord,y_cord);
            }
        });
        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                x_cord = x_cord + 1;
                pallo.relocate(x_cord,y_cord);
            }
        });

        Pane root = new Pane();
        root.getChildren().addAll(pallo, up, down, left, right);
        Scene ikkuna = new Scene(root,600,500);
        primaryStage.setScene(ikkuna);
        primaryStage.show();
    }
}
