package com.example.cmsc355cookbookapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public final class PantryDB {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private PantryDB() {}

    /* Inner class that defines the table contents */
    public static class Ingredient implements BaseColumns {
        public static final String TABLE_NAME = "ingr";
        public static final String COLUMN_NAME = "name";
    }


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Ingredient.TABLE_NAME + " (" +
                    Ingredient._ID + " INTEGER PRIMARY KEY," +
                    Ingredient.COLUMN_NAME + " TEXT," +
                    Ingredient._COUNT + " TEXT";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Ingredient.TABLE_NAME;
}

public class Pantry extends AppCompatActivity {
    public static final String DATABASE_NAME = "MyPantry.db";

    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    EditText input;
    ImageView enter;

    //@Override
    protected  void onCreate(Bundle savedInstanceState, SQLiteDatabase db){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry_layout);
        db.execSQL(SQL_CREATE_ENTRIES);

        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);

        //create pantry db


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
                makeToast("Removed: " + items.get(i));
                removeItem(i);
                return false;
            }
        });

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if(text == null || text.length() == 0) {
                    makeToast("Enter an Item.");
                }else{
                    addItem(text);
                    input.setText("");
                    makeToast("Added: " + text);
                }
            }
        });
    }
    public void removeItem(int remove){
        items.remove(remove);
        adapter.notifyDataSetChanged();
    }

    public void addItem(String item){
        items.add(item);
        adapter.notifyDataSetChanged();
    }

    Toast t;

    private void makeToast(String s){
        if(t != null) t.cancel();
        t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        t.show();
    }
}