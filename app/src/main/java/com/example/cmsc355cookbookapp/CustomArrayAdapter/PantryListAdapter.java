package com.example.cmsc355cookbookapp.CustomArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cmsc355cookbookapp.Ingredients_class;
import com.example.cmsc355cookbookapp.Pantry;
import com.example.cmsc355cookbookapp.R;
import com.example.cmsc355cookbookapp.ingredientsDBHelper;

import java.util.List;

public class PantryListAdapter extends ArrayAdapter<Ingredients_class> {
    public PantryListAdapter(Context context, List<Ingredients_class> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ingredientsDBHelper db = new ingredientsDBHelper( getContext());

        //Not really sure how this work but it grabs am
        Ingredients_class ingredients = getItem(position);
        String amountAndType =  Integer.toString(ingredients.getAmount()) + " " +ingredients.getAmount_type();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pantry_item_list, parent, false);
        }
        EditText amountToAdd = convertView.findViewById(R.id.amountToAdd);
        Button pos_btn = convertView.findViewById(R.id.pos_btn);
        Button neg_btn = convertView.findViewById(R.id.neg_btn);

        TextView ing_name = convertView.findViewById(R.id.ing_name);
        TextView ing_amount_type = convertView.findViewById(R.id.ing_amount_type);
        ing_amount_type.setText(amountAndType);
        ing_name.setText(ingredients.getName());

        pos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!amountToAdd.getText().toString().equals("") ) {

                    int amountToAddint = Integer.parseInt(amountToAdd.getText().toString());
                    if (amountToAddint < 0) {
                        amountToAddint = 0;
                    }
                    int newAmount = ingredients.getAmount() + amountToAddint;
                    if (newAmount < 0) {
                        newAmount = 0;
                    }
                    ingredients.setAmount(newAmount);
                    String amountAndType = Integer.toString(ingredients.getAmount()) + " " + ingredients.getAmount_type();
                    ing_amount_type.setText(amountAndType);
                    db.setAmountByName(ingredients.getName(), ingredients.getAmount());
                }
            }
        });
        neg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!amountToAdd.getText().toString().equals("") ){
                    int amountToAddint = Integer.parseInt(amountToAdd.getText().toString());
                    if (amountToAddint < 0) {
                        amountToAddint = 0;
                    }
                    int newAmount = ingredients.getAmount() - amountToAddint;
                    if (newAmount < 0) {
                        newAmount = 0;
                    }
                    ingredients.setAmount(newAmount);
                    String amountAndType = Integer.toString(ingredients.getAmount()) + " " + ingredients.getAmount_type();
                    ing_amount_type.setText(amountAndType);
                    db.setAmountByName(ingredients.getName(), ingredients.getAmount());
                }
            }
        });
        return convertView;
    }

}
