package com.example.deliveryapp;

import java.io.Serializable;

public class FoodDomain {
    private String title;
    private String pic;
    private String description;
    private Double fee;
    private int numberInCart;

    public FoodDomain(String title , String pic,String description , double fee)
    {
        this.description=description;
        this.fee = fee;
        this.pic = pic;
        this.title = title;
    }

    public FoodDomain(String title) {
        this.title = title;
    }

    public FoodDomain(String title , String pic, String description , double fee , int numberInCart)
    {
        this.description=description;
        this.fee = fee;
        this.pic = pic;
        this.title = title;
        this.numberInCart = numberInCart;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getTitle()
    {
        return  title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
}
