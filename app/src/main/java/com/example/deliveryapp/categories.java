package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        View logoutIcon = findViewById(R.id.logoutIcon);

        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogout();
            }
        });

        //List of items:
        List<HighTechitem> hightTechItemList = new ArrayList<>();

        hightTechItemList.add(new HighTechitem("Fast Food", "fastfood"));
        hightTechItemList.add(new HighTechitem("Traditional", "traditional"));
        hightTechItemList.add(new HighTechitem("Sushi", "souchi"));


        //get List view:

        ListView shopListView = findViewById(R.id.shop_list_view);
        shopListView.setAdapter(new HightTechItemAdapter(this, hightTechItemList));


        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //Clicked fast food
                    startActivity(new Intent(categories.this,FastFoodMenu.class));
                } else if (position == 1) {

                    //clicked traditional
                    startActivity(new Intent(categories.this, TraditionalMenu.class));

                } else {
                    //cliked sushi
                    startActivity(new Intent(categories.this, SuchiFoodMenu.class));
                }
            }
        });
    }

    public void performLogout() {
        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent homeIntent = new Intent(categories.this, HomePage.class);
        startActivity(homeIntent);


        finish();
    }
}