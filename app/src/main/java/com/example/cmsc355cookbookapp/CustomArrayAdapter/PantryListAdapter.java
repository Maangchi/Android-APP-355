package com.example.cmsc355cookbookapp.CustomArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cmsc355cookbookapp.Ingredients_class;
import com.example.cmsc355cookbookapp.R;

import java.util.List;

public class PantryListAdapter extends ArrayAdapter<Ingredients_class> {
    public PantryListAdapter(Context context, List<Ingredients_class> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ingredients_class ingredients = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pantry_item_list, parent, false);
        }

        TextView ing_amount_list = convertView.findViewById(R.id.ing_amount_list);
        ing_amount_list.setText(Integer.toString(ingredients.getAmount()));
        TextView ing_name = convertView.findViewById(R.id.ing_name);
        TextView ing_amount_type = convertView.findViewById(R.id.ing_amount_type);
        ing_amount_type.setText(ingredients.getAmount_type());
        ing_name.setText(ingredients.getName());
        return convertView;
    }
}
