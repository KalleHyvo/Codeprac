package org.example.vko7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class teht6 extends Application implements Serializable {
    static  boolean on = false;
    static int ID_indeksi;
    static int ID_muistio;
    ArrayList listview_teko = new ArrayList<>();

    HBox alaboksi = new HBox();
    Button nosta = new Button("Nosta");
    Button talleta = new Button("Talleta");
    Text summa = new Text("Summa:");
    TextField summa_field = new TextField();
    Button lopetus = new Button("Lopeta");
    ListView<String> list = new ListView<String>();
    VBox tekstilaatikko = new VBox();
    Text tili_näyttö = new Text("Ei tili valittuna");
    Text tili_korko = new Text("Ei tiliä");
    Text tili_saldo = new Text("Ei tiliä");

    Pane root = new Pane();
    @Override
    public void start(Stage primaryStage) {
        list.setPrefWidth(50); list.setPrefHeight(250);
        ArrayList<Tili> Taulu = new ArrayList<>();
        try {
            FileInputStream TiliOut = new FileInputStream("tilit.dat");
            System.out.println("Tiedosto löytyi!" + "\n");
            ObjectInputStream Out = new ObjectInputStream(TiliOut);

            Taulu = (ArrayList) Out.readObject();

            Out.close();
            TiliOut.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt!" + "\n");
            Tili Tili1 = new Tili(29, 100);
            Tili Tili2 = new Tili(21, 100);
            Tili Tili3 = new Tili(22, 100);
            //taulun oliot
            Taulu.add(Tili1);
            Taulu.add(Tili2);
            Taulu.add(Tili3);
        }
        for(Tili i : Taulu){
            listview_teko.add(Integer.toString((i.get_id())));
        }
        ObservableList<String> itemit = FXCollections.observableArrayList (listview_teko);
        list.setItems(itemit);

        ArrayList<Tili> finalTaulu = Taulu;
        list.setOnMouseClicked(mouseEvent -> {
            ObservableList<String> valinnat = list.getSelectionModel().getSelectedItems();
            for( String valinta : valinnat){
                ID_muistio = Integer.parseInt(valinta);
            }
            for(Tili tili : finalTaulu){
                if(tili.get_id() == ID_muistio){
                ID_indeksi = finalTaulu.indexOf(tili);
                }
            }
            tili_näyttö.setText("Tilin "+ finalTaulu.get(ID_indeksi).get_id() + " tiedot" );
            tili_korko.setText("vuosiKorko: "+ finalTaulu.get(ID_indeksi).getVuosiKorko());
            tili_saldo.setText("saldo = " + finalTaulu.get(ID_indeksi).get_saldo());
        });
        alaboksi.getChildren().addAll(nosta,talleta,summa,summa_field,lopetus);
        alaboksi.setLayoutX(70); alaboksi.setLayoutY(260);

        ArrayList<Tili> finalTaulu2 = Taulu;
        ArrayList<Tili> finalTaulu3 = Taulu;
        nosta.setOnAction(actionEvent -> {
            if(summa_field.getText() != null){
                int sum = Integer.parseInt(summa_field.getText());
                for (Tili tili : finalTaulu2){
                    if(tili.get_id() == ID_muistio){
                        tili.set_saldo(tili.get_saldo() - sum);
                        tili_saldo.setText("saldo = " + finalTaulu3.get(ID_indeksi).get_saldo());
                        break;
                    }
                }
            }
        });
        ArrayList<Tili> finalTaulu4 = Taulu;
        ArrayList<Tili> finalTaulu5 = Taulu;
        talleta.setOnAction(actionEvent -> {
            if(summa_field.getText() != null){
                int sum = Integer.parseInt(summa_field.getText());
                for (Tili tili : finalTaulu4){
                    if(tili.get_id() == ID_muistio){
                        tili.set_saldo(tili.get_saldo() + sum);
                        tili_saldo.setText("saldo = " + finalTaulu5.get(ID_indeksi).get_saldo());
                        break;
                    }
                }
            }
        });
        ArrayList<Tili> finalTaulu6 = Taulu;
        lopetus.setOnAction(actionEvent -> {
            try{
                FileOutputStream TilitIn = new FileOutputStream("tilit.dat");
                ObjectOutputStream in = new ObjectOutputStream(TilitIn);
               in.writeObject(finalTaulu6);
                in.close();
                TilitIn.close();} catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        });
        tekstilaatikko.getChildren().addAll(tili_näyttö, tili_korko, tili_saldo);
        tekstilaatikko.setLayoutX(60); tekstilaatikko.setLayoutY(20);

        root.getChildren().addAll(list,alaboksi, tekstilaatikko);
        Scene kehys = new Scene(root, 500, 300);

        primaryStage. setTitle("Tili käyttöliittymä");
        primaryStage.setScene(kehys);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
