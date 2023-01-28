package com.example.jeux;


import javafx.scene.image.ImageView;

public class Case2 {
    private ImageView i;
    private int org;
    public Case2(ImageView s, int a) {
        i=s;
        org=a;
    }
    public int getOrg() {
        return org;
    }
    public void setOrg(int org) {
        this.org = org;
    }
    public ImageView getI() {
        return i;
    }
}
