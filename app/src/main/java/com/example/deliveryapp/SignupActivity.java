package com.example.deliveryapp;


import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.deliveryapp.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper= new DatabaseHelper(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String email= binding.signupEmail.getText().toString();
                String password= binding.signupPassword.getText().toString();
                String confirmPassword= binding.signupConfirm.getText().toString();

                if(email.equals("")|| password.equals("")|| confirmPassword.equals(""))
                    Toast.makeText(SignupActivity.this,"All fields are mandatory",Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(confirmPassword)){
                        Boolean checkUserEmail= databaseHelper.checkEmail(email);
                        if (checkUserEmail ==false){
                            Boolean insert=databaseHelper.insertData(email,password);
                            if(insert==true){
                                Toast.makeText(SignupActivity.this,"Signup Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignupActivity.this,"Signup Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(SignupActivity.this,"User already esists, please login", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignupActivity.this,"Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });


    }
}