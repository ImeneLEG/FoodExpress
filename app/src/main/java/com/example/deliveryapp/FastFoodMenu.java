
package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deliveryapp.R;

import java.util.ArrayList;

public class FastFoodMenu extends AppCompatActivity {

    private ManagementCart cartManager;
    private TextView addBtn;
    private FoodDomain object;
    RecyclerView.Adapter adapter , adapter2 , adapter3 , adapter4 , adapter5;
    int numberOrder = 1;
    private RecyclerView recyclerViewPopularList , recyclerViewPopularList2 , recyclerViewPopularList3 , recyclerViewPopularList4  , recyclerViewPopularList5;
private ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);
        recyclerViewPopular();

        // Get a reference to the ImageView
        ImageView myImageView = findViewById(R.id.goToCardIcon);


        // Set a click listener for the ImageView
        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event, for example, navigate to CardListActivity
                Intent intent = new Intent(FastFoodMenu.this, cartListActivity.class);
                startActivity(intent);
            }
        });


    }

    private void recyclerViewPopular()
    {
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recycleview);
        recyclerViewPopularList.setLayoutManager(LinearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Burger","myburger","",30));
        foodList.add(new FoodDomain("Pizza", "mypizza3","",45));
        foodList.add(new FoodDomain("Hot-dog", "hotdog","",30));
        foodList.add(new FoodDomain("Tacos", "tacos","",40));
        foodList.add(new FoodDomain("Sandwich Submarine", "sandwich","",34));
        foodList.add(new FoodDomain("Nuggets de poulet ", "nuggets","",36));
        adapter = new RestaurantAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter);

        LinearLayoutManager LinearLayoutManager2 = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList2 = findViewById(R.id.recycleview2);
        recyclerViewPopularList2.setLayoutManager(LinearLayoutManager2);

        ArrayList<FoodDomain> foodList2 = new ArrayList<>();
        foodList2.add(new FoodDomain("Tortilla espagnole", "mytortilla2","",15));
        foodList2.add(new FoodDomain("Kebab", "kebab","",40));
        foodList2.add(new FoodDomain("Samosa", "mysamosa","",50));
        foodList2.add(new FoodDomain("Phở", "mypho","",25));
        foodList2.add(new FoodDomain("Pad thaï", "padthai","",24));
        foodList2.add(new FoodDomain("Gyros ", "gyros","",26));
        adapter2 = new RestaurantAdapter(foodList2);
        recyclerViewPopularList2.setAdapter(adapter2);

        LinearLayoutManager LinearLayoutManager3 = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList3 = findViewById(R.id.recycleview3);
        recyclerViewPopularList3.setLayoutManager(LinearLayoutManager3);

        ArrayList<FoodDomain> foodList3 = new ArrayList<>();
        foodList3.add(new FoodDomain("Ceviche", "myceviche2","",23));
        foodList3.add(new FoodDomain("Naan", "naan","",25));
        foodList3.add(new FoodDomain("Panini", "panini","",40));
        foodList3.add(new FoodDomain("Falafel", "shawarma2","",50));
        foodList3.add(new FoodDomain("Burrito", "myburrito","",32));
        foodList3.add(new FoodDomain("Poutine", "mypoutine","",33));
        adapter3 = new RestaurantAdapter(foodList3);
        recyclerViewPopularList3.setAdapter(adapter3);

        LinearLayoutManager LinearLayoutManager4 = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList4 = findViewById(R.id.recycleview4);
        recyclerViewPopularList4.setLayoutManager(LinearLayoutManager4);

        ArrayList<FoodDomain> foodList4 = new ArrayList<>();
        foodList4.add(new FoodDomain("Kebab", "kebab","",38));
        foodList4.add(new FoodDomain("Empanadas", "myempanada","",35));
        foodList4.add(new FoodDomain("Samosas", "mysamosa","",50));
        foodList4.add(new FoodDomain("Chili Cheese Fries", "chili","",36));
        foodList4.add(new FoodDomain("Doner", "doner","",50));
        foodList4.add(new FoodDomain("Crêpes salée", "crepes","",35));
        adapter4 = new RestaurantAdapter(foodList4);
        recyclerViewPopularList4.setAdapter(adapter4);

        LinearLayoutManager LinearLayoutManager5 = new LinearLayoutManager(this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList5 = findViewById(R.id.recycleview5);
        recyclerViewPopularList5.setLayoutManager(LinearLayoutManager5);

        ArrayList<FoodDomain> foodList5 = new ArrayList<>();
        foodList5.add(new FoodDomain("Baozi", "baozi","",32));
        foodList5.add(new FoodDomain("Arepas", "arepas2","",34));
        foodList5.add(new FoodDomain("Banh Mi", "banhmi","",45));
        foodList5.add(new FoodDomain("Shawarma", "shawarma","",51));
        foodList5.add(new FoodDomain("Dumples ", "dumpling","",39));
        foodList5.add(new FoodDomain("Bánh Xèo", "banhxeo","",20));
        adapter5 = new RestaurantAdapter(foodList5);
        recyclerViewPopularList5.setAdapter(adapter5);




    }
    public void addToCart(View view) {
        View parentLayout = (View) view.getParent(); // Récupère le parent de la vue (élément de la liste)
        TextView titleTextView = parentLayout.findViewById(R.id.title);
        TextView feeTextView = parentLayout.findViewById(R.id.fee);
        ImageView picImageView = parentLayout.findViewById(R.id.pic);

        String title = titleTextView.getText().toString();
        String feeString = feeTextView.getText().toString();
        String picPath = String.valueOf(picImageView.getTag());
        String description = ""; // Ajoutez votre logique pour obtenir la description

        Double fee;
        try {
            fee = Double.parseDouble(feeString);
        } catch (NumberFormatException e) {
            fee = 0.0;
        }

        FoodDomain foodItem = new FoodDomain(title, picPath, description, fee);

        // Ajouter l'article au panier
        cartManager = new ManagementCart(this);
        cartManager.insertFood(foodItem);

        // Passer les données à l'activité cartListActivity

        Intent intent = new Intent(this, cartListActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("picPath", picPath);
        intent.putExtra("description", description);
        intent.putExtra("fee", fee);


    }

}
