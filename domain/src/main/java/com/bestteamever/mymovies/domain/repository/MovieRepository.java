package com.bestteamever.mymovies.domain.repository;

import com.bestteamever.mymovies.domain.model.Movie;

import java.util.List;

import rx.Observable;

public interface MovieRepository {
    Observable<List<Movie>> getList();
}
