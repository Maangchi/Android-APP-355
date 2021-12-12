package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewRecipes extends AppCompatActivity {

    private ArrayList<recipes_class> recipesArrayList;
    private recipesDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipes);

        //initializing variables
        recipesArrayList = new ArrayList<>();
        dbHelper = new recipesDBHelper(ViewRecipes.this);

        //getting recipe array list from dbhelper
        recipesArrayList = dbHelper.showRecipes();





    }
}