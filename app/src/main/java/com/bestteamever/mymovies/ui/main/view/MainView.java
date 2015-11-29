package com.bestteamever.mymovies.ui.main.view;

import com.bestteamever.mymovies.model.MovieModel;

import java.util.List;

public interface MainView {
    void showMovies(List<MovieModel> movies);
}
