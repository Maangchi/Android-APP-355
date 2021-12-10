package com.example.cmsc355cookbookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ingredientsDBHelper extends SQLiteOpenHelper {

    public static final String INGREDIENT_TABLE = "INGREDIENT_TABLE";
    public static final String COLUMN_INGREDIENT_ID = "ID";
    public static final String COLUMN_INGREDIENT_NAME = "INGREDIENT_NAME";
    public static final String COLUMN_INGREDIENT_AMOUNT = "INGREDIENT_AMOUNT";
    public static final String COLUMN_INGREDIENT_AMOUNT_TYPE = "INGREDIENT_AMOUNT_TYPE";
    public static final String COLUMN_INGREDIENT_NEED = "INGREDIENT_NEED";

    public ingredientsDBHelper(@Nullable Context context) {
        super(context, "ingredients.db", null, 1);
    }

    //This is called the first time a db is accessed There should be code in here to create a new db
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE "+INGREDIENT_TABLE+" ("+COLUMN_INGREDIENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_INGREDIENT_NAME+" TEXT, "+COLUMN_INGREDIENT_AMOUNT+" INT, "+COLUMN_INGREDIENT_AMOUNT_TYPE+" TEXT, "+COLUMN_INGREDIENT_NEED+" BOOL)";
        db.execSQL(createTableStatement);
    }

    //This is called if the db version number changes. It prevents users apps from breaking when you change the db design
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(Ingredients_class Ingredient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_INGREDIENT_NAME, Ingredient.getName());
        cv.put(COLUMN_INGREDIENT_AMOUNT, Ingredient.getAmount());
        cv.put(COLUMN_INGREDIENT_AMOUNT_TYPE, Ingredient.getAmount_type());
        cv.put(COLUMN_INGREDIENT_NEED, Ingredient.isNeed());

        long insert = db.insert(INGREDIENT_TABLE, null, cv);
        db.close();
        return insert != -1;
    }

    public List<Ingredients_class> getAll() {
        List<Ingredients_class> returnList = new ArrayList<>();

        //SQL Query to get all data from DB
        String queryString = "SELECT * FROM "+INGREDIENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int amount = cursor.getInt(2);
                String Amount_type = cursor.getString(3);
                boolean need = cursor.getInt(4) == 1;

                Ingredients_class temp = new Ingredients_class(id, name, amount, Amount_type, need);
                returnList.add(temp);
            } while (cursor.moveToNext());
        }
        else{
            // Nothing will be added if there is an empty DB
        }

        cursor.close();
        db.close();
        return returnList;
    }
}
