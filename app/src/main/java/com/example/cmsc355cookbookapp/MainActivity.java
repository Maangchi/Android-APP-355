package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cmsc355cookbookapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ing_btn = findViewById(R.id.textView2);
    }

    public void onIngbtnClick (View view) {
        setContentView(R.layout.ingrediants_page);
    }
}