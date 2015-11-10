package com.bestteamever.mymovies.repository;

import com.bestteamever.mymovies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MyMoviesRepository {
    public List<Movie> getList() {
        List<Movie> result = new ArrayList<>();
        result.add(Movie.newBuilder().withMDate("11/11/2015").withMTilte(
                "Sorteo extra Once del Once").build());
        return result;
    }
}
