package com.bestteamever.mymovies.model.mapper;

import com.bestteamever.mymovies.domain.model.Movie;
import com.bestteamever.mymovies.model.MovieModel;
import java.util.ArrayList;
import java.util.List;

public class MovieModelMapper {
  public static final String IMAGES_END_POINT = "http://image.tmdb.org/t/p/w342";

  public static List<MovieModel> transform(List<Movie> movies) {
    List<MovieModel> result = new ArrayList<>();

    if (movies == null) {
      return result;
    }

    for (Movie movie : movies) {
      result.add(transform(movie));
    }

    return result;
  }

  public static MovieModel transform(Movie movie) {
    return MovieModel.newBuilder()
        .withTitle(movie.getTitle())
        .withDate(movie.getDate())
        .withOverview(movie.getOverView())
        .withPoster(IMAGES_END_POINT + movie.getPoster())
        .build();
  }
}
