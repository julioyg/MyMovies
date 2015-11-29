package com.bestteamever.mymovies.di.module;

import com.bestteamever.mymovies.domain.executor.PostExecutionThread;
import com.bestteamever.mymovies.domain.executor.ThreadExecutor;
import com.bestteamever.mymovies.domain.interactor.movie.GetMovieListInteractor;
import com.bestteamever.mymovies.domain.repository.MovieRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    GetMovieListInteractor provideGetMovieListInteractor(MovieRepository repository, ThreadExecutor threadExecutor,
                                                         PostExecutionThread postExecutionThread) {
        return new GetMovieListInteractor(repository, threadExecutor, postExecutionThread);
    }
}
