package com.bestteamever.mymovies.model;

public class Movie {
    private String mTilte;
    private String mDate;

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
