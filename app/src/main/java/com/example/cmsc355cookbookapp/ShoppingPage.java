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


        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = items.get(i);
                makeToast(name);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeToast("Just removed: " + items.get(i) + "from the list!");
                removeItem(i);
                return false;
            }
        });

        refreshShopList();

        //Listeners
        add_btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = input.getText().toString();
                if(text == null || text.length() == 0) {
                    makeToast("Enter an item you'd like to add to the cart: ");
                }else{
                    addItem(text);
                    input.setText("");
                    makeToast("Just added: " + text + "to the cart!");

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