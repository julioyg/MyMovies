package com.bestteamever.mymovies.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    private String mTitle;
    private String mDate;
    private String mPoster;
    private String mOverView;

    private Movie(Builder builder) {
        this.mTitle = builder.mTitle;
        this.mDate = builder.mDate;
        this.mPoster = builder.mPoster;
        this.mOverView = builder.mOverView;
    }

    protected Movie(Parcel in) {
        this.mTitle = in.readString();
        this.mDate = in.readString();
        this.mPoster = in.readString();
        this.mOverView = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDate() {
        return mDate;
    }

    public String getPoster() {
        return mPoster;
    }

    public String getOverView() {
        return mOverView;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mDate);
        dest.writeString(this.mPoster);
        dest.writeString(this.mOverView);
    }

    public static final class Builder {
        public String mPoster;
        public String mOverView;
        private String mTitle;
        private String mDate;

        private Builder() {
        }

        public Builder withTitle(String val) {
            mTitle = val;
            return this;
        }

        public Builder withDate(String val) {
            mDate = val;
            return this;
        }

        public Builder withPoster(String val) {
            mPoster = val;
            return this;
        }

        public Builder withOverview(String val) {
            mOverView = val;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
