package org.example.vko6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht3 extends Application {

    double määrä;
    double vuosi_määrä;
    double vuosikorko;
    double tuotto;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ja rahaa tulee");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(5);
        root.add(new Text("Sijoituksen määrä: "),0,0);
        root.add(new Text("Vuosien määrä "),0,1);
        root.add(new Text("Vuosikorko %"),0,2);
        root.add(new Text(""),0,3);
        root.add(new Text("Tuotto odotus "),0,4);

        TextField sijoitus = new TextField();
        sijoitus.setAlignment(Pos.CENTER_RIGHT);
        TextField vuodet = new TextField();
        vuodet.setAlignment(Pos.CENTER_RIGHT);
        TextField korko = new TextField();
        korko.setAlignment(Pos.CENTER_RIGHT);
        TextField tuotto = new TextField();
        tuotto.setAlignment(Pos.CENTER_RIGHT);

        Button lasku = new Button("Laske");

        root.add(sijoitus,1,0); root.add(vuodet,1,1);
        root.add(korko,1,2); root.add(lasku,1,3); root.add(tuotto,1,4);

        lasku.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == lasku){
                    if(sijoitus.getText() != null){
                        määrä = Double.parseDouble(sijoitus.getText());}
                    else {määrä = 0;}
                    if(vuodet.getText() != null){
                        vuosi_määrä = Double.parseDouble(vuodet.getText());}
                    else {vuosi_määrä = 0;}
                    if(korko.getText() != null){
                        vuosikorko = Double.parseDouble(korko.getText());}
                    else {vuosikorko = 0;}
                    double summa = määrä*Math.pow((1+vuosikorko/100),vuosi_määrä);
                    tuotto.setText(String.format("%.2f", summa));
                }

            }
        });

        Scene ikkuna = new Scene(root,600,500);
        primaryStage.setScene(ikkuna);
        primaryStage.show();
    }
}

