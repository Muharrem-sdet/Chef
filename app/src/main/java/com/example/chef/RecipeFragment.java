package com.example.chef;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeFragment extends Fragment {

    private ImageView recipeImage;
    private TextView recipeName;
    private TextView recipeDescription;

    public RecipeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recipeImage = view.findViewById(R.id.fragment_recipe_image);
        recipeName = view.findViewById(R.id.fragment_recipe_name);
        recipeDescription = view.findViewById(R.id.fragment_recipe_description);

        //Here a default recipe view values are set for the startup screen
        recipeImage.setImageResource(R.drawable.image01);
        recipeName.setText(R.string.default_food_name);
        recipeDescription.setText(R.string.long_recipe_description);

        getParentFragmentManager().setFragmentResultListener(ProjectConstants.BUNDLE_REQUEST_KEY,
                this, (requestKey, result) -> {
                    Recipe recipe = result.getParcelable(ProjectConstants.PARCELABLE_RECIPE_PARAM);
                    recipeImage.setImageResource(recipe.ImageId);
                    recipeName.setText(recipe.name);
                    recipeDescription.setText(recipe.description);
                });
    }
}