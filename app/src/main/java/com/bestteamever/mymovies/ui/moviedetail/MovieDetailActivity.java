package com.bestteamever.mymovies.ui.moviedetail;

import android.os.Bundle;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.ui.activity.BaseActivity;
import com.bestteamever.mymovies.ui.moviedetail.View.MovieDetailFragment;

public class MovieDetailActivity extends BaseActivity {

    public static final String MOVIE = "MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MovieDetailFragment())
                    .commit();
        }
    }

}
