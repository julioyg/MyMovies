package com.bestteamever.mymovies.domain.interactor.movie;

import com.bestteamever.mymovies.domain.executor.PostExecutionThread;
import com.bestteamever.mymovies.domain.executor.ThreadExecutor;
import com.bestteamever.mymovies.domain.interactor.Interactor;
import com.bestteamever.mymovies.domain.repository.MovieRepository;

import rx.Observable;

public class GetMovieListInteractor extends Interactor {
    private final MovieRepository movieRepository;

    public GetMovieListInteractor(MovieRepository movieRepository, ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return movieRepository.getList();
    }
}
