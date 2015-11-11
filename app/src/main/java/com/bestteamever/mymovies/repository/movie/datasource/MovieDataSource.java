package com.bestteamever.mymovies.repository.movie.datasource;

import com.bestteamever.mymovies.model.Movie;

import java.util.List;

public interface MovieDataSource {
    List<Movie> get();
}
