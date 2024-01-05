package com.example.deliveryapp;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

import card.list.adapter.ChangeNumberItemListener;

public class ManagementCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFood = getListCart();
        boolean exist = false;

        for (FoodDomain food : listFood) {
            if (food.getTitle().equals(item.getTitle())) {
                exist = true;
                food.setNumberInCart(food.getNumberInCart() + 1);
                break;
            }
        }

        if (!exist) {
            item.setNumberInCart(1); // Si l'article n'est pas déjà dans le panier, on en ajoute un
            listFood.add(item);
        }

        tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
    }


    public ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }




    public void plusNumberFood(ArrayList<FoodDomain> listFood , int position ,  ChangeNumberItemListener changeNumberItemsListener ) {
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<FoodDomain> listFood , int position ,  ChangeNumberItemListener changeNumberItemsListener ) {
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }
        else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() - 1);

        }
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> listFood = getListCart();
        double fee = 0;
        for (int i = 0 ; i<listFood.size();i++){
            fee =  fee + (listFood.get(i).getFee() * listFood.get(i).getNumberInCart());
        }
        return fee;
    }

}