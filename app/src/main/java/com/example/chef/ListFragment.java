package com.example.chef;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment {


    public ListFragment() {
    }

    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateTheRecipeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);

        OnClickFoodAction listener = (recipe) -> onClickFood(recipe, view);

        FoodListAdapter adapter = new FoodListAdapter(recipeList, listener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void populateTheRecipeList() {
        String[] imageIds = getResources().getStringArray(R.array.food_image_ids);
        String[] names = getResources().getStringArray(R.array.food_names);
        String[] descriptions = getResources().getStringArray(R.array.food_descriptions);

        for (int i = 0; i < names.length; i++) {
            int imageId = getResources().getIdentifier(imageIds[i], "drawable", getContext().getPackageName());
            recipeList.add(new Recipe(imageId, names[i],
                    descriptions[i].concat(getResources().getString(R.string.long_recipe_description))));
        }
    }

    public void onClickFood(Recipe recipe, View view) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(ProjectConstants.PARCELABLE_RECIPE_PARAM, recipe);

        getParentFragmentManager().setFragmentResult(ProjectConstants.BUNDLE_REQUEST_KEY, bundle);
        ((MainActivity) getActivity()).viewPager.setCurrentItem(1);
    }
}