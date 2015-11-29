package com.bestteamever.mymovies.ui.movieslist;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.di.HasComponent;
import com.bestteamever.mymovies.di.component.DaggerMainComponent;
import com.bestteamever.mymovies.di.component.MainComponent;
import com.bestteamever.mymovies.di.module.MainModule;
import com.bestteamever.mymovies.ui.activity.BaseActivity;

public class MoviesListActivity extends BaseActivity implements HasComponent<MainComponent> {

  private MainComponent mActivityComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_movies_list);

    this.configureActionBar();
    this.initializeInjector();
  }

  private void configureActionBar() {
    Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
    super.setSupportActionBar(toolbar);
  }

  private void initializeInjector() {
    this.mActivityComponent = DaggerMainComponent.builder()
        .applicationComponent(super.getApplicationComponent())
        .mainModule(new MainModule())
        .build();
  }

  @Override public MainComponent getComponent() {
    return this.mActivityComponent;
  }
}
