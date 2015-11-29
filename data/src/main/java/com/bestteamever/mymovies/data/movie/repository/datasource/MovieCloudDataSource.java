package com.bestteamever.mymovies.data.movie.repository.datasource;

import com.bestteamever.mymovies.data.movie.mapper.MovieMapper;
import com.bestteamever.mymovies.data.movie.net.RestApi;
import com.bestteamever.mymovies.data.movie.net.ServiceGenerator;
import com.bestteamever.mymovies.data.movie.repository.Authorization;
import com.bestteamever.mymovies.domain.model.Movie;
import java.util.List;
import rx.Observable;

public class MovieCloudDataSource implements MovieDataSource {
  private static final String END_POINT = "http://api.myapifilms.com/tmdb/";

  @Override public Observable<List<Movie>> get(Authorization authorization, String title) {
    return ServiceGenerator.createService(RestApi.class, END_POINT)
        .getMovieList(authorization.getToken(), title)
        .map(MovieMapper::transform);
  }
}
