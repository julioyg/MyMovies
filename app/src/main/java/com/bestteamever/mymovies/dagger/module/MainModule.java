package com.bestteamever.mymovies.dagger.module;

import com.bestteamever.mymovies.interactor.GetMovieListInteractor;
import com.bestteamever.mymovies.interactor.GetMovieListInteractorImpl;
import com.bestteamever.mymovies.repository.movie.MovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    GetMovieListInteractor provideGetMovieListInteractor(MovieRepository repository) {
        return new GetMovieListInteractorImpl(repository);
    }
}
