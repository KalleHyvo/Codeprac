package org.example.vko5_teht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Teht5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tehtävä 5");
        GridPane gridpane = new GridPane();
        gridpane.setHgap(3);
        gridpane.setVgap(3);
        gridpane.setLayoutX(10);
        gridpane.setLayoutY(10);
        gridpane.setGridLinesVisible(true);
        Scene scene = new Scene(gridpane,550,420, Color.WHITE);

        Image suomi = new Image("Suomi.jpg", 150,100,false,false);
        Image italia = new Image("italy.png", 150,100,false,false);
        Image norja = new Image("Norge.jpg", 150,100,false,false);
        Image ruotsi = new Image("Sverige.jpg", 150,100,false,false);
        Image ukraina = new Image("ukraine.png", 150,100,false,false);
        Image uk = new Image("union-jack.jpg", 150,100,false,false);

        gridpane.add(new ImageView(suomi),0,0);
        gridpane.add(new ImageView(ruotsi),1,0);
        gridpane.add(new ImageView(norja),2,0);
        gridpane.add(new ImageView(italia),0,1);
        gridpane.add(new ImageView(ukraina),1,1);
        gridpane.add(new ImageView(uk),2,1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
