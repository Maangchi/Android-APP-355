package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/*public class ShoppingPage extends AppCompatActivity {

    private
    Button shopping_btn = findViewById(R.id.Shopping_btn);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_page);

    }*/

public class ShoppingPage<listView> {
    ListView listView;
    ArrayList<String> items;
}
