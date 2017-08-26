package com.project.udacity.bakingapp.parcelobject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ikhwan on 8/26/17.
 */

public class Recipe implements Parcelable {

    private final String id;
    private final String name;
    private final ArrayList<Ingredient> ingredients;
    private final ArrayList<CookingStep> cookingSteps;
    private final String servings;
    private final String image;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeTypedList(this.ingredients);
        dest.writeTypedList(this.cookingSteps);
        dest.writeString(this.servings);
        dest.writeString(this.image);
    }

    private Recipe(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        this.cookingSteps = in.createTypedArrayList(CookingStep.CREATOR);
        this.servings = in.readString();
        this.image = in.readString();
    }

    public Recipe(String id, String name, ArrayList<Ingredient> ingredients, ArrayList<CookingStep> cookingSteps,
                  String servings, String image) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps;
        this.servings = servings;
        this.image = image;
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {

        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
