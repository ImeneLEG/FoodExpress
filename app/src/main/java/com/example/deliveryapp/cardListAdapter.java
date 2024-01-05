package com.example.deliveryapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import card.list.adapter.ChangeNumberItemListener;

public class cardListAdapter extends RecyclerView.Adapter<cardListAdapter.ViewHolder>{

    private ArrayList<FoodDomain> foodDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemListener changeNumberItemsListener;

    public cardListAdapter(ArrayList<FoodDomain> foodDomains , Context context, ChangeNumberItemListener changeNumberItemsListener ){

        this.foodDomains = foodDomains;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return  new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull cardListAdapter.ViewHolder holder , @SuppressLint("RecyclerView") int position) {
        holder.title.setText(foodDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(foodDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((foodDomains.get(position).getNumberInCart()* foodDomains.get(position).getFee())*100)/100));
        holder.num.setText(String.valueOf(foodDomains.get(position).getNumberInCart()));

        String picName = foodDomains.get(position).getPic();

        // Obtenez l'ID de la ressource Drawable à partir de son nom
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(
                picName, "drawable", holder.itemView.getContext().getPackageName());

        // Utilisez Glide pour charger l'image dans votre ImageView
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        // Définissez le chemin de l'image en tant que tag pour l'ImageView
        holder.pic.setTag(picName);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    managementCart.plusNumberFood(foodDomains, adapterPosition, new ChangeNumberItemListener() {
                        @Override
                        public void changed() {
                            notifyDataSetChanged();
                            changeNumberItemsListener.changed();
                        }
                    });
                }
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                managementCart.minusNumberFood(foodDomains,position,new ChangeNumberItemListener(){
                    @Override
                    public void changed(){
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return  foodDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title , feeEachItem;
        ImageView pic , plusItem , minusItem;
        TextView totalEachItem , num;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.title);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.cartImage);
            totalEachItem= itemView.findViewById(R.id.totalEachItem);
            num =itemView.findViewById(R.id.quantituTxt);
            plusItem = itemView.findViewById(R.id.addImage);
            minusItem=itemView.findViewById(R.id.minusImage);

        }

    }




}
