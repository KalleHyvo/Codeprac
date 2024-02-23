package org.example.vko5_teht;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Teht1 extends Application {

    public static void main (String[]args){
        launch();
    }
    @Override
    public void start(Stage ruutu) throws Exception{
        StackPane pane = new StackPane();
        Button painike = new Button("Kokeile mua");
        Scene scene = new Scene(pane,380,420, Color.WHITE);
        ruutu.setTitle("Tehtävä 1 ratkaisu");
        pane.getChildren().add(painike);



        ruutu.setScene(scene);
        ruutu.show();
    }
}
