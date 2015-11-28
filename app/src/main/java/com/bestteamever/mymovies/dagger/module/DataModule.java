package com.bestteamever.mymovies.dagger.module;

import com.bestteamever.mymovies.repository.movie.MovieDataRepository;
import com.bestteamever.mymovies.repository.movie.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides @Singleton
    MovieRepository provideMovieRepository() {
        return new MovieDataRepository();
    }
}
