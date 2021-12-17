package com.example.cmsc355cookbookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class recipesDBHelper extends SQLiteOpenHelper {

    public static final String COLUMN_ID = "ID";
    public static final String RECIPE_TABLE = "RECIPE_TABLE";
    public static final String COLUMN_RECIPE_NAME = "RECIPE_NAME";
    public static final String COLUMN_ING_1 = "ING1";
    public static final String COLUMN_ING_1_AMT = "ING1_AMT";
    public static final String COLUMN_ING_1_AMT_TYPE = "ING1_AMT_TYPE";
    public static final String COLUMN_ING_2 = "ING2";
    public static final String COLUMN_ING_2_AMT = "ING2_AMT";
    public static final String COLUMN_ING_2_AMT_TYPE = "ING2_AMT_TYPE";
    public static final String COLUMN_ING_3 = "ING3";
    public static final String COLUMN_ING_3_AMT = "ING3_AMT";
    public static final String COLUMN_ING_3_AMT_TYPE = "ING3_AMT_TYPE";

    public recipesDBHelper(@Nullable Context context) {
        super(context, "recipe.db", null, 1);
    }

    // this is called the first time a database is accessed. Should be code to create new table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + RECIPE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RECIPE_NAME + " TEXT, " + COLUMN_ING_1 + " TEXT, " + COLUMN_ING_1_AMT + " INT, " + COLUMN_ING_1_AMT_TYPE + " TEXT, " + COLUMN_ING_2 + " TEXT, " + COLUMN_ING_2_AMT + " INT, " + COLUMN_ING_2_AMT_TYPE + " TEXT, " + COLUMN_ING_3 + " TEXT, " + COLUMN_ING_3_AMT + " INT, " + COLUMN_ING_3_AMT_TYPE + " TEXT)";
        db.execSQL(createTableStatement);
    }

    // this is called if database version number changes. It prevents previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(recipes_class recipe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_RECIPE_NAME, recipe.getRecipe());
        cv.put(COLUMN_ING_1, recipe.getR_ing1());
        cv.put(COLUMN_ING_1_AMT, recipe.getR_ing1_amt());
        cv.put(COLUMN_ING_1_AMT_TYPE, recipe.getR_ing1_amtType());
        cv.put(COLUMN_ING_2, recipe.getR_ing2());
        cv.put(COLUMN_ING_2_AMT, recipe.getR_ing2_amt());
        cv.put(COLUMN_ING_2_AMT_TYPE, recipe.getR_ing2_amtType());
        cv.put(COLUMN_ING_3, recipe.getR_ing3());
        cv.put(COLUMN_ING_3_AMT, recipe.getR_ing3_amt());
        cv.put(COLUMN_ING_3_AMT_TYPE, recipe.getR_ing3_amtType());

        long insert = db.insert(RECIPE_TABLE,null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean deleteOne(recipes_class recipes){
        SQLiteDatabase db = getWritableDatabase();
        String queryString = "DELETE FROM " + RECIPE_TABLE + " WHERE " + COLUMN_ID + " = " + recipes.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    public List<recipes_class> showRecipes() {
        List<recipes_class> returnList = new ArrayList();

        String queryString = "SELECT * FROM " + RECIPE_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            // loop through cursor results
            do{
                int recipeID = cursor.getInt(0);
                String recipeName = cursor.getString(1);
                String ing1 = cursor.getString(2);
                int ing1amt = cursor.getInt(3);
                String ing1type = cursor.getString(4);
                String ing2 = cursor.getString(5);
                int ing2amt = cursor.getInt(6);
                String ing2type = cursor.getString(7);
                String ing3 = cursor.getString(8);
                int ing3amt = cursor.getInt(9);
                String ing3type = cursor.getString(10);

                recipes_class newRecipe = new recipes_class(recipeID, recipeName, ing1, ing1amt, ing1type,ing2, ing2amt, ing2type,ing3, ing3amt, ing3type);
                returnList.add(newRecipe);
            }while(cursor.moveToNext());
        }
        else{
            // failure. do not add anything to the list.
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
