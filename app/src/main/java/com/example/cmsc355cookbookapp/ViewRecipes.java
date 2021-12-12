package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewRecipes extends AppCompatActivity {

    private ArrayList<recipes_class> recipesArrayList;
    private recipesDBHelper dbHelper;
    private RecipeRVAdapter RecipeRVAdapter;
    private RecyclerView recipesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipes);

        //initializing variables
        recipesArrayList = new ArrayList<>();
        dbHelper = new recipesDBHelper(ViewRecipes.this);

        //getting recipe array list from dbhelper
        recipesArrayList = dbHelper.showRecipes();

        //passing our array lost to our adapter class.
        RecipeRVAdapter = new RecipeRVAdapter(recipesArrayList, ViewRecipes.this);
        recipesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewRecipes.this, RecyclerView.VERTICAL, false);
        recipesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recipesRV.setAdapter(RecipeRVAdapter);





    }
}