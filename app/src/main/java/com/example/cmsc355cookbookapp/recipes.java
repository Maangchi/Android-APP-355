package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class recipes extends AppCompatActivity {

    //references to buttons
    Button btn_add, btn_view, btn_viewRecipes;
    EditText et_recipe, et_ing1, et_ing2, et_ing3, et_ing1_amt, et_ing2_amt, et_ing3_amt, et_ing1_amtType, et_ing2_amtType, et_ing3_amtType;
    ListView lv_recipelist;
    ArrayAdapter recipeArrayAdapter;
    recipesDBHelper viewDBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_layout);

        btn_add = findViewById(R.id.btn_add);
        btn_view = findViewById(R.id.btn_view);

        //initialize variables
        et_recipe = findViewById(R.id.et_recipe);
        et_ing1 = findViewById(R.id.et_ing1);
        et_ing2 = findViewById(R.id.et_ing2);
        et_ing3 = findViewById(R.id.et_ing3);
        et_ing1_amt = findViewById(R.id.et_ing1_amt);
        et_ing2_amt = findViewById(R.id.et_ing2_amt);
        et_ing3_amt = findViewById(R.id.et_ing3_amt);
        et_ing1_amtType = findViewById(R.id.et_ing1_amtType);
        et_ing2_amtType = findViewById(R.id.et_ing2_amtType);
        et_ing3_amtType = findViewById(R.id.et_ing3_amtType);
        lv_recipelist = findViewById(R.id.lv_recipelist);

        //create dbhelper and pass context
        viewDBhelper = new recipesDBHelper(recipes.this);

        ShowRecipesOnListView(viewDBhelper);

        // button listeners for the add button
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recipes_class recipe_construct;

                try {
                    recipe_construct = new recipes_class(-1, et_recipe.getText().toString(), //
                            et_ing1.getText().toString(),Integer.parseInt(et_ing1_amt.getText().toString()),et_ing1_amtType.getText().toString(),//
                            et_ing2.getText().toString(),Integer.parseInt(et_ing2_amt.getText().toString()),et_ing2_amtType.getText().toString(),//
                            et_ing3.getText().toString(),Integer.parseInt(et_ing3_amt.getText().toString()),et_ing3_amtType.getText().toString());
                    //Toast.makeText(recipes.this, recipe_construct.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(recipes.this, "Error Creating Recipe", Toast.LENGTH_SHORT).show();
                    recipe_construct = new recipes_class(-1, "error",
                            "trash", 0, "trash",//
                            "trash", 0, "trash",//
                            "trash", 0, "trash");
                }
                recipesDBHelper rDBHelper = new recipesDBHelper(recipes.this);

                boolean success = rDBHelper.addOne(recipe_construct);

                Toast.makeText(recipes.this, "Success: "  + success, Toast.LENGTH_SHORT).show();
                ShowRecipesOnListView(viewDBhelper);
            }
        });

        //button listener for the view button
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipesDBHelper viewDBhelper = new recipesDBHelper(recipes.this);

                ShowRecipesOnListView(viewDBhelper);

                Toast.makeText(recipes.this, "Your Recipes are Amazing", Toast.LENGTH_SHORT).show();
            }
        });

        //new button listener for view button
        btn_viewRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(recipes.this, ViewRecipes.class);
                startActivity(i);
            }
        });

        lv_recipelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                recipes_class clickedRecipe = (recipes_class) adapterView.getItemAtPosition(i);
                viewDBhelper.deleteOne(clickedRecipe);
                ShowRecipesOnListView(viewDBhelper);
                Toast.makeText(recipes.this, "Deleted" + clickedRecipe.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ShowRecipesOnListView(recipesDBHelper viewDBhelper2) {
        recipeArrayAdapter = new ArrayAdapter<recipes_class>(recipes.this, android.R.layout.simple_list_item_1, viewDBhelper2.showRecipes());
        lv_recipelist.setAdapter(recipeArrayAdapter);
    }

}