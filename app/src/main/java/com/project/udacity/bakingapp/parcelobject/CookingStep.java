package com.project.udacity.bakingapp.parcelobject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ikhwan on 8/26/17.
 */

public class CookingStep implements Parcelable {

    private final String id;
    private final String shortDescription;
    private final String description;
    private final String videoURL;
    private final String thumbnailURL;

    public static final Parcelable.Creator<CookingStep> CREATOR = new Parcelable.Creator<CookingStep>() {

        @Override
        public CookingStep createFromParcel(Parcel source) {
            return new CookingStep(source);
        }

        @Override
        public CookingStep[] newArray(int size) {
            return new CookingStep[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.shortDescription);
        dest.writeString(this.description);
        dest.writeString(this.videoURL);
        dest.writeString(this.thumbnailURL);
    }

    private CookingStep(Parcel in) {
        this.id = in.readString();
        this.shortDescription = in.readString();
        this.description = in.readString();
        this.videoURL = in.readString();
        this.thumbnailURL = in.readString();
    }

    public CookingStep(String id, String shortDescription, String description, String videoURL, String thumbnailURL) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }

    public String getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
