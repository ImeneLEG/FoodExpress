package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import card.list.adapter.ChangeNumberItemListener;

public class cartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recycleViewList;
    private ManagementCart managementCart;


    TextView totalTxtItems , taxTxt , deliveryTxt , totalTxt , emptyTxt , checkout;

    private double tax;
    private ScrollView scrollView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);



        initView();
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event, for example, navigate to CardListActivity
                Intent intent = new Intent(cartListActivity.this, FirstPayementActivity.class);
                startActivity(intent);
            }
        });
        initList();
        CalculateCart();






    }



    private void initView(){
        recycleViewList = findViewById(R.id.cartView);
        totalTxtItems = findViewById(R.id.TotalPriceItems);
        taxTxt=findViewById(R.id.TaxPrice);
        deliveryTxt=findViewById(R.id.DeliveryPrice);
        totalTxt =findViewById(R.id.TotalPrice);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView);
        recycleViewList = findViewById(R.id.cartView);
        checkout = findViewById(R.id.checkout);

    }
    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycleViewList.setLayoutManager(linearLayoutManager);
        adapter = new cardListAdapter(managementCart.getListCart(),this, new ChangeNumberItemListener(){
            @Override
            public void changed(){
                CalculateCart();
            }
        }) ;

        recycleViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);

        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }
    private void CalculateCart(){
        double percentTax = 0.02;
        double delivery =10;

        tax = Math.round((managementCart.getTotalFee() * percentTax)*100)/100;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery)*100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee() *100)/100;

        totalTxtItems.setText(  itemTotal+"dh");
        deliveryTxt.setText(delivery+"dh");
        taxTxt.setText(tax+"dh");
        totalTxt.setText(total+"dh");
    }


}