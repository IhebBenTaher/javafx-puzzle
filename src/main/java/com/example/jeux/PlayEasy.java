package com.example.jeux;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayEasy {

    @FXML
    private Label b1;
    @FXML
    private Label b2;

    @FXML
    void hover(MouseEvent event) {
        modif((Label)event.getSource());
    }
    @FXML
    void dishover(MouseEvent event) {
        modif2((Label)event.getSource());
    }
    void modif(Label b){
        b.setStyle("-fx-background-color: #00a83b;-fx-text-fill:purple;-fx-border-width:5;-fx-border-color:purple;-fx-border-radius:30;-fx-background-radius:40;");
    }
    void modif2(Label b){
        b.setStyle("-fx-background-color: purple;-fx-text-fill:#00a83b;-fx-border-width:5;-fx-border-color:#00a83b;-fx-border-radius:30;-fx-background-radius:40;");
    }
    @FXML
    void nextplay(MouseEvent event) {
        Stage s=(Stage)b1.getScene().getWindow();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s1=new Scene(root);
        s.setScene(s1);
        s.show();
    }

    @FXML
    void nextrecord(MouseEvent event) {
        Stage s=(Stage)b2.getScene().getWindow();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("record.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s1=new Scene(root);
        s.setScene(s1);
        s.show();
    }

}
