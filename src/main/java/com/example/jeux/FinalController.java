package com.example.jeux;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinalController implements Initializable {
    @FXML
    private Label l;
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
            root = FXMLLoader.load(getClass().getResource("PlayEasy.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s1=new Scene(root);
        s.setScene(s1);
        s.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String s="Congratulations!\n";
        try {
            if(Integer.parseInt(LireEcrire.Lire(Naviguer.getN()))==0 || Integer.parseInt(LireEcrire.Lire(Naviguer.getN()))>Naviguer.getScore()){
                s+="New Record: "+Naviguer.getScore();
                LireEcrire.Ecrire(Naviguer.getScore()+"",Naviguer.getN());
            }
            else{
                s+="Your Score: "+Naviguer.getScore();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l.setText(s);
    }
}
