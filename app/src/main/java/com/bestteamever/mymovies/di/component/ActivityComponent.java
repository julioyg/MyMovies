package com.bestteamever.mymovies.di.component;

import android.app.Activity;
import com.bestteamever.mymovies.di.PerActivity;
import com.bestteamever.mymovies.di.module.ActivityModule;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}
