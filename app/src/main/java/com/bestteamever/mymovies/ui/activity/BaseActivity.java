package com.bestteamever.mymovies.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bestteamever.mymovies.App;
import com.bestteamever.mymovies.dagger.component.ApplicationComponent;
import com.bestteamever.mymovies.dagger.module.ActivityModule;
import com.bestteamever.mymovies.repository.movie.MovieRepository;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {
   @Inject MovieRepository mMovieRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }
}
