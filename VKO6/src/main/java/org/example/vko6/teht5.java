package org.example.vko6;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class teht5 extends Application {
    // viime tehtävän muuttujan jota käytän tässäkin, tekee samaa kuin tehtävässä 4
    static int klikkaus = 0;
    // arvattava sana
    final String arvattava_sana = "MEHILÄINEN";
    // käytetään textfieldissä promptina, ja päivitetään kun arvataan sanoja
    static String vinkki = "";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //asetetaan paneeleja, muuuta sälää
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



        TextField sanan_arvaus = new TextField();
        //tällä textfieldi ei ole automaattisesti valittuna
        sanan_arvaus.setFocusTraversable(false);
        //tällä näkee promptin kun kirjoittaa
        sanan_arvaus.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
        //automatisoidaan ensimmäinen "vinkki" peliin, eli jokaista arvattava_sana kirjainta vastaan lisätään " "
        for(int i = 0; i < arvattava_sana.length(); i ++){
            vinkki = vinkki + "_";
            vinkki.replace("null","");}
        sanan_arvaus.setPromptText(vinkki);
        root.getChildren().add(sanan_arvaus);
        // lisää asioiden laittamista, ja koordinaatti säätöä
        Text voitto = new Text("Voitit pelin!");
        Text häviö = new Text("Hävisit pelin!");
        voitto.setLayoutY(40);
        voitto.setLayoutX(20);
        häviö.setLayoutY(40);
        häviö.setLayoutX(20);


        //Eventti joka tapahtuu kun kirjoittaa textfieldiin ja painaa enter
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER) && sanan_arvaus.getText() != null) {
                    String arvaus = sanan_arvaus.getText();
                    /*
                    väärin = true, lisää yhden osan piirrosta jos ei saa oikein
                     */
                    boolean väärin = true;
                    if(arvaus.toLowerCase().equals(arvattava_sana.toLowerCase()) == false){
                        /*
                        katsoo kahden for loopin avulla onko arvattu sana oikea, ja onko oikea kirjain oikeassa kohtaa
                        ja päivittää vinkki muuttujaa promptissa
                         */
                        for(int i = 0; i < arvaus.length(); i ++ ){
                            for(int k = 0; k <arvattava_sana.length(); k++){
                                if(arvaus.toLowerCase().charAt(i) == arvattava_sana.toLowerCase().charAt(k)){
                                    vinkki = vinkki.substring(0, k) + arvattava_sana.charAt(k)
                                            + vinkki.substring(k + 1);
                                }
                            }
                        }} else if (arvaus.toLowerCase().equals(arvattava_sana.toLowerCase()) == true) {
                        // jos sana oikein, lisätään voitto tektsi ja väärin = false, eli ei lisää piirrokseen
                        root.getChildren().add(voitto);
                        väärin = false;

                    }

                    //päivittää promptin ja poistaa textfielding pois valinnasta
                    sanan_arvaus.setPromptText(vinkki);
                    sanan_arvaus.deselect();
                    if(väärin == true){
                        klikkaus += 1;
                    }
                    switch (klikkaus){
                        case 1: root.getChildren().add(soikio); break;
                        case 2: root.getChildren().add(puu1); break;
                        case 3: root.getChildren().add(puu2); break;
                        case 4: root.getChildren().add(köysi); break;
                        case 5: root.getChildren().add(pää); break;
                        case 6: root.getChildren().add(torso); break;
                        case 7: root.getChildren().add(käsi2); break;
                        case 8: root.getChildren().add(käsi1); break;
                        case 9: root.getChildren().add(jalka2); break;
                        case 10: root.getChildren().addAll(jalka1, häviö); break;
                    }
                    sanan_arvaus.setFocusTraversable(false);
                    sanan_arvaus.clear();

                }

            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



