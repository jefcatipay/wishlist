package com.example.jefkrisfercatipay.wishlist;

import java.io.Serializable;

/**
 * Created by Jef Krisfer Catipay on 10/10/2017.
 */

public class wish implements Serializable {

    private String listName;
    private String listDesc;
    private double listPrice;
    private int image;

    public wish(){

    }

    public wish(String listname, String listDesc, double listPrice, int image){
        this.listDesc = listDesc;
        this.listName = listname;
        this.listPrice = listPrice;
        this.image = image;

    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListDesc() {
        return listDesc;
    }

    public void setListDesc(String listDesc) {
        this.listDesc = listDesc;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
