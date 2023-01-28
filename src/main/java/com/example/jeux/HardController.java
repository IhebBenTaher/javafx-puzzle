package com.example.jeux;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HardController implements Initializable {
    @FXML
    private Label back;
    @FXML
    void hover(MouseEvent event){
        back.setStyle("-fx-background-color: #00a83b;");
    }
    @FXML
    void dishover(MouseEvent event){
        back.setStyle("-fx-background-color: purple;-fx-background-radius:40");
    }
    @FXML
    void back(MouseEvent event){
        Stage s=(Stage)back.getScene().getWindow();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s1=new Scene(root);
        s.setScene(s1);
        s.show();
    }
    ArrayList<Case2>eListiv=new ArrayList<>();
    private int nb=0;
    @FXML
    private ImageView i1=new ImageView();
    @FXML
    private ImageView i2=new ImageView();
    @FXML
    private ImageView i3=new ImageView();
    @FXML
    private ImageView i4=new ImageView();
    @FXML
    private ImageView i5=new ImageView();
    @FXML
    private ImageView i6=new ImageView();
    @FXML
    private ImageView i7=new ImageView();
    @FXML
    private ImageView i8=new ImageView();
    @FXML
    private ImageView i10=new ImageView();
    @FXML
    private ImageView i9=new ImageView();
    @FXML
    private ImageView i11=new ImageView();
    @FXML
    private ImageView i12=new ImageView();
    @FXML
    private ImageView i13=new ImageView();
    @FXML
    private ImageView i14=new ImageView();
    @FXML
    private ImageView i15=new ImageView();
    @FXML
    private ImageView i16=new ImageView();
    @FXML
    private ImageView i17=new ImageView();
    @FXML
    private ImageView i18=new ImageView();
    @FXML
    private ImageView i20=new ImageView();
    @FXML
    private ImageView i19=new ImageView();
    @FXML
    private ImageView i21=new ImageView();
    @FXML
    private ImageView i22=new ImageView();
    @FXML
    private ImageView i23=new ImageView();
    @FXML
    private ImageView i24=new ImageView();
    @FXML
    private ImageView i25;
    @FXML
    private Label count;
    private boolean test(){
        for(int i=0;i<eListiv.size();i++)
            if(i!=eListiv.get(i).getOrg()-1)
                return false;
        return true;
    }
    private void showFinal(){
        Stage st=(Stage)count.getScene().getWindow();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("final.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene s1=new Scene(root);
        st.setScene(s1);
        st.show();
    }
    @FXML
    void move(MouseEvent event) {
        ImageView iv=(ImageView)event.getSource();
        int i=0;
        while(i<25 && eListiv.get(i).getI()!=iv)
            i++;
        if(i<20 && eListiv.get(i+5).getI()==i25){
            count.setText("Moves: "+(++nb));
            TranslateTransition t1=new TranslateTransition();
            t1.setByY(-60);
            t1.setDuration(Duration.millis(200));
            t1.setNode(eListiv.get(i+5).getI());
            t1.play();
            TranslateTransition t2=new TranslateTransition();
            t2.setByY(60);
            t2.setDuration(Duration.millis(200));
            t2.setNode(eListiv.get(i).getI());
            t2.play();
            Case2 k=eListiv.get(i+5);
            eListiv.set(i+5,eListiv.get(i));
            eListiv.set(i,k);
            if(test()){
                try {
                    eListiv.get(24).getI().setImage(new Image(getClass().getResource("25.png").toURI().toString()));
                    eListiv.get(24).getI().setOpacity(0);
                    FadeTransition ft=new FadeTransition();
                    ft.setDelay(Duration.millis(200));
                    ft.setDuration(Duration.millis(500));
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.setNode(eListiv.get(24).getI());
                    ft.play();
                    Naviguer.setScore(nb);
                    new Thread(()->{
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Platform.runLater(()->{
                            showFinal();
                        });
                    }).start();
                }catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else{
            if(i>4 && eListiv.get(i-5).getI()==i25){
                count.setText("Moves: "+(++nb));
                TranslateTransition t1=new TranslateTransition();
                t1.setByY(60);
                t1.setDuration(Duration.millis(200));
                t1.setNode(eListiv.get(i-5).getI());
                t1.play();
                TranslateTransition t2=new TranslateTransition();
                t2.setByY(-60);
                t2.setDuration(Duration.millis(200));
                t2.setNode(eListiv.get(i).getI());
                t2.play();
                Case2 k=eListiv.get(i-5);
                eListiv.set(i-5,eListiv.get(i));
                eListiv.set(i,k);
                if(test()){
                    try {
                        eListiv.get(24).getI().setImage(new Image(getClass().getResource("25.png").toURI().toString()));
                        FadeTransition ft=new FadeTransition();
                        eListiv.get(24).getI().setOpacity(0);
                        ft.setDelay(Duration.millis(200));
                        ft.setDuration(Duration.millis(500));
                        ft.setFromValue(0);
                        ft.setToValue(1);
                        ft.setNode(eListiv.get(24).getI());
                        ft.play();
                        Naviguer.setScore(nb);
                        new Thread(()->{
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            Platform.runLater(()->{
                                showFinal();
                            });
                        }).start();
                    }catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else{
                if((i%5==1 || i%5==2 || i%5==3 || i%5==4) && eListiv.get(i-1).getI()==i25){
                    count.setText("Moves: "+(++nb));
                    TranslateTransition t1=new TranslateTransition();
                    t1.setByX(60);
                    t1.setDuration(Duration.millis(200));
                    t1.setNode(eListiv.get(i-1).getI());
                    t1.play();
                    TranslateTransition t2=new TranslateTransition();
                    t2.setByX(-60);
                    t2.setDuration(Duration.millis(200));
                    t2.setNode(eListiv.get(i).getI());
                    t2.play();
                    Case2 k=eListiv.get(i-1);
                    eListiv.set(i-1,eListiv.get(i));
                    eListiv.set(i,k);
                    if(test()){
                        try {
                            eListiv.get(24).getI().setImage(new Image(getClass().getResource("25.png").toURI().toString()));
                            FadeTransition ft=new FadeTransition();
                            ft.setDelay(Duration.millis(200));
                            eListiv.get(24).getI().setOpacity(0);
                            ft.setDuration(Duration.millis(500));
                            ft.setFromValue(0);
                            ft.setToValue(1);
                            ft.setNode(eListiv.get(24).getI());
                            ft.play();
                            Naviguer.setScore(nb);
                            new Thread(()->{
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Platform.runLater(()->{
                                    showFinal();
                                });
                            }).start();
                        }catch (URISyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else{
                    if((i%5==0 || i%5==1 || i%5==2 || i%5==3) && eListiv.get(i+1).getI()==i25){
                        count.setText("Moves: "+(++nb));
                        TranslateTransition t1=new TranslateTransition();
                        t1.setByX(-60);
                        t1.setDuration(Duration.millis(200));
                        t1.setNode(eListiv.get(i+1).getI());
                        t1.play();
                        TranslateTransition t2=new TranslateTransition();
                        t2.setByX(60);
                        t2.setDuration(Duration.millis(200));
                        t2.setNode(eListiv.get(i).getI());
                        t2.play();
                        Case2 k=eListiv.get(i+1);
                        eListiv.set(i+1,eListiv.get(i));
                        eListiv.set(i,k);
                        if(test()){
                            try {
                                eListiv.get(24).getI().setImage(new Image(getClass().getResource("25.png").toURI().toString()));
                                FadeTransition ft=new FadeTransition();
                                eListiv.get(24).getI().setOpacity(0);
                                ft.setDuration(Duration.millis(500));
                                ft.setDelay(Duration.millis(200));
                                ft.setFromValue(0);
                                ft.setToValue(1);
                                ft.setNode(eListiv.get(24).getI());
                                ft.play();
                                Naviguer.setScore(nb);
                                new Thread(()->{
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    Platform.runLater(()->{
                                        showFinal();
                                    });
                                }).start();
                            }catch (URISyntaxException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Case>easyList=new ArrayList<>();
        eListiv.add(new Case2(i1,0));eListiv.add(new Case2(i2,0));eListiv.add(new Case2(i3,0));eListiv.add(new Case2(i4,0));eListiv.add(new Case2(i5,0));eListiv.add(new Case2(i6,0));eListiv.add(new Case2(i7,0));eListiv.add(new Case2(i8,0));eListiv.add(new Case2(i9,0));eListiv.add(new Case2(i10,0));eListiv.add(new Case2(i11,0));eListiv.add(new Case2(i12,0));eListiv.add(new Case2(i13,0));eListiv.add(new Case2(i14,0));eListiv.add(new Case2(i15,0));eListiv.add(new Case2(i16,0));eListiv.add(new Case2(i17,0));eListiv.add(new Case2(i18,0));eListiv.add(new Case2(i19,0));eListiv.add(new Case2(i20,0));eListiv.add(new Case2(i21,0));eListiv.add(new Case2(i22,0));eListiv.add(new Case2(i23,0));eListiv.add(new Case2(i24,0));eListiv.add(new Case2(i25,25));
        int l[]=new int[24];
        for(int i=0;i<24;i++){
            l[i]=i+1;
        }
        for(int i=0;i<24;i++) {
            try {
                easyList.add(new Case(new Image(getClass().getResource((i + 1) + "h.png").toURI().toString()), i + 1, 5));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        int y=0;
        for(int i=0;i<24;i++) {
            int x = (int) Math.floor(Math.random() * easyList.size());
            eListiv.get(i).setOrg(easyList.get(x).getOrg());
            eListiv.get(i).getI().setImage(easyList.get(x).geti());
            eListiv.get(i).getI().setFitWidth(60);eListiv.get(i).getI().setFitHeight(60);
            eListiv.get(i).getI().setOpacity(0);
            ScaleTransition st=new ScaleTransition();
            st.setDuration(Duration.millis(200));
            st.setByX(-2);
            st.setDelay(Duration.millis(y+=100));
            st.setByY(-2);
            st.setNode(eListiv.get(i).getI());
            st.play();
            FadeTransition fd=new FadeTransition();
            fd.setDuration(Duration.millis(200));
            fd.setFromValue(0);
            fd.setToValue(1);
            fd.setDelay(Duration.millis(y));
            fd.setNode(eListiv.get(i).getI());
            fd.play();
            easyList.remove(x);
        }
    }
}
