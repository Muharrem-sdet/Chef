package com.example.chef.views;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.chef.views.list_fragment.ListFragment;
import com.example.chef.views.recipe_fragment.RecipeFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ListFragment();
        } else {
            return new RecipeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
