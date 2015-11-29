package com.bestteamever.mymovies.ui.main.presenter;

import com.bestteamever.mymovies.domain.interactor.DefaultSubscriber;
import com.bestteamever.mymovies.domain.interactor.movie.GetMovieListInteractor;
import com.bestteamever.mymovies.domain.model.Movie;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.model.mapper.MovieModelMapper;
import com.bestteamever.mymovies.ui.main.view.MainView;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter {
    private final GetMovieListInteractor mGetMovieListInteractor;
    private MainView mView;

    @Inject
    public MainPresenter(GetMovieListInteractor getMovieListInteractor) {
        mGetMovieListInteractor = getMovieListInteractor;
    }

    public void takeView(MainView view) {
        this.mView = view;
        this.mGetMovieListInteractor.execute(new UserDetailsSubscriber());
    }

    public void dropView() {
        this.mGetMovieListInteractor.unsubscribe();
        this.mView = null;
    }

    private void showMovies(List<MovieModel> movies) {
        this.mView.showMovies(movies);
    }

    private final class UserDetailsSubscriber extends DefaultSubscriber<List<Movie>> {

        @Override
        public void onNext(List<Movie> movies) {
            MainPresenter.this.showMovies(MovieModelMapper.transform(movies));
        }
    }
}
