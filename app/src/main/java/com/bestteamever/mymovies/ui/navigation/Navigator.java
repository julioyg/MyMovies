package com.bestteamever.mymovies.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.moviedetail.MovieDetailActivity;

import javax.inject.Inject;

public class Navigator {
    @Inject
    public Navigator() {

    }

    @SuppressWarnings ("unchecked")
    public void navigateToItemDetail(Context context, MovieModel movie, ActivityOptionsCompat options) {
        Activity activity = (Activity) context;

        Intent intent = MovieDetailActivity.getCallingIntent(context, movie);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
