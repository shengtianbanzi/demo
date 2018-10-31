package com.nyfz.httpdemo;

/**
 * Created by zhangliang on 2017-9-4.
 */

public class Serviceitem {
    private String name;
    private String price;
    private String photo;


    public  Serviceitem()
    {

    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {

        return photo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
