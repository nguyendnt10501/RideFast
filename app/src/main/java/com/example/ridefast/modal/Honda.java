package com.example.ridefast.modal;

public class Honda {
    public Honda() {
    }

    String background;
    String name;
    String category;
    Float price;

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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

    public Honda(String background, String name, String category, Float price) {
        this.background = background;
        this.name = name;
        this.category = category;
        this.price = price;
    }



}
