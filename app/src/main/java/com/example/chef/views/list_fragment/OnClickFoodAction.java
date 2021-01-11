package com.example.chef.views.list_fragment;

import com.example.chef.data.Recipe;

@FunctionalInterface
public interface OnClickFoodAction {
    void perform(Recipe recipe);
}
