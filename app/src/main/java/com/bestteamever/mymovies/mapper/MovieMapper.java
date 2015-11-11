package com.bestteamever.mymovies.mapper;

import com.bestteamever.mymovies.model.Movie;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {
    public static List<Movie> transform(JsonArray movies) {
        List<Movie> result = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++) {
            result.add(transform(movies.get(i).getAsJsonObject()));
        }

        return result;
    }

    public static Movie transform(JsonObject movie) {
        String title = JsonUtils.getAsString(movie.get("title"));
        String date = JsonUtils.getAsString(movie.get("release_date"));

        return Movie.newBuilder().withTilte(title).withDate(date).build();
    }
}
