package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button ing_btn;
    Button shopping_btn;
    Button recipe_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopping_btn = (Button)findViewById(R.id.shopping_btn);
        ing_btn = (Button)findViewById(R.id.ing_btn);
        recipe_btn = (Button)findViewById(R.id.recipe_btn);

        shopping_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShoppingPage();
            }
        });

        recipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipes();
            }
        });

        ing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPantry();
            }
        });

        recipe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipes();
            }
        });
    }

    public void openPantry() {
        Toast.makeText(MainActivity.this, "Opening Pantry!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Pantry.class);
        startActivity(intent);
    }

    public void openRecipes() {
        Toast.makeText(MainActivity.this, "Opening Recipe Book!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, recipes.class);
        startActivity(intent);
    }

    public void openShoppingPage() {
        Toast.makeText(MainActivity.this, "Shopping Time!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShoppingPage.class);
        startActivity(intent);
    }

}