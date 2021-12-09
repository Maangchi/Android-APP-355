package com.example.cmsc355cookbookapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Pantry extends AppCompatActivity {
    Button add_btn_ing;
    EditText Item_Amount, input_name, amount_type;
    ListView ingrediate_list;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry_layout);

        add_btn_ing = findViewById(R.id.add_btn_ing );
        Item_Amount = findViewById(R.id.Item_Amount);
        input_name = findViewById(R.id.input_name);
        amount_type = findViewById(R.id.amount_type);
        ingrediate_list = findViewById(R.id.ingrediate_list);

        //Listeners
        add_btn_ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingredients_class ingredientModel = new Ingredients_class(-1, input_name.getText().toString(), Integer.parseInt(Item_Amount.getText().toString()), amount_type.getText().toString(), false);
                Toast.makeText(Pantry.this, ingredientModel.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}