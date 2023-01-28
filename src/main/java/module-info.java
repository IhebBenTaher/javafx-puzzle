module com.example.jeux {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jeux to javafx.fxml;
    exports com.example.jeux;
}