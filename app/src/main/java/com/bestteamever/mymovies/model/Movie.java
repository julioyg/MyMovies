package com.bestteamever.mymovies.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String mTilte;
    private String mDate;
    private String mOverview;
    private String mPoster;

    private Movie(Builder builder) {
        mTilte = builder.mTilte;
        mDate = builder.mDate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTilte() {
        return mTilte;
    }

    public String getDate() {
        return mDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getPoster() {
        return mPoster;
    }

    public static final class Builder {
        private String mTilte;
        private String mDate;

        private Builder() {
        }

        public Builder withTilte(String val) {
            mTilte = val;
            return this;
        }

        public Builder withDate(String val) {
            mDate = val;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
