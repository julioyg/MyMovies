package com.bestteamever.mymovies.domain.model;

public class Movie {
    private final String mTitle;
    private final String mDate;
    private final String mPoster;
    private final String mOverView;

    private Movie(Builder builder) {
        this.mTitle = builder.mTitle;
        this.mDate = builder.mDate;
        this.mPoster = builder.mPoster;
        this.mOverView = builder.mOverView;
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
