package com.bestteamever.mymovies.ui.moviedetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.activity.BaseActivity;
import com.bestteamever.mymovies.ui.moviedetail.View.MovieDetailFragment;

public class MovieDetailActivity extends BaseActivity {

    public static final String INTENT_EXTRA_MOVIE = "com.bestteamever.mymovies.EXTRA_MOVIE";

    public static Intent getCallingIntent(Context context, MovieModel movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(INTENT_EXTRA_MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MovieDetailFragment()).commit();
        }
    }
}
