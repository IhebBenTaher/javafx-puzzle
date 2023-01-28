package com.example.jeux;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecordController implements Initializable {
    @FXML
    private Button back;
    @FXML
    void hoverb(MouseEvent event){
        back.setStyle("-fx-background-color: #00a83b;");
    }
    @FXML
    void dishoverb(MouseEvent event){
        back.setStyle("-fx-background-color: purple;-fx-background-radius:40");
    }
    @FXML
    void back(ActionEvent event){
        Stage s=(Stage)back.getScene().getWindow();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("PlayEasy.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s1=new Scene(root);
        s.setScene(s1);
        s.show();
    }

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            b1.setText("Easy: "+LireEcrire.Lire(1));
            b2.setText("Normal: "+LireEcrire.Lire(2));
            b3.setText("Hard: "+LireEcrire.Lire(3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}