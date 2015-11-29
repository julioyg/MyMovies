package com.bestteamever.mymovies.data.movie.repository.datasource;

import com.bestteamever.mymovies.data.movie.repository.Authorization;
import com.bestteamever.mymovies.domain.model.Movie;

import java.util.List;

import rx.Observable;

public interface MovieDataSource {
    Observable<List<Movie>> get(Authorization authorization);
}
