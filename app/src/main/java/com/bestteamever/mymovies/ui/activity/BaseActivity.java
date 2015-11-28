package com.bestteamever.mymovies.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bestteamever.mymovies.App;
import com.bestteamever.mymovies.dagger.component.ApplicationComponent;
import com.bestteamever.mymovies.dagger.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {
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
