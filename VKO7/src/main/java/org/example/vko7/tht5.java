package org.example.vko7;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tht5 extends Application {
    static double font_size = 20;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane paneeli = new Pane();
        VBox napit = new VBox(); napit.setSpacing(20);
        HBox fonttiboksi = new HBox(); fonttiboksi.setSpacing(135);
        HBox alaboxi = new HBox(); alaboxi.setLayoutY(270); alaboxi.setLayoutX(5);
        VBox napit2 = new VBox(); napit2.setSpacing(25);

        Text alateksti = new Text("Anna uusi teksti: ");
        TextField tekstiboxi = new TextField(); tekstiboxi.setPrefWidth(400);
        alaboxi.getChildren().addAll(alateksti,tekstiboxi);

        CheckBox bold = new CheckBox("Bold");
        CheckBox italic = new CheckBox("Italic");
        napit2.getChildren().addAll(bold,italic);
        napit2.setLayoutX(450); napit2.setLayoutY(60);

        fonttiboksi.setLayoutX(180); fonttiboksi.setLayoutY(5);
        Text ylös = new Text("Anna uusi koko tekstille:");
        TextField fontti = new TextField(); fontti.setPrefWidth(50);
        fonttiboksi.getChildren().addAll(ylös, fontti);

        napit.setLayoutX(5); napit.setLayoutY(50);
        RadioButton red = new RadioButton("Punainen");
        RadioButton blue = new RadioButton("Sininen");
        RadioButton black = new RadioButton("Musta");
        RadioButton orange = new RadioButton("Oranssi");
        RadioButton green = new RadioButton("Vihreä");

        Text näyttö = new Text("paikannus"); näyttö.setLayoutX(150); näyttö.setLayoutY(150);

        ToggleGroup väri = new ToggleGroup();
        red.setToggleGroup(väri); blue.setToggleGroup(väri);
        black.setToggleGroup(väri); orange.setToggleGroup(väri);
        green.setToggleGroup(väri);

        tekstiboxi.setOnKeyPressed(actionEvent -> {
            if(actionEvent.getCode().equals(KeyCode.ENTER) && tekstiboxi.getText() != null){
                näyttö.setText(tekstiboxi.getText());
            }
        });

        väri.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if  (väri.getSelectedToggle()== red){
                    näyttö.setFill(Color.RED);
                } else if (väri.getSelectedToggle() == blue) {
                    näyttö.setFill(Color.BLUE);
                } else if (väri.getSelectedToggle() == black) {
                    näyttö.setFill(Color.BLACK);
                } else if (väri.getSelectedToggle() == orange) {
                    näyttö.setFill(Color.ORANGE);
                } else if (väri.getSelectedToggle() == green) {
                    näyttö.setFill(Color.GREEN);
                }
            }
        });
        fontti.setOnKeyPressed(actionEvent -> {
            if(actionEvent.getCode().equals(KeyCode.ENTER) && fontti.getText() != null){
                näyttö.setFont(Font.font(Double.parseDouble(fontti.getText())));
                 font_size = Double.parseDouble(fontti.getText());
            }
        });
        EventHandler checkmark = new EventHandler() {
            @Override
            public void handle(Event event) {
                if (italic.isSelected() && bold.isSelected()) {
                    näyttö.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC,font_size));
                }
                 else if (italic.isSelected()) {
                    näyttö.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC,font_size));
                } else if (bold.isSelected()) {
                    näyttö.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,font_size));
                } else {
                    näyttö.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR,font_size));
                }
            }
        };
        bold.setOnAction(checkmark);
        italic.setOnAction(checkmark);



        napit.getChildren().addAll(red, blue, black ,orange, green);
        paneeli.getChildren().addAll(napit, näyttö, fonttiboksi, alaboxi, napit2);
        Scene kehys = new Scene(paneeli, 500, 300);
        primaryStage. setTitle("Muokataan tekstin ulkoasua");
        primaryStage.setScene(kehys);
        primaryStage.show();
    }
}
