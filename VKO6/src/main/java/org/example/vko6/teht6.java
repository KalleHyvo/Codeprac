package org.example.vko6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class teht6 extends Application {

    // käytetään ajan päivittämisessä ja sen laskemisessa
    static int time_count ;
    // käytetään määrittelemään miten time_count luetaan
    static boolean time_count_atribute = false;
    // käytetään kertomaan onko mikroaaltouuni päällä
    static boolean cooking = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // asioiden luomista ja asettelua
        primaryStage.setTitle("Tehtävä 6");
        AnchorPane root = new AnchorPane();
        HBox aika = new HBox();
        HBox napit = new HBox();
        VBox Systeemi = new VBox();
        TextField ajastin = new TextField(); ajastin.setPromptText("0:00");
        ajastin.setMaxWidth(125);
        Pane kuva = new Pane();
        kuva.setMaxSize(400,400);
        Image ateria = new Image("img.png", 200,150,false,false);
        Rectangle ikkuna = new Rectangle(290,193);
        aika.getChildren().add(ajastin);
        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button clear = new Button("Clear");
        napit.getChildren().addAll(start,stop,clear);
        Rectangle background = new Rectangle(530,200);
        Text nimi = new Text("MIKROAALTOUUNI");
        ImageView ateria_kuva =new ImageView(ateria);
        Text valmistuu = new Text("Ruoka on kohta valmis");
        valmistuu.setFont(Font.font(20));
        Text valmistui = new Text("Ruoka on valmista!");
        valmistui.setFont(Font.font(20));
        background.setFill(Color.WHITE);
        background.setStroke(Color.BLACK);
        AnchorPane.setLeftAnchor(background,10.0);
        Systeemi.getChildren().add(aika);
        Systeemi.getChildren().add(napit);
        Systeemi.setSpacing(5);
        AnchorPane.setLeftAnchor(Systeemi,414.0);
        AnchorPane.setTopAnchor(Systeemi,8.0);
        kuva.getChildren().addAll(ateria_kuva);
        AnchorPane.setLeftAnchor(kuva,10.0);
        AnchorPane.setLeftAnchor(kuva,120.0);
        AnchorPane.setTopAnchor(kuva,13.0);
        AnchorPane.setLeftAnchor(ikkuna,70.0);
        AnchorPane.setTopAnchor(ikkuna,3.0);
        valmistuu.setFill(Color.RED);
        valmistuu.setLayoutX(10);
        valmistuu.setLayoutY(100);
        valmistui.setFill(Color.RED);
        valmistui.setLayoutX(10);
        valmistui.setLayoutY(100);
        System.out.println(time_count);
        ikkuna.setStroke(Color.BLACK);
        ikkuna.setFill(Color.TRANSPARENT);
        AnchorPane.setTopAnchor(nimi, 180.0);
        AnchorPane.setRightAnchor(nimi,33.0);

        /*
         luodaan timeline, joka kun pistetään päälle, pienentää time_count muuttujaa yhdellä joka sekuntti,
         muuttaa time_count muotoon 0:00 ja päivittää ajastin textfieldiin uuden ajan
         */
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                time_count = time_count - 1;
                int minutes = (time_count % 3600) / 60;
                int seconds = time_count % 60;
                String update = String.format("%02d:%02d",minutes, seconds);
                ajastin.setText(update);
            }
        }));
        /*
        start eventti, aloitetaan timeline ja katsotaan millä tavalla päivitetään time_count ajastin text-
        fieldistä
         */
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == start && ajastin.getText() != null){
                    // aika muodossa sekuntti (esim 9) käytetään tätä
                    if(time_count_atribute == false){
                        time_count = Integer.parseInt(ajastin.getText());}
                    else{
                        // jos aika muodossa 0:00 pilkotaan se kahteen osiin 00:00 -> minuutit ja sekunnit
                        time_count = Integer.parseInt(ajastin.getText().substring(0,2))*60 +
                                Integer.parseInt(ajastin.getText().substring(3,5));
                    }
                    // päälllä, päivitetään kuinka kauan timeline on käynnissä ja aloitetaan timeline
                    cooking = true;
                    timeline.setCycleCount(time_count);
                    timeline.play();
                }
            }
        });
        // lopetetaan timeline
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cooking = false;
                time_count_atribute = true;
                timeline.stop();
            }
        });
        // tyhjennetään textfield, siksi time_count_atribute = false koska aika taas muodossa 0
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cooking = false;
                time_count_atribute = false;
                timeline.stop();
                ajastin.clear();
            }
        });
        /*
        ateriakuvalle hoverproperty, jos hiiri kuvan päällä ja aika on 0 ja mikroaaltouuni päällä, poistetaan ateria
        kuva ja näytetään valmistui teksti, ja valmistuu tekstille mutta aika ei 0
         */
        kuva.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            if (newValue && time_count == 0 && cooking == true) {
                kuva.getChildren().add(valmistui);
                kuva.getChildren().remove(ateria_kuva);
            } else if (newValue && cooking == true) {
                kuva.getChildren().add(valmistuu);
                kuva.getChildren().remove(ateria_kuva);
            }else {
                // kun hiiri lähtee pois kuvan päältä, ja ateria kuvaa ei ole se lisätään
                if (kuva.getChildren().contains(ateria_kuva) == false){
                    kuva.getChildren().add(ateria_kuva);
                }
                // poistetaan muut mahdolliset lisäykset
                kuva.getChildren().remove(valmistuu);
                kuva.getChildren().remove(valmistui);
            }
        });
        root.getChildren().addAll(background,nimi, ikkuna, Systeemi, kuva);
        Scene scene = new Scene(root,550,220, Color.GRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
