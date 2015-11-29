package com.bestteamever.mymovies.data.movie.net;

import com.google.gson.JsonObject;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface RestApi {

    @GET ("searchMovie?movieName=frozen")
    Observable<JsonObject> getMovieList(@Query ("token") String token);
}
