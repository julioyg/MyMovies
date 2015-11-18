package com.bestteamever.mymovies.repository.movie;

import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.repository.movie.datasource.MovieCloudDataSource;
import com.bestteamever.mymovies.repository.movie.datasource.MovieDataSource;

import java.util.List;

public class MovieDataRepository implements MovieRepository {
    private final MovieDataSource mCloudDataSource = new MovieCloudDataSource();

    @Override
    public List<Movie> getList() {
        return mCloudDataSource.get();
    }
}
