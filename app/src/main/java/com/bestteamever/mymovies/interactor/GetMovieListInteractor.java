package com.bestteamever.mymovies.interactor;

import com.bestteamever.mymovies.model.Movie;

import java.util.List;

public interface GetMovieListInteractor {
    interface Callback {
        void onMoviesList(List<Movie> movies);
    }

    void get(Callback callback);
}
