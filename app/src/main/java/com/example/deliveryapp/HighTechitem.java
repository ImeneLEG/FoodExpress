package com.example.deliveryapp;

public class HighTechitem {

    //fileds:
    private String name;


    private boolean isSelected;

    private String mnemonic;
    //constructor:
    public HighTechitem(String name , String mnemonic ){
        this.name = name;

        this.mnemonic = mnemonic;

    }
    //methods

    public String getName(){return this.name;}


    public String  getMnemonic(){return this.mnemonic;}

}
