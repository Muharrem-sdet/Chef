package com.example.chef.views.list_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chef.R;
import com.example.chef.data.Recipe;

import java.util.ArrayList;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    private final ArrayList<Recipe> recipeList;
    private final OnClickFoodAction listener;

    public FoodListAdapter(ArrayList<Recipe> recipeList, OnClickFoodAction listener) {
        this.recipeList = recipeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.foodImage.setImageResource(recipeList.get(position).ImageId);
        holder.foodName.setText(recipeList.get(position).name);

        holder.itemView.setOnClickListener(v -> listener.perform(recipeList.get(position)));
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_image);
            foodName = itemView.findViewById(R.id.food_name);
        }
    }

}
