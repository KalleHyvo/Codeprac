module org.example.vko6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.vko6 to javafx.fxml;
    exports org.example.vko6;
}