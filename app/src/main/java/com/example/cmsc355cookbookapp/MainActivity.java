package com.example.cmsc355cookbookapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ing_btn = findViewById(R.id.textView2);
        Button shopping_list = findViewById(R.id.Shopping_btn);
        Button ing_btn_press = findViewById(R.id.ing_btn);
        ing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyApp","This is the ingredients");
                Toast.makeText(getApplicationContext(), "Open the Pantry", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
    public void onIngbtnClick (View view) {
        setContentView(R.layout.ingredients_page);
    }
}