package org.example.vko7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht2 extends Application {
        static String valinta_lista = "";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text valinta_show = new Text("Valitsit: ");
        valinta_show.setLayoutX(5); valinta_show.setLayoutY(180);
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Porkkana", "Lanttu", "Punajuuri", "Nauris", "Retiisi",
                "Palsternakka", "Maa-artisokka");
        list.setItems(items);
        list.setPrefHeight(170); list.setPrefWidth(400);

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.isControlDown()){
                    list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    valinta_lista = "Valitsit: ";
                    ObservableList<String> valinnat = list.getSelectionModel().getSelectedItems();

                    for(String valinta : valinnat){
                        valinta_lista= valinta_lista + valinta + " ";

                    }

                }else{
                    valinta_lista = "Valitsit: ";
                    ObservableList<String> valinnat = list.getSelectionModel().getSelectedItems();
                    list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    for(String valinta : valinnat){

                        valinta_lista= valinta_lista + valinta + " ";
                    }
                }
                valinta_show.setText(valinta_lista);
            }
        });

        primaryStage.setTitle("Valitse juurekset kasviskeittoon:");
        Group root = new Group();
        root.getChildren().addAll(list, valinta_show);
        Scene scene = new Scene(root,400,200, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
