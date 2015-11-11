package com.bestteamever.mymovies.ui.main.presenter;

import com.bestteamever.mymovies.interactor.GetMovieListInteractor;
import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.ui.main.view.MainView;

import java.util.List;

public class MainPresenter implements GetMovieListInteractor.Callback {
    private final GetMovieListInteractor mGetMovieListInteractor = new GetMovieListInteractor();
    private MainView mView;

    public void takeView(MainView view) {
        this.mView = view;
        mGetMovieListInteractor.get(this);
    }

    public void dropView() {
        this.mView = null;
    }

    @Override
    public void onMoviesList(List<Movie> movies) {
        if (this.mView == null) {
            return;
        }

        mView.showMovies(movies);
    }
}
