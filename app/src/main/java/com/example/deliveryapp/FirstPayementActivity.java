package com.example.deliveryapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class FirstPayementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement);
        // Renommez la référence du bouton à "paypalbtn"
        Button paypalBtn = findViewById(R.id.paypalBtn);

        paypalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lorsque le bouton est cliqué, naviguez vers une nouvelle activité
                Intent intent = new Intent(FirstPayementActivity.this, paypalform.class);
                startActivity(intent);
            }


        });

        Button masterCardBtn = findViewById(R.id.masterCardBtn);

        masterCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lorsque le bouton est cliqué, naviguez vers une nouvelle activité
                Intent intent = new Intent(FirstPayementActivity.this, mastercard.class);
                startActivity(intent);
            }


        });

    }
}

