package com.example.chef.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {

    public int ImageId;
    public String name;
    public String description;

    public Recipe(int imageId, String name, String description) {
        ImageId = imageId;
        this.name = name;
        this.description = description;
    }

    protected Recipe(Parcel in) {
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
