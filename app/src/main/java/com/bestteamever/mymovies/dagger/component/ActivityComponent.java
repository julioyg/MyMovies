package com.bestteamever.mymovies.dagger.component;

import android.app.Activity;

import com.bestteamever.mymovies.dagger.PerActivity;
import com.bestteamever.mymovies.dagger.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
