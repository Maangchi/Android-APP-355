package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private
    Button ing_btn = findViewById(R.id.ing_btn);
    Button shopping_btn = findViewById(R.id.Shopping_btn);
    Button ing_btn_press = findViewById(R.id.ing_btn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openingredients_page();
            }
        });
        shopping_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openshopping_page();
            }
        });
    }

    public void openingredients_page() {
        Intent intent = new Intent(this, ingredientsPage.class);
        startActivity(intent);
    }
    public void openshopping_page() {
        Intent intent = new Intent(this, ShoppingPage.class);
        startActivity(intent);
    }






}