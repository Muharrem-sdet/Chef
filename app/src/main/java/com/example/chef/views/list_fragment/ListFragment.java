package com.example.chef.views.list_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chef.R;
import com.example.chef.data.ProjectConstants;
import com.example.chef.data.Recipe;
import com.example.chef.views.MainActivity;

import java.util.ArrayList;

public class ListFragment extends Fragment {


    public ListFragment() {
    }

    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);

        populateTheRecipeList();
        OnClickFoodAction listener = (recipe) -> onClickFood(recipe);

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

    public void onClickFood(Recipe recipe) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(ProjectConstants.PARCELABLE_RECIPE_PARAM, recipe);

        getParentFragmentManager().setFragmentResult(ProjectConstants.BUNDLE_REQUEST_KEY, bundle);
        ((MainActivity) getActivity()).viewPager.setCurrentItem(1);
    }
}