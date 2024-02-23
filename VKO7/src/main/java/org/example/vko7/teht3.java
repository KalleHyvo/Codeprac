package org.example.vko7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class teht3 extends Application
{
    @Override // korvaa metodin start luokassa Application
    public void start(Stage alkuIkkuna)
    {
        HBox ajan_asetin = new HBox();
        ajan_asetin.setSpacing(5);
        Text hour = new Text("Tunnit");
        TextField tunnit = new TextField(); tunnit.setPrefWidth(70);
        Text minutes = new Text("minuutit");
        TextField minuutit = new TextField(); minuutit.setPrefWidth(70);
        Text seconds = new Text("sekunnit");
        TextField sekunnit = new TextField(); sekunnit.setPrefWidth(70);
        KelloPaneeli kello = new KelloPaneeli();
        ajan_asetin.getChildren().addAll(hour, tunnit, minutes , minuutit, seconds, sekunnit);
        // merkkijono kellonajalle
        String aikaMerkkijono = kello.getTunti() + ":" +
                kello.getMinuutti() + ":" + kello.getSekunti();
        Label lbOikeaAika = new Label(aikaMerkkijono);
        // sijoitetaan kello ja label paneeliin
        BorderPane paneeli = new BorderPane();
        paneeli.setCenter(kello);

        paneeli.setTop(ajan_asetin);
        BorderPane.setAlignment(ajan_asetin, Pos.TOP_CENTER);
        BorderPane.setAlignment(kello, Pos.CENTER);

        // kehys ja sjoitetaan siihen paneeli
        Scene kehys = new Scene(paneeli, 500, 300);
        alkuIkkuna. setTitle("Aseta kellolle aika"); // otsikko ikkunalle
        alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
        alkuIkkuna.show(); // n�ytet��n ikkuna

        // lis�t��n kuuntelija joka seuraa paneelin muutoksia
        paneeli.widthProperty().addListener(ov ->
                kello.setLeveys(paneeli.getWidth())
        );

        paneeli.heightProperty().addListener(ov ->
                kello.setKorkeus(paneeli.getHeight())
        );
        minuutit.setOnKeyPressed(KeyEvent -> {
            if(KeyEvent.getCode().equals(KeyCode.ENTER) && minuutit.getText() != null){
                kello.setMinuutti(Integer.parseInt(minuutit.getText()));
                System.out.println(kello.getMinuutti());
            }
        });
        sekunnit.setOnKeyPressed(KeyEvent -> {
            if(KeyEvent.getCode().equals(KeyCode.ENTER) && sekunnit.getText() != null){
                kello.setSekunti(Integer.parseInt(sekunnit.getText()));
                System.out.println(kello.getSekunti());
            }
        });
        tunnit.setOnKeyPressed(KeyEvent -> {
            if(KeyEvent.getCode().equals(KeyCode.ENTER) && tunnit.getText() != null){
                kello.setTunti(Integer.parseInt(tunnit.getText()));
                System.out.println(kello.getTunti());
            }
        });
    }

    public static void main(String [] args)
    {
        Application.launch(args);
    }
}