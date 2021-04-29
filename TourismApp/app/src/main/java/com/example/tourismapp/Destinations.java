package com.example.tourismapp;

public class Destinations {
    private int id,image;

    public Destinations(int id,int image) {
        this.image = image;
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
