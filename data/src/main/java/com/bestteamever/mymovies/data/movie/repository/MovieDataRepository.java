package com.bestteamever.mymovies.data.movie.repository;

import com.bestteamever.mymovies.data.movie.repository.datasource.MovieCloudDataSource;
import com.bestteamever.mymovies.data.movie.repository.datasource.MovieDataSource;
import com.bestteamever.mymovies.domain.model.Movie;
import com.bestteamever.mymovies.domain.repository.MovieRepository;

import java.util.List;

import rx.Observable;

public class MovieDataRepository implements MovieRepository {
    private final MovieDataSource mCloudDataSource = new MovieCloudDataSource();
    private final Authorization mAuthorization;

    public MovieDataRepository(Authorization authorization) {
        this.mAuthorization = authorization;
    }

    @Override
    public Observable<List<Movie>> getList(String title) {
        return mCloudDataSource.get(mAuthorization, title);
    }
}
