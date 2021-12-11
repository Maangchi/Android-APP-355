package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class recipes extends AppCompatActivity {

    //references to buttons
    Button btn_add, btn_viewall;
    EditText et_recipe, et_ing1, et_ing2, et_ing3, et_ing1_amt, et_ing2_amt, et_ing3_amt, et_ing1_amtType, et_ing2_amtType, et_ing3_amtType;
    ListView lv_recipelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_layout);

        btn_add = findViewById(R.id.btn_add);
        btn_viewall = findViewById(R.id.btn_viewall);
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

        // button listeners for the add and view all buttons
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
            }
        });

        btn_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recipesDBHelper viewDBhelper = new recipesDBHelper(recipes.this);
                List<recipes_class> myRecipes = viewDBhelper.showRecipes();

                Toast.makeText(recipes.this, myRecipes.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}