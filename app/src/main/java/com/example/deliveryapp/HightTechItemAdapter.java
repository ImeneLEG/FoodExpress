package com.example.deliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HightTechItemAdapter extends BaseAdapter {

    //fields
    private Context context;
    private List<HighTechitem> hightTechItemList;

    private LayoutInflater inflater;

    //constructor:
    public HightTechItemAdapter(Context context , List<HighTechitem> hightTechItemList){
        this.context = context;
        this.hightTechItemList = hightTechItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return hightTechItemList.size();
    }

    @Override
    public HighTechitem getItem(int position) {
        return hightTechItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view = inflater.inflate(R.layout.adapter_item,null);


       HighTechitem currentItem = getItem(i);
       String itemName = currentItem.getName();
       String mnemonic = currentItem.getMnemonic();


        //get item image view

        ImageView itemIconView = view.findViewById(R.id.item_icon);
        String resourceName = "item_"+mnemonic+"_icon";
        int resId = context.getResources().getIdentifier(resourceName,"drawable",context.getPackageName());
        itemIconView.setImageResource(resId);



         //get item name view
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);


       return view;
    }
}
