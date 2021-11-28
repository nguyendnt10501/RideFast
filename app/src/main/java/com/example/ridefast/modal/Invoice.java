package com.example.ridefast.modal;

import android.widget.ImageView;

public class Invoice {
    String name;
    String price;
    int mainProduct;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(int mainProduct) {
        this.mainProduct = mainProduct;
    }

    public Invoice(String name, String price, int mainProduct) {
        this.name = name;
        this.price = price;
        this.mainProduct = mainProduct;
    }
}
