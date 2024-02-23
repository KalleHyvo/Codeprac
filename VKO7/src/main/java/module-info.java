module org.example.vko7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.vko7 to javafx.fxml;
    exports org.example.vko7;
}