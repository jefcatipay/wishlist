package com.example.jefkrisfercatipay.wishlist;

/**
 * Created by Jef Krisfer Catipay on 10/10/2017.
 */

public class list_model {

    private String listName;
    private String listDesc;
    private String listPrice;
    private int image;

    public list_model(){

    }

    public list_model(String listname, String listDesc, String listPrice, int image){
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

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
