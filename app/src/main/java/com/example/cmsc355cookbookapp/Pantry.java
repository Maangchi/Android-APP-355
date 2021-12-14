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

import com.example.cmsc355cookbookapp.CustomArrayAdapter.PantryListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pantry extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button add_btn_ing;
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



        items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Green Onions");
        items.add("Big Apples");
        items.add("Spaghetti Pasta");
        items.add("Ragù sauce");
        items.add("Eggs");
        items.add("Milk");
        items.add("Potato Chips");
        items.add("Fettuccine Pasta");
        items.add("Olive oil");
        items.add("Ramen");
        items.add("Rice");
        items.add("Salt");
        items.add("Pepper");
        items.add("Vinegar");
        items.add("Sugar");
        items.add("Soy sauce");
        items.add("Flour");
        items.add("Honey");
        items.add("Vegetable oil");
        items.add("Sriracha");
        items.add("Mayonnaise");
        items.add("Basil");
        items.add("Oregano");
        items.add("Tortillas");
        items.add("Paprika");
        items.add("Peanut Butter");
        items.add("Apple Cider");
        items.add("Cayenne Pepper");


        String[] Amount_types = getResources().getStringArray(R.array.amount_types);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.amount_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amount_type.setAdapter(adapter);
        amount_type.setOnItemSelectedListener(this);
        refreshList();


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeToast("Just removed: " + items.get(i) + "from the list");
                removeItem(i);
                return false;
            }
        });


        //Listeners
        add_btn_ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = input.getText().toString();
                if(text == null || text.length() == 0) {
                    makeToast("Enter an item you'd like to add: ");
                }else{
                    addItem(text);
                    input.setText("");
                    makeToast("Just added: " + text + "to the list");

                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void refreshList() {
        ingredientsDBHelper db = new ingredientsDBHelper( Pantry.this);
        List<Ingredients_class> all = db.getAll();
        if(all.size() > 0) {
            PantryListAdapter adapter = new PantryListAdapter(Pantry.this, all);
            ingrediate_list.setAdapter(adapter);
        }
        db.close();
    }
}