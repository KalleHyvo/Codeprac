package org.example.vko5_teht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Teht6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tehtävä 6");
        AnchorPane root = new AnchorPane();
        HBox aika = new HBox();
        HBox napit = new HBox();
        VBox Systeemi = new VBox();
        Pane kuva = new Pane();
        Image ateria = new Image("ateriakuva.png", 200,150,false,false);
        Rectangle ikkuna = new Rectangle(290,193);
        aika.getChildren().add(new Text("                0:00"));
        napit.getChildren().add(new Button("Start"));
        napit.getChildren().add(new Button("Stop"));
        napit.getChildren().add(new Button("Clear"));
        Rectangle kulmio1 = new Rectangle(125,24);
        Rectangle background = new Rectangle(530,200);
        Text nimi = new Text("MIKROAALTOUUNI");

        background.setFill(Color.WHITE);
        background.setStroke(Color.BLACK);
        AnchorPane.setLeftAnchor(background,10.0);

        Systeemi.getChildren().add(aika);
        Systeemi.getChildren().add(napit);
        Systeemi.setSpacing(5);
        AnchorPane.setLeftAnchor(Systeemi,414.0);
        AnchorPane.setTopAnchor(Systeemi,8.0);

        kulmio1.setStroke(Color.BLACK);
        kulmio1.setStroke(Color.BLACK);kulmio1.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(kulmio1,414.0);
        AnchorPane.setTopAnchor(kulmio1,4.0);


        kuva.getChildren().addAll(ikkuna, new ImageView(ateria));
        AnchorPane.setLeftAnchor(kuva,10.0);
        AnchorPane.setLeftAnchor(kuva,120.0);
        AnchorPane.setTopAnchor(kuva,13.0);
        AnchorPane.setLeftAnchor(ikkuna,70.0);
        AnchorPane.setTopAnchor(ikkuna,3.0);

        ikkuna.setStroke(Color.BLACK);
        ikkuna.setFill(Color.TRANSPARENT);

        AnchorPane.setTopAnchor(nimi, 180.0);
        AnchorPane.setRightAnchor(nimi,33.0);

        root.getChildren().addAll(background, ikkuna , kuva, kulmio1, Systeemi, nimi);
        Scene scene = new Scene(root,550,220, Color.GRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
