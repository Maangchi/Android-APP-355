package com.example.cmsc355cookbookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeRVAdapter extends RecyclerView.Adapter<RecipeRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<recipes_class> recipes_classArrayList;
    private Context context;

    // constructor
    public RecipeRVAdapter(ArrayList<recipes_class> recipes_classArrayList, Context context) {
        this.recipes_classArrayList = recipes_classArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        recipes_class modal = recipes_classArrayList.get(position);
        holder.recipeTV.setText(modal.getRecipe());
        holder.ing1TV.setText(modal.getR_ing1());
        holder.ing2TV.setText(modal.getR_ing2());
        holder.ing3TV.setText(modal.getR_ing2());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return recipes_classArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView recipeTV, ing1TV, ing2TV, ing3TV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            recipeTV = itemView.findViewById(R.id.et_recipe);
            ing1TV = itemView.findViewById(R.id.et_ing1);
            ing2TV = itemView.findViewById(R.id.et_ing2);
            ing3TV = itemView.findViewById(R.id.et_ing3);
        }
    }
}
