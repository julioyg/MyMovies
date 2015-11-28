package com.bestteamever.mymovies.dagger.component;

import android.content.Context;

import com.bestteamever.mymovies.dagger.module.ApplicationModule;
import com.bestteamever.mymovies.dagger.module.DataModule;
import com.bestteamever.mymovies.repository.movie.MovieRepository;
import com.bestteamever.mymovies.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    MovieRepository movierepository();
}