package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    EditText input;
    ImageView enter;
    private
    Button ing_btn = findViewById(R.id.ing_btn);
    Button shopping_btn = findViewById(R.id.Shopping_btn);
    Button ing_btn_press = findViewById(R.id.ing_btn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);

        items = new ArrayList<>();
        items.add("Onions");
        items.add("Lettuce");
        items.add("Bread");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = items.get(i);
                makeToast(name);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeToast("Long press: " + items.get(i));
                return false;
            }
        });

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if (text == null || text.length() == 0) {
                    makeToast("Enter an item. ");
                } else {
                    addItem(text);
                    input.setText("");
                    makeToast("Added: " + text);
                }
            }
        });

        public void addItem(String item){
            items.add(item);
            adapter.notifyDataSetChanged();

        }




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
    Toast t;
    private void makeToast(String s) {
        if(t !=null) t.cancel();
        t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        t.show();


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