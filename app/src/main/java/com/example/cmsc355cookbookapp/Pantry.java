package com.example.cmsc355cookbookapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pantry extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button add_btn_ing, View_btn;
    EditText Item_Amount, input_name;
    ListView ingrediate_list;
    TextView text_header;
    Spinner amount_type;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry_layout);
        text_header = findViewById(R.id.text_header);
        add_btn_ing = findViewById(R.id.add_btn_ing );
        Item_Amount = findViewById(R.id.Item_Amount);
        input_name = findViewById(R.id.input_name);
        ingrediate_list = findViewById(R.id.ingrediate_list);
        View_btn = findViewById(R.id.View_btn);


        amount_type = findViewById(R.id.amount_type);

        String[] Amount_types = getResources().getStringArray(R.array.amount_types);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.amount_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amount_type.setAdapter(adapter);
        amount_type.setOnItemSelectedListener(this);

        //Listeners
        add_btn_ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingredients_class ingredient;
                ingredientsDBHelper dbHelper = new ingredientsDBHelper(Pantry.this);

                if((!input_name.getText().toString().equals("")) && (!amount_type.getSelectedItem().toString().equals("")) && (!Item_Amount.getText().toString().equals("")) ) {
                    ingredient = new Ingredients_class(-1, input_name.getText().toString(), Integer.parseInt(Item_Amount.getText().toString()), amount_type.getSelectedItem().toString(), false);
                    boolean success = dbHelper.addOne(ingredient);
                }
                else {
                    Toast.makeText(Pantry.this, "Missing Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        View_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientsDBHelper db = new ingredientsDBHelper( Pantry.this);
                List<Ingredients_class> all = db.getAll();

                ArrayAdapter adapter = new ArrayAdapter<Ingredients_class>(Pantry.this, android.R.layout.simple_list_item_1, all);
                ingrediate_list.setAdapter(adapter);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}