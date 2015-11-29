package com.bestteamever.mymovies.domain.interactor.movie;

import com.bestteamever.mymovies.domain.executor.PostExecutionThread;
import com.bestteamever.mymovies.domain.executor.ThreadExecutor;
import com.bestteamever.mymovies.domain.interactor.Interactor;
import com.bestteamever.mymovies.domain.repository.MovieRepository;

import rx.Observable;
import rx.Subscriber;

public class GetMovieListInteractor extends Interactor {
    private final MovieRepository movieRepository;
    private String title;

    public GetMovieListInteractor(MovieRepository movieRepository, ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }

    public void execute(String title, Subscriber useCaseSubscriber) {
        this.title = title;
        super.execute(useCaseSubscriber);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return movieRepository.getList(title);
    }
}
