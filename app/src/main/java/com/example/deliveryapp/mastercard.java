package com.example.deliveryapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class mastercard extends AppCompatActivity {

    private EditText cardNumberEditText;
    private EditText expireEndEditText;
    private EditText cvvEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mastercard);

        cvvEditText = findViewById(R.id.editTextName44);
        expireEndEditText = findViewById(R.id.editTextName33);
        cardNumberEditText = findViewById(R.id.editTextName22);
        submitButton = findViewById(R.id.submitBtn2);

        cardNumberEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String cardNumber = editable.toString().replaceAll("\\s", "");

                if (cardNumber.length() != 16) {
                    cardNumberEditText.setError("Card number must have 16 digits");
                } else {
                    cardNumberEditText.setError(null);
                }
            }
        });

        expireEndEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 5 || !editable.toString().contains("/")) {
                    expireEndEditText.setError("Invalid date format (use MM/YY)");
                } else {
                    expireEndEditText.setError(null);
                }
            }
        });

        cvvEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 3) {
                    cvvEditText.setError("CVV must have exactly 3 digits");
                } else {
                    cvvEditText.setError(null);
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tousLesChampsSontRemplis()) {
                    if (conditionsSontRemplies()) {
                        afficherMessagePaiementEffectue();
                    } else {
                        afficherMessageErreur("Please fill in all fields correctly.");
                    }
                } else {
                    afficherMessageErreur("Please fill in all fields before submitting.");
                }
            }
        });
    }

    private boolean tousLesChampsSontRemplis() {
        return !cardNumberEditText.getText().toString().isEmpty() &&
                !expireEndEditText.getText().toString().isEmpty() &&
                !cvvEditText.getText().toString().isEmpty();
    }

    private boolean conditionsSontRemplies() {
        return cardNumberEditText.getError() == null &&
                expireEndEditText.getError() == null &&
                cvvEditText.getError() == null;
    }

    private void afficherMessagePaiementEffectue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Payment successful")
                .setPositiveButton("OK", null)
                .create()
                .show();
    }


    private void afficherMessageErreur(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", null)
                .create()
                .show();
    }
}
