package com.example.deliveryapp;

import static androidx.recyclerview.widget.RecyclerView.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

ArrayList<FoodDomain> FoodDomains;

public RestaurantAdapter(ArrayList<FoodDomain> FoodDomains)
{
this.FoodDomains = FoodDomains;
}

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        holder.title.setText(FoodDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(FoodDomains.get(position).getFee()));

        String picName = FoodDomains.get(position).getPic();

        // Obtenez l'ID de la ressource Drawable à partir de son nom
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(
                picName, "drawable", holder.itemView.getContext().getPackageName());

        // Utilisez Glide pour charger l'image dans votre ImageView
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        // Définissez le chemin de l'image en tant que tag pour l'ImageView
        holder.pic.setTag(picName);


    }




    @Override
    public int getItemCount() {
        return FoodDomains.size();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder
    {

        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);

        }


    }

}
