package com.bestteamever.mymovies;

import android.app.Application;

import com.bestteamever.mymovies.di.component.ApplicationComponent;
import com.bestteamever.mymovies.di.component.DaggerApplicationComponent;
import com.bestteamever.mymovies.di.module.ApplicationModule;

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                                                               .applicationModule(new ApplicationModule(this))
                                                               .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
