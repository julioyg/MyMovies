package com.bestteamever.mymovies.dagger.module;

import android.content.Context;

import com.bestteamever.mymovies.App;
import com.bestteamever.mymovies.repository.movie.MovieDataRepository;
import com.bestteamever.mymovies.repository.movie.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    MovieRepository provideMovieRepository() {
        return new MovieDataRepository();
    }

}