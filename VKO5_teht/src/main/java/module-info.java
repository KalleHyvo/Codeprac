module org.example.vko5_teht {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.vko5_teht to javafx.fxml;
    exports org.example.vko5_teht;
}