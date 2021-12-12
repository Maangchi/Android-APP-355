package com.example.cmsc355cookbookapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cmsc355cookbookapp.CustomArrayAdapter.PantryListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingPage extends AppCompatActivity{
    Button add_btn_shop;
    EditText shop_input_name;
    ListView shop_ingrediate_list;
    TextView shop_text_header;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_page);

        shop_text_header = findViewById(R.id.shop_text_header);
        add_btn_shop = findViewById(R.id.add_btn_shop );
        shop_input_name = findViewById(R.id.shop_input_name);
        shop_ingrediate_list = findViewById(R.id.shop_ingrediate_list);

        refreshShopList();

        //Listeners
        add_btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ingredients_class ingredient;
                ingredientsDBHelper dbHelper = new ingredientsDBHelper(ShoppingPage.this);

                if((!shop_input_name.getText().toString().equals(""))) {
                    ingredient = new Ingredients_class(-1, shop_input_name.getText().toString(), 0," ", false);
                    boolean success = dbHelper.addOne(ingredient);
                    refreshShopList();
                    Toast.makeText(ShoppingPage.this, shop_input_name.getText().toString()+" Added to the Shopping", Toast.LENGTH_SHORT ).show();
                }
                else {
                    Toast.makeText(ShoppingPage.this, "Missing Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void refreshShopList() {
        ingredientsDBHelper db = new ingredientsDBHelper( ShoppingPage.this);
        List<Ingredients_class> all = db.getAllEmpty();
        Log.d("DEBUG", "refreshShopList: " + all.toString());
        if(all.size() > 0) {
            PantryListAdapter adapter = new PantryListAdapter(ShoppingPage.this, all);
            shop_ingrediate_list.setAdapter(adapter);
        }
        else{
            Log.d("DEBUG", "refreshShopList: Made it though the list create flow");
        }
        db.close();
    }

}