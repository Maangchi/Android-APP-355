package com.example.cmsc355cookbookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
