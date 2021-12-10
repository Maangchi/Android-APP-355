package com.example.cmsc355cookbookapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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
    public static final String QUERY_SEARCH_BY_NAME = "SELECT * FROM "+INGREDIENT_TABLE+" WHERE "+COLUMN_INGREDIENT_NAME+"=";

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
        condenseDB();
        return insert != -1;
    }

    public List<Ingredients_class> getAll() {
        condenseDB();
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
    public Ingredients_class searchByName(String name) {
        Ingredients_class ingredient = new Ingredients_class();
        String queryString = QUERY_SEARCH_BY_NAME +"'"+name+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            String ing_name = cursor.getString(1);
            int amount = cursor.getInt(2);
            String Amount_type = cursor.getString(3);
            boolean need = cursor.getInt(4) == 1;
            cursor.close();
            db.close();
            return new Ingredients_class(id, name, amount, Amount_type, need);
        }
        else {
            cursor.close();
            db.close();
            return new Ingredients_class();
        }
    }
    public void condenseDB() {
        String queryString = "SELECT * FROM " + INGREDIENT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor1 = db.rawQuery(queryString, null);
        Cursor cursor2 = db.rawQuery(queryString, null);
        Log.d("DEBUG", "condenseDB: Attempting Condensing");
        if (cursor1.moveToFirst()) {
            do {
                Log.d("DEBUG", "condenseDB: Cursor1 at ID: "+Integer.toString(cursor1.getInt(0)));
                while (cursor2.moveToNext()) {


                    Log.d("DEBUG", "condenseDB: Found Cursor2 at ID: "+Integer.toString(cursor2.getInt(0)) );
                    if (cursor1.getInt(0) == cursor2.getInt(0)) {
                        Log.d("DEBUG", "condenseDB: Cursors on the same Entry");

                    }
                    else if( cursor2.getInt(0) < cursor1.getInt(0)){
                        Log.d("DEBUG", "condenseDB: Cursor 2 is less than Cursor 1");
                    }
                    else {
                        if (cursor1.getString(1).equals(cursor2.getString(1))) {
                            Log.d("DEBUG", "condenseDB: Found Repeated Entries at ID1: "+Integer.toString(cursor1.getInt(0))+" ID2: "+Integer.toString(cursor2.getInt(0)));
                            int newAmount = (cursor1.getInt(2) + cursor2.getInt(2));
                            ContentValues cv = new ContentValues();
                            cv.put(COLUMN_INGREDIENT_NAME, cursor1.getString(1));
                            cv.put(COLUMN_INGREDIENT_AMOUNT, newAmount);
                            cv.put(COLUMN_INGREDIENT_AMOUNT_TYPE, cursor1.getString(3));
                            cv.put(COLUMN_INGREDIENT_NEED, cursor1.getInt(4) == 1);
                            Log.d("DEBUG", "condenseDB: Updating ID: "+Integer.toString(cursor1.getInt(0))+" to have "+Integer.toString(newAmount));
                            db.update(INGREDIENT_TABLE, cv,COLUMN_INGREDIENT_ID+"="+Integer.toString(cursor1.getInt(0)),null);
                            Log.d("DEBUG", "condenseDB: Deleting ID: "+Integer.toString(cursor2.getInt(0)));
                            db.delete(INGREDIENT_TABLE,COLUMN_INGREDIENT_ID+"="+Integer.toString(cursor2.getInt(0)),null);
                        }
                    }


                }
                cursor2.moveToFirst();
            } while (cursor1.moveToNext());

            cursor1.close();
            cursor2.close();
            db.close();
        }
    }
}
