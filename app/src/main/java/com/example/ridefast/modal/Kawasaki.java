package com.example.ridefast.modal;

import java.io.Serializable;

public class Kawasaki implements Serializable {

    String image;
    String name;
    String category;
    Float price;

    public Kawasaki() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Kawasaki(String image, String name, String category, Float price) {
        this.image = image;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
