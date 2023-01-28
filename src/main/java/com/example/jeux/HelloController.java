package com.example.jeux;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
        @FXML
        private Button b1;
        @FXML
        private Button b2;
        @FXML
        private Button b3;
        @FXML
        void hover(MouseEvent event) {
            modif((Button)event.getSource());
        }
        @FXML
        void dishover(MouseEvent event) {
           modif2((Button)event.getSource());
         }
        void modif(Button b){
            b.setStyle("-fx-background-color: #00a83b;-fx-text-fill:purple;-fx-border-width:5;-fx-border-color:purple;-fx-border-radius:30;-fx-background-radius:40;");
        }
        void modif2(Button b){
            b.setStyle("-fx-background-color: purple;-fx-text-fill:#00a83b;-fx-border-width:5;-fx-border-color:#00a83b;-fx-border-radius:30;-fx-background-radius:40;");
        }
        @FXML
        void nave(ActionEvent event) {
            Stage s=(Stage)b1.getScene().getWindow();
            Parent root= null;
            try {
                root = FXMLLoader.load(getClass().getResource("easy.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene s1=new Scene(root);
            s.setScene(s1);
            s.show();
            Naviguer.setN(1);
       }
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
       void navn(ActionEvent event) {
           Stage s=(Stage)b2.getScene().getWindow();
           Parent root= null;
           try {
               root = FXMLLoader.load(getClass().getResource("normal.fxml"));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           Scene s1=new Scene(root);
           s.setScene(s1);
           s.show();
           Naviguer.setN(2);
       }
        @FXML
        void navh(ActionEvent event) {
            Stage s=(Stage)b3.getScene().getWindow();
            Parent root= null;
            try {
                root = FXMLLoader.load(getClass().getResource("hard.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene s1=new Scene(root);
            s.setScene(s1);
            s.show();
            Naviguer.setN(3);
        }
}