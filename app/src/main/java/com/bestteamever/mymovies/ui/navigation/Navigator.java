package com.bestteamever.mymovies.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.moviedetail.MovieDetailActivity;

import javax.inject.Inject;

public class Navigator {
    @Inject
    public Navigator() {

    }

    public void navigateToItemDetail(Context context, MovieModel movie) {
        Intent intent = MovieDetailActivity.getCallingIntent(context, movie);
        context.startActivity(intent);
    }
}
