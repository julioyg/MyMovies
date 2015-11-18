package com.bestteamever.mymovies.repository.movie.datasource;

import android.util.Log;

import com.bestteamever.mymovies.mapper.MovieMapper;
import com.bestteamever.mymovies.model.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieCloudDataSource implements MovieDataSource {
    private static final String TAG = MovieCloudDataSource.class.getSimpleName();

    private final Gson mGson = new Gson();
    String strUrl =
            "http://api.myapifilms.com/tmdb/searchMovie?movieName=frozen&token=b651984d-945f-4df0-b686-bf2206df3142&format=json&language=en&includeAdult=1";

    @Override
    public List<Movie> get() {
        HttpURLConnection urlConnection = null;
        List<Movie> movies = new ArrayList<>();
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            JsonObject jsonObject = mGson.fromJson(reader, JsonObject.class);
            JsonArray results = jsonObject.getAsJsonObject("data").getAsJsonArray("results");

            movies.addAll(MovieMapper.transform(results));
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return movies;
    }
}
