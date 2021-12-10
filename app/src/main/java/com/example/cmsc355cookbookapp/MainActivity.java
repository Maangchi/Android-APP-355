package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button ing_btn;
    Button shopping_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        shopping_btn = (Button)findViewById(R.id.shopping_btn);

        shopping_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShoppingPage();
            }
        });
        ing_btn = (Button)findViewById(R.id.ing_btn);
        ing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPantry();
            }
        });

    }

    public void openPantry() {
        Intent intent = new Intent(this, Pantry.class);
        startActivity(intent);
    }

    public void openShoppingPage() {
        Intent intent = new Intent(this, ShoppingPage.class);
        startActivity(intent);
    }
}