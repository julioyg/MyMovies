package com.bestteamever.mymovies.data.movie.mapper;

import com.bestteamever.mymovies.domain.model.Movie;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

  public static List<Movie> transform(JsonObject jsonObject) {
    JsonArray jsonArray = jsonObject.getAsJsonObject("data").getAsJsonArray("results");

    List<Movie> result = new ArrayList<>();

    for (int i = 0; i < jsonArray.size(); i++) {
      JsonObject movie = jsonArray.get(i).getAsJsonObject();

      String title = JsonUtils.getAsString(movie.get("title"));
      String date = JsonUtils.getAsString(movie.get("release_date"));
      String overview = JsonUtils.getAsString(movie.get("overview"));
      String poster = JsonUtils.getAsString(movie.get("poster_path"));

      result.add(Movie.newBuilder()
          .withTitle(title)
          .withDate(date)
          .withOverview(overview)
          .withPoster(poster)
          .build());
    }

    return result;
  }
}
