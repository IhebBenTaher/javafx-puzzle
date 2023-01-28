package com.example.jeux;

import javafx.scene.image.Image;

public class Case {
    private Image i;
    private int org;
    private int act;
    private int max;
    public int getOrg() {
        return org;
    }
    public Case(Image s, int a, int b) {
        i=s;
        org=a;
        max=b;
        act=0;
    }
    public void setAct(int a){
        act=a;
    }
    public Image geti(){
        return i;
    }
}
