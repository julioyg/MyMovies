package com.bestteamever.mymovies.ui.moviedetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.activity.BaseActivity;

public class MovieDetailActivity extends BaseActivity {

  public static final String INTENT_EXTRA_MOVIE = "com.bestteamever.mymovies.EXTRA_MOVIE";

  public static Intent getCallingIntent(Context context, MovieModel movie) {
    Intent intent = new Intent(context, MovieDetailActivity.class);
    intent.putExtra(INTENT_EXTRA_MOVIE, movie);
    return intent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_movie_detail);

    this.configureActionBar();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        ActivityCompat.finishAfterTransition(this);
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void configureActionBar() {
    ActionBar actionBar = getSupportActionBar();

    if (actionBar == null) {
      return;
    }

    actionBar.setDisplayHomeAsUpEnabled(true);
  }
}
