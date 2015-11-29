package com.bestteamever.mymovies.di.module;

import com.bestteamever.mymovies.auth.AuthorizationImpl;
import com.bestteamever.mymovies.data.movie.repository.MovieDataRepository;
import com.bestteamever.mymovies.domain.repository.MovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    MovieRepository provideUserRepository(AuthorizationImpl authorization) {
        return new MovieDataRepository(authorization);
    }
}
